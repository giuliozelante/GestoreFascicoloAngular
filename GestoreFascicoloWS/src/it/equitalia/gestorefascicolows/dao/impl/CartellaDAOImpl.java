package it.equitalia.gestorefascicolows.dao.impl;
  
import it.equitalia.gestorefascicolows.dao.CartellaDAO;
import it.equitalia.gestorefascicolows.dao.DaoHandler;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dati.DataValue;
import it.equitalia.gestorefascicolows.dati.DocumentoType;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo; 
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.CodificaDocumento;
import it.equitalia.gestorefascicolows.utils.DateUtil;
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;
import it.equitalia.gestorefascicolows.utils.UtilsClass;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

import org.apache.log4j.Logger;  

public class CartellaDAOImpl extends EntityItemClass implements CartellaDAO {
	public static final int N_CARTELLA =  1;			 
	public static final int DESCRIZIONE_DOCUMENTO = 2;
	public static final int ENTE =  3; 
	public static final int DATA_NOTIFICA = 4 ;
	public static final int IMPORTO_INIZIALE =  5;
	public static final int IMPORTO_A_RUOLO =  6;
	public static final int COMPENSI_ENTRO_SCADENZE = 7 ;
	public static final int DIRITTI_DI_NOTIFICA = 8 ;
	public static final int IMPORTO_DA_PAGARE = 9 ; 
	public static final int IMPORTI_A_RUOLO_RESIDUI = 10 ;
	public static final int COMPENSI_OLTRE_SCADENZE =  11;
	public static final int DIRITTI_RESIDUO_DI_NOTIFICA =  12;
	public static final int INTERESSI_DI_MORA =  13;
	public static final int SPESE_DI_PROCEDURA =  14;
	public static final int ALTRE_SPESE =  15;
	public static final int NUMERO_RAV =  16;
	public static final int SOSPENSIONE = 17 ;
	public static final int SGRAVI =  18;
	public static final int RATEAZIONE = 19 ;
	public static final int PROCEDURE =  20;
	public static final int TIPO_DOCUMENTO =  21;
 
	public static final int STATO_PDF =  92;
	public static final int STATO_RELATE =  93;
//bug costante duplicata	public static final int DATA_RELATE =  94;
	public static final int DATA_AGGIORNAMENTO_RELATE =  94;
	public static final int CORRELATION_ID_PDF =  95; //  aggiunta  20-05-2015 cambio Wsdl
	public static final int CORRELATION_ID_RELATE =  96; //22-05-2015 RelateDocumentoStandard
	public static final int DATA_ULTIMO_AGGIORNAMENTO_CARTELLA =  99;  //FASCICOLO_2.1
	
	

	public static final int DOCUMENTO_ESATTORIALE_TIPO_MODELLO =  210;
	public static final int DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO =  215;
	public static final int DOCUMENTO_ESATTORIALE_IMPORTO = 220 ;
	public static final int DOCUMENTO_ESATTORIALE_DATA_SPEDIZIONE = 225 ;
	public static final int DOCUMENTO_ESATTORIALE_STATO =  291;
	public static final int DOCUMENTO_ESATTORIALE_GESTORE =  290;
	public static final int DOCUMENTO_ESATTORIALE_STATO_PDF =  292; 
	public static final int DOCUMENTO_ESATTORIALE_STATO_RELATE =  293; 	//2015-03-31 relate-doc-esattoriali
	public static final int DOCUMENTO_ESATTORIALE_DATA_AGGIORNAMENTO_RELATE =  294; //2015-03-31 relate-doc-esattoriali
	public static final int DOCUMENTO_ESATTORIALE_CORRELATION_ID_PDF =  295; //  aggiunta  20-05-2015 cambio Wsdl
	public static final int DOCUMENTO_ESATTORIALE_CORRELATION_ID_RELATE =  296;  //22-05-2015 RelateDocumentoStandard
	
	 
	public static final String STATO_DOCUMENTUM_NON_RICHIESTO =  "NR";
	public static final String STATO_DOCUMENTUM_RICHIESTO =  "RI";
	public static final String STATO_DOCUMENTUM_DISPONIBILE=  "DI";
	public static final String STATO_DOCUMENTUM_NON_DISPONIBILE=  "ND";

