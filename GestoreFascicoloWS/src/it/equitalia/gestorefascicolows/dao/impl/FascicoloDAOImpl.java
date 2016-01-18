package it.equitalia.gestorefascicolows.dao.impl;

 
  
import it.equitalia.gestorefascicolows.dao.DaoHandler;
import it.equitalia.gestorefascicolows.dao.EntityDAO;
import it.equitalia.gestorefascicolows.dao.FascicoloDAO; 
import it.equitalia.gestorefascicolows.dao.PreparedStatementWrapper;
import it.equitalia.gestorefascicolows.dati.Anagrafica;
import it.equitalia.gestorefascicolows.dati.AperturaFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.ChiusuraFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.EMail;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.FascicoloList;
import it.equitalia.gestorefascicolows.dati.Indirizzo;
import it.equitalia.gestorefascicolows.dati.Telefono;
import it.equitalia.gestorefascicolows.srv.FaultType;
import it.equitalia.gestorefascicolows.utils.Convertions;
import it.equitalia.gestorefascicolows.utils.Log4jFactory;
import it.equitalia.gestorefascicolows.utils.MessagesClass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;



public class FascicoloDAOImpl extends DaoHandler implements FascicoloDAO {
	public static final int STATO_FASCICOLO_APERTO = 10;
	public static final int STATO_FASCICOLO_CHIUSO = 90; 

	public static final String ANAGRAFICA_INDIRIZZO_PRINCIPALE_SI = "S";
	public static final String ANAGRAFICA_INDIRIZZO_PRINCIPALE_NO = "N";
	

	private static Logger logger = Log4jFactory
			.getLogger(FascicoloDAOImpl.class);
	private static Logger errorLogger = Log4jFactory.getErrorLogger();

	private String INSERT_FASCICOLO_QUERY;
	//inizio 06/11/2014	private String INSERT_ANAGRAFICA_FASCICOLO_QUERY;
	//inizio 06/11/2014 private String INSERT_ANGRAFICA_INDIRIZZO_QUERY;

	private String UPDATE_CHIUSURA_FASCICOLO_QUERY;
	


	private int anagraficaFascicoloId = 0;
	private int anagraficaIndirizzoId = 0;


	public FascicoloDAOImpl() {
	}
	
	public FascicoloDAOImpl(boolean autoCommit, String origin) throws FaultType {
		super(autoCommit, origin);
	}

	public String aperturaFascicoloInsert(AperturaFascicoloWSRequest request)
			throws FaultType, SQLException {
		String output = "";
		boolean esito = true;
		Connection connection = getConnection();
		esito = executeQueryInsertFascicolo(request, connection);
		if (esito) {
			esito = executeQueryInsertAnagraficaFascicolo(request, connection);
		}
		if (esito) {
			esito = executeQueryInsertAnagraficaIndirizzo(request, connection);
		}
		if (esito) {
			logger.debug(MessagesClass
					.getMessage("ESITO_APERTURA_FASCICOLO_OK"));
			closeConnection();
			logger.debug(MessagesClass.getMessage("CONNESSIONE_CHIUSA"));
		} else {
			rollback(connection);
			output = MessagesClass.getMessage("ESITO_APERTURA_FASCICOLO_NOK").concat(";").concat(MessagesClass.getMessage("DESCRIZIONE_APERTURA_FASCICOLO_NOK"));
		}
		if (esito) {
			output = MessagesClass.getMessage("ESITO_APERTURA_FASCICOLO_OK").concat(";").concat(MessagesClass.getMessage("DESCRIZIONE_APERTURA_FASCICOLO_OK"));;
		}
		return output;
	}

