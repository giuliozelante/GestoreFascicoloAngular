package it.equitalia.gestorefascicolows.utils.documentum;
  
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.documentum.com.DfClientX;
import com.documentum.com.IDfClientX;
import com.documentum.fc.client.DfQuery;
import com.documentum.fc.client.IDfClient;
import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfDocument;
import com.documentum.fc.client.IDfQuery;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSessionManager;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfTime;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfLoginInfo;
import com.documentum.operations.IDfCheckinNode;
import com.documentum.operations.IDfCheckinOperation;
import com.documentum.operations.IDfCheckoutNode;
import com.documentum.operations.IDfCheckoutOperation;
import com.ibm.xslt4j.regexp.recompile;

public class DocumentumHandler {
	static Logger logger = Logger.getLogger(DocumentumHandler.class);
	
	

	public static void main(String[] args) throws Exception {

		String fsc_codice_fiscale="DNDPLG82E22F839H" ;
		String fsc_id_chiamante="CRM" ;
		String fsc_id_fascicolo="RINO123";
		String prova1_fsc_num_documento="prova1zip" ;
//		String prova2_fsc_num_documento="prova2" ;
		String fsc_tipo_documento="RELATA" ;

		DocumentumHandler  documentumHandler  = new DocumentumHandler("dmadmin" , "dmadmin001", "DOCTESTREPFSC"); 

		File prova1 = new File("C:/Users/utente/Desktop/prova1.zip");
//		File prova2 = new File("C:/Users/utente/Desktop/prova2.txt");
		
		documentumHandler.putFileInFsc_document(prova1, 
				ContentType.TXT, 
				fsc_codice_fiscale, 
				fsc_id_chiamante, 
				fsc_id_fascicolo, 
				prova1_fsc_num_documento, 
				fsc_tipo_documento);	
		

//		documentumHandler.putFileInFsc_document(prova2, 
//				ContentType.TXT, 
//				fsc_codice_fiscale, 
//				fsc_id_chiamante, 
//				fsc_id_fascicolo, 
//				prova2_fsc_num_documento, 
//				fsc_tipo_documento);	 
		 
//		documentumHandler.deleteObjectsFromFsc_document(fsc_codice_fiscale, fsc_id_chiamante, fsc_id_fascicolo, prova1_fsc_num_documento, fsc_tipo_documento);

		scriviLista();
		
		documentumHandler.saveFileFromFsc_document(fsc_codice_fiscale, fsc_id_chiamante, fsc_id_fascicolo, 
				prova1_fsc_num_documento, 
				fsc_tipo_documento, 
				new File("C:/Users/utente/Desktop/output1.zip") );
		
	}

	private static String scriviLista() throws Exception {
		StringBuffer buff= new StringBuffer();
		DocumentumHandler  documentumHandler  = new DocumentumHandler("dmadmin" , "dmadmin001", "DOCTESTREPFSC"); 
		
		Map<String, String>  mappa = documentumHandler.getListRObjectIdObjectNameFromFsc_document();

		buff.append(" ---------------------- \n");
		for (Entry<String, String> entry : mappa.entrySet() ) {
			buff.append("Key = " + entry.getKey() + ", Value = " + entry.getValue()+"\n");
		}
		return  buff.toString();
	}

	public static void testGetFile() throws Exception {

		DocumentumHandler  documentumHandler  = new DocumentumHandler("dmadmin" , "dmadmin001", "DOCTESTREPFSC"); 

		documentumHandler.getFileFromDocumentum(
					"fsc_document",  
					"DNDPLG82E22F839H",
					"CRM",
					"RINO123",
					"1234567890",
					"RELATA", 
					new File("C:/Users/utente/Desktop/prova.xxx") 
		
		);
		
	}


