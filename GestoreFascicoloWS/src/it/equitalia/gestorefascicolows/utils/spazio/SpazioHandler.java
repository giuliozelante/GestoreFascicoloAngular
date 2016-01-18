package it.equitalia.gestorefascicolows.utils.spazio;

  

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;

import com.primeur.javax.jms.SPC;
import com.primeur.javax.jms.SpazioBytesFile;
import com.primeur.javax.jms.SpazioCharSet;
import com.primeur.javax.jms.SpazioEorEofType;
import com.primeur.javax.jms.SpazioFile;
import com.primeur.javax.jms.SpazioProperty;
import com.primeur.javax.jms.SpazioQueueReceiver;
import com.primeur.javax.jms.SpazioQueueSender;
import com.primeur.javax.jms.SpazioTextRecordFile;
import com.primeur.spazio.jms.SPQueue;
import com.primeur.spazio.jms.SPQueueConnection;
import com.primeur.spazio.jms.SPQueueConnectionFactory;
import com.primeur.spazio.jms.SPQueueSession;
import com.primeur.spazio.jms.SPTextFile;
import com.primeur.spazio.jms.SPTextRecordFile;

public class SpazioHandler {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SpazioHandler.class);
	
	private static final boolean NO_TRANSACTION_USAGE        = false;
	
//	private String jndiQueueConnFactory;
//	private String jndiQueue;
	private String uClass;
	private String sender;
	
	private SPQueueConnectionFactory queueConnectionFactory;
	private Queue queue;

