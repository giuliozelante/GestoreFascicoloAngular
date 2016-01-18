package it.equitalia.gestorefascicolo.web.util;

import org.apache.poi.ss.usermodel.CellStyle;

public class Utils {
	private CellStyle cellStyle;

	public Utils(CellStyle style){
		cellStyle = style;
	}

	public CellStyle getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(CellStyle cellStyle) {
		this.cellStyle = cellStyle;
	}

}