	public void deleteObjectsFromFsc_document( 
										String fsc_codice_fiscale,
										String fsc_id_chiamante,
										String fsc_id_fascicolo,
										String fsc_num_documento,
										String fsc_tipo_documento  ) throws Exception {
		

		IDfSessionManager sm      = null;
		IDfSession        session = null;   

		String qualification = 
			"delete fsc_document objects " +
			"where   fsc_codice_fiscale = '"  + fsc_codice_fiscale + "' and" + 
			" fsc_id_chiamante = '"  + fsc_id_chiamante + "' and" + 
			" fsc_id_fascicolo = '"  + fsc_id_fascicolo + "' and" + 
			" fsc_num_documento = '"  + fsc_num_documento + "' and" + 
			" fsc_tipo_documento = '"  + fsc_tipo_documento + "' ";
		
		try {
 
            sm = getSessionManager(); 
            session = sm.getSession(docbase);

			// esecuzione query
			IDfQuery idfQuery = new DfQuery();
			idfQuery.setDQL(qualification);

			idfQuery.execute(session, IDfQuery.DF_EXEC_QUERY );

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("qualification[" + qualification + "]");
			throw ex;

		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) { logger.error("",e1); }
		}
	}
	
	
	public static void testList() throws Exception {

//		DocumentumHandler  documentumHandler  = new DocumentumHandler("dmadmin" , "dmadmin001", "DOCTESTREPFSC"); 
//		Map<String, String>  mappa = documentumHandler.getListRObjectIdObjectNameFromDocumentum("fsc_document", ContentType.TXT);
//		
//		for (Entry<String, String> entry : mappa.entrySet() ) {
//		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		
//		documentumHandler.deleteObjFromDocumentum("fsc_document", ContentType.TXT);
//		
//		mappa = documentumHandler.getListRObjectIdObjectNameFromDocumentum("fsc_document", ContentType.TXT);
//		
//		for (Entry<String, String> entry : mappa.entrySet() ) {
//		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		
	}
	
	
	
	
	public static void test1() {
		
		File file =new File("C:/Users/utente/Desktop/pippo.txt");
		
		DocumentumHandler  dh  = new DocumentumHandler("dmadmin" , "dmadmin001", "DOCTESTREPFSC");
		DocumentumFileBean dfb = new DocumentumFileBean();

		Map<String,Object> mapFile = new HashMap<String, Object>();
		mapFile.put("fsc_codice_fiscale",        "DNDPLG82E22F839H");
		mapFile.put("fsc_id_chiamante",         "CRM");
		mapFile.put("fsc_id_fascicolo",          "RINO123");
		mapFile.put("fsc_num_documento",        "1234567890");
		mapFile.put("fsc_tipo_documento",             "RELATA");               
		//DEVO DEFINIRE LE ACL
		//mapFile.put("acl_name",                  "PCS LAVORAZIONE FLUSSI");
		mapFile.put("acl_domain",                "dmadmin");
					
		dfb.setFileName(       file.getName()   );
		dfb.setAttributiFile(   mapFile);
		
		dfb.setFilePath(        file.getAbsolutePath());
		//IL FOLDER NON SERVE
		//dfb.setFolder(          "/PCS/Lavorazioni/ECC/096/00001000");
		dfb.setClasseDcmt(      "fsc_document");
		//dfb.setClasseDcmtFolder("pcs_folder_flusso_logico");
		dfb.setContentType(ContentType.TXT);
		
		try {
			dh.putFileInDocumentum(dfb);
		} catch (Exception e) { 
		}
	}

	
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	public DocumentumHandler(String username, String password, String docbase){
		this.username = username;
		this.password = password;
		this.docbase  = docbase;			
	}
	
	public enum ContentType {
		TXT,
		XML,
		PDF,
		ZIP
	}
	
	private static Map<ContentType, String> mapContentType = new HashMap<ContentType, String>();
	
	static {
		mapContentType.put(ContentType.TXT, "crtext");
		mapContentType.put(ContentType.XML, "xml");
		mapContentType.put(ContentType.PDF, "pdf");
		mapContentType.put(ContentType.ZIP, "zip");
	}
	
	private String docbase;  //"DOCTESTREPFSC";
	private String username; //"dmadmin";
	private String password; //"dmadmin001";

//	private org.apache.log4j.Logger logger;

