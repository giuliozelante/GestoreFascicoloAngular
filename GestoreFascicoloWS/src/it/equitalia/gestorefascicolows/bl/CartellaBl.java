package it.equitalia.gestorefascicolows.bl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
  
import it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoRequest;
import it.equitalia.dettagliocartellaavviso.wsdl.DettaglioCartellaAvvisoResponse;
import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.FascicoloDAO;
import it.equitalia.gestorefascicolows.dao.impl.CartellaDAOImpl;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSResponse;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.DateUtil;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;

public class CartellaBl {
	private static Logger logger = Log4jFactory.getLogger(CartellaBl.class);

	
	
	 
	//inizio modifiche Agosto 
	public static int getCartellaIndex(Fascicolo fascicolo, String numeroCartella) throws Exception {
		int ret=-1;
		for (int i = 0; i<fascicolo.getCartelle().length;i++){
			for (int iv = 0; iv < fascicolo.getCartelle(i).getDataValues().length;iv++)
				if (fascicolo.getCartelle(i).getDataValues(iv).getDataTypeId()==CartellaDAOImpl.N_CARTELLA &&
						fascicolo.getCartelle(i).getDataValues(iv).getValue().equals(numeroCartella)){
					ret = i;
			}
		}

		if (ret==-1) {
			throw new Exception("Numero cartella[" + numeroCartella + "] non presente nel fascicolo" );
		}
		
		return ret;
	}
	//fine modifiche Agosto 
	public static String getImportoDaPagareCartella(Fascicolo fascicolo, int cartellaIndex) throws Exception {
		String ret= "";
		for (int iv = 0; iv < fascicolo.getCartelle(cartellaIndex).getDataValues().length;iv++) {
			if (fascicolo.getCartelle(cartellaIndex).getDataValues(iv).getDataTypeId()==CartellaDAOImpl.IMPORTO_DA_PAGARE)
				ret = fascicolo.getCartelle(cartellaIndex).getDataValues(iv).getValue();
		}
		return ret;
	}
	

	public static GetCartellaWSResponse getCartella(GetCartellaWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - getCartella: started"); 

    	FascicoloDAO dao ; 
		Fascicolo fascicolo;
		
    	try { 
    		dao   = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		fascicolo = dao.getFascicoloConEntityPrimoLivello(
									in.getFascicoloId() ,
									in.getCallerId(), EntityDAO.ENTITY_ID_CARTELLA ) ; 
    		if (fascicolo != null ) {
    			
    			logger.info("GestoreFascicoloWS - getCartella: trovato fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "]");
    			
    			int cartellaIndex = CartellaBl.getCartellaIndex(fascicolo,in.getNumeroCartella());	 //FASCICOLO_2.1      			

    			//inizio modifica_problema_transazioni 13/10/2014  
        		if (!FascicoloBl.isChiuso( fascicolo )
        				&& !CartellaBl.isAggiornata( fascicolo.getCartelle(cartellaIndex), fascicolo ) ) {  //FASCICOLO_2.1
        			logger.info("GestoreFascicoloWS - getCartella: il fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "] è aperto");

        			//FASCICOLO_2.1      			int cartellaIndex = CartellaBl.getCartellaIndex(fascicolo,in.getNumeroCartella());	 

        			DettaglioCartellaAvvisoResponse response = getBPSDettaglioCartellaResponse(fascicolo,  
																							cartellaIndex,  
																							in );
        			
        			
        	    	fascicolo = FascicoloBl.updateCartella(fascicolo,  
        							cartellaIndex, //modifiche Agosto 
        							in,
        							response );  

        			logger.info("GestoreFascicoloWS - getCartella: eseguito aggiornamento della cartella[" + in.getNumeroCartella() + "] per il fascicolo con FascicoloId[" + in.getFascicoloId() + "] CallerId[" + in.getCallerId() + "] è aperto");
        			
    			}   else{ 
        			
            		dao  = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE); 
    	    		fascicolo = dao.getCartella(
    						in.getFascicoloId() ,
    						in.getCallerId(),
    						in.getNumeroCartella(),
    						in.getCodiceAmbito() );
    			} 
    			//fine modifica_problema_transazioni 13/10/2014  
	    		
			} else{  
				Exception ex = new Exception("Nessun fascicolo trovato");
				throw ex;
			}
    		
		} catch (Exception e) { 
			logger.error("Errore in GestoreFascicoloWS - getCartella", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}

		logger.info("GestoreFascicoloWS - getCartella: end"); 
		
		return new GetCartellaWSResponse( fascicolo ); 
	}



	//inizio FASCICOLO_2.1
	private static boolean isAggiornata(EntityItem cartella, Fascicolo fascicolo) throws ParseException, Exception {  
		boolean res;
		Calendar dataUltimoAggiornamentoCartella = DateUtil.parseDate(
				UtilsClass.getEntityItemDataValue(cartella, CartellaDAOImpl.DATA_ULTIMO_AGGIORNAMENTO_CARTELLA)
					 ); 
		Calendar now = Calendar.getInstance();
		
		if (	dataUltimoAggiornamentoCartella!=null
				&& dataUltimoAggiornamentoCartella.get(Calendar.YEAR) == now.get(Calendar.YEAR)
				&& dataUltimoAggiornamentoCartella.get(Calendar.MONTH) == now.get(Calendar.MONTH)
				&& dataUltimoAggiornamentoCartella.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH) ) {
			res = true;
		} else{
			res = false;  
		}
		 
		if (res) { 
			logger.info("GestoreFascicoloWS - la cartella numero [" +  
					UtilsClass.getEntityItemDataValue(cartella, CartellaDAOImpl.N_CARTELLA)
					+ "] del fascicolo con FascicoloId[" + fascicolo.getFascicoloId() + "] CallerId[" + fascicolo.getCallerId() + "] è aggiornata");
		} 
		return res; 
	}  
	//fine FASCICOLO_2.1
 
	private static DettaglioCartellaAvvisoResponse getBPSDettaglioCartellaResponse( Fascicolo fascicolo, int cartellaIndex, GetCartellaWSRequest in) throws Exception {

    	// chiama il WS
		DettaglioCartellaAvvisoRequest request = new DettaglioCartellaAvvisoRequest();
    	request.setCodiceFiscale( fascicolo.getAnagrafica().getCodiceFiscale().trim() ) ;
    	request.setDataRichiesta( new Date()) ; 
    	request.setTipoDocumento( CodificaDocumento.getTipoDocumento( in )  );  
    	request.setNumeroDocumento(in.getNumeroCartella()) ;
    	
    	
    	if (getImportoDaPagareCartella(fascicolo, cartellaIndex).equals("0.0")){
    		request.setTipologia(MessagesClass.getMessage("TIPOLOGIA_DOCUMENTI_TUTTI").trim()) ;
    	}
    	else{
    		request.setTipologia(MessagesClass.getMessage("TIPOLOGIA_DOCUMENTI_INSOLUTI").trim()) ;
    	}
    	return  FascicoloBl.getBPSDettaglioCartellaResponse(request); 
	} 
}
