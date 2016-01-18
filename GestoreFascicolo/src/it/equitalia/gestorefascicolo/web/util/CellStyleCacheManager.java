package it.equitalia.gestorefascicolo.web.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CellStyleCacheManager {
    protected Set cellStyles;
    protected HSSFCellStyle cellStyle;
    protected HSSFCellStyle defaultValuesCellStyle;
    protected HSSFWorkbook workbook;

    public CellStyleCacheManager(HSSFWorkbook workbook) {
    	this.workbook = workbook;
    	this.cellStyles = new HashSet();
    	// El desperdicio de estilos será pués de dos
    	cellStyle = workbook.createCellStyle();
    	// Estilo almacenado para reiniciar el que se va a usar
    	defaultValuesCellStyle = workbook.createCellStyle();
    }

    /** Si el estilo se crea con createCellStyle, ya no podremos hacer nada */
    public void setCellStyle(HSSFCell cell, HSSFCellStyle cellStyle) {
    	CellStyleWrapper cellStyleWrp = new CellStyleWrapper(cellStyle);
    	CellStyleWrapper cachedCellStyleWrp = null;

    	Iterator it = cellStyles.iterator();

    	while(it.hasNext() && (cachedCellStyleWrp == null)) {
    		CellStyleWrapper tmpCachedCellStyleWrp = (CellStyleWrapper) it.next();

    		if(tmpCachedCellStyleWrp.equals(cellStyleWrp)) {
    			// Si algún estilo coincide con el actual usamos ese
    			cachedCellStyleWrp = tmpCachedCellStyleWrp;
    		}
    	}

    	if(cachedCellStyleWrp == null) {
    		// Si el estilo no existe creamos uno nuevo
    		HSSFCellStyle newCellStyle = workbook.createCellStyle();
    		CellStyleCacheManager.copyCellStyle(workbook, cellStyle, newCellStyle);

    		CellStyleWrapper newWrp = new CellStyleWrapper(newCellStyle);
    		cellStyles.add(newWrp);
    		cachedCellStyleWrp = newWrp;
    	}

    	cell.setCellStyle(cachedCellStyleWrp.getHSSFCellStyle());
    }

    public HSSFCellStyle getGeneralStyle() {
    	copyCellStyle(workbook,defaultValuesCellStyle, cellStyle );
    	return cellStyle;
    }

    public static void copyCellStyle(HSSFWorkbook wb, HSSFCellStyle c1, HSSFCellStyle c2) {
    	c2.setAlignment(c1.getAlignment());
    	c2.setBorderBottom(c1.getBorderBottom());
    	c2.setBorderLeft(c1.getBorderLeft());
    	c2.setBorderRight(c1.getBorderRight());
    	c2.setBorderTop(c1.getBorderTop());
    	c2.setBottomBorderColor(c1.getBottomBorderColor());
    	c2.setDataFormat(c1.getDataFormat());
    	c2.setFillBackgroundColor(c1.getFillBackgroundColor());
    	c2.setFillForegroundColor(c1.getFillForegroundColor());
    	c2.setFillPattern(c1.getFillPattern());

    	try {
    		c2.setFont(wb.getFontAt(c1.getFontIndex()));
    	} catch(NullPointerException e) {
//    		TLogger.getInstance().log(e.getMessage());
    	} catch(ArrayIndexOutOfBoundsException e) {
//    		TLogger.getInstance().log("Be sure to have intialized all POI font objects !\n%s",e.getMessage());
    	}

    	c2.setHidden(c1.getHidden());
    	c2.setIndention(c1.getIndention());
    	c2.setLeftBorderColor(c1.getLeftBorderColor());
    	c2.setLocked(c1.getLocked());
    	c2.setRightBorderColor(c1.getRightBorderColor());
    	c2.setRotation(c1.getRotation());
    	c2.setTopBorderColor(c1.getTopBorderColor());
    	c2.setVerticalAlignment(c1.getVerticalAlignment());
    	c2.setWrapText(c1.getWrapText());
    }
}
