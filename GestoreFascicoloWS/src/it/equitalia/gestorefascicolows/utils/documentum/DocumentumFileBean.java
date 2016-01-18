package it.equitalia.gestorefascicolows.utils.documentum;
  
import it.equitalia.gestorefascicolows.utils.documentum.DocumentumHandler.ContentType;

import java.util.Map;
 

public class DocumentumFileBean {
	
	private String      fileName;
	private String      folder;
	private String      classeDcmtFolder;
	private String      classeDcmt;
	private String      filePath;
	private boolean     creaDirs;
	private ContentType contentType;
	
	private Map<String, Object> attributiFile;
	private Map<String, Object> attributiFolder;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getClasseDcmtFolder() {
		return classeDcmtFolder;
	}
	public void setClasseDcmtFolder(String classeDcmtFolder) {
		this.classeDcmtFolder = classeDcmtFolder;
	}
	public String getClasseDcmt() {
		return classeDcmt;
	}
	public void setClasseDcmt(String classeDcmt) {
		this.classeDcmt = classeDcmt;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public ContentType getContentType() {
		return contentType;
	}
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	public Map<String, Object> getAttributiFile() {
		return attributiFile;
	}
	public void setAttributiFile(Map<String, Object> attributiFile) {
		this.attributiFile = attributiFile;
	}
	public boolean isCreaDirs() {
		return creaDirs;
	}
	public void setCreaDirs(boolean creaDirs) {
		this.creaDirs = creaDirs;
	}
	public Map<String, Object> getAttributiFolder() {
		return attributiFolder;
	}
	public void setAttributiFolder(Map<String, Object> attributiFolder) {
		this.attributiFolder = attributiFolder;
	}
}