	private String INSERT_ENTITY_ITEM_QUERY; 
	
	

    private static Logger logger = Log4jFactory.getLogger(CartellaDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
   
   
//  2041_08_18 modifica_1 private String fascicoloID;
//  2041_08_18 modifica_1   private String callerID;
    private int entityItemId = 0;
	 

	public CartellaDAOImpl() {
	}
	
    
	public CartellaDAOImpl(boolean autocommit, String origin) throws FaultType {
		super(autocommit, origin); 
	}
	

	//inizio modifica_problema_transazioni 13/10/2014  
	

	public void inserimentoDocumentoEsattorialeNonCartellaInsert(
			Fascicolo fascicolo,
			ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType> listaDocumentiEsattoriali,
			String fascicoloId, String callerId) throws Exception {

		Connection conn = null;
		try {
			conn = getConnection();
			inserimentoDocumentoEsattorialeNonCartellaInsert(fascicolo, listaDocumentiEsattoriali, fascicoloId, callerId, conn);
		} finally {
			closeConnection();
		}
	}
	
	public void inserimentoCartellaInsert( 
			Fascicolo fascicolo,		//2041_08_18 modifica_2
			DocumentoType [] documentoTypeArray,
			String fascicoloId, String callerId, Connection conn  ) throws Exception { 
		  inserimentoCartellaInsert(fascicolo, documentoTypeArray, fascicoloId, callerId, N_CARTELLA, conn);
	}
	

	public void inserimentoCartellaInsert(Fascicolo fascicolo, DocumentoType[] documentoTypeArray, String fascicoloId, String callerId) throws Exception {

		Connection conn = null;
		try {
			conn = getConnection();
			inserimentoCartellaInsert(fascicolo, documentoTypeArray, fascicoloId, callerId, conn);
		} finally {
			closeConnection();
		}
		
		
	}
	
	//fine modifica_problema_transazioni 13/10/2014  

 
	//inizio modifica_problema_transazioni 13/10/2014  
	private void inserimentoCartellaInsert(    
			Fascicolo fascicolo,//2041_08_18 modifica_2
			DocumentoType [] documentoTypeArray,
			String fascicoloId, String callerId,  int numeroDocumentoDataTypeId, Connection connection) throws Exception {
			//inizio  2041_08_18 modifica_1
//			fascicoloID=fascicoloId;
//			callerID=callerId;
			setFascicoloId(fascicoloId);
			setCallerId(callerId);
			//fine  2041_08_18 modifica_1 
 
			if(!UtilsClass.isNotEmpty(documentoTypeArray)){
				logger.info(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_DOCUMENTO_VOID"));
		 	}
			
			logger.debug("FascicoloId: "+getFascicoloId()+"\n");
			logger.debug("CAllerId: "+getCallerId()+"\n");
			logger.debug("Numero dei documenti da elaborare: "+documentoTypeArray.length+"\n");
			  
			
			for (int i = 0; i < documentoTypeArray.length; i++) {
				//inizio 2041_08_18 modifica_2 
				
				//cerca l'entity tra quelle presenti nell'eventuale fascicolo
				entityItemId = getEntityItemId(fascicolo, documentoTypeArray[i].getIdDocumento().getNumeroDocumento(), numeroDocumentoDataTypeId,
								connection); 
				 
				if (entityItemId>-1) {
					dataValueInsertRefresh(connection,documentoTypeArray[i]);	
				} else {
					entityItemInsert(connection, EntityItemClass.ENTITY_ITEM_ID_CARTELLE);  
					dataValueInsert(connection,documentoTypeArray[i],
										false//06/11/2014
										); 	  
					 
				} 
				//fine 2041_08_18 modifica_2
				  
			}  
			logger.debug(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_DOCUMENTO_OK"));   
		}
	//fine modifica_problema_transazioni 13/10/2014  
	
 

	
	 

	

	//inizio 06/11/2014	 sostituisco gli statement creati da stringa con i preparedstatement usati propriamente per il problema delle stringhe che includono apici
	private void dataValueInsertRefresh(Connection connection, DocumentoType documento) throws Exception {
		 
		dataValueInsert(connection, documento, true); 
		
		
	}
	//fine 06/11/2014

 



	//inizio modifica_problema_transazioni 13/10/2014
//	private int getEntityItemId(Fascicolo fascicolo,
//			String numeroDocumento, //DocumentoType documentoType, 
//			int numeroDocumentoDataTypeId) {
//		 
//		if (fascicolo==null) {
//			return -1; 
//		}
//		for (EntityItem  entityItem: fascicolo.getCartelle()  ) {
//			 
//			for (DataValue data : entityItem.getDataValues()) {
//				if (data.getDataTypeId() == numeroDocumentoDataTypeId && data.getValue().equals( numeroDocumento )   ) {
//					return entityItem.getEntityItemId();
//				}
//			}
//		}
//		
//		return -1;
//		 
//	} 
	
	
	private int getEntityItemId(Fascicolo fascicolo, String numeroDocumento,  int numeroDocumentoDataTypeId, Connection connection) throws SQLException { 
		int entityItemId = -1;
		
		if (fascicolo!=null) {
			
			PreparedStatementWrapper preparedStatement = null;
			ResultSet rs = null;
			try {
				String query = " select dv.ENTITYITEMID " +
							   "		from gestore_fascicolo.datavalue  dv " +
							   "			inner join gestore_fascicolo.entityitem ei  on(dv.ENTITYITEMID = ei.ENTITYITEMID)  " +
							   " WHERE  dv.fascicoloId = ?  " +
							   " AND dv.callerId = ? " +
							   " AND dv.dataTypeId =  " +  numeroDocumentoDataTypeId +
							   " AND dv.VALUE = ?  " +
							   " AND ei.fascicoloId = ?  " +
							   " AND ei.callerId = ? " ;
				
				preparedStatement =  new PreparedStatementWrapper(connection, query);  
				preparedStatement.setString(1, fascicolo.getFascicoloId() );  
				preparedStatement.setString(2, fascicolo.getCallerId() );
				preparedStatement.setString(3, numeroDocumento );
				preparedStatement.setString(4, fascicolo.getFascicoloId() );
				preparedStatement.setString(5, fascicolo.getCallerId() );
				
				
				rs= preparedStatement.executeQuery();
			
				if (rs!=null && rs.next()) {
					entityItemId = rs.getInt("ENTITYITEMID");
				}
			
			}  finally{
				if (preparedStatement!=null) {
					preparedStatement.close();					
				}
				if (rs!=null) {
					rs.close();
				}
			} 
			
		}
		
		return entityItemId;
		 
	} 
	//fine  modifica_problema_transazioni 13/10/2014
	

	public void updateValue(String numeroDocumento, int dataTypeId, String value, String fascicoloId, String callerId, boolean isCartella) throws Exception { 
	 
		int entityItemId; 
		ResultSet rs = null;
		PreparedStatementWrapper ps =null; 
		Connection conn =null; 
			
		String query = " select ENTITYITEMID " +
				" from gestore_fascicolo.dataValue " +
				" where dataTypeid = " +  (isCartella?N_CARTELLA:DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO) +
				"  AND value = ? " +
				"  AND fascicoloid = ? " +
				"  AND callerid = ? " ;
		try {
			conn = getConnection();

			ps =  new PreparedStatementWrapper(conn, query);
			ps.setString(1, numeroDocumento);  
			ps.setString(2, fascicoloId);  
			ps.setString(3, callerId);  
			
			rs = ps.executeQuery();
			
			if (rs!=null && rs.next() ) {
				entityItemId  = rs.getInt("ENTITYITEMID");
				
				EntityDAO entityDAO = new EntityDAO(); 
				
				entityDAO.updateDataValue( entityItemId,  dataTypeId,  value);
			} else{
				throw new Exception ("Impossibile trovare ENTITYITEMID");
			}

			
		} finally{  
			if (rs!=null) {
				rs.close();
			} 
			if (ps!=null) {
				ps.close();
			} 
			if (conn!= null) {
				conn.commit();
				conn.close();
			}
		} 
		 
	}



	//inizio modifica_problema_transazioni 13/10/2014
	private void entityItemInsert(Connection connection, int entityId) throws Exception{  
	 
		String entityItemeInsertQuery=buildEntityItemInsert(entityId);
		PreparedStatementWrapper preparedStatement = null;
		try {
			preparedStatement = new PreparedStatementWrapper(connection, entityItemeInsertQuery, new String[]{"ENTITYITEMID"} ); 
			preparedStatement.executeQuery();
			ResultSet rs =  preparedStatement.getGeneratedKeys();
			if(rs.next()){
				entityItemId=rs.getInt(1);
				logger.debug("INSERITO ENTITYITEM CON ID[" + entityItemId +  "]");
			} else{
				throw new Exception( MessagesClass.getMessage("ERROR_GENERATED_KEYS") );
			}
			
		}  catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT" )+ e.getMessage(), e);
			throw e;
		}  
	}
	//fine modifica_problema_transazioni 13/10/2014
	

	
	//inizio 06/11/2014	 sostituisco gli statement creati da stringa con i preparedstatement usati propriamente per il problema delle stringhe che includono apici
	private void dataValueInsert(Connection connection,DocumentoType documento, 
				boolean refresh //06/11/2014	
				) throws Exception{ 	

		 
		PreparedStatementWrapper preparedStatementWrapper = null;
		try {
			

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
			

			//Descrizione
			executeInsertDatavalue(DESCRIZIONE_DOCUMENTO, entityItemId, CodificaDocumento.getDescrizione(documento), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			 
			//N ° Cartella
			executeInsertDatavalue(N_CARTELLA, entityItemId, documento.getIdDocumento().getNumeroDocumento(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);

			//Ente
			executeInsertDatavalue(ENTE, entityItemId, documento.getEnte()[0].getDescrizione(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			
			//Data Notifica		String dataNotifica=UtilsClass.getDataStandard(documento.getDataNotifica());
			String dataNotifica=UtilsClass.getDataStandard(documento.getDataNotifica());
			if (dataNotifica.equals("0001-01-01")){
				dataNotifica="";
			}
			executeInsertDatavalue(DATA_NOTIFICA, entityItemId, dataNotifica, getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);


			//Importo iniziale
			executeInsertDatavalue(IMPORTO_INIZIALE, entityItemId, CodificaDocumento.getImporto(documento.getImportoTotaleDocumento()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);



			//Importo da pagare
			executeInsertDatavalue(IMPORTO_DA_PAGARE, entityItemId, CodificaDocumento.getImporto(documento.getImportoResiduoDocumento()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);



			//Sospensione
			executeInsertDatavalue(SOSPENSIONE, entityItemId, CodificaDocumento.getSospensioni(documento), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			 

			//Sgravi
			executeInsertDatavalue(SGRAVI, entityItemId, CodificaDocumento.getSgravi(documento), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 

			//Rateazioni
			executeInsertDatavalue(RATEAZIONE, entityItemId, CodificaDocumento.getRateazioni(documento), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 

			//Procedure
			executeInsertDatavalue(PROCEDURE, entityItemId, CodificaDocumento.getProcedure(documento), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 

			//Importo a ruolo
			executeInsertDatavalue(IMPORTO_A_RUOLO, entityItemId, CodificaDocumento.getImporto(documento.getImportoInizialeTributi()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);

			
			//Compoensi entro scadenze
			executeInsertDatavalue(COMPENSI_ENTRO_SCADENZE, entityItemId, CodificaDocumento.getImporto(documento.getImportoTotaleCompensi()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 
			 
			//Diritti di notifica
			executeInsertDatavalue(DIRITTI_DI_NOTIFICA, entityItemId, CodificaDocumento.getImporto(documento.getImportoTotaleNotifica()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 

			//Numero rav
			if (!documento.getNumeroRav().equals("0")){
				executeInsertDatavalue(NUMERO_RAV, entityItemId, documento.getNumeroRav(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			}

			//Importi a ruolo residui
			executeInsertDatavalue(IMPORTI_A_RUOLO_RESIDUI, entityItemId, CodificaDocumento.getImporto(documento.getImportoResiduoTributi()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 

			//Compensi oltre scadenze
			executeInsertDatavalue(COMPENSI_OLTRE_SCADENZE, entityItemId, CodificaDocumento.getImporto(documento.getImportoResiduoCompensi()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 
			
			//Diritti di notifica
			executeInsertDatavalue(DIRITTI_RESIDUO_DI_NOTIFICA, entityItemId, CodificaDocumento.getImporto(documento.getImportoResiduoNotifica()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 
			//Interessi di mora
			executeInsertDatavalue(INTERESSI_DI_MORA, entityItemId, CodificaDocumento.getImporto(documento.getImportoInteressiMora()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
	  
			//Altre spese
			executeInsertDatavalue(ALTRE_SPESE, entityItemId, CodificaDocumento.getImporto(documento.getImportoAltreSpese()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
 

			//Spese di procedura
			executeInsertDatavalue(SPESE_DI_PROCEDURA, entityItemId, CodificaDocumento.getImporto(documento.getImportoSpeseProcedure()), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
  
			executeInsertDatavalue(STATO_PDF, entityItemId, documento.getStatoPdf(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			executeInsertDatavalue(STATO_RELATE, entityItemId, documento.getStatoRelate(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			executeInsertDatavalue(DATA_AGGIORNAMENTO_RELATE, entityItemId, DateUtil.getEmptyDateValue(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			
			executeInsertDatavalue(CORRELATION_ID_PDF, entityItemId, "", getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh); 		//  aggiunta  20-05-2015 cambio Wsdl
			executeInsertDatavalue(CORRELATION_ID_RELATE, entityItemId, "", getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh); 	//22-05-2015 RelateDocumentoStandard
			
			//tipo documento
			executeInsertDatavalue(TIPO_DOCUMENTO, entityItemId, documento.getIdDocumento().getTipoDocumento(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			 
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	//modifica_problema_transazioni 13/10/2014
			//modifica_problema_transazioni 13/10/2014 return false;
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		} 
		//modifica_problema_transazioni 13/10/2014 return true;
	}
	//fine 06/11/2014
	
	private String buildEntityItemInsert(int entityId) throws FaultType{
		INSERT_ENTITY_ITEM_QUERY=EntityItemClass.buildEntityItemInsert(entityId, 
				getFascicoloId(), //  2041_08_18 modifica_1
				getCallerId(), //  2041_08_18 modifica_1
				//modifica 2041_08_18  0, 0,
				0);	 
		return INSERT_ENTITY_ITEM_QUERY;
	}
	
//inizio 06/11/2014	
//	private String buildDescrizioneInsert (DocumentoType documento) throws Exception{
//		String descrizione=CodificaDocumento.getDescrizione(documento);
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DESCRIZIONE_DOCUMENTO  , entityItemId, 0, 0, descrizione); //  2041_08_18 modifica_1	
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildNCartellaInsert(DocumentoType documento) throws Exception{
//		String numeroCartella=documento.getIdDocumento().getNumeroDocumento();
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(N_CARTELLA  , entityItemId, 0, 0, numeroCartella);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	 
//
//
//	private String buildEnteInsert(DocumentoType documento) throws Exception{
//		String ente=documento.getEnte()[0].getDescrizione();
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(ENTE , entityItemId, 0, 0, ente);//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildDataNotificaInsert(DocumentoType documento) throws Exception{
//		String dataNotifica=UtilsClass.getDataStandard(documento.getDataNotifica());
//		if (dataNotifica.equals("0001-01-01")){
//			dataNotifica="";
//		}
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(DATA_NOTIFICA , entityItemId, 0, 0, dataNotifica);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildImportoInizialeInsert(DocumentoType documento) throws Exception{
//		String importoIniziale=CodificaDocumento.getImporto(documento.getImportoTotaleDocumento());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( IMPORTO_INIZIALE , entityItemId, 0, 0, importoIniziale);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String  buildImportoDaPagareInsert(DocumentoType documento) throws Exception{
//		String importoResiduoDocumento=CodificaDocumento.getImporto(documento.getImportoResiduoDocumento());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(IMPORTO_DA_PAGARE , entityItemId, 0, 0, importoResiduoDocumento);//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildSospensioneInsert(DocumentoType documento) throws Exception{
//		String sospensioni=CodificaDocumento.getSospensioni(documento);		
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( SOSPENSIONE , entityItemId, 0, 0, sospensioni);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildSgraviInsert(DocumentoType documento) throws Exception{
//		String sgravi=CodificaDocumento.getSgravi(documento);
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( SGRAVI , entityItemId, 0, 0, sgravi);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildRateazioniInsert(DocumentoType documento) throws Exception{
//		String rateazioni=CodificaDocumento.getRateazioni(documento);
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( RATEAZIONE , entityItemId, 0, 0, rateazioni);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildProcedureInsert(DocumentoType documento) throws Exception{
//		String procedure=CodificaDocumento.getProcedure(documento);	
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(  PROCEDURE  , entityItemId, 0, 0, procedure);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildImportoARuoloInsert(DocumentoType documento) throws Exception{
//		String importoARuolo=CodificaDocumento.getImporto(documento.getImportoInizialeTributi());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(  IMPORTO_A_RUOLO , entityItemId, 0, 0, importoARuolo);		//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildCompensiEntroScadenzeInsert(DocumentoType documento) throws Exception{
//		String compensiEntroScadenze=CodificaDocumento.getImporto(documento.getImportoTotaleCompensi());		
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( COMPENSI_ENTRO_SCADENZE , entityItemId, 0, 0, compensiEntroScadenze);	//  2041_08_18 modifica_1	
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildDirittiDiNotificaInsert(DocumentoType documento) throws Exception{
//		String dirittiDiNotifica=CodificaDocumento.getImporto(documento.getImportoTotaleNotifica());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( DIRITTI_DI_NOTIFICA , entityItemId, 0, 0, dirittiDiNotifica);//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildNumeroRavInsert(DocumentoType documento) throws Exception{
//		String numeroRav=documento.getNumeroRav();
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( NUMERO_RAV , entityItemId, 0, 0, numeroRav);	//  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//
//	
//	private String buildImportiARuoloResiduiInsert(DocumentoType documento) throws Exception{
//		String importiARuoloResidui=CodificaDocumento.getImporto(documento.getImportoResiduoTributi());		
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( IMPORTI_A_RUOLO_RESIDUI , entityItemId, 0, 0, importiARuoloResidui);		 //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildCompensiOltreScadenzeInsert(DocumentoType documento) throws Exception{
//		String compensiOltreScadenze=CodificaDocumento.getImporto(documento.getImportoResiduoCompensi());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( COMPENSI_OLTRE_SCADENZE , entityItemId, 0, 0, compensiOltreScadenze); //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//
//	}
//	
//	private String buildDirittiResiduoDiNotificaInsert(DocumentoType documento) throws Exception{
//		String dirittiResiduoDiNotifica=CodificaDocumento.getImporto(documento.getImportoResiduoNotifica());	
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( DIRITTI_RESIDUO_DI_NOTIFICA  , entityItemId, 0, 0, dirittiResiduoDiNotifica);  //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildInteressiDiMoraInsert(DocumentoType documento) throws Exception{
//		String interessiDiMora=CodificaDocumento.getImporto(documento.getImportoInteressiMora());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert(INTERESSI_DI_MORA  , entityItemId, 0, 0, interessiDiMora);  //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildAltreSpeseInsert(DocumentoType documento) throws Exception{
//		String altreSpese=CodificaDocumento.getImporto(documento.getImportoAltreSpese());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( ALTRE_SPESE , entityItemId, 0, 0, altreSpese);   //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
//	
//	private String buildSpeseDiProceduraInsert(DocumentoType documento) throws Exception{
//		String speseDiProcedura=CodificaDocumento.getImporto(documento.getImportoSpeseProcedure());
//		INSERT_DATA_VALUE_QUERY=buildDataValueInsert( SPESE_DI_PROCEDURA , entityItemId, 0, 0, speseDiProcedura); //  2041_08_18 modifica_1
//		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_DATA_VALUE_INSERT")+ "\n" + INSERT_DATA_VALUE_QUERY);
//		return INSERT_DATA_VALUE_QUERY;
//	}
	//inizio 06/11/2014	


	public boolean documentoEsistente(String numeroDocumento) throws SQLException { 
		boolean result = true; 
		ResultSet rs = null;
		PreparedStatementWrapper ps =null; 
		Connection conn =null; 
			
		String query = " select ENTITYITEMID " +
				" from gestore_fascicolo.dataValue " +
				" where ( dataTypeid = " + N_CARTELLA + " or  dataTypeid = " + DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO + " ) " +
				" AND value = ?" ;
		try {
			conn = getConnection();

			ps =  new PreparedStatementWrapper(conn, query);
			ps.setString(1, numeroDocumento);  
			
			rs = ps.executeQuery();
			
			if (rs==null || !rs.next() ) {
				result = false;
			}  
			
		} finally{  
			if (rs!=null) {
				rs.close();
			} 
			if (ps!=null) {
				ps.close();
			} 
			if (conn!= null) {
				conn.close();
			}
		} 
		
		return result;
	}


	public boolean pdfEsistente(String numeroDocumento) throws SQLException { 
		boolean result = false; 
		ResultSet rs = null;
		PreparedStatementWrapper ps =null; 
		Connection conn =null; 
			
		String query = " select dt2.value " +
				"	from gestore_fascicolo.dataValue dt1 join gestore_fascicolo.dataValue dt2 on(dt1.ENTITYITEMID  = dt2.ENTITYITEMID) " +
				"	where dt1.dataTypeid = " + N_CARTELLA +
				"		AND dt1.value = ?  " +
				"		AND dt2.DATATYPEID =  " +  STATO_PDF ;
		try {
			conn = getConnection();

			ps =  new PreparedStatementWrapper(conn, query);
			ps.setString(1, numeroDocumento);  
			
			rs = ps.executeQuery();
			
			if (rs!=null && rs.next() ) {
				String statoDocumentum = rs.getString("value");
				if ( statoDocumentum.equals(STATO_DOCUMENTUM_DISPONIBILE) ) {
					result = true; 
				}
			}

			
		} finally{  
			if (rs!=null) {
				rs.close();
			} 
			if (ps!=null) {
				ps.close();
			} 
			if (conn!= null) {
				conn.close();
			}
		} 
		
		return result;
	
	}


	public void inserimentoDocumentoEsattorialeNonCartellaInsert(
			Fascicolo fascicolo,
			ArrayList<it.equitalia.documentiesattoriali.bpel.DocumentoType> listaDocumentiEsattoriali,
			String fascicoloId, String callerId, Connection connection) throws Exception {
 
		setFascicoloId(fascicoloId);
		setCallerId(callerId);
 
		boolean esito=true;  
		
		if( listaDocumentiEsattoriali.size() == 0){
			logger.info(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_DOCUMENTO_VOID"));
			 
		}
		
		logger.debug("FascicoloId: "+getFascicoloId()+"\n");
		logger.debug("CallerId: "+getCallerId()+"\n");
		logger.debug("Numero dei doccumenti esattoriali non cartelle da elaborare: "+ listaDocumentiEsattoriali.size()+"\n");
		  
		
		for (int i = 0; i < listaDocumentiEsattoriali.size()  ; i++) {
			it.equitalia.documentiesattoriali.bpel.DocumentoType documentoEsattoriale = listaDocumentiEsattoriali.get(i);
			
			//cerca l'entity tra quelle presenti nell'eventuale fascicolo
			entityItemId = getEntityItemId(fascicolo, documentoEsattoriale.getNumeroDocumento(), DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO,
										connection); 
			 
			if (entityItemId>-1) {
				try { 
					dataValueInsert (connection, documentoEsattoriale, getFascicoloId(), getCallerId(), true)	;
					esito = true;
				} catch (Exception e) {
					logger.error("",e);
					throw e;
				}
			} else{

				//inizio modifica_problema_transazioni 13/10/2014
				entityItemInsert(connection, EntityItemClass.ENTITY_ITEM_ID_DOCUMENTI_ESATTORIALI); 
				dataValueInsert (connection, documentoEsattoriale, getFascicoloId(), getCallerId(), false)	;  
				//fine modifica_problema_transazioni 13/10/2014
				 
			} 
			
			if(!esito){ 
				throw new Exception(MessagesClass.getMessage("ESITO_INSERIMENTO_DOCUMENTO_NOK").concat(";").concat(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_DOCUMENTO_NOK")));   
			}
		} 
		if (esito) {
			logger.debug(MessagesClass.getMessage("DESCRIZIONE_INSERIMENTO_DOCUMENTO_OK")); 
			logger.debug(MessagesClass.getMessage("CONNESSIONE_CHIUSA"));
		}  
 
	}


	//inizio modifica_problema_transazioni 13/10/2014
	private void  dataValueInsert(Connection connection, it.equitalia.documentiesattoriali.bpel.DocumentoType documentoEsattoriale,String fascicoloId, String callerId,
			boolean refresh) throws  Exception { 
		
		
		PreparedStatementWrapper preparedStatementWrapper = null;
		
		try{
			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
			
			
			
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_DATA_SPEDIZIONE, entityItemId, documentoEsattoriale.getDataSpedizione()==null?"":documentoEsattoriale.getDataSpedizione(), fascicoloId, callerId, preparedStatementWrapper, refresh);
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_TIPO_MODELLO, entityItemId, documentoEsattoriale.getTipoModello() , fascicoloId, callerId, preparedStatementWrapper, refresh);
//per adesso non lo mettiamo
//			executeInsert(DOCUMENTO_ESATTORIALE_GESTORE, entityItemId, 
//							 	"gestore", 
//								fascicoloId, callerId, preparedStatementWrapper, refresh);		
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_IMPORTO, entityItemId, documentoEsattoriale.getImporto() , fascicoloId, callerId, preparedStatementWrapper, refresh);
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_NUMERO_DOCUMENTO, entityItemId, documentoEsattoriale.getNumeroDocumento() , fascicoloId, callerId, preparedStatementWrapper, refresh);
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_STATO , entityItemId, documentoEsattoriale.getStatoDocumento() , fascicoloId, callerId, preparedStatementWrapper, refresh);
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_STATO_PDF , entityItemId, STATO_DOCUMENTUM_NON_RICHIESTO, fascicoloId, callerId, preparedStatementWrapper, refresh);
			 
			//inizio 2015-03-31 relate-doc-esattoriali 
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_STATO_RELATE, entityItemId, CartellaDAOImpl.STATO_DOCUMENTUM_NON_RICHIESTO, getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_DATA_AGGIORNAMENTO_RELATE, entityItemId, DateUtil.getEmptyDateValue(), getFascicoloId(), getCallerId(), preparedStatementWrapper, refresh);
			//fine 2015-03-31 relate-doc-esattoriali
			
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_CORRELATION_ID_PDF , entityItemId, "", fascicoloId, callerId, preparedStatementWrapper, refresh);  //  aggiunta  20-05-2015 cambio Wsdl
			executeInsertDatavalue(DOCUMENTO_ESATTORIALE_CORRELATION_ID_RELATE , entityItemId, "", fascicoloId, callerId, preparedStatementWrapper, refresh);  //	22-05-2015 RelateDocumentoStandard	
			
			
		} catch (Exception e) {
				errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
				throw e;
		} finally{ 
			if (preparedStatementWrapper != null) { 
				preparedStatementWrapper.close();
			}
		}     
	}
	//fine modifica_problema_transazioni 13/10/2014


	//inizio FASCICOLO_2.1
	public void insertOrUpdateDataUltimoAggiornamento(EntityItem cartellaEntityItem, Fascicolo fascicolo) throws Exception{ 	
		Connection conn = getConnection();
		PreparedStatementWrapper preparedStatementWrapper = null; 
 
		try { 
			preparedStatementWrapper = new PreparedStatementWrapper(conn, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  

			executeInsertDatavalue(DATA_ULTIMO_AGGIORNAMENTO_CARTELLA, 
					cartellaEntityItem.getEntityItemId(), 
					DateUtil.getActualDateValue(), 
					fascicolo.getFascicoloId(), 
					fascicolo.getCallerId(), 
					preparedStatementWrapper, 
					false);
			 
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e; 
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
			closeConnection();
		} 
			
	}
	//fine FASCICOLO_2.1


}
