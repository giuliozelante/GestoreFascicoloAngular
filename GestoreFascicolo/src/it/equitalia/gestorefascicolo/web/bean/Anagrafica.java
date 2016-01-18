package it.equitalia.gestorefascicolo.web.bean;

import java.io.Serializable;

public class Anagrafica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4960142241043392976L;
	private String[] indirizzoNew;
	private Integer[] indirizzoRemove;
	private String[] telefonoNew;
	private Integer[] telefonoRemove; 
	private String[] emailNew;
	private Integer[] emailRemove;
	
	public String[] getEmailNew() {
		return emailNew;
	}
	public Integer[] getEmailRemove() {
		return emailRemove;
	}
	public String[] getIndirizzoNew() {
		return indirizzoNew;
	}
	public Integer[] getIndirizzoRemove() {
		return indirizzoRemove;
	}
	public String[] getTelefonoNew() {
		return telefonoNew;
	}
	public Integer[] getTelefonoRemove() {
		return telefonoRemove;
	}
	public void setEmailNew(String[] emailNew) {
		this.emailNew = emailNew;
	}
	public void setEmailRemove(Integer[] emailRemove) {
		this.emailRemove = emailRemove;
	}
	public void setIndirizzoNew(String[] indirizzoNew) {
		this.indirizzoNew = indirizzoNew;
	}
	public void setIndirizzoRemove(Integer[] indirizzoRemove) {
		this.indirizzoRemove = indirizzoRemove;
	}
	public void setTelefonoNew(String[] telefonoNew) {
		this.telefonoNew = telefonoNew;
	}
	public void setTelefonoRemove(Integer[] telefonoRemove) {
		this.telefonoRemove = telefonoRemove;
	} 
	
}
