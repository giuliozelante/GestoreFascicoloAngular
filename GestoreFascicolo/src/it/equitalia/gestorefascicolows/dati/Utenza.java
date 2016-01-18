package it.equitalia.gestorefascicolows.dati;

import java.io.Serializable;

public class Utenza implements Serializable{

	/**
	 *
	 */
	
	private boolean isCRM=false;
	
	public boolean isCRM() {
		return isCRM;
	}

	public void setCRM(boolean isCRM) {
		this.isCRM = isCRM;
	}
	private static final long serialVersionUID = -1049846045678401180L;
	private String xpar_FSCidFascicolo;
	private String xpar_FSCidChiamante;
	private String cf_user;
	private boolean user;

	public Utenza(boolean user) {
		super();
		this.user = user;
	}

	public Utenza(){super();}

	public String getCf_user() {
		return cf_user;
	}
	public String getXpar_FSCidChiamante() {
		return xpar_FSCidChiamante;
	}
	public String getXpar_FSCidFascicolo() {
		return xpar_FSCidFascicolo;
	}
	public void setCf_user(String cf_user) {
		this.cf_user = cf_user;
	}
	public void setXpar_FSCidChiamante(String xpar_FSCidChiamante) {
		this.xpar_FSCidChiamante = xpar_FSCidChiamante;
	}
	public void setXpar_FSCidFascicolo(String xpar_FSCidFascicolo) {
		this.xpar_FSCidFascicolo = xpar_FSCidFascicolo;
	}
	public boolean isUser() {
		return user;
	}
	public void setUser(boolean user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Utenza [xpar_FSCidFascicolo=" + xpar_FSCidFascicolo
				+ ", xpar_FSCidChiamante=" + xpar_FSCidChiamante + ", cf_user="
				+ cf_user + ", user=" + user + "]";
	}

}
