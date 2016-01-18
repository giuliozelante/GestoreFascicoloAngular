package it.equitalia.gestorefascicolows.utils.documentum;

import com.documentum.fc.common.IDfId;

public class CheckedOutFile {
	
	private IDfId  id       = null;
	private String filePath = null;
	
	public CheckedOutFile(IDfId id, String filePath) {
		this.id       = id;
		this.filePath = filePath;
	}

	public IDfId getId() {
		return id;
	}
	public void setId(IDfId id) {
		this.id = id;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