//	private static String docbase  = "documentum";
//	private static String username = "dmadmin";
//	private static String password = "dmdevelop";
	

	public void putFileInDocumentum(DocumentumFileBean dfb) throws Exception {

        IDfClientX        cx      = null;
        IDfClient         client  = null;
        IDfSessionManager sm      = null;
        IDfSession        session = null;

        try {
        	
            cx     = new DfClientX();
            client = cx.getLocalClient();
            sm     = client.newSessionManager();

            // accesso al repository
            IDfLoginInfo li = cx.getLoginInfo();
            li.setUser(    username);
            li.setPassword(password);
            sm.setIdentity(docbase, li);

            // creazione nuova sessione
            session = sm.getSession(docbase);  
            
            // creazione oggetto generico
            IDfDocument document = (IDfDocument) session.newObject(dfb.getClasseDcmt());
            document.setObjectName(                    dfb.getFileName());     // nome del file
            document.setContentType(mapContentType.get(dfb.getContentType())); // tipo di file
            document.setFile(                          dfb.getFilePath());     // percorso del file in locale
            
            // impostazione degli attributi della classe documentale 
			impostaAttributi(document,dfb.getAttributiFile()); 

            // salvataggio del file sul documentale 
            document.save(); 

        } catch (Exception e) {
			e.printStackTrace();
        	logger.error("",e);
        	throw e;
		} catch (Error e) {
			e.printStackTrace();
			logger.error("",e);
        	throw e;
		}
        finally {
        	if (sm!=null) {
                sm.release(session);				
			}
        }
	}
	


	public Map<String, String> getListRObjectIdObjectNameFromFsc_document(  ) throws Exception {

		IDfSessionManager sm      = null;
		IDfSession        session = null;  
		IDfCollection     collection = null;
		Map<String, String> list = new HashMap<String, String>();

		String qualification="";
		try {
 
            sm = getSessionManager();  
            session = sm.getSession(docbase);

			qualification = 
				" select * " +
				" from fsc_document ";
 
  
			IDfQuery idfQuery = new DfQuery();
			idfQuery.setDQL(qualification);

			collection = idfQuery.execute(session, IDfQuery.DF_READ_QUERY);

			while(collection.next()) {
				list.put(collection.getString("r_object_id"), collection.getString("object_name"));
			}  

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("qualification[" + qualification + "]",ex);
			throw ex;

		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) { logger.error("",e1); }
		}
	}
	
	
	public Map<String, String> getListRObjectIdObjectNameFromFsc_document(
														String fsc_codice_fiscale,
														String fsc_id_chiamante,
														String fsc_id_fascicolo,
														String fsc_num_documento,
														String fsc_tipo_documento  ) throws Exception {

		IDfSessionManager sm      = null;
		IDfSession        session = null;  
		IDfCollection     collection = null;
		Map<String, String> list = new HashMap<String, String>();
		

		String qualification = 
			" select * " +
			" from fsc_document " +
			" where   fsc_codice_fiscale = '"  + fsc_codice_fiscale + "' and" + 
			" fsc_id_chiamante = '"  + fsc_id_chiamante + "' and" + 
			" fsc_id_fascicolo = '"  + fsc_id_fascicolo + "' and" + 
			" fsc_num_documento = '"  + fsc_num_documento + "' and" + 
			" fsc_tipo_documento = '"  + fsc_tipo_documento + "' ";
		
		try {
 
            sm = getSessionManager();  
            session = sm.getSession(docbase);

 
  
			IDfQuery idfQuery = new DfQuery();
			idfQuery.setDQL(qualification);

			collection = idfQuery.execute(session, IDfQuery.DF_READ_QUERY);

			while(collection.next()) {
				list.put(collection.getString("r_object_id"), collection.getString("object_name"));
			}  

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("qualification[" + qualification + "]",ex);
			throw ex;

		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) { logger.error("",e1); }
		}
	}


	public Map<String, String> getListRObjectIdObjectNameFromDocumentum(String classeDoc, ContentType contentType ) throws Exception {

		IDfSessionManager sm      = null;
		IDfSession        session = null; 
		IDfCollection     collection = null;
		String qualification = null;
		Map<String, String> list = new HashMap<String, String>();
        IDfClientX        cx      = null;
        IDfClient         client  = null; 

		try {

            cx     = new DfClientX();
            client = cx.getLocalClient();
            sm     = client.newSessionManager();

            // accesso al repository
            IDfLoginInfo li = cx.getLoginInfo();
            li.setUser(    username);
            li.setPassword(password);
            sm.setIdentity(docbase, li);

            // creazione nuova sessione
            session = sm.getSession(docbase);

			qualification = 
				"select * from %s where " +
//				" folder(%s) and " +
				" a_content_type='" + mapContentType.get(contentType) +"'";

			qualification = String.format(qualification, classeDoc  ); 

			// esecuzione query
			IDfQuery idfQuery = new DfQuery();
			idfQuery.setDQL(qualification);

			collection = idfQuery.execute(session, IDfQuery.DF_READ_QUERY);

			while(collection.next()) {
				list.put(collection.getString("r_object_id"), collection.getString("object_name"));
			}  

			return list;

		} catch (Exception ex) {
			System.err.println(String.format(
					"ECCEZIONE. DocumentumHandler.getListFileFromDocumentum(), QUERY: %s - Message: %s",
					qualification,  ex.getMessage())  );
			throw ex;

		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) {logger.error("",e1); }
		}
	}
	
	
	private void impostaAttributi(IDfDocument document, Map<String,Object> map) throws DfException{
		
		if (map == null || map.isEmpty()) return;

		Set<String> keySet = map.keySet();
		
		for (String key : keySet) {
			Object obj = map.get(key);
			if (obj instanceof String) {
				document.setString(key, (String)obj);
			}
			else if (obj instanceof Integer) {
				document.setInt(key, ((Integer)obj).intValue());
			}
			else if (obj instanceof Date) {
				document.setTime(key, new DfTime((Date) obj));
			}
			else if (obj instanceof Double) {
				document.setDouble(key, ((Double)obj).doubleValue());
			}
			else if (obj instanceof String[]) {
				int index = 0;
				String[] list = (String[]) obj;
				for (String p : list) {
					document.setRepeatingString(key, index++, p);
				}
			}
		}		
	}

	


	public void deleteObjFromDocumentum(String classeDoc, ContentType contentType ) throws Exception {

		IDfSessionManager sm      = null;
		IDfSession        session = null;      

		String query = 
			" %s where " + 
			" a_content_type='" + mapContentType.get(contentType) +"'";
        
		try { 
			sm = getSessionManager(); 
            session =  sm.getSession(docbase);
 
			query = String.format(query, classeDoc  );
			 
			 
			// recupero dell' r_object_id
			IDfId  idObj  = session.getIdByQualification(query);
			
			IDfDocument object = (IDfDocument)session.getObject(idObj);
			object.removeContent(0);
			object.save();
				  
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Query = " +  query ,e);
			throw e;
		
		} finally {
			try {if (sm != null && session!=null) sm.release(session);} catch (Exception e1) { logger.error(e1.getMessage(),e1); }
		}  
		
	} 


	private IDfSessionManager getSessionManager() throws DfException {

		IDfSessionManager sm      = null;   
        IDfClientX        cx      = null;
        IDfClient         client  = null;  

        cx     = new DfClientX();
        client = cx.getLocalClient();
        sm     = client.newSessionManager();

        // accesso al repository
        IDfLoginInfo li = cx.getLoginInfo();
        li.setUser(    username);
        li.setPassword(password);
        sm.setIdentity(docbase, li);
        
        return     sm ;
	}
	

	public boolean saveFileFromFsc_document(	 
										String fsc_codice_fiscale,
										String fsc_id_chiamante,
										String fsc_id_fascicolo,
										String fsc_num_documento,
										String fsc_tipo_documento, 
										File file ) throws Exception {
 
		boolean result = false;
		IDfSessionManager sm      = null;
		IDfSession        session = null; 

		try { 

			sm = getSessionManager(); 
            session =  sm.getSession(docbase);
						
			String qualification = 
				" fsc_document where"                 +
				" fsc_codice_fiscale = '"  + fsc_codice_fiscale + "' and" + 
				" fsc_id_chiamante = '"  + fsc_id_chiamante + "' and" + 
				" fsc_id_fascicolo = '"  + fsc_id_fascicolo + "' and" + 
				" fsc_num_documento = '"  + fsc_num_documento + "' and" + 
				" fsc_tipo_documento = '"  + fsc_tipo_documento + "' ";
 
 
			 
			IDfId        idObj  = session.getIdByQualification(qualification);
			
			if(!idObj.isNull()){
				logger.info("Oggetto trovato");
				IDfSysObject sysObj = (IDfSysObject) session.getObject(idObj);
				logger.info("Scrivo su file");
				sysObj.getFile(file.getAbsolutePath());
				result = true;
			} else {
				logger.info("File non trovato ");
				file = null;
			}

		} catch (DfException de) {
			de.printStackTrace();
			logger.info(Thread.currentThread().getStackTrace()[2]);
			logger.error(de);

			throw de;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("",ex);
			throw ex;

		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) { logger.error(e1.getMessage(),e1); }
		}
		return result;
 
	}
	
	

	public void getFileFromDocumentum(	
										String classeDoc,
										String fsc_codice_fiscale,
										String fsc_id_chiamante,
										String fsc_id_fascicolo,
										String fsc_num_documento,
										String fsc_tipo_documento, 
										File file ) throws Exception {
 

		IDfSessionManager sm      = null;
		IDfSession        session = null;

		try {

			sm = getSessionManager();
            session =  sm.getSession(docbase);
						
			String qualification = 
				"%s where "                 +
				" fsc_codice_fiscale = '"  + fsc_codice_fiscale + "' and" + 
				" fsc_id_chiamante = '"  + fsc_id_chiamante + "' and" + 
				" fsc_id_fascicolo = '"  + fsc_id_fascicolo + "' and" +  
				" fsc_tipo_documento = '"  + fsc_tipo_documento + "' ";		 

			if (fsc_num_documento!=null) {
				qualification +=  " and fsc_num_documento = '"  + fsc_num_documento + "' "  ;
			}
			 
			
			qualification = String.format(qualification, classeDoc );
 
			 
			IDfId        idObj  = session.getIdByQualification(qualification);
			
			if(!idObj.isNull()){
				logger.info("Oggetto trovato");
				IDfSysObject sysObj = (IDfSysObject) session.getObject(idObj);
				logger.info("Scrivo su file");
				sysObj.getFile(file.getAbsolutePath());
			} else {
				logger.info("File non trovato ");
				file = null;
			}

		} catch (DfException de) {
			de.printStackTrace();
			logger.info(Thread.currentThread().getStackTrace()[2]);
			logger.error(de);

			throw de;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("",ex);
			throw ex;

		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) { logger.error(e1.getMessage(),e1); }
		}
 
	}
	
	

	public void putFileInFsc_document( File file,
										ContentType contentType, 
										String fsc_codice_fiscale,
										String fsc_id_chiamante,
										String fsc_id_fascicolo,
										String fsc_num_documento,
										String fsc_tipo_documento ) throws Exception { 
		 
		DocumentumFileBean dfb = new DocumentumFileBean();

		Map<String,Object> mapFile = new HashMap<String, Object>();
		mapFile.put("fsc_codice_fiscale",        fsc_codice_fiscale);
		mapFile.put("fsc_id_chiamante",         fsc_id_chiamante);
		mapFile.put("fsc_id_fascicolo",         fsc_id_fascicolo);
		if (fsc_num_documento!=null) {
			mapFile.put("fsc_num_documento",        fsc_num_documento); 
		}
		mapFile.put("fsc_tipo_documento",             fsc_tipo_documento);         
		
		//DEVO DEFINIRE LE ACL
		//mapFile.put("acl_name",                  "PCS LAVORAZIONE FLUSSI");
		mapFile.put("acl_domain",     username );
					
		dfb.setFileName(       file.getName()   );
		dfb.setAttributiFile(  mapFile );
		
		dfb.setFilePath(        file.getAbsolutePath());
		//IL FOLDER NON SERVE
		//dfb.setFolder(          "/PCS/Lavorazioni/ECC/096/00001000");
		dfb.setClasseDcmt(      "fsc_document");
		//dfb.setClasseDcmtFolder("pcs_folder_flusso_logico");
		dfb.setContentType(contentType);
		 
		putFileInDocumentum(dfb);
		 
	}

	

	public void checkInDocumentum(CheckedOutFile checkedOutFile) throws Exception {
		
		IDfSessionManager sm      = null;
		IDfSession        session = null;   
 
		try {
 
            sm = getSessionManager(); 
            session = sm.getSession(docbase);
			
			logger.debug("DocumentumHandler.checkInDocumentum - recupero id del file di cui ho fatto checkout"); 
			
			IDfId        idObj  = checkedOutFile.getId(); 
			IDfClientX           clientx = new DfClientX();
			IDfCheckinOperation  ciOp    = clientx.getCheckinOperation();
			
			logger.debug("DocumentumHandler.checkInDocumentum - set checkin version"); 
			ciOp.setCheckinVersion(IDfCheckinOperation.NEXT_MAJOR);
			
			ciOp.setVersionLabels("CURRENT");
			
			logger.debug(String.format("DocumentumHandler.checkInDocumentum - recupero documento con id %s", idObj.getId())); 
			IDfDocument doc = (IDfDocument) session.getObject(idObj);
			
			//ciOp.add(doc);
			IDfCheckinNode node = (IDfCheckinNode) ciOp.add(doc);
			
			
			// goran fix per file grandi
			node.setXMLApplicationName("Ignore");
			
			ciOp.add(node);
			ciOp.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("",ex);
			throw ex;
		
		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) { logger.error(e1.getMessage(),e1); }
		}
	}
	
	

	public CheckedOutFile checkOutFromDocumentum(
			String classeDoc,
			String fsc_codice_fiscale,
			String fsc_id_chiamante,
			String fsc_id_fascicolo,
			String fsc_num_documento,
			String fsc_tipo_documento,
			String checkInOutDir) throws Exception {


		IDfSessionManager sm      = null;
		IDfSession        session = null; 

		try { 

			sm = getSessionManager(); 
            session =  sm.getSession(docbase);
			

			String qualification = 
				"%s (ALL) where"                 +
				" fsc_codice_fiscale = '"  + fsc_codice_fiscale + "' and " + 
				" fsc_id_chiamante = '"  + fsc_id_chiamante + "' and " + 
				" fsc_id_fascicolo = '"  + fsc_id_fascicolo + "' and " +  
				" fsc_tipo_documento = '"  + fsc_tipo_documento + "'  and "+
				" ANY r_version_label = 'CURRENT'";   

			if (fsc_num_documento!=null) {
				qualification +=  " and fsc_num_documento = '"  + fsc_num_documento + "' "  ;
			}

			qualification = String.format(qualification, classeDoc );
			 
			IDfId        idObj  = session.getIdByQualification(qualification);
			
			if ( idObj.getId().equals("0000000000000000")  ) {
				return null;
			} else{
				
				session.getObject(idObj);

				IDfClientX           clientx = new DfClientX();
				IDfCheckoutOperation coOp    = clientx.getCheckoutOperation();
				coOp.setDestinationDirectory(checkInOutDir);

				IDfDocument     doc    = (IDfDocument) session.getObject(idObj);
				IDfCheckoutNode coNode = (IDfCheckoutNode) coOp.add(doc);
				coOp.execute();
				
				return new CheckedOutFile(idObj, coNode.getFilePath());
				
			} 
			 
			
		} catch (Exception ex) {
			logger.error("",ex);
			throw ex;
	
		} finally {
			try { if (sm != null && session!=null) sm.release(session); } catch (Exception e1) { logger.error(e1.getMessage(),e1); }
		}
	}
	
}