//	//private Properties properties;
//	
//	public SpazioHandler(String jndiQueueConnFactory, String jndiQueue) {
//		this.jndiQueueConnFactory = jndiQueueConnFactory;
//		this.jndiQueue            = jndiQueue;
//		
//		//this.properties = GetiProperties.getProperties();
//	}
	
	


	public   SpazioHandler(String jndiQueueConnFactory , String jndiQueue, boolean consuma) throws Exception {
		
		Properties ctxProps = new Properties();
		Context ctx = new InitialContext(ctxProps);
		queueConnectionFactory = (SPQueueConnectionFactory) ctx.lookup(jndiQueueConnFactory);
		
		// proprietà per eliminare o lasciare il file sulla coda
		queueConnectionFactory.setReceiveBrowseIncludeConsulted(!consuma);
		if (consuma) queueConnectionFactory.setReceiveModeInput();
		else         queueConnectionFactory.setReceiveModeBrowse();

		queue = (Queue) ctx.lookup(jndiQueue);
	}
	
	
	
	public SpazioHandler( 	String hostSpazio,
							int portRMI,
							String queueManager,
							String queueName,
							boolean consuma
							) { 

		queueConnectionFactory = new SPQueueConnectionFactory();
		queueConnectionFactory.setHostName(hostSpazio);
		queueConnectionFactory.setHostPort(portRMI);

		queueConnectionFactory.setScriptApi(false);
		queueConnectionFactory.setTraceApi(false);
		queueConnectionFactory.setVersionCheck(false);
		queueConnectionFactory.setTransportType(SPC.SPJMS_TP_CLIENT_SP_RMI);

		queueConnectionFactory.setCodePage(0);
		queueConnectionFactory.setCCSID(1);

		queueConnectionFactory.setQueueManager(queueManager);


		// proprietà per eliminare o lasciare il file sulla coda
		this.queueConnectionFactory.setReceiveBrowseIncludeConsulted(!consuma);
		if (consuma) this.queueConnectionFactory.setReceiveModeInput();
		else         this.queueConnectionFactory.setReceiveModeBrowse();
		
		SPQueue spqueue = new SPQueue();
		spqueue.setQueueName(queueName);
		spqueue.setQueueManager(queueManager);

//		this.jndiQueueConnFactory = queueManager;
//		this.jndiQueue            = queueName; 

		queue = spqueue;
	}
	
	 


	public FileSpazio getFile(String internalNumber, OutputStream os ) throws Exception {

		SPQueueConnection masterConnection = null;
		SPQueueSession    session          = null;
		
		try { 
			
			masterConnection = (SPQueueConnection) this.queueConnectionFactory.createQueueConnection();
			masterConnection.start();

			session = (SPQueueSession) masterConnection.createQueueSession(
					NO_TRANSACTION_USAGE,
					Session.AUTO_ACKNOWLEDGE);
			
			String selector = SpazioProperty.INT_NUM+" = '0x" + internalNumber + "'";
			
			SpazioQueueReceiver recvr = (SpazioQueueReceiver) session.createReceiver(queue, selector);
			SpazioFile spazioFile = (SpazioFile) recvr.receiveNoWait();

			if (spazioFile == null) {
				throw new FileNotFoundException("File non trovato per internalNumber[" + internalNumber + "]");
			}
			
			FileSpazio fp = new FileSpazio();
			fp.setCorrId(     spazioFile.getStringProperty(SpazioProperty.CORREL_ID));
			fp.setDescription(spazioFile.getStringProperty(SpazioProperty.DESCRIPTION));
			fp.setSender(     spazioFile.getStringProperty(SpazioProperty.SENDER));
			fp.setUClass(     spazioFile.getStringProperty(SpazioProperty.U_CLASS));
			fp.setInternalNumber(internalNumber);
			
			// gestione distinta tra file binary e file record
			if (spazioFile instanceof SPTextRecordFile) {
				
				SPTextRecordFile spTextRecordFile = (SPTextRecordFile) spazioFile;
				
				spTextRecordFile.reset();
				byte[] record = null;
				while ((record = spTextRecordFile.readRecord()) != null) {
					os.write(record,0,record.length);
				}
				spTextRecordFile.acknowledge();
				
			} else if (spazioFile instanceof SPTextFile) {
				
				SPTextFile spTextFile = (SPTextFile) spazioFile;
				spTextFile.reset();
				
				String line;
				while ((line = spTextFile.readLine()) != null) {
		        	os.write((line+"\n").getBytes()); 
				}
				spTextFile.acknowledge();
				
			} else {
				
				SpazioBytesFile spazioBytesFile = (SpazioBytesFile) spazioFile;
				spazioBytesFile.reset();
				int read = 0;
				byte[] buffer = new byte[1024];
				while ((read = spazioBytesFile.readBytes(buffer, buffer.length)) > 0) {
		        	os.write(buffer,0,read);
				}
				spazioBytesFile.acknowledge();
			}
			
			if (NO_TRANSACTION_USAGE) session.commit();
			recvr.close();
 
			
			return fp;
			
		} catch (Exception e) {
			logger.error("",e);
			throw e;
			
		} finally {
			try { if (os               != null) os              .close(); } catch(Exception e) {printStackTrace(e, getClass());} 
			try { if (session          != null) session         .close(); } catch(Exception e) {printStackTrace(e, getClass());} 
			try { if (masterConnection != null) masterConnection.close(); } catch(Exception e) {printStackTrace(e, getClass());} 
		}
	}
	
	public void sendTextRecordFile(String nomeFile, InputStream is) throws Exception {
		
		SPQueueConnection masterConnection = null;
		SPQueueSession    session          = null;
		
		try { 
			
			masterConnection = (SPQueueConnection) queueConnectionFactory.createQueueConnection();
			masterConnection.start();
		
			session = (SPQueueSession) masterConnection.createQueueSession(
					NO_TRANSACTION_USAGE,
					Session.AUTO_ACKNOWLEDGE);
			
			SpazioQueueSender queueSender = (SpazioQueueSender) session.createSender(queue);
			
			SpazioTextRecordFile file = session.createVarTextRecordFile(SpazioEorEofType.EOR_CRLF);
			
			file.setIntProperty(SpazioProperty.CODED_CHAR_SET_ID, SpazioCharSet.ASCII);
			
			file.setStringProperty(SpazioProperty.CORREL_ID,    nomeFile);
			file.setStringProperty(SpazioProperty.DESCRIPTION,  nomeFile);
			
			if (this.uClass != null && this.uClass.trim().length() > 0) {
				file.setStringProperty(SpazioProperty.U_CLASS, this.uClass);	
			}
			
			if (this.sender != null && this.sender.trim().length() > 0) {
				file.setStringProperty(SpazioProperty.SENDER, this.sender);	
			}
			
			file.clearBody(queueSender);
			String line = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			while ((line = br.readLine()) != null) {
				file.writeLine(line);
			}
			
			queueSender.send(file);

			if (NO_TRANSACTION_USAGE) {
				session.commit();
			} 
			
		} catch (Exception e) {
			logger.error("",e);
			throw e;
			
		} finally {
			try { if (session          != null) session         .close(); } catch(Exception e) {printStackTrace(e, getClass());} 
			try { if (masterConnection != null) masterConnection.close(); } catch(Exception e) {printStackTrace(e, getClass());} 
		}
	}
		
	private static void printStackTrace(Throwable t, Class<?> clazz) {
		Logger.getLogger(clazz).error(t.toString().replaceAll("\t", " "));
		Logger.getLogger("ErrorLogger").error(t.toString(), t);
	}

//	private void initQueue(boolean consuma) throws Exception {		
//		Properties ctxProps = new Properties();
//		Context ctx = new InitialContext(ctxProps);
//		this.queueConnectionFactory = (SPQueueConnectionFactory) ctx.lookup(jndiQueueConnFactory);
//
//		// proprietà per eliminare o lasciare il file sulla coda
//		this.queueConnectionFactory.setReceiveBrowseIncludeConsulted(!consuma);
//		if (consuma) this.queueConnectionFactory.setReceiveModeInput();
//		else         this.queueConnectionFactory.setReceiveModeBrowse();
//
//		this.queue = (Queue) ctx.lookup(jndiQueue);
//	}

	public String getUClass() {
		return this.uClass;
	}

	public void setUClass(String class1) {
		this.uClass = class1;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
}
