package it.equitalia.gestorefascicolows.bl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import it.equitalia.gestorefascicolows.dao.DAOFactory;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.FascicoloDAO;
import it.equitalia.gestorefascicolows.dao.impl.FascicoloDAOImpl;
import it.equitalia.gestorefascicolows.dati.Anagrafica;
import it.equitalia.gestorefascicolows.dati.DeleteEmailWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteEmailWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteIndirizzoWSResponse;
import it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSRequest;
import it.equitalia.gestorefascicolows.dati.DeleteTelefonoWSResponse;
import it.equitalia.gestorefascicolows.dati.EMail;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.Indirizzo;
import it.equitalia.gestorefascicolows.dati.InsertEmailWSRequest;
import it.equitalia.gestorefascicolows.dati.InsertEmailWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSRequest;
import it.equitalia.gestorefascicolows.dati.InsertIndirizzoWSResponse;
import it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest;
import it.equitalia.gestorefascicolows.dati.InsertTelefonoWSResponse;
import it.equitalia.gestorefascicolows.dati.Telefono;
import it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest;
import it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;

public class AnagraficaBl {
	private static Logger logger = Log4jFactory.getLogger(AnagraficaBl.class);

	public static InsertIndirizzoWSResponse insertIndirizzo( InsertIndirizzoWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - insertIndirizzo: started");
		InsertIndirizzoWSResponse res;
		
		FascicoloDAO dao;	  
    	try {
    		dao   = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		res =  new InsertIndirizzoWSResponse( dao.insertIndirizzo(
									in.getFascicoloId() ,
									in.getCallerId(),
									in.getIndirizzo(), 
									false) 
									);
		} catch (Exception e) { 
			logger.error("", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  
		
		logger.info("GestoreFascicoloWS - insertIndirizzo: end");
		
		return res;
	}

	public static InsertTelefonoWSResponse insertTelefono( InsertTelefonoWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - insertTelefono: started");
		InsertTelefonoWSResponse res;
    	FascicoloDAO dao; 
    	
    	try {
    		dao   = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		res =  new InsertTelefonoWSResponse( dao.insertTelefono(
									in.getFascicoloId() ,
									in.getCallerId(),
									in.getTelefono()  ) 
									);
		} catch (Exception e) { 
			logger.error("", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}   
		logger.info("GestoreFascicoloWS - insertTelefono: end");
		return res;
	}

	public static InsertEmailWSResponse insertEmail(InsertEmailWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - insertEmail: started");
		InsertEmailWSResponse res;
    	FascicoloDAO dao; 
    	
    	try {
    		dao   = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		res =  new InsertEmailWSResponse( dao.insertEmail(
									in.getFascicoloId() ,
									in.getCallerId(),
									in.getEMail()  ) 
									);
		} catch (Exception e) { 
			logger.error("", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  
		logger.info("GestoreFascicoloWS - insertEmail: end");
		
		return res;
	}

	public static DeleteIndirizzoWSResponse deleteIndirizzo( DeleteIndirizzoWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - deleteIndirizzo: started");
		DeleteIndirizzoWSResponse res;
    	FascicoloDAO dao; 
    	
    	try {
    		dao   = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
			res=  new DeleteIndirizzoWSResponse( dao.deleteIndirizzo( 
					in.getIndirizzoId() )); 
		} catch (Exception e) { 
			logger.error("", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  

		logger.info("GestoreFascicoloWS - deleteIndirizzo: end");
		return res;
	}

	public static DeleteTelefonoWSResponse deleteTelefono( DeleteTelefonoWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - deleteTelefono: started");
		DeleteTelefonoWSResponse res;
    	FascicoloDAO dao;  
    	try {
    		dao   = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		
    		res = new DeleteTelefonoWSResponse(  dao.deleteTelefono(  in.getTelefonoId() ) );
		} catch (Exception e) { 
			logger.error("", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  
		
		logger.info("GestoreFascicoloWS - deleteTelefono: end");
		
		return res;
	}

	public static DeleteEmailWSResponse deleteEmail(DeleteEmailWSRequest in) throws FaultType {
		logger.info("GestoreFascicoloWS - deleteEmail: started");
    	FascicoloDAO dao;
    	DeleteEmailWSResponse res;
    	try {
    		dao = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
    		
			res = new DeleteEmailWSResponse( dao.deleteEmail( in.getEMailId() ) );
			
		} catch (Exception e) { 
			logger.error("", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}  
		logger.info("GestoreFascicoloWS - deleteEmail: end");
		return res;
	}

	public static UpdateAnagraficaWSResponse updateAnagrafica(UpdateAnagraficaWSRequest in) throws FaultType   {
		logger.info("GestoreFascicoloWS - updateAnagrafica: started");
		UpdateAnagraficaWSResponse response = new UpdateAnagraficaWSResponse();

		Connection conn = null; 
		try {  
			
			try {
				FascicoloDAO dao  = DAOFactory.getFascicoloDAO(true, DBFactory.ORIGINE_ORACLE);
				
				Fascicolo fascicolo = dao.getFascicoloConEntityPrimoLivello(
										in.getFascicoloId() ,
										in.getCallerId(), EntityDAO.ENTITY_ID_CARTELLA ) ;
				
				conn = DBFactory.connectionGet(DBFactory.ORIGINE_ORACLE, false); 
				conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED );
				
				FascicoloBl.lockFascicolo(
										conn, 
										in.getFascicoloId() ,
										in.getCallerId() );
				
				//cancello tutte le email, i numeri di telefono e gli indirizzi (eccetto quello principale)
				dao = DAOFactory.getFascicoloDAO();
				Anagrafica anagrafica = fascicolo.getAnagrafica();
				EMail[] emailDaCancellare = anagrafica.getEmail();
				for (EMail mail : emailDaCancellare) {
					dao.deleteEmail(mail.getEMailId(), conn);
				}
				Telefono[] telefoniDaCancellare = anagrafica.getTelefoni();
				for (Telefono telefono : telefoniDaCancellare) {
					dao.deleteTelefono(telefono.getTelefonoId(),conn);
				}
				Indirizzo[] indirizziDaCancellare = anagrafica.getIndirizzi(); 
				for (Indirizzo indirizzo : indirizziDaCancellare) {
					if (indirizzo.getIndirizzoPrincipale().equals( FascicoloDAOImpl.ANAGRAFICA_INDIRIZZO_PRINCIPALE_NO ) ) {
						dao.deleteIndirizzo(indirizzo.getIndirizzoId(), conn);
					}
				}
				
				//inserisco le nuove le email, i numeri di telefono e gli indirizzi 
				String[] emailDaInserire = in.getEmail();
				
				if (emailDaInserire!=null) {
					for (String  email: emailDaInserire) {
						dao.insertEmail(
								in.getFascicoloId() ,
								in.getCallerId(),
								anagrafica.getAnagraficaId(), email, conn);
					} 
				}
				
				String[] telefoniDaInserire = in.getNumeroTelefono();

				if (telefoniDaInserire!=null) {
					for (String telefono : telefoniDaInserire) {
						dao.insertTelefono(
								in.getFascicoloId() ,
								in.getCallerId(),
								anagrafica.getAnagraficaId(), telefono, conn);
					}	 
				}			
				
				
				String[] indirizziNonPrincipaliDaInserire = in.getIndirizzo();

				if (indirizziNonPrincipaliDaInserire!=null) {
					for (String indirizzo : indirizziNonPrincipaliDaInserire) {
						dao.insertIndirizzo(
								in.getFascicoloId() ,
								in.getCallerId(),
								anagrafica.getAnagraficaId(), indirizzo, false, conn);
					}
					
				}
				
				conn.commit();
				
				response.setEsito("OK");
				
			} catch (Exception e) {
				logger.error("", e);
				if (conn!=null) {
					conn.rollback();
				}

				response.setEsito("KO");
				
			} finally{
				if (conn!=null) {
					conn.close();
				}
			}

			
		} catch (Exception e) {
			logger.error("", e);
			FaultType faultType = new FaultType(0, e.getMessage());
			throw faultType;
		}
		logger.info("GestoreFascicoloWS - updateAnagrafica: end");
		
		return response;
	}

}