	private boolean executeQueryInsertFascicolo(
			AperturaFascicoloWSRequest request, Connection connection)
			throws FaultType {
		String insertFascicoloQuery = buildInsertFascicoloQuery(request);
		CallableStatement callableStatement = null;
		boolean esito = false;
		try {
			callableStatement = connection.prepareCall(insertFascicoloQuery);
			callableStatement.executeUpdate();
			esito = true;
			callableStatement.close();
		} catch (SQLException e) {
			errorLogger.error(MessagesClass
					.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			errorLogger.error(MessagesClass
					.getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ")
					+ e.getMessage());
			e.printStackTrace();
		}

		return esito;
	}

	//inizio 06/11/2014
	private boolean executeQueryInsertAnagraficaFascicolo(
			AperturaFascicoloWSRequest request, Connection connection)
			throws FaultType, SQLException {
		PreparedStatementWrapper preparedStatement = null;   
		ResultSet rs = null;
		boolean esito = false;
		try {
			preparedStatement = buildInsertAnagraficaFascicoloQuery(request, connection, new String[]{"ANAGRAFICAFASCICOLOID"} ); 
			preparedStatement.executeUpdate();
			rs =  preparedStatement.getGeneratedKeys();
			if(rs.next()){
				anagraficaFascicoloId=rs.getInt(1);
			}
			esito = true;
			preparedStatement.close();
		} catch (Exception e) {
			errorLogger.error(MessagesClass .getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ") + e.getMessage(), e);
			e.printStackTrace();
			esito = false;
		} finally{
			if (rs!=null) {
				rs.close();
			}
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
		}
		return esito;
	}
	//fine  06/11/2014

	private boolean executeQueryInsertAnagraficaIndirizzo(
			AperturaFascicoloWSRequest request, Connection connection)
			throws FaultType, SQLException {
		
		PreparedStatementWrapper preparedStatement = null;   
		ResultSet rs = null;
		boolean esito = false;
		try {
			preparedStatement = buildInsertAnagraficaIndirizzoQuery(request, true, connection, new String[]{"ANAGRAFICAINDIRIZZOID"} ); 
			preparedStatement.executeUpdate();
			rs =  preparedStatement.getGeneratedKeys();
			if(rs.next()){
				anagraficaIndirizzoId=rs.getInt(1);
			}
			esito = true;
			preparedStatement.close();
		} catch (Exception e) {
			errorLogger.error(MessagesClass .getMessage("ERRORE_QUERY_APERTURA_FASCICOLO ") + e.getMessage(), e);
			e.printStackTrace();
			esito = false;
		} finally{
			if (rs!=null) {
				rs.close();
			}
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
		}
		return esito; 
		  
	}

	//inizio  FASCICOLO_2.1
	
	
	public void dataUltimoAggiornamentoDocumentiEsattorialiUpdate(Fascicolo fascicolo, Connection conn) throws Exception  {  
		PreparedStatementWrapper ps = null;
		
		try { 
			ps =  new PreparedStatementWrapper( conn
							, "UPDATE GESTORE_FASCICOLO.Fascicolo   " +
									" SET DATAULTIMOAGGIORNAMENTODE = ?  " +
									" WHERE fascicoloId = ? AND callerId = ? ");

			ps.setDate(1, Calendar.getInstance() );
			ps.setString(2, fascicolo.getFascicoloId() );
			ps.setString(3, fascicolo.getCallerId() );
			
			ps.executeUpdate();
			 
		} catch (Exception e) {
			errorLogger.error("", e);
			e.printStackTrace();
		} finally {
			if (ps!=null) {
				ps.close();
			} 
		}
		
	}
	
	public void dataUltimoAggiornamentoUpdate(Fascicolo fascicolo, Connection conn) throws Exception  {  
		PreparedStatementWrapper ps = null;
		
		try { 
			ps =  new PreparedStatementWrapper( conn
							, "UPDATE GESTORE_FASCICOLO.Fascicolo   " +
									" SET DATAULTIMOAGGIORNAMENTO = ?  " +
									" WHERE fascicoloId = ? AND callerId = ? ");

			ps.setDate(1, Calendar.getInstance() );
			ps.setString(2, fascicolo.getFascicoloId() );
			ps.setString(3, fascicolo.getCallerId() );
			
			ps.executeUpdate();
			 
		} catch (Exception e) {
			errorLogger.error("", e);
			e.printStackTrace();
		} finally {
			if (ps!=null) {
				ps.close();
			} 
		}
		
	}
	//fine  FASCICOLO_2.1
	
	
	public String chiusuraFascicoloUpdate(ChiusuraFascicoloWSRequest request)
			throws FaultType {
		String esito = "";
		Connection connection = getConnection();
		ResultSet rs = null;
		boolean errorOccurred = false;
		String updateSoggettoFisicoSql = buildUpdateChiusuraFascicolo(request);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement(updateSoggettoFisicoSql);
			rs = preparedStatement.executeQuery();
			esito = MessagesClass.getMessage("ESITO_CHIUSURA_FASCICOLO_OK").concat(";").concat(MessagesClass.getMessage("DESCRIZIONE_CHIUSURA_FASCICOLO_OK"));
		} catch (SQLException e) {
			errorOccurred = true;
			errorLogger.error(MessagesClass
					.getMessage("ERRORE_QUERY_CHIUSURA_FASCICOLO ")
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			errorOccurred = true;
			errorLogger.error(MessagesClass
					.getMessage("ERRORE_QUERY_CHIUSURA_FASCICOLO ")
					+ e.getMessage());
			e.printStackTrace();

		} finally {
			closeResultSet(rs, preparedStatement);
			logger.debug(MessagesClass.getMessage("CONNESSIONE_CHIUSA"));
		}
		if (errorOccurred) {
			rollback(connection);
			logger.debug(MessagesClass.getMessage("EXECUTE_ROLLBACK"));
			esito = MessagesClass.getMessage("ESITO_CHIUSURA_FASCICOLO_NOK").concat(";").concat(MessagesClass.getMessage("DESCRIZIONE_CHIUSURA_FASCICOLO_NOK"));
			
		} else {
			closeConnection();
		}
		return esito;
	}

	public String buildInsertFascicoloQuery(AperturaFascicoloWSRequest request)
			throws FaultType {
		StringBuffer insertFascicoloQuery;
		insertFascicoloQuery = new StringBuffer("");
		insertFascicoloQuery
				.append(" INSERT INTO GESTORE_FASCICOLO.Fascicolo ");
		insertFascicoloQuery
				.append(" (fascicoloId,callerId,dataApertura,dataChiusura,statoFascicoloId) ");
		insertFascicoloQuery.append(" VALUES ");
		insertFascicoloQuery.append("( ");
		insertFascicoloQuery
				.append("'" + request.getFascicoloId() + "'" + " ,");
		insertFascicoloQuery.append("'" + request.getCallerId() + "'" + " ,");
		insertFascicoloQuery.append("TO_DATE('" + request.getDataApertura()
				+ "','yyyy-MM-dd')" + " ,");
		insertFascicoloQuery.append("TO_DATE('0001-01-01','yyyy-MM-dd') ,");
		insertFascicoloQuery.append("10 )");
		INSERT_FASCICOLO_QUERY = insertFascicoloQuery.toString();
		logger.debug(MessagesClass.getMessage("ESECUZIONE_QUERY_FASCICOLO")
				+ "\n" + INSERT_FASCICOLO_QUERY);
 
		return INSERT_FASCICOLO_QUERY;
	}
	
	//inizio 06/11/2014
	public PreparedStatementWrapper buildInsertAnagraficaFascicoloQuery(
			AperturaFascicoloWSRequest request, Connection conn, String[] columnNames) throws FaultType, SQLException {  
		
		PreparedStatementWrapper ps; 
		StringBuffer insertAnagraficaFascicoloQuery;
		insertAnagraficaFascicoloQuery = new StringBuffer("");
		insertAnagraficaFascicoloQuery.append("  INSERT INTO GESTORE_FASCICOLO.ANAGRAFICAFASCICOLO ");
		insertAnagraficaFascicoloQuery.append(" (ANAGRAFICAFASCICOLOID,FASCICOLOID,CALLERID,CODICEFISCALE,NATURAGIURIDICA,COGNOME,NOME,RAGIONESOCIALE) ");
		insertAnagraficaFascicoloQuery.append(" VALUES ");
		insertAnagraficaFascicoloQuery.append("( ");
	    insertAnagraficaFascicoloQuery.append(" (GESTORE_FASCICOLO.ANAGRAFICAFASCICOLOIDSequence.NEXTVAL), " +
	    		" ?, ?, ?, ?, ?, ?, ?  )");
	    
	    ps = new PreparedStatementWrapper(conn, insertAnagraficaFascicoloQuery.toString(), columnNames );  
	    ps.setString(1, request.getFascicoloId());
	    ps.setString(2, request.getCallerId());
	    ps.setString(3, request.getCodiceFiscale().trim().toUpperCase() ); //Bug3656
	    ps.setString(4, request.getNaturaGiuridica());
	    ps.setString(5, request.getCognome());
	    ps.setString(6, request.getNome() );
	    ps.setString(7, request.getRagioneSociale());  
		
		return  ps; 
		
	}
	//fine 06/11/2014

	

	//inizio 06/11/2014
	public PreparedStatementWrapper buildInsertAnagraficaIndirizzoQuery(
			AperturaFascicoloWSRequest request, boolean isIndirizzoPrincipale, Connection conn, String[] columnNames) throws Exception { 
		 
		PreparedStatementWrapper ps;  
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO GESTORE_FASCICOLO.ANAGRAFICAINDIRIZZO  (ANAGRAFICAINDIRIZZOID,ANAGRAFICAFASCICOLOID,INDIRIZZO,INDIRIZZOPRINCIPALE) ");
		query.append(" VALUES (  (GESTORE_FASCICOLO.ANAGRAFICAINDIRIZZOIDSequence.NEXTVAL), ?, ?, ? )");
	    
	    ps = new PreparedStatementWrapper(conn, query.toString(), columnNames  );  
	    ps.setInt(1,  anagraficaFascicoloId); 
	    ps.setString(2, request.getIndirizzo() ); 
		if (isIndirizzoPrincipale) {	
		    ps.setString(3, ANAGRAFICA_INDIRIZZO_PRINCIPALE_SI);
		} else{
		    ps.setString(3, ANAGRAFICA_INDIRIZZO_PRINCIPALE_NO ); 
		}
		
		return  ps;  
	}
	//fine 06/11/2014

	public String buildUpdateChiusuraFascicolo(
			ChiusuraFascicoloWSRequest request) throws FaultType {
		StringBuffer chiusuraFascicoloQuery;
		chiusuraFascicoloQuery = new StringBuffer("");
		chiusuraFascicoloQuery.append(" UPDATE GESTORE_FASCICOLO.Fascicolo ");
		chiusuraFascicoloQuery.append(" SET statoFascicoloId=90, ");
		chiusuraFascicoloQuery.append(" dataChiusura= " + "TO_DATE('"+ request.getDataChiusura() + "','yyyy-MM-dd')");
		chiusuraFascicoloQuery.append(" WHERE fascicoloId= '"+ request.getFascicoloId() + "' ");
		chiusuraFascicoloQuery.append(" AND callerId='" + request.getCallerId()+ "'");
		UPDATE_CHIUSURA_FASCICOLO_QUERY = chiusuraFascicoloQuery.toString();
		logger.debug(MessagesClass
				.getMessage("UPDATE_CHIUSURA_FASCICOLO_QUERY")
				+ "\n" + UPDATE_CHIUSURA_FASCICOLO_QUERY);
		return UPDATE_CHIUSURA_FASCICOLO_QUERY;
	}
	//fine 06/11/2014
	
	 
	
	

	public  FascicoloList[] searchFascicolo(String fascicoloId,
			String callerId, Date dataAperturaDa, Date dataAperturaA,
			Date dataChiusuraDa, Date dataChiusuraA,
			Integer statoFascicolo, String codiceFiscale) throws Exception { 
		
		FascicoloList[] result = new FascicoloList[0];
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String query = " SELECT *   " +
		"  FROM GESTORE_FASCICOLO.FASCICOLO F 										 " +
		"  INNER JOIN GESTORE_FASCICOLO.anagraficaFASCICOLO AF                       " +
		"  on(F.FASCICOLOID = AF.FASCICOLOID AND f.callerid = af.callerid)           " +
		"  INNER JOIN GESTORE_FASCICOLO.STATOFASCICOLO SF                            " +
		"  on(F.statofascicoloid = SF.statofascicoloid )                             " ;
		
		
			
		boolean primaCondizione = true;
		if (!isEmpty( fascicoloId) ) {
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " F.FASCICOLOID = ? ";
			primaCondizione = false;
		}
		if (!isEmpty(callerId) ){
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " F.CALLERID = ? ";
			primaCondizione = false;
		}
		if (!isEmpty(dataAperturaDa)) {
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " F.DATAAPERTURA >= ? "; 
			primaCondizione = false;
		}
		if (!isEmpty(dataAperturaA)) {
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " F.DATAAPERTURA <= ? ";
			primaCondizione = false;
		}
		if (!isEmpty(dataChiusuraDa)) {
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " F.DATACHIUSURA >= ? ";
			primaCondizione = false;
		}
		if (!isEmpty(dataChiusuraA) ) {
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " F.DATACHIUSURA <= ? AND F.DATACHIUSURA > TO_DATE('00010101', 'yyyymmdd') ";
			primaCondizione = false;
		}
		if (!isEmpty(statoFascicolo) ) {
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " F.STATOFASCICOLOID = ? ";
			primaCondizione = false;
		} 
		if (!isEmpty(codiceFiscale) ) {
			query += primaCondizione?" WHERE ":" AND "; 
			query +=  " AF.CODICEFISCALE LIKE ? ";
			primaCondizione = false;
		}
		
		
		
		
			
		try {
			ArrayList<FascicoloList> lista = new ArrayList<FascicoloList>();
			conn = getConnection();
			
			ps = conn.prepareStatement(query);
			int psIndex = 1;
			if (!isEmpty(fascicoloId)) {
				ps.setString(psIndex++, fascicoloId);
			}
			if (!isEmpty(callerId)) { 
				ps.setString(psIndex++, callerId);
			}
			if (!isEmpty(dataAperturaDa)) { 
				ps.setDate(psIndex++, Convertions.fromUtitlDateToSqlDate(  dataAperturaDa ) );
			}
			if (!isEmpty(dataAperturaA) ){ 
				ps.setDate(psIndex++, Convertions.fromUtitlDateToSqlDate(  dataAperturaA ) );
			}
			if (!isEmpty(dataChiusuraDa)) { 
				ps.setDate(psIndex++, Convertions.fromUtitlDateToSqlDate(  dataChiusuraDa ) );
			}
			if (!isEmpty(dataChiusuraA) ){ 
				ps.setDate(psIndex++, Convertions.fromUtitlDateToSqlDate(  dataChiusuraA ) ); 
			} 
			if (!isEmpty(statoFascicolo)) {
				ps.setInt(psIndex++, statoFascicolo); 
			} 
			if (!isEmpty(codiceFiscale) ) {
				ps.setString(psIndex++, "%".concat(codiceFiscale.toUpperCase().concat("%")));
			}
			
			rs = ps.executeQuery();
			
			if (rs!=null) {
				while (rs.next() ) {
					FascicoloList record = new FascicoloList();
					record.setFascicoloId(rs.getString("FASCICOLOID")) ;
					record.setCallerId(rs.getString("CALLERID")) ;
					record.setDataApertura(  Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATAAPERTURA") ) ) ;
					record.setDataChiusura(	Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATACHIUSURA") ) ) ;
					record.setCodiceFiscale(rs.getString("CODICEFISCALE")) ;
					record.setStatoFascicoloId(rs.getInt("STATOFASCICOLOID")) ;
					record.setStatoFascicoloDescr(rs.getString("STATOFASCICOLODESCRIZIONE")) ; 
					
					
					lista.add(record);
				}
			}
			
			result = lista.toArray(new FascicoloList[0]);
			
			
		} catch (Exception e) {
			logger.error("",e);
			throw e;
		} finally{
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (conn!=null) {
				closeConnection();
			}
		}
		
		
		return result;
	}


//	public Fascicolo getFascicoloConEntityPrimoLivello(String cf, int entityId) throws Exception {
//		Fascicolo fascicolo = null; 
//		Connection conn = null;
//		PreparedStatementWrapper ps =null;
//		ResultSet rs =null; 
//		String query = " SELECT *   " +
//		"  FROM GESTORE_FASCICOLO.FASCICOLO F 										 " +
//		"  INNER JOIN GESTORE_FASCICOLO.anagraficaFASCICOLO AF                       " +
//		"  on(F.FASCICOLOID = AF.FASCICOLOID AND f.callerid = af.callerid)           " +
//		"  INNER JOIN GESTORE_FASCICOLO.STATOFASCICOLO SF                            " +
//		"  on(F.statofascicoloid = SF.statofascicoloid )         " +
//		"  WHERE  AF.codiceFiscale = ? " ;
//		 
//			
//		try {
//
//			conn = getConnection();
//			
//			ps =  new PreparedStatementWrapper( conn, query);
//			
//			ps.setString(1,  StringUtils.rightPad(cf, 16, ' ')  );		
//			
//			rs =    ps.executeQuery(); 
//			
//			if (rs!=null 
//					&& rs.next() ) {
//				fascicolo = new Fascicolo();
//				
//				fascicolo.setFascicoloId(rs.getString("FASCICOLOID"));
//				fascicolo.setCallerId(rs.getString("CALLERID"));
//				fascicolo.setDataApertura(  Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATAAPERTURA") ) );
//				fascicolo.setDataChiusura( Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATACHIUSURA") )  );
//				fascicolo.setStatoFascicoloId(rs.getInt("STATOFASCICOLOID"));
//				fascicolo.setStatoFascicoloDescr(rs.getString("STATOFASCICOLODESCRIZIONE"));
//				
//				Anagrafica anagrafica = new Anagrafica();
//				anagrafica.setAnagraficaId(rs.getInt("ANAGRAFICAFASCICOLOID")) ;
//				anagrafica.setCodiceFiscale(rs.getString("CODICEFISCALE")) ;
//				anagrafica.setCognome(rs.getString("COGNOME")) ;
//				anagrafica.setEmail( selectEmail(anagrafica.getAnagraficaId(),conn ) ) ;
//				anagrafica.setIndirizzi(selectIndirizzi(anagrafica.getAnagraficaId(),conn )) ;
//				anagrafica.setNaturaGiuridica(rs.getString("NATURAGIURIDICA")) ;
//				anagrafica.setNome(rs.getString("NOME")) ;
//				anagrafica.setRagioneSociale(rs.getString("RAGIONESOCIALE")) ;
//				anagrafica.setTelefoni(selectTelefoni(anagrafica.getAnagraficaId(),conn )) ; 
//				fascicolo.setAnagrafica(anagrafica);       
//
//				EntityItem[] cartelle = EntityDAO.getEntityItems(fascicolo.getFascicoloId(), fascicolo.getCallerId(), entityId, 1, conn) ; 
//				
//				fascicolo.setCartelle(cartelle);
//				
//			}
//			 
//			
//			
//		} catch (Exception e) {
//			logger.error("",e);
//			throw e;
//		} finally{
//			if (rs!=null) {
//				rs.close();
//			}
//			if (ps!=null) {
//				ps.close();
//			}
//			if (conn!=null) {
//				closeConnection();
//			}
//		}
//		
//		
//		return  fascicolo ;
//	}
//	
	
	private boolean isEmpty(Integer i) { 
		return i==null;
	}

	private boolean isEmpty(Date dataAperturaDa) {
		return dataAperturaDa==null;
	}

	private boolean isEmpty(String s) { 
		return s==null||s.trim().equals("");
	}
	
	//inizio modifica_problema_transazioni 13/10/2014
	public Fascicolo getFascicoloConEntityPrimoLivello(String fascicoloId, String callerId, int entityId, Connection connection) throws Exception {

		Fascicolo fascicolo = null;  
		PreparedStatementWrapper ps =null;
		ResultSet rs =null;
		String query = " SELECT *   " +
		"  FROM GESTORE_FASCICOLO.FASCICOLO F 										 " +
		"  INNER JOIN GESTORE_FASCICOLO.anagraficaFASCICOLO AF                       " +
		"  on(F.FASCICOLOID = AF.FASCICOLOID AND f.callerid = af.callerid)           " +
		"  INNER JOIN GESTORE_FASCICOLO.STATOFASCICOLO SF                            " +
		"  on(F.statofascicoloid = SF.statofascicoloid )         " +
		"  WHERE	  F.FASCICOLOID = ? " +
		"	AND     F.CALLERID = ?               " ;
		 
			
		try { 
			
			ps =  new PreparedStatementWrapper (connection, query);

			ps.setString(1, fascicoloId); 
			ps.setString(2, callerId);
			 
		 
			
			rs = ps.executeQuery();
			
			
			if (rs!=null && rs.next() ) {
				fascicolo = new Fascicolo();
				
				fascicolo.setFascicoloId(rs.getString("FASCICOLOID"));
				fascicolo.setCallerId(rs.getString("CALLERID"));
				fascicolo.setDataApertura(  Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATAAPERTURA") ) );
				fascicolo.setDataChiusura( Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATACHIUSURA") )  );
				fascicolo.setStatoFascicoloId(rs.getInt("STATOFASCICOLOID"));
				fascicolo.setStatoFascicoloDescr(rs.getString("STATOFASCICOLODESCRIZIONE"));
			    //inizio FASCICOLO_2.1 
				fascicolo.setDataUltimoAggiornamento(  rs.getTimestamp("DATAULTIMOAGGIORNAMENTO") );
				fascicolo.setDataUltimoAggiornamentoDocumentiEsattoriali(rs.getTimestamp("DATAULTIMOAGGIORNAMENTODE") );
			    //fine FASCICOLO_2.1 
				
				Anagrafica anagrafica = new Anagrafica();
				anagrafica.setAnagraficaId(rs.getInt("ANAGRAFICAFASCICOLOID")) ;
				anagrafica.setCodiceFiscale(rs.getString("CODICEFISCALE")) ;
				anagrafica.setCognome(rs.getString("COGNOME")) ;
				anagrafica.setEmail( selectEmail(anagrafica.getAnagraficaId(),connection ) ) ;
				anagrafica.setIndirizzi(selectIndirizzi(anagrafica.getAnagraficaId(),connection )) ;
				anagrafica.setNaturaGiuridica(rs.getString("NATURAGIURIDICA")) ;
				anagrafica.setNome(rs.getString("NOME")) ;
				anagrafica.setRagioneSociale(rs.getString("RAGIONESOCIALE")) ; 
				anagrafica.setTelefoni(selectTelefoni(anagrafica.getAnagraficaId(),connection )) ; 
				fascicolo.setAnagrafica(anagrafica);  

				EntityItem[] cartelle = EntityDAO.getEntityItems(fascicoloId, callerId, entityId, 1, connection) ; 
				
				fascicolo.setCartelle(cartelle);
				
			}
			 
			
			
		} catch (Exception e) {
			logger.error("",e);
			throw e;
		} finally{
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
		}
		
		
		return  fascicolo ;
	}

	public Fascicolo getFascicoloConEntityPrimoLivello(String fascicoloId, String callerId, int entityId) throws Exception { 
		Connection conn = null;
		Fascicolo  result = null;
		try {
			conn = getConnection();
			result = getFascicoloConEntityPrimoLivello(fascicoloId, callerId, entityId, conn);
		} finally{
			if (conn!=null) {
				closeConnection();
			}	
		}
		
		return result;
		
	}
	//fine modifica_problema_transazioni 13/10/2014

	public int getStatoFascicolo(String fascicoloId, String callerId) throws Exception {

		int statoFascicolo = 0;
		Connection conn = null;
		PreparedStatementWrapper ps =null;
		ResultSet rs =null;
		String query = " SELECT STATOFASCICOLOID " +
		" FROM GESTORE_FASCICOLO.FASCICOLO F " +
		" WHERE	  F.FASCICOLOID = ? " +
		" AND     F.CALLERID = ? " ;
			
		try {
			conn = getConnection();
			ps =  new PreparedStatementWrapper (conn, query);
			ps.setString(1, fascicoloId); 
			ps.setString(2, callerId);
			rs = ps.executeQuery();
			if (rs!=null && rs.next() ) {
				statoFascicolo = rs.getInt("STATOFASCICOLOID");
			}
			
		} catch (Exception e) {
			logger.error("",e);
			throw e;
		} finally{
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (conn!=null) {
				closeConnection();
			}
		}
		return  statoFascicolo;
	}
	
	
	private Telefono[] selectTelefoni(Integer anagraficaId, Connection conn) throws SQLException {
		ArrayList<Telefono> list = new ArrayList<Telefono>();
		PreparedStatement ps =null;
		ResultSet rs =null;
		String query = " SELECT *  " +
				"FROM   gestore_fascicolo.anagraficatelefono " +
				"WHERE ANAGRAFICAFASCICOLOID = ? ";
		
		
			
		try {

			ps = conn.prepareStatement(query);
			ps.setInt(1, anagraficaId);
			
			rs = ps.executeQuery();
			
			while (rs.next()) { 
				Telefono tel = new Telefono();
				tel.setTelefono(rs.getString("NUMEROTELEFONO"));
				tel.setTelefonoId(rs.getInt("ANAGRAFICATELEFONOID"));
				list.add(tel);
			}
		} finally{ 
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
		}
		return list.toArray(new Telefono[0]);
	}

	private Indirizzo[] selectIndirizzi(Integer anagraficaId, Connection conn) throws SQLException {
		PreparedStatement ps =null;
		ResultSet rs =null;
		String query = " SELECT *  " +
							"FROM   gestore_fascicolo.anagraficaindirizzo " +
							"WHERE ANAGRAFICAFASCICOLOID = ? "+
							"ORDER BY ANAGRAFICAINDIRIZZOID";
		ArrayList<Indirizzo> list = new ArrayList<Indirizzo>();
		  
		try {


			ps = conn.prepareStatement(query);
			ps.setInt(1, anagraficaId);
			
			rs = ps.executeQuery();
			
			while (rs.next()) { 
				Indirizzo indirizzo = new Indirizzo();
				indirizzo.setIndirizzo(rs.getString("INDIRIZZO"));
				indirizzo.setIndirizzoId(rs.getInt("ANAGRAFICAINDIRIZZOID") );
				indirizzo.setIndirizzoPrincipale(rs.getString("INDIRIZZOPRINCIPALE") );
				list.add(indirizzo);
			}
 
		} finally{ 
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
		}
		return list.toArray(new Indirizzo[0] );
	}

	private EMail[] selectEmail(Integer anagraficaId, Connection conn) throws SQLException {
		PreparedStatement ps =null;
		ResultSet rs =null;
		ArrayList<EMail> list = new ArrayList<EMail>();
		String query = " SELECT *  " +
				"FROM   gestore_fascicolo.anagraficaemail " +
				"WHERE ANAGRAFICAFASCICOLOID = ? ";
		 
			
		try {


			ps = conn.prepareStatement(query);
			ps.setInt(1, anagraficaId);
			
			rs = ps.executeQuery();
			
			while (rs.next()) { 
				EMail email = new EMail();

				email.setEMail(rs.getString("EMAIL")) ;
				email.setEMailId(rs.getInt("ANAGRAFICAEMAILID")) ;
				
				list.add(email);
			}
		} finally{ 
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
		}
		return list.toArray(new EMail[0]);
	}


	public String deleteEmail(int mailId) throws SQLException {
		PreparedStatement ps =null;
		ResultSet rs =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.anagraficaemail " +
						" WHERE anagraficaemailid = ?" ;
		 
		String res ="KO";
		Connection conn =null;
		try {
			conn = getConnection();

			ps = conn.prepareStatement(query);
			ps.setInt(1, mailId);
			
			int deleted = ps.executeUpdate();
			 
			if (deleted >0 ) {
				res = "OK";
			} else{
				res = "Dato da cancellare non trovato";
			}
		} finally{ 
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return res;
	}
	
	
	

	public String deleteTelefono(int telefonoId) throws SQLException {
		PreparedStatement ps =null;
		ResultSet rs =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.anagraficatelefono " +
						" WHERE anagraficatelefonoid = ?" ;
		 
		String res ="KO";
		Connection conn =null;
		try {
			conn = getConnection();

			ps = conn.prepareStatement(query);
			ps.setInt(1, telefonoId);
			

			
			int deleted = ps.executeUpdate();
			 
			if (deleted >0 ) {
				res = "OK";
			} else{
				res = "Dato da cancellare non trovato";
			}
		} finally{ 
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return res;
	}


	public void deleteEmail(int mailId, Connection conn) throws SQLException {
		PreparedStatementWrapper ps =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.anagraficaemail " +
						" WHERE anagraficaemailid = ?" ;
		
		try {  
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setInt(1, mailId); 
			ps.executeUpdate();
			  
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		} 
	}

	public void deleteIndirizzo(int mailId, Connection conn) throws SQLException {
		PreparedStatementWrapper ps =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.anagraficaindirizzo " +
						" WHERE anagraficaindirizzoid = ?" ;
		
		try {  
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setInt(1, mailId); 
			ps.executeUpdate();
			  
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		} 
	}
	
	public String deleteIndirizzo(int indirizzoId) throws SQLException {
		PreparedStatement ps =null;
		ResultSet rs =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.anagraficaindirizzo " +
						" WHERE anagraficaindirizzoid = ?" ;
		 
		String res ="KO";
		Connection conn =null;
		try {
			conn = getConnection();

			ps = conn.prepareStatement(query);
			ps.setInt(1, indirizzoId);
			

			
			int deleted = ps.executeUpdate();
			 
			if (deleted >0 ) {
				res = "OK";
			} else{
				res = "Dato da cancellare non trovato";
			}
		} finally{ 
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return res;
	}


	public void insertIndirizzo(String fascicoloId, String callerId,
			int anagraficaId, String indirizzo, boolean isIndirizzoPrincipale, Connection conn
			) throws SQLException {

		PreparedStatementWrapper ps =null; 
		String query = " INSERT INTO gestore_fascicolo.ANAGRAFICAINDIRIZZO (anagraficaindirizzoid, anagraficafascicoloid, indirizzo, indirizzoprincipale ) " +
				"	VALUES (" +
				" GESTORE_FASCICOLO.ANAGRAFICAINDIRIZZOIDSequence.NEXTVAL, " +
				"?,?,? )" ;
		  
		try { 
  
				ps = PreparedStatementWrapper.prepareStatement(conn, query);
				ps.setInt(1, anagraficaId );
				ps.setString(2, indirizzo );
				if (isIndirizzoPrincipale) {
					ps.setString(3, ANAGRAFICA_INDIRIZZO_PRINCIPALE_SI ); 
				} else{ 
					ps.setString(3, ANAGRAFICA_INDIRIZZO_PRINCIPALE_NO ); 
				} 
				ps.executeUpdate();
				 
			
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		} 
	}

	
	public String insertIndirizzo(String fascicoloId, String callerId, String indirizzo, boolean isIndirizzoPrincipale) throws SQLException {

		PreparedStatement ps =null; 
		String query = " INSERT INTO gestore_fascicolo.ANAGRAFICAINDIRIZZO (anagraficaindirizzoid, anagraficafascicoloid, indirizzo, indirizzoprincipale ) " +
				"	VALUES (" +
				" GESTORE_FASCICOLO.ANAGRAFICAINDIRIZZOIDSequence.NEXTVAL, " +
				"?,?,? )" ;
		 
		String res ="KO";
		Connection conn =null;
		try {
			conn = getConnection();

			Anagrafica anagrafica = selectAnagrafica(fascicoloId, callerId, conn);
			
			if (anagrafica !=null) {

				ps = conn.prepareStatement(query);
				ps.setInt(1, anagrafica.getAnagraficaId() );
				ps.setString(2, indirizzo );
				if (isIndirizzoPrincipale) {
					ps.setString(3, ANAGRAFICA_INDIRIZZO_PRINCIPALE_SI ); 
				} else{ 
					ps.setString(3, ANAGRAFICA_INDIRIZZO_PRINCIPALE_NO ); 
				}
				
				int insert = ps.executeUpdate();
				 
				if (insert > 0) {
					res = "OK";
				}
			}
			
		} finally{  
			if (ps!=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return res;
	}

	private Anagrafica selectAnagrafica(String fascicoloId, String callerId, Connection conn) throws SQLException {

		ResultSet rs = null;
		PreparedStatement ps =null; 
		Anagrafica res = null;
		String query =  " select * " +
				"from gestore_fascicolo.anagraficafascicolo " +
				" WHERE FASCICOLOID = ? " +
				" AND CALLERID = ? " ;
		  
		try {
			conn = getConnection();
 
			
			ps = conn.prepareStatement(query);
			ps.setString(1, fascicoloId);
			ps.setString(2, callerId);
			
			rs = ps.executeQuery();
			 
			if (rs !=null && rs.next() ) {
				res = new Anagrafica();
				res.setAnagraficaId(rs.getInt("ANAGRAFICAFASCICOLOID")) ;
				res.setCodiceFiscale(rs.getString("CODICEFISCALE")) ;
				res.setCognome(rs.getString("COGNOME")) ;
				res.setNaturaGiuridica(rs.getString("NATURAGIURIDICA")) ;
				res.setNome(rs.getString("NOME")) ;
				res.setRagioneSociale(rs.getString("RAGIONESOCIALE")) ;                    
				      
				
			}
		} finally{ 
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			} 
		}
		return res;
	}


	public void insertTelefono(String fascicoloId, String callerId,
			int anagraficaId, String telefono, Connection conn)
			throws SQLException {

		PreparedStatementWrapper ps =null; 

		String query = " INSERT INTO gestore_fascicolo.ANAGRAFICATELEFONO (anagraficatelefonoid, anagraficafascicoloid, numerotelefono ) " +
				"	VALUES (" +
				" GESTORE_FASCICOLO.ANAGRAFICATELEFONOIDSequence.NEXTVAL, " +
				"?,?  )" ;
		  
		try {    
				ps = PreparedStatementWrapper.prepareStatement(conn, query);
				ps.setInt(1, anagraficaId );
				ps.setString(2, telefono ); 
				  
				ps.executeUpdate();  
			
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		} 

	}
	
	public String insertTelefono(String fascicoloId, String callerId,
			String telefono) throws SQLException {

		PreparedStatement ps =null; 
		String query = " INSERT INTO gestore_fascicolo.ANAGRAFICATELEFONO (anagraficatelefonoid, anagraficafascicoloid, numerotelefono ) " +
				"	VALUES (" +
				" GESTORE_FASCICOLO.ANAGRAFICATELEFONOIDSequence.NEXTVAL, " +
				"?,?  )" ;
		 
		String res ="KO";
		Connection conn =null;
		try {
			conn = getConnection();

			Anagrafica anagrafica = selectAnagrafica(fascicoloId, callerId, conn);
			
			if (anagrafica !=null) {

				ps = conn.prepareStatement(query);
				ps.setInt(1, anagrafica.getAnagraficaId() );
				ps.setString(2, telefono ); 
				
				int insert = ps.executeUpdate();
				 
				if (insert > 0) {
					res = "OK";
				}
			}
			
		} finally{  
			if (ps!=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return res;

	}


	public void insertEmail(String fascicoloId, String callerId, int anagraficaId, String email
			 , Connection conn
			) throws SQLException {

		PreparedStatementWrapper ps =null; 
		
		String query = " INSERT INTO gestore_fascicolo.ANAGRAFICAEMAIL (anagraficaemailid, anagraficafascicoloid, email ) " +
				"	VALUES (" +
				" GESTORE_FASCICOLO.ANAGRAFICAEMAILIDSequence.NEXTVAL, " +
				"?,?  )" ;
		  
		try {    
				ps = PreparedStatementWrapper.prepareStatement(conn, query);
				ps.setInt(1, anagraficaId );
				ps.setString(2, email ); 
				  
				ps.executeUpdate();  
			
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		} 

	}
	
	
	public String insertEmail(String fascicoloId, String callerId, String mail) throws SQLException {

		PreparedStatement ps =null; 
		String query = " INSERT INTO gestore_fascicolo.ANAGRAFICAEMAIL (anagraficaemailid, anagraficafascicoloid, email ) " +
				"	VALUES (" +
				" GESTORE_FASCICOLO.ANAGRAFICAEMAILIDSequence.NEXTVAL, " +
				"?,?  )" ;
		 
		String res ="KO";
		Connection conn =null;
		try {
			conn = getConnection();

			Anagrafica anagrafica = selectAnagrafica(fascicoloId, callerId, conn);
			
			if (anagrafica !=null) {

				ps = conn.prepareStatement(query);
				ps.setInt(1, anagrafica.getAnagraficaId() );
				ps.setString(2, mail ); 
				
				int insert = ps.executeUpdate();
				 
				if (insert > 0) {
					res = "OK";
				}
			}
			
		} finally{  
			if (ps!=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return res;

	}
	

	//inizio modifica_problema_transazioni 13/10/2014  
	public Fascicolo getCartella(String fascicoloId, String callerId, String numeroCartella, String codiceAmbito) throws Exception { 
		Fascicolo result = null;
		Connection conn = null;
		try {
			conn = getConnection();
			result = getCartella(fascicoloId, callerId, numeroCartella, codiceAmbito, conn);
		} finally{ 
			if (conn!=null) {
				closeConnection();
			}
		}
		return result;
		
	}

	public Fascicolo getCartella(String fascicoloId, String callerId, String numeroCartella, String codiceAmbito, Connection connection) throws Exception { 


		Fascicolo fascicolo = new Fascicolo(); 
		PreparedStatement ps =null;
		ResultSet rs =null;
		String query = " SELECT *   " +
		"  FROM GESTORE_FASCICOLO.FASCICOLO F 										 " +
		"  INNER JOIN GESTORE_FASCICOLO.anagraficaFASCICOLO AF                       " +
		"  on(F.FASCICOLOID = AF.FASCICOLOID AND f.callerid = af.callerid)           " +
		"  INNER JOIN GESTORE_FASCICOLO.STATOFASCICOLO SF                            " +
		"  on(F.statofascicoloid = SF.statofascicoloid )         " +
		"  WHERE	  F.FASCICOLOID = ? " +
		"	AND     F.CALLERID = ?               " ;
		 
			
		try {  
			
			ps = connection.prepareStatement(query);

			if (fascicoloId!=null) {
				ps.setString(1, fascicoloId);
			}
			if (callerId!=null) { 
				ps.setString(2, callerId);
			}
			
			rs = ps.executeQuery();
			
			if (rs!=null && rs.next() ) {

				fascicolo.setFascicoloId(rs.getString("FASCICOLOID"));
				fascicolo.setCallerId(rs.getString("CALLERID"));
				fascicolo.setDataApertura(  Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATAAPERTURA") ) );
				fascicolo.setDataChiusura( Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATACHIUSURA") )  );
				fascicolo.setStatoFascicoloId(rs.getInt("STATOFASCICOLOID"));
				fascicolo.setStatoFascicoloDescr("Aperto"); 
			    //inizio FASCICOLO_2.1 
				fascicolo.setDataUltimoAggiornamento(  rs.getTimestamp("DATAULTIMOAGGIORNAMENTO") );
				fascicolo.setDataUltimoAggiornamentoDocumentiEsattoriali(rs.getTimestamp("DATAULTIMOAGGIORNAMENTODE") );
			    //fine FASCICOLO_2.1 
				
				Anagrafica anagrafica = new Anagrafica();
				anagrafica.setAnagraficaId(rs.getInt("ANAGRAFICAFASCICOLOID")) ;
				anagrafica.setCodiceFiscale(rs.getString("CODICEFISCALE")) ;
				anagrafica.setCognome(rs.getString("COGNOME")) ;
				anagrafica.setEmail( selectEmail(anagrafica.getAnagraficaId(),connection ) ) ;
				anagrafica.setIndirizzi(selectIndirizzi(anagrafica.getAnagraficaId(),connection )) ;
				anagrafica.setNaturaGiuridica(rs.getString("NATURAGIURIDICA")) ;
				anagrafica.setNome(rs.getString("NOME")) ;
				anagrafica.setRagioneSociale(rs.getString("RAGIONESOCIALE")) ;
				anagrafica.setTelefoni(selectTelefoni(anagrafica.getAnagraficaId(),connection )) ; 
				fascicolo.setAnagrafica(anagrafica);       

				EntityItem[] cartella = new EntityItem[1];
				
				cartella[0] = getEntityCartella(fascicoloId,   callerId,  numeroCartella,   connection);
				
				fascicolo.setCartelle(cartella);
				
			}
			 
			
			
		} catch (Exception e) {
			logger.error("",e);
			throw e;
		} finally{
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
		}
		
		
		return   fascicolo ;
	
	}


	public void svuotaFascicolo(Fascicolo fascicolo) throws Exception { 
		Connection conn = null;
		try {
			conn = getConnection();
			svuotaFascicolo(fascicolo, conn);
		} finally {
			closeConnection();
		}
		
	}
	//fine modifica_problema_transazioni 13/10/2014  
	
	/**
	 * Cancella tutti i dati delle entità figlie e i dati non persistenti dei documenti contenuti nell'oggetto "fascicolo".
	 * Questo non siginfica che svuoti ogni volta tutti i dati dell'intero fascicolo, perchè questo oggetto può essere valorizzato
	 * di volta in volta solo con le entità delle cartelle o solo con le entità dei documenti esattoriali che non sono cartelle
	 */
	public void svuotaFascicolo(Fascicolo fascicolo, Connection conn) throws Exception {
		
		
		//inizio 2041_08_18 modifica_2	  non si cancellano gli item delle cartelle    
		for (int i = 0; i < fascicolo.getCartelle().length; i++) {    
			svuotaDettagliCartelle(fascicolo.getFascicoloId(), fascicolo.getCallerId() , conn );
			EntityDAO.deleteDataValue(fascicolo.getCartelle(i).getEntityItemId(), conn, true);
			//2041_08_18 modifica_2				EntityDAO.deleteEntityItem(fascicolo.getCartelle(i).getEntityItemId(), conn);
		} 
		//fine 2041_08_18 modifica_2	
	}
	
	
	private EntityItem getEntityCartella(String fascicoloId, String callerId, String numeroCartella,  Connection conn) throws FaultType, SQLException { 

		//bug 2015-03-15 mancava la chiusura della connessione, ho cambiato a static il metodo, visto che la connessione viene passata dall'esterno
		return EntityDAO.getEntityCartella(fascicoloId, callerId, numeroCartella,  conn);
	}

	/**
	 * cancella i dettagli della cartella (Tributi, Procedure, Piani di reateazione)
	 * @throws SQLException 
	 */    
	//inizio modifica mail 08/10/2014 10:38

	public void svuotaDettagliCartella(String fascicoloId, String callerId, Integer entityItemId) throws Exception {

		Connection conn = null;
		try {
			conn = getConnection();
			svuotaDettagliCartella(fascicoloId, callerId, entityItemId, conn);
		} finally {
			closeConnection();
		}
		
	}
	//fine modifica mail 08/10/2014 10:38

	
	

	//inizio bug3780
	public void svuotaDettagliCartella(String fascicoloId, String callerId, Integer entityItemId, Connection conn) throws Exception {

		EntityItem[] entityDiscendenti = EntityDAO.getEntityItemsDiscendenti(fascicoloId, callerId, entityItemId, conn, EntityDAO.LIVELLO_MAX);
		
		for (EntityItem entityItem : entityDiscendenti) {
			EntityDAO.deleteEntityItemDescendants(entityItem, conn);
		} 
	}
	//inizio bug3780
	
	
	
	
	public void svuotaDettagliCartelle(String fascicoloId, String callerId, Connection conn) throws Exception { 

		PreparedStatementWrapper deleteDatavaluePs =null; 
		PreparedStatementWrapper deleteEntityitemPs =null; 
		String deleteDatavalue = "  delete from gestore_fascicolo.datavalue " +
					" where ENTITYITEMID in ( " +
					" select ENTITYITEMID FROM   gestore_fascicolo.entityitem   " +
					" WHERE fascicoloId = ? AND callerId = ? AND PARENTENTITYITEMID != 0  " +
						" )  " ;
		 

		String deleteEntityitem = "  delete FROM   gestore_fascicolo.entityitem    " +
					" WHERE fascicoloId = ? AND callerId = ? AND PARENTENTITYITEMID != 0  " ;
		
		
		  

		try {  

			deleteDatavaluePs =  new PreparedStatementWrapper(conn, deleteDatavalue);
			deleteDatavaluePs.setString(1, fascicoloId); 
			deleteDatavaluePs.setString(2, callerId); 
			
			int deleted = deleteDatavaluePs.executeUpdate();  

			deleteEntityitemPs =  new PreparedStatementWrapper(conn, deleteEntityitem);
			deleteEntityitemPs.setString(1, fascicoloId); 
			deleteEntityitemPs.setString(2, callerId); 
			
			deleted = deleteEntityitemPs.executeUpdate(); 
			
		} finally{  
			if (deleteDatavaluePs!=null) {
				deleteDatavaluePs.close();
			} 
			if (deleteEntityitemPs!=null) {
				deleteEntityitemPs.close();
			} 
		} 
		
		 
	} 
	


	public void deleteTelefono(int id, Connection conn) throws SQLException {
		PreparedStatementWrapper ps =null; 
		String query = " delete " +
						" FROM   gestore_fascicolo.anagraficatelefono " +
						" WHERE anagraficatelefonoid = ?" ;
		
		try {  
			ps = PreparedStatementWrapper.prepareStatement(conn, query);
			ps.setInt(1, id); 
			ps.executeUpdate();
			  
		} finally{  
			if (ps!=null) {
				ps.close();
			} 
		} 
	}


	//INIZIO modifica 20-05-2015 cambio Wsdl
	public Fascicolo getFascicoloConAnagrafica(String fascicoloId, String callerId) throws Exception {
		Connection connection = null;
		Fascicolo fascicolo = null;  
		PreparedStatementWrapper ps =null;
		ResultSet rs =null;
		String query = " SELECT *   " +
		"  FROM GESTORE_FASCICOLO.FASCICOLO F 										 " +
		"  INNER JOIN GESTORE_FASCICOLO.anagraficaFASCICOLO AF                       " +
		"  on(F.FASCICOLOID = AF.FASCICOLOID AND f.callerid = af.callerid)           " +
		"  INNER JOIN GESTORE_FASCICOLO.STATOFASCICOLO SF                            " +
		"  on(F.statofascicoloid = SF.statofascicoloid )         " +
		"  WHERE	  F.FASCICOLOID = ? " +
		"	AND     F.CALLERID = ?               " ;
		 
			
		try { 
			connection = getConnection();
			
			ps =  new PreparedStatementWrapper (connection, query);

			ps.setString(1, fascicoloId); 
			ps.setString(2, callerId);
			 
		 
			
			rs = ps.executeQuery();
			
			
			if (rs!=null && rs.next() ) {
				fascicolo = new Fascicolo();
				
				fascicolo.setFascicoloId(rs.getString("FASCICOLOID"));
				fascicolo.setCallerId(rs.getString("CALLERID"));
				fascicolo.setDataApertura(  Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATAAPERTURA") ) );
				fascicolo.setDataChiusura( Convertions.fromSqlDateToDefaultStringDate( rs.getDate("DATACHIUSURA") )  );
				fascicolo.setStatoFascicoloId(rs.getInt("STATOFASCICOLOID"));
				fascicolo.setStatoFascicoloDescr(rs.getString("STATOFASCICOLODESCRIZIONE"));
			    //inizio FASCICOLO_2.1 
				fascicolo.setDataUltimoAggiornamento(  rs.getTimestamp("DATAULTIMOAGGIORNAMENTO") );
				fascicolo.setDataUltimoAggiornamentoDocumentiEsattoriali(rs.getTimestamp("DATAULTIMOAGGIORNAMENTODE") );
			    //fine FASCICOLO_2.1 
				
				Anagrafica anagrafica = new Anagrafica();
				anagrafica.setAnagraficaId(rs.getInt("ANAGRAFICAFASCICOLOID")) ;
				anagrafica.setCodiceFiscale(rs.getString("CODICEFISCALE")) ;
				anagrafica.setCognome(rs.getString("COGNOME")) ;
				anagrafica.setEmail( selectEmail(anagrafica.getAnagraficaId(),connection ) ) ;
				anagrafica.setIndirizzi(selectIndirizzi(anagrafica.getAnagraficaId(),connection )) ;
				anagrafica.setNaturaGiuridica(rs.getString("NATURAGIURIDICA")) ;
				anagrafica.setNome(rs.getString("NOME")) ;
				anagrafica.setRagioneSociale(rs.getString("RAGIONESOCIALE")) ; 
				anagrafica.setTelefoni(selectTelefoni(anagrafica.getAnagraficaId(),connection )) ; 
				fascicolo.setAnagrafica(anagrafica);  
 
			}
			 
			
			
		} catch (Exception e) {
			logger.error("",e);
			throw e;
		} finally{
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			closeConnection();
		}
		
		
		return  fascicolo ;
	}
	//FINE modifica 20-05-2015 cambio Wsdl
}
