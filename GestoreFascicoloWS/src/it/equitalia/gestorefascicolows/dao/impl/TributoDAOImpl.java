package it.equitalia.gestorefascicolows.dao.impl;

import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dao.TributoDAO; 
import it.equitalia.gestorefascicolows.dati.*;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;

import java.sql.Connection; 
import java.sql.ResultSet; 

import org.apache.log4j.Logger;
 

public class TributoDAOImpl extends EntityItemClass implements TributoDAO { 
	public static final int  DATA_TYPE_ID_CODICE_TRIBUTO = 110;
	public static final int  DATA_TYPE_ID_DESCRIZIONE_TRIBUTO   = 115;
	public static final int  DATA_TYPE_ID_ENTE_IMPOSITORE = 120;
	public static final int  DATA_TYPE_ID_ANNO = 125;
	public static final int  DATA_TYPE_ID_RATEIZZATO =130 ;
	public static final int  DATA_TYPE_ID_IMPORTO_A_RUOLO_INIZIALE = 135;
	public static final int  DATA_TYPE_ID_IMPORTO_PAGATO = 140 ;
	public static final int  DATA_TYPE_ID_IMPORTO_SGRAVATO = 145;
	public static final int  DATA_TYPE_ID_IMPORTI_SOSPESI = 150;
	public static final int  DATA_TYPE_ID_IMPORTO_RESIDUO = 155;

	
	private static Logger logger = Log4jFactory.getLogger(TributoDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
  //2041_08_18 modifica_1    private String fascicoloID;
  //2041_08_18 modifica_1    private String callerID;
    private String INSERT_ENTITY_ITEM_QUERY;
    private String INSERT_DATA_VALUE_QUERY;
	

	public TributoDAOImpl() {
	}

    
	public TributoDAOImpl(boolean autocommit, String origin) throws FaultType {
		super(autocommit, origin);
	}


//	public String inserimentoTributoInsert(InserimentoTributoWSRequest request) throws FaultType {
//		return inserimentoTributoInsert(request.getTributo(), request.getFascicoloId(), request.getCallerId() );
//	}
	
	public void inserimentoTributoInsert(TributoType [] tributoTypeArray, String fascicoloId, String callerId, EntityItem cartella, Connection connection) throws   Exception { 
	 
		
		//inizio 2041_08_18 modifica_1
//	    this.fascicoloID=fascicoloId;
//	    this.callerID=callerId;
		setFascicoloId(fascicoloId);
		setCallerId(callerId);
		//fine 2041_08_18 modifica_1 

		boolean flagPresenzaTributi=UtilsClass.isNotEmpty(tributoTypeArray);
		if(!flagPresenzaTributi){
			logger.info(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_TRIBUTO_VOID")); 
		}
		
		logger.debug("FascicoloId: "+getFascicoloId()+"\n");
		logger.debug("CAllerId: "+getCallerId()+"\n");
		logger.debug("Numero dei tributi da elaborare: "+tributoTypeArray.length+"\n");


		for (int i = 0; i < tributoTypeArray.length; i++) {
			entityItemInsert(connection, cartella.getEntityItemId());
			dataValueInsert(connection,tributoTypeArray[i], cartella.getEntityItemId() );	
		 
		} 

		logger.debug(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_TRIBUTO_OK")); 

	}
	
	
	private int entityItemId = 0;
	private void entityItemInsert(Connection connection, int parentEntityItemId) throws Exception{ 
		String entityItemeInsertQuery=buildEntityItemInsert(parentEntityItemId);
		PreparedStatementWrapper preparedStatement = null;
		try {
			preparedStatement = PreparedStatementWrapper.prepareStatement(connection, entityItemeInsertQuery,new String[]{"ENTITYITEMID"});
			preparedStatement.executeQuery();
			ResultSet rs =  preparedStatement.getGeneratedKeys();
			if(rs.next()){
				entityItemId=rs.getInt(1);
			} else{
				throw new Exception( MessagesClass.getMessage("ERROR_GENERATED_KEYS") );
			} 
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT" )+ e.getMessage());
			e.printStackTrace();
			throw e;
		}  
	}

	private String buildEntityItemInsert( int parentEntityItemId) throws FaultType{
		INSERT_ENTITY_ITEM_QUERY=EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_TRIBUTI, 
				getFascicoloId(),  //2041_08_18 modifica_1
				getCallerId(), 		//2041_08_18 modifica_1
				//modifica 2041_08_18   0, 0, 
				parentEntityItemId);	
		
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + INSERT_ENTITY_ITEM_QUERY);
		return INSERT_ENTITY_ITEM_QUERY;	
	}

	//inizio 06/11/2014	 sostituisco gli statement creati da stringa con i preparedstatement usati propriamente per il problema delle stringhe che includono apici
	public void dataValueInsert(Connection connection,TributoType tributo, int cartellaEntityItemId) throws Exception{
 
		PreparedStatementWrapper preparedStatementWrapper = null;
		try { 

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");
			
			//Codice Tributo
			executeInsertDatavalue(DATA_TYPE_ID_CODICE_TRIBUTO, entityItemId,tributo.getCodiceTributo(), getFascicoloId(), getCallerId(), preparedStatementWrapper, false); 

			//Descrizione Tributo Ente
			executeInsertDatavalue(DATA_TYPE_ID_DESCRIZIONE_TRIBUTO, entityItemId,tributo.getDescrizioneTributo().concat(" ").concat(tributo.getDescrizioneTributoRuolo()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Ente impositore
			executeInsertDatavalue(DATA_TYPE_ID_ENTE_IMPOSITORE, entityItemId,tributo.getEnte().getDescrizione(), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Anno
			executeInsertDatavalue(DATA_TYPE_ID_ANNO, entityItemId,tributo.getAnnoTributo(), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Rateizzato
			executeInsertDatavalue(DATA_TYPE_ID_RATEIZZATO, entityItemId,CodificaDocumento.getRateizzabile(tributo), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Importo a ruolo iniziale
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_A_RUOLO_INIZIALE, entityItemId,CodificaDocumento.getImporto(tributo.getImportoIniziale()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Importo Pagato
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_PAGATO, entityItemId, CodificaDocumento.getImporto(tributo.getImportoPagato()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Importo Sgravato
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_SGRAVATO, entityItemId,CodificaDocumento.getImporto(tributo.getImportoSgravato()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Importi Sospesi
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTI_SOSPESI, entityItemId,CodificaDocumento.getImporto(tributo.getImportoSospeso()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
  
			//Importo Residuo
			executeInsertDatavalue(DATA_TYPE_ID_IMPORTO_RESIDUO, entityItemId,CodificaDocumento.getImporto(tributo.getImportoResiduoTotale()), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
 
			
			
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	  
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		}   
		
	}
	
	
//	public String buildCodiceTributoInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String codiceTributo=tributo.getCodiceTributo();
//		INSERT_DATA_VALUE_QUERY= buildDataValueInsert(DATA_TYPE_ID_CODICE_TRIBUTO, entityItemId, 0, cartellaEntityItemId, codiceTributo); //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildDescrizioneTributoEnteInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String descrizioneTributoEnte=tributo.getDescrizioneTributo().concat(" ").concat(tributo.getDescrizioneTributoRuolo());		
//		INSERT_DATA_VALUE_QUERY= buildDataValueInsert(DATA_TYPE_ID_DESCRIZIONE_TRIBUTO, entityItemId, 0, cartellaEntityItemId, descrizioneTributoEnte);	 //  2041_08_18 modifica_1	
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//
//	public String buildEnteImpositoreInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String enteImpositore=tributo.getEnte().getDescrizione();		
//		INSERT_DATA_VALUE_QUERY=  buildDataValueInsert(DATA_TYPE_ID_ENTE_IMPOSITORE, entityItemId, 0, cartellaEntityItemId, enteImpositore); //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildAnnoInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String anno=tributo.getAnnoTributo();
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_ANNO, entityItemId, 0, cartellaEntityItemId, anno);	 //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	
//	public String buildRateizzatoInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String rateizzato=CodificaDocumento.getRateizzabile(tributo);
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_RATEIZZATO, entityItemId, 0, cartellaEntityItemId, rateizzato);	 //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildImportoARuoloInizialeInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String importoARuoloIniziale=CodificaDocumento.getImporto(tributo.getImportoIniziale());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_IMPORTO_A_RUOLO_INIZIALE, entityItemId, 0, cartellaEntityItemId, importoARuoloIniziale);	 //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildImportoPagatoInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String importoPagato=CodificaDocumento.getImporto(tributo.getImportoPagato());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_IMPORTO_PAGATO, entityItemId, 0, cartellaEntityItemId, importoPagato);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildImportoSgravatoInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String importoSgravato=CodificaDocumento.getImporto(tributo.getImportoSgravato());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_IMPORTO_SGRAVATO, entityItemId, 0, cartellaEntityItemId, importoSgravato);//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildImportiSospesiInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String importiSospesi=CodificaDocumento.getImporto(tributo.getImportoSospeso());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_IMPORTI_SOSPESI, entityItemId, 0, cartellaEntityItemId, importiSospesi);	//  2041_08_18 modifica_1	
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	public String buildImportoResiduoInsert(TributoType tributo, int cartellaEntityItemId) throws Exception{
//		String importoAResiduo=CodificaDocumento.getImporto(tributo.getImportoResiduoCorrente());	
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_TYPE_ID_IMPORTO_RESIDUO, entityItemId, 0, cartellaEntityItemId, importoAResiduo);//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
	//fine 06/11/2014

	public void inserimentoTributoInsert(TributoType[] tributoTypeArray, 	String fascicoloId, String callerId, EntityItem cartella) throws Exception {

		Connection conn = null;
		try {
			conn = getConnection();
			inserimentoTributoInsert(tributoTypeArray, fascicoloId, callerId, cartella, conn );
		} finally {
			closeConnection();
		}
		
	}

}
