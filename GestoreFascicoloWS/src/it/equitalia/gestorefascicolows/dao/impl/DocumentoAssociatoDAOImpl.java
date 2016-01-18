package it.equitalia.gestorefascicolows.dao.impl;
 
import java.sql.Connection; 
import java.sql.ResultSet; 

import org.apache.log4j.Logger;

import it.equitalia.gestorefascicolows.dao.DocumentoAssociatoDAO;
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.IdentificativoDocumentoType; 
import it.equitalia.gestorefascicolows.srv.FaultType; 
import it.equitalia.gestorefascicolows.utils.EntityItemClass;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass; 

/**
 *  ModDocumentiAssociati
 */
public class DocumentoAssociatoDAOImpl extends EntityItemClass implements DocumentoAssociatoDAO	 { 
	public static final int  DATA_TYPE_ID_N_DOCUMENTO_ASSOCIATO_PIANO_RATEAZIONE =  455;
	public static final int  DATA_TYPE_ID_N_DOCUMENTO_ASSOCIATO_PROCEDURA =  355;
	
	private static Logger logger = Log4jFactory.getLogger(DocumentoAssociatoDAOImpl.class);
    private static Logger errorLogger = Log4jFactory.getErrorLogger();
	private int entityItemId = 0;

	public DocumentoAssociatoDAOImpl( )   {  }
	
	
	public DocumentoAssociatoDAOImpl(boolean autocommit, String origin) throws FaultType {
		super(autocommit, origin); 
	}
			
	

	public void inserimentoDocumentoAssociatoProceduraInsert(
			IdentificativoDocumentoType[] documentiAssociati, String fascicoloId,
			String callerId,   int parentEntityItemId, Connection connection) throws  Exception { 

		setFascicoloId(fascicoloId);
		setCallerId(callerId);
		  
		logger.debug("Numero dei documenti associati ai piani: "+ documentiAssociati.length+"\n");
 
		for (int i = 0; i < documentiAssociati.length; i++) {
			documentoAssociatoProceduraEntityItemInsert(connection,   parentEntityItemId );  //bug 2015-03-11  i documenti associati alle procedure vengono inseriti come documenti associati ai piani di rateazione
			documentoAssociatoDataValueInsert(connection, documentiAssociati[i], DATA_TYPE_ID_N_DOCUMENTO_ASSOCIATO_PROCEDURA );	
			
		}   
	}
	
	
	public void inserimentoDocumentoAssociatoPianoRateazioneInsert(
			IdentificativoDocumentoType[] documentiAssociati, String fascicoloId,
			String callerId,   int parentEntityItemId, Connection connection) throws  Exception { 

		setFascicoloId(fascicoloId);
		setCallerId(callerId);
		  
		logger.debug("Numero dei documenti associati ai piani: "+ documentiAssociati.length+"\n");
 
		for (int i = 0; i < documentiAssociati.length; i++) {
			documentoAssociatoPianoRateazioneEntityItemInsert(connection,   parentEntityItemId ); 
			documentoAssociatoDataValueInsert(connection, documentiAssociati[i], DATA_TYPE_ID_N_DOCUMENTO_ASSOCIATO_PIANO_RATEAZIONE  );	 
		}   
	}
	
	//inizio bug 2015-03-11  i documenti associati alle procedure vengono inseriti come documenti associati ai piani di rateazione
	private void documentoAssociatoPianoRateazioneEntityItemInsert(Connection connection, int parentEntityItemId) throws Exception{ 
		String entityItemeInsertQuery=buildDocumentoAssociatoPianoRateazioneEntityItemInsert(parentEntityItemId);
		PreparedStatementWrapper preparedStatement = null; 
		preparedStatement = PreparedStatementWrapper.prepareStatement(connection, entityItemeInsertQuery,new String[]{"ENTITYITEMID"}) ;
		preparedStatement.executeQuery();
		ResultSet rs =  preparedStatement.getGeneratedKeys();
		if(rs.next()){
			entityItemId=rs.getInt(1);
		} else{
			throw new Exception( MessagesClass.getMessage("ERROR_GENERATED_KEYS") );
		}
	}
	

	private void documentoAssociatoProceduraEntityItemInsert(Connection connection, int parentEntityItemId) throws Exception{ 
		String entityItemeInsertQuery=buildDocumentoAssociatoProceduraEntityItemInsert(parentEntityItemId);
		PreparedStatementWrapper preparedStatement = null; 
		preparedStatement = PreparedStatementWrapper.prepareStatement(connection, entityItemeInsertQuery,new String[]{"ENTITYITEMID"});
		preparedStatement.executeQuery();
		ResultSet rs =  preparedStatement.getGeneratedKeys();
		if(rs.next()){
			entityItemId=rs.getInt(1);
		} else{
			throw new Exception( MessagesClass.getMessage("ERROR_GENERATED_KEYS") );
		}
	}

	private String buildDocumentoAssociatoProceduraEntityItemInsert( int parentEntityItemId) throws FaultType{
		String res = EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_DOCUMENTI_ASSOCIATI_PROCEDURE, 
													getFascicoloId(),  
													getCallerId(),   
													parentEntityItemId);
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + res);
		return res;
		
	}
	//fine bug 2015-03-11
	
	private String buildDocumentoAssociatoPianoRateazioneEntityItemInsert( int parentEntityItemId) throws FaultType{
		String res = EntityItemClass.buildEntityItemInsert(EntityItemClass.ENTITY_ITEM_ID_DOCUMENTI_ASSOCIATI_PIANI_DI_REATEAZIONE, 
													getFascicoloId(),  
													getCallerId(),   
													parentEntityItemId);
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_ENTITY_ITEM_INSERT")+ "\n" + res);
		return res;
		
	}
	
	
	
	public void documentoAssociatoDataValueInsert(Connection connection,IdentificativoDocumentoType documentoAssociato, int  dataType) throws Exception{
		  
		PreparedStatementWrapper preparedStatementWrapper = null;
		try {

			preparedStatementWrapper = new PreparedStatementWrapper(connection, 
					"INSERT INTO GESTORE_FASCICOLO.DATAVALUE  " +
					"(DATATYPEID,ENTITYITEMID,PARENTDATATYPEID," +
					"PARENTENTITYITEMID,VALUE, fascicoloId, callerId,  	persistence )  " +
					"VALUES (?,?,0,0,?,?,?,?)");  
			
			//N°DOC 
			executeInsertDatavalue(dataType, entityItemId, documentoAssociato.getNumeroDocumento(), getFascicoloId(), getCallerId(), preparedStatementWrapper, false);
			     
		} catch (Exception e) {
			errorLogger.error(MessagesClass.getMessage("ERRORE_QUERY_DATA_VALUE_DESCRIZIONE")+ e.getMessage(), e);
			throw e;	  
		} finally{
			if (preparedStatementWrapper != null) { 
				try {  	preparedStatementWrapper.close(); } catch (Exception e2) {  }
			}
		}  
		 
	}

}
