package it.equitalia.gestorefascicolo.web.action;

import it.equitalia.aperturafascicolo.bpel.AperturaFascicoloResponse;
import it.equitalia.chiusurafascicolo.bpel.ChiusuraFascicoloResponse;
import it.equitalia.gestorefascicolo.web.bean.Anagrafica;
import it.equitalia.gestorefascicolo.web.delegate.AperturaFascicoloWSDelegate;
import it.equitalia.gestorefascicolo.web.delegate.ChiusuraFascicoloWSDelegate;
import it.equitalia.gestorefascicolo.web.delegate.FrontendGestoreFascicoloWSDelegate;
import it.equitalia.gestorefascicolo.web.util.CellStyleCacheManager;
import it.equitalia.gestorefascicolo.web.util.Log4jFactory;
import it.equitalia.gestorefascicolo.web.util.UtilConstants;
import it.equitalia.gestorefascicolows.dati.EMail;
import it.equitalia.gestorefascicolows.dati.EntityItem;
import it.equitalia.gestorefascicolows.dati.Fascicolo;
import it.equitalia.gestorefascicolows.dati.FascicoloList;
import it.equitalia.gestorefascicolows.dati.GetCartellaWSRequest;
import it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSRequest;
import it.equitalia.gestorefascicolows.dati.GetDocumentiEsattorialiNonCartelleWSResponse;
import it.equitalia.gestorefascicolows.dati.GetFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSRequest;
import it.equitalia.gestorefascicolows.dati.GetPdfDocumentoWSResponse;
import it.equitalia.gestorefascicolows.dati.GetRelateWSRequest;
import it.equitalia.gestorefascicolows.dati.GetRelateWSResponse;
import it.equitalia.gestorefascicolows.dati.Indirizzo;
import it.equitalia.gestorefascicolows.dati.InsertTelefonoWSRequest;
import it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSRequest;
import it.equitalia.gestorefascicolows.dati.PdfEstrattoContoWSResponse;
import it.equitalia.gestorefascicolows.dati.SearchFascicoloWSRequest;
import it.equitalia.gestorefascicolows.dati.Telefono;
import it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSRequest;
import it.equitalia.gestorefascicolows.dati.UpdateAnagraficaWSResponse;
import it.equitalia.gestorefascicolows.dati.Utenza;
import it.equitalia.gestorefascicolows.srv.FaultType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.xml.rpc.ServiceException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.softwareforge.struts2.breadcrumb.BreadCrumb;
import org.softwareforge.struts2.breadcrumb.BreadCrumbInterceptor;
import org.softwareforge.struts2.breadcrumb.BreadCrumbTrail;
import org.softwareforge.struts2.breadcrumb.NameComparator;
import org.softwareforge.struts2.breadcrumb.RewindMode;

import com.google.gson.Gson;
public class FascicoloAction extends BaseAction {
	private static final Logger logger = Log4jFactory.getLogger(FascicoloAction.class);
	private static final Logger errorLogger = Log4jFactory.getErrorLogger();

	private SearchFascicoloWSRequest searchFascicolo = new SearchFascicoloWSRequest();
	private String codiceFiscale;
	private FascicoloList[] fascicoloList;

	private static final long serialVersionUID = 5001833260647584726L;
	private EntityItem cartella = new EntityItem();
	private Fascicolo fascicolo = new Fascicolo();
	private GetFascicoloWSRequest getFascicoloWSRequest = new GetFascicoloWSRequest();
	private InsertTelefonoWSRequest inTelefonoWSRequest = new InsertTelefonoWSRequest();
	private GetCartellaWSRequest inCartellaWSRequest = new GetCartellaWSRequest();
	private GetDocumentiEsattorialiNonCartelleWSResponse documenti = new GetDocumentiEsattorialiNonCartelleWSResponse();
	private GetPdfDocumentoWSRequest getPdfDocumentoWSRequest = new GetPdfDocumentoWSRequest();
	private GetRelateWSRequest getRelateWSRequest = new GetRelateWSRequest();
	private PdfEstrattoContoWSRequest pdfEstrattoContoWSRequest = new PdfEstrattoContoWSRequest();
	private Anagrafica anagrafica = new Anagrafica();
	private String table = "";
	private static int FONT_14=0;
	private static int FONT_12=1;
	private static int FONT_10_NORMAL=2;
	private static int FONT_10_BOLD=3;
	private List<Font> fonts;

	private String errorMessage;

	private String tableLista;

	public String getTableLista() {
		return tableLista;
	}
	public void setTableLista(String tableLista) {
		this.tableLista = tableLista;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@SkipValidation
	public String apri() throws ServiceException, IOException{

		if(getRequest().getSession().getAttribute("navigazione")==null)
			return "pageHome";


		logger.info("INIZIO");
		AperturaFascicoloWSDelegate delegate = AperturaFascicoloWSDelegate.getInstance(ServletActionContext.getRequest());
		AperturaFascicoloResponse response = delegate.apriFascicolo(fascicolo.getFascicoloId(), fascicolo.getCallerId(), fascicolo.getAnagrafica().getCodiceFiscale());
		Gson gson = new Gson();
		ServletActionContext.getResponse().getWriter().write(gson.toJson(response));
		logger.info("FINE");
		return null;
	}
	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String apriDocumentiEsattoriali() throws Exception{

		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}



		logger.info("INIZIO");
		logger.info("\t- ALTRI DOCUMENTI ESATTORIALI -\t");
		logger.info("UTENTE:\t\t"+getUtenza().getCf_user());
		logger.info("IdFascicolo:\t"+fascicolo.getFascicoloId());
		logger.info("IdChiamante:\t"+fascicolo.getCallerId());
		try{
			//			throw new Exception();
			GetDocumentiEsattorialiNonCartelleWSRequest request = new GetDocumentiEsattorialiNonCartelleWSRequest();
			request.setCallerId(fascicolo.getCallerId());
			request.setFascicoloId(fascicolo.getFascicoloId());
			setDocumenti(FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest()).getDocumentiEsattorialiNonCartelle(request));
			if(this.documenti==null||this.documenti.getFascicolo()==null||this.documenti.getFascicolo().getDocumenti()==null||this.documenti.getFascicolo().getDocumenti().length==0){
				//XXX:1.7.0 ServletActionContext.getActionMapping().setName("dettaglioFascicoloCrm");
				addActionMessage(getDocumentiNoCRTNonPresenti());
				//XXX:1.7.0 return dettaglioFascicoloCrm();
			}
		}catch(Exception e){
			errorLogger.error(e.getMessage(),e);
			setErrorMessage(e.getMessage());
			return "pageDettaglio";
		}
		logger.info("FINE");
		deferredName = getProperties().getString("crumb.altri.documenti.esattoriali");
		return "documentiEsattoriali";
	}
	@SkipValidation
	public String chiudi() throws ServiceException, IOException{


		if(getRequest().getSession().getAttribute("navigazione")==null)
			return "pageHome";

		logger.info("INIZIO");
		ChiusuraFascicoloWSDelegate delegate = ChiusuraFascicoloWSDelegate.getInstance(ServletActionContext.getRequest());
		ChiusuraFascicoloResponse response = delegate.chiudiFascicolo(fascicolo.getFascicoloId(), fascicolo.getCallerId());
		Gson gson = new Gson();
		ServletActionContext.getResponse().getWriter().write(gson.toJson(response));
		logger.info("FINE");
		return null;
	}
	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String dettaglioCartella() throws Exception {

		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}



		logger.info("INIZIO");
		logger.info("\t- DETTAGLIO CARTELLA -\t");
		logger.info("UTENTE:\t\t"+getUtenza().getCf_user());
		logger.info("CARTELLA:\t"+inCartellaWSRequest.getNumeroCartella());
		logger.info("IdFascicolo:\t"+fascicolo.getFascicoloId());
		logger.info("IdChiamante:\t"+fascicolo.getCallerId());

		try {
			//XXX: Next release: Modifica codice ambito (da string a numero intero)
			//inCartellaWSRequest.setCodiceAmbito(String.valueOf(ncartellaBuf.replace(3, 20, "")));
			inCartellaWSRequest.setCodiceAmbito(String.valueOf(Integer.parseInt(inCartellaWSRequest.getNumeroCartella().substring(0, 3))));
			inCartellaWSRequest.setCallerId(fascicolo.getCallerId());
			inCartellaWSRequest.setFascicoloId(fascicolo.getFascicoloId());
			cartella = FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest()).getCartella(inCartellaWSRequest).getCartelle(0);

			getSession().setAttribute("cartellaSession", cartella);
			getSession().setAttribute("fascicoloSession", fascicolo);
		} catch (FaultType e) {
			errorLogger.error(e.getMessage(),e);
			setErrorMessage(e.getMessage1());
			return "pageDettaglio";
		} catch (Exception e) {
			errorLogger.error(e.getMessage(),e);
			setErrorMessage(e.getMessage()+" - "+e.getCause());
			return "pageDettaglio";
		}
		logger.info("FINE");
		deferredName = getProperties().getString("crumb.dettaglio.cartella");
		return "dettaglioCartella";
	}



	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String dettaglio() throws Exception{


		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}


		logger.info("INIZIO");
		try {
			GetFascicoloWSRequest inFascicoloWSRequest = new GetFascicoloWSRequest();

			if(getUtenza().getXpar_FSCidChiamante()!=null&&!getUtenza().getXpar_FSCidChiamante().equalsIgnoreCase("")){
				fascicolo.setCallerId(getUtenza().getXpar_FSCidChiamante());
				fascicolo.setFascicoloId(getUtenza().getXpar_FSCidFascicolo());
				setUtenza(new Utenza(getUtenza().isUser()));
				getSession().setAttribute(SESSION_UTENZA, getUtenza());
			}

			logger.info("\t- DETTAGLIO FASCICOLO -\t");
			logger.info("UTENTE:\t\t"+getUtenza().getCf_user());
			logger.info("IdFascicolo:\t"+fascicolo.getFascicoloId());
			logger.info("IdChiamante:\t"+fascicolo.getCallerId());

			inFascicoloWSRequest.setCallerId(fascicolo.getCallerId());
			inFascicoloWSRequest.setFascicoloId(fascicolo.getFascicoloId());
			Fascicolo fascicolo = FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest()).getFascicolo(inFascicoloWSRequest);

			BeanUtils.copyProperties(this.fascicolo, fascicolo);

			this.fascicolo.getAnagrafica().setNaturaGiuridica(fascicolo.getAnagrafica().getNaturaGiuridica().trim());

			if((this.fascicolo.getCartelle()==null||this.fascicolo.getCartelle().length==0)&&!hasActionMessages()){
				addActionMessage(getCartelleNonPresenti());
				//				if(getOtherParams()==null||getOtherParams().equals("NONE")){
				//					this.setFascicolo(null);
				//					return lista();
				//				}
			}
			getSession().setAttribute("AnagraficaSession", fascicolo.getAnagrafica());
		} catch (Exception e) {
			errorLogger.error(e.getMessage(),e);
			setErrorMessage(e.getMessage()+" - "+e.getCause());
			if(getOtherParams()==null||getOtherParams().equals("NONE")){
				this.setFascicolo(null);

				return "pageLista";

			}
		}
		logger.info("FINE");
		deferredName = getProperties().getString("crumb.dettaglio.fascicolo");
		return "dettaglio";
	}
	@SkipValidation
	public String getPdfDocumento() throws Exception{


		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}


		logger.info("INIZIO");
		logger.info("\t- PDF DOCUMENTO -\t");
		logger.info("UTENTE:\t\t"+getUtenza().getCf_user());
		logger.info("CARTELLA:\t"+getPdfDocumentoWSRequest.getNumeroDocumento());
		logger.info("IdFascicolo:\t"+getPdfDocumentoWSRequest.getFascicoloId());
		logger.info("IdChiamante:\t"+getPdfDocumentoWSRequest.getCallerId());

		logger.info("ServletActionContext.getRequest().getParameter(\"downloadPDF\"): "+ServletActionContext.getRequest().getParameter("downloadPDF"));

		FrontendGestoreFascicoloWSDelegate delegate = FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest());
		GetPdfDocumentoWSResponse response = delegate.getPdfDocumento(getPdfDocumentoWSRequest);

		if(ServletActionContext.getRequest().getParameter("downloadPDF")!=null&&!ServletActionContext.getRequest().getParameter("downloadPDF").equals("")&&response.getPdf()!=null&&response.getPdf().length!=0){
			ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream() ;
			ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment; filename=\""+getPdfDocumentoWSRequest.getNumeroDocumento()+"_"+Calendar.getInstance().getTimeInMillis()+".pdf\"");
			ServletActionContext.getResponse().setContentType("application/pdf");
			outputStream.write(response.getPdf());
			outputStream.flush();
			outputStream.close();
		}/*else if(ServletActionContext.getRequest().getParameter("downloadPDF")!=null&&!ServletActionContext.getRequest().getParameter("downloadPDF").equals("")&&(response.getPdf()==null||response.getPdf().length==0)){
			errorLogger.error("\t- PDF DOCUMENTO VUOTO-\t");
			errorLogger.error("UTENTE:\t\t"+getUtenza().getCf_user());
			errorLogger.error("CARTELLA:\t"+getPdfDocumentoWSRequest.getNumeroDocumento());
			errorLogger.error("IdFascicolo:\t"+getPdfDocumentoWSRequest.getFascicoloId());
			errorLogger.error("IdChiamante:\t"+getPdfDocumentoWSRequest.getCallerId());

			addActionError("PDF DOCUMENTO VUOTO");
			return null;
		}*/else{
			Gson gson = new Gson();
			ServletActionContext.getResponse().getWriter().write(gson.toJson(response));
		}

		try{
			BreadCrumbTrail trail = (BreadCrumbTrail) getSession().getAttribute(BreadCrumbInterceptor.CRUMB_KEY);
			trail.rewindAt(trail.getCrumbs().size());
		}catch(Exception e){}

		logger.info("FINE");
		return null;
	}

//inizio modifica 2015-06-10 distinzione estratto conto soluti/insoluti
	public String getPdfEstrattoContoSoluti() throws Exception{

		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}

		return getPdfEstrattoConto(UtilConstants.ESTRATTO_CONTO_SOLUTI);
	}

	public String getPdfEstrattoContoInsoluti() throws Exception{

		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}

		return getPdfEstrattoConto(UtilConstants.ESTRATTO_CONTO_INSOLUTI);

	}


	public String getPdfEstrattoConto(String tipologia) throws Exception{


		logger.info("INIZIO");
		logger.info("\t- PDF ESTRATTO CONTO -\t");
		logger.info("UTENTE:\t\t"+getUtenza().getCf_user());
		logger.info("IdFascicolo:\t"+fascicolo.getFascicoloId());
		logger.info("IdChiamante:\t"+fascicolo.getCallerId());
		FrontendGestoreFascicoloWSDelegate delegate = FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest());
		pdfEstrattoContoWSRequest.setCallerId(fascicolo.getCallerId());
		pdfEstrattoContoWSRequest.setCf(fascicolo.getAnagrafica().getCodiceFiscale());
		pdfEstrattoContoWSRequest.setFascicoloId(fascicolo.getFascicoloId());
		pdfEstrattoContoWSRequest.setTipologia(tipologia);
		PdfEstrattoContoWSResponse response;
		try{
			response = delegate.getPdfEstrattoConto(pdfEstrattoContoWSRequest);
			if(response.getPdf()!=null&&response.getPdf().length!=0){
				ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream() ;
				ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment; filename=\""+pdfEstrattoContoWSRequest.getFascicoloId()+"_"+Calendar.getInstance().getTimeInMillis()+".pdf\"");
				ServletActionContext.getResponse().setContentType("application/pdf");
				outputStream.write(response.getPdf());
				outputStream.flush();
				outputStream.close();
			}else{
				//			Gson gson = new Gson();
				//			ServletActionContext.getResponse().getWriter().write(gson.toJson(response));
				ServletActionContext.getActionMapping().setName("dettaglioFascicoloCrm");
				addActionMessage(response.getDescrizioneEsito());
				return dettaglio();
			}
		}catch(Exception e){
			errorLogger.error(e.getMessage(),e);
			addActionError(e.getMessage());
			return dettaglio();
		}
		try{
			BreadCrumbTrail trail = (BreadCrumbTrail) getSession().getAttribute(BreadCrumbInterceptor.CRUMB_KEY);
			trail.rewindAt(trail.getCrumbs().size());
		}catch(Exception e){}

		logger.info("FINE");
		return null;
	}
	//fine modifica 2015-06-10 distinzione estratto conto soluti/insoluti

	public String getRelate() throws Exception{


		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}


		logger.info("INIZIO");
		logger.info("\t- RELATE -\t");
		logger.info("UTENTE:\t\t"+getUtenza().getCf_user());
		logger.info("CARTELLA:\t"+getRelateWSRequest.getNumeroDocumento());
		logger.info("IdFascicolo:\t"+getRelateWSRequest.getFascicoloId());
		logger.info("IdChiamante:\t"+getRelateWSRequest.getCallerId());

		FrontendGestoreFascicoloWSDelegate delegate = FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest());
		GetRelateWSResponse response;
		try{
			response = delegate.getRelate(getRelateWSRequest);
			// throw new Exception();
			if(ServletActionContext.getRequest().getParameter("downloadRelate")!=null&&!ServletActionContext.getRequest().getParameter("downloadRelate").equals("")
					&&getRelateWSRequest.getDownload()!=null&&getRelateWSRequest.getDownload().equals("S")
					&&response.getPdf()!=null&&response.getPdf().length!=0){
				ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream() ;
				ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment; filename=\""+getRelateWSRequest.getNumeroDocumento()+"_"+Calendar.getInstance().getTimeInMillis()+".zip\"");
				ServletActionContext.getResponse().setContentType("application/zip");
				outputStream.write(response.getPdf());
				outputStream.flush();
				outputStream.close();
			}/*else if(ServletActionContext.getRequest().getParameter("downloadRelate")!=null&&!ServletActionContext.getRequest().getParameter("downloadRelate").equals("")
				&&getRelateWSRequest.getDownload()!=null&&getRelateWSRequest.getDownload().equals("S")
				&&(response.getPdf()==null||response.getPdf().length==0)){
			errorLogger.error("INIZIO");
			errorLogger.error("\t- RELATE VUOTE -\t");
			errorLogger.error("UTENTE:\t\t"+getUtenza().getCf_user());
			errorLogger.error("CARTELLA:\t"+getRelateWSRequest.getNumeroDocumento());
			errorLogger.error("IdFascicolo:\t"+getRelateWSRequest.getFascicoloId());
			errorLogger.error("IdChiamante:\t"+getRelateWSRequest.getCallerId());

			addActionError("RELATE VUOTE");
			return dettaglioFascicoloCrm();
		}*/
			else{
				Gson gson = new Gson();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
				response.setDataAggiornamento(sdfNew.format(sdf.parse(response.getDataAggiornamento())));
				ServletActionContext.getResponse().getWriter().write(gson.toJson(response));
			}
		}catch(Exception e){
			errorLogger.error(e.getMessage(),e);
			addActionError(e.getMessage());
		}finally{
			BreadCrumbTrail trail = (BreadCrumbTrail) getSession().getAttribute(BreadCrumbInterceptor.CRUMB_KEY);
			if(trail!=null){trail.rewindAt(trail.getCrumbs().size());}
		}
		logger.info("FINE");
		return null;
	}

	public String salvaAnagrafica() throws Exception{


		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}


		logger.info("INIZIO");
		UpdateAnagraficaWSResponse response;
		try {

			FrontendGestoreFascicoloWSDelegate delegate = FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest());
			UpdateAnagraficaWSRequest in = new UpdateAnagraficaWSRequest();
			in.setCallerId(fascicolo.getCallerId());
			in.setFascicoloId(fascicolo.getFascicoloId());


			ArrayList<String> indirizziConfermati = new ArrayList<String>();
			Indirizzo[] vecchiIndirizzi = ((it.equitalia.gestorefascicolows.dati.Anagrafica)getSession().getAttribute("AnagraficaSession")).getIndirizzi();
			if (vecchiIndirizzi!=null) {
				for (Indirizzo ind: vecchiIndirizzi) {
					if (ind.getIndirizzoPrincipale().equals("N")) {
						boolean daRimuovere = false;
						for (Integer id : anagrafica.getIndirizzoRemove()) {
							if (ind.getIndirizzoId().equals(id)) {
								daRimuovere = true;
							}
						}
						if (!daRimuovere) {
							indirizziConfermati.add(ind.getIndirizzo());
						}
					}
				}
			}

			ArrayList<String> indirizziDaSalvare = new ArrayList<String>();
			for (String indirizzo : anagrafica.getIndirizzoNew()) {
				if (indirizzo!=null && !indirizzo.equals("")) {
					indirizziDaSalvare.add(indirizzo);
				}
			}
			indirizziDaSalvare.addAll(indirizziConfermati);
			in.setIndirizzo(indirizziDaSalvare.toArray(new String[0]));



			ArrayList<String> telefoniConfermati = new ArrayList<String>();
			Telefono[] vecchiTelefoni = ((it.equitalia.gestorefascicolows.dati.Anagrafica)getSession().getAttribute("AnagraficaSession")).getTelefoni();
			if (vecchiTelefoni!=null) {
				for (Telefono tel: vecchiTelefoni) {
					boolean daRimuovere = false;
					for (Integer id : anagrafica.getTelefonoRemove()) {
						if (tel.getTelefonoId().equals(id)) {
							daRimuovere = true;
						}
					}
					if (!daRimuovere) {
						telefoniConfermati.add(tel.getTelefono());
					}
				}
			}

			ArrayList<String> telefoniDaSalvare = new ArrayList<String>();
			for (String numeroTel : anagrafica.getTelefonoNew()) {
				if (numeroTel!=null && !numeroTel.equals("")) {
					telefoniDaSalvare.add(numeroTel);
				}
			}
			telefoniDaSalvare.addAll(telefoniConfermati);
			in.setNumeroTelefono( telefoniDaSalvare.toArray(new String[0]) );

			ArrayList<String> emailConfermate = new ArrayList<String>();
			EMail[] vecchieEmail = ((it.equitalia.gestorefascicolows.dati.Anagrafica)getSession().getAttribute("AnagraficaSession")).getEmail();
			if (vecchieEmail!=null) {
				for (EMail email: vecchieEmail) {
					boolean daRimuovere = false;
					for (Integer id : anagrafica.getEmailRemove()) {
						if (email.getEMailId().equals(id)) {
							daRimuovere = true;
						}
					}
					if (!daRimuovere) {
						emailConfermate.add(email.getEMail());
					}
				}
			}

			ArrayList<String> emailDaSalvare = new ArrayList<String>();
			for (String email : anagrafica.getEmailNew()) {
				if (email!=null && !email.equals("")) {
					emailDaSalvare.add(email);
				}
			}
			emailDaSalvare.addAll(emailConfermate);
			in.setEmail( emailDaSalvare.toArray(new String[0]) );

			response = delegate.updateAnagrafica(in);
		} catch (Exception e) {
			logger.error("", e);
			throw e;
		}

		if (response.getEsito().equals("KO") ) {
			throw new Exception("Errore in salvaAnagrafica");
		}

		logger.info("FINE");

		return "dettaglioRedirect";   //  modifica bug 2015-04-09
	}

	public String exportExcel() throws IOException{


		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}


		try{
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Export");

			CellStyleCacheManager styleManager = new CellStyleCacheManager(workbook);

			Font font14Normal = workbook.createFont();
			Font font12Normal = workbook.createFont();
			Font font10Normal = workbook.createFont();
			Font font10Bold = workbook.createFont();

			font14Normal.setFontHeightInPoints((short)14);
			font14Normal.setFontName("Calibri");
			font12Normal.setFontHeightInPoints((short)12);
			font12Normal.setFontName("Calibri");
			font10Normal.setFontHeightInPoints((short)10);
			font10Normal.setFontName("Calibri");
			font10Bold.setFontHeightInPoints((short)10);
			font10Bold.setFontName("Calibri");
			font10Bold.setBoldweight(Font.BOLDWEIGHT_BOLD);

			fonts = new ArrayList<Font>();
			fonts.add(font14Normal);
			fonts.add(font12Normal);
			fonts.add(font10Normal);
			fonts.add(font10Bold);

			Document doc = Jsoup.parse(this.table);

			ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream() ;
			ServletActionContext.getResponse().setCharacterEncoding("windows-1252");
			ServletActionContext.getResponse().setContentType("application/vnd.ms-excel");
			ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment; filename="+doc.getElementById("fascicoloId").val()+"_"+GregorianCalendar.getInstance().getTimeInMillis()+".xls");

			logger.debug(doc.toString());

			int cellIndex = 0;
			HSSFRow row = null;
			HSSFCell cell = null;

			//XXX:Dati Fascicolo
			workbook = createDatiFascicolo(doc, row, sheet, workbook, cellIndex, cell,styleManager);
			//XXX:Dati Anagrafici
			workbook = createDatiAnagrafici(doc, row, sheet, workbook, cellIndex, cell,styleManager);
			//XXX:Lista Cartelle
			workbook = createListaCartelle(doc,row,sheet, cell,cellIndex,workbook,styleManager);
			//XXX:Dettaglio Cartella
			workbook = createDettaglioCartella(doc, row, sheet, cell, cellIndex, workbook,styleManager);

			row = sheet.getRow(sheet.getLastRowNum()-2);
			for (Iterator<Cell> iterator = row.cellIterator(); iterator.hasNext();) {
				Cell newCell = (Cell) iterator.next();
				sheet.autoSizeColumn(newCell.getColumnIndex());
			}

			//XXX:Lista degli elementi contenuti nella cartella o dei documenti esattoriali
			workbook = createListaItems(doc, row, sheet, cell, cellIndex, workbook,styleManager);

			workbook.write(outputStream);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			addActionError(e.getMessage()+" - "+e.getCause());
			return ERROR;
		}
		//        workbook.close();
		return null;
	}


	public String exportListaExcel() throws IOException{


		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}



		try{
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Export");


			CellStyleCacheManager styleManager = new CellStyleCacheManager(workbook);

			Font font14Normal = workbook.createFont();
			Font font12Normal = workbook.createFont();
			Font font10Normal = workbook.createFont();
			Font font10Bold = workbook.createFont();

			font14Normal.setFontHeightInPoints((short)14);
			font14Normal.setFontName("Calibri");
			font12Normal.setFontHeightInPoints((short)12);
			font12Normal.setFontName("Calibri");
			font10Normal.setFontHeightInPoints((short)10);
			font10Normal.setFontName("Calibri");
			font10Bold.setFontHeightInPoints((short)10);
			font10Bold.setFontName("Calibri");
			font10Bold.setBoldweight(Font.BOLDWEIGHT_BOLD);

			fonts = new ArrayList<Font>();
			fonts.add(font14Normal);
			fonts.add(font12Normal);
			fonts.add(font10Normal);
			fonts.add(font10Bold);

			Document doc = Jsoup.parse(this.tableLista);

			ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream() ;
			ServletActionContext.getResponse().setCharacterEncoding("windows-1252");
			ServletActionContext.getResponse().setContentType("application/vnd.ms-excel");
			ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment; filename=lista_fascicoli_"+GregorianCalendar.getInstance().getTimeInMillis()+".xls");

			logger.debug(doc.toString());

			int cellIndex = 0;
			HSSFRow row = null;
			HSSFCell cell = null;

			workbook = createListaFascicoli(doc,row,sheet, cell,cellIndex,workbook,styleManager);

			workbook.write(outputStream);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			addActionError(e.getMessage()+" - "+e.getCause());
			return ERROR;
		}
		//        workbook.close();
		return null;
	}

	private HSSFWorkbook createListaFascicoli(Document doc, HSSFRow row,
			HSSFSheet sheet, HSSFCell cell, int cellIndex,
			HSSFWorkbook workbook, CellStyleCacheManager styleManager) {

		HSSFCellStyle style = styleManager.getGeneralStyle();

		if(doc.getElementById("elencoDati")!=null){

			Elements htmlRows = doc.getElementById("elencoDati").getElementsByTag("tr");

			int rowIndex = workbook.getSheetAt(0).getLastRowNum();

			row = sheet.createRow(rowIndex++);
			cell = row.createCell(cellIndex);
			style.setFont(fonts.get(FONT_14));
			styleManager.setCellStyle(cell, style);
			cell.setCellValue("Lista Fascicoli");

			row = sheet.createRow(rowIndex++);

			for (Element htmlRow : htmlRows)
			{
				row = sheet.createRow(rowIndex++);
				Elements htmlCellHeadings = htmlRow.getElementsByTag("th");

				for (Element htmlCellHeading : htmlCellHeadings) {
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex);
					style.setWrapText(true);

					style.setBorderBottom(CellStyle.BORDER_THIN);
					style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					style.setFont(fonts.get(FONT_10_BOLD));
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCellHeading.text());
					sheet.setColumnWidth(cellIndex,calculateColWidth(htmlCellHeading.text().length()+9) );
					cellIndex++;


				}

			    htmlCellHeadings = htmlRow.getElementsByTag("td");

				for (Element htmlCellHeading : htmlCellHeadings) {
					style = styleManager.getGeneralStyle();
					if(rowIndex%2==0){
						style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND );
						style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
					}
					cell = row.createCell(cellIndex++);
					style.setWrapText(true);

					style.setBorderBottom(CellStyle.BORDER_THIN);
					style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCellHeading.text());

				}

				cellIndex = 0;


			}





			//row = sheet.createRow(sheet.getLastRowNum()+1);
		}
		return workbook;
	}

	  public static int calculateColWidth(int width){
          if(width > 254)
                  return 65280; // Maximum allowed column width.
          if(width > 1){
                  int floor = (int)(Math.floor(((double)width)/5));
                  int factor = (30*floor);
                  int value = 450 + factor + ((width-1) * 250);
                  return value;
          }
          else
                  return 450; // default to column size 1 if zero, one or negative number is passed.
  }


	public String saveAnagrafica() throws Exception {
		logger.info("INIZIO");
		for (Telefono telefono: this.fascicolo.getAnagrafica().getTelefoni()) {
			logger.debug("-----------> " + telefono);
		}
		logger.info("FINE");
		return SUCCESS;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public void setCartella(EntityItem cartella) {
		this.cartella = cartella;
	}

	@Override
	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String execute() throws Exception {


		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}



		searchFascicolo.setStatoFascicolo(new Integer(10));



		GregorianCalendar calendar=(GregorianCalendar) GregorianCalendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());

		calendar.set(Calendar.DAY_OF_MONTH, 1);

		searchFascicolo.setDataAperturaDa(calendar.getTime());

		BreadCrumbTrail trail = (BreadCrumbTrail) getSession().getAttribute(BreadCrumbInterceptor.CRUMB_KEY);

		// rewinding at position -1 has the effect of clearing the entire trail
		if(trail!=null){trail.rewindAt(0);}
		deferredName = getProperties().getString("crumb.cerca.fascicolo");

		return INPUT;
	}

	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String lista() throws Exception{

		Utenza current=getUtenza();

		if(!current.isCRM())
		{
			if(getRequest().getSession().getAttribute("navigazione")==null)
				return "pageHome";
		}


		logger.info("INIZIO");
		try{
			setFascicoloList(FrontendGestoreFascicoloWSDelegate.getInstance(ServletActionContext.getRequest()).searchFascicolo(searchFascicolo));
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			setErrorMessage(e.getMessage()+" - "+e.getCause());
			return "pageCerca";

		}
		logger.info("FINE");
		deferredName = getProperties().getString("crumb.lista.fascicoli");
		ServletActionContext.getResponse().getWriter().write((new Gson()).toJson(fascicoloList));
//		return "lista";
		return null;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public FascicoloList[] getFascicoloList() {
		return fascicoloList;
	}

	public SearchFascicoloWSRequest getSearchFascicolo() {
		return searchFascicolo;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setFascicoloList(FascicoloList[] fascicoloList) {
		this.fascicoloList = fascicoloList;
	}

	public void setSearchFascicolo(SearchFascicoloWSRequest searchFascicolo) {
		this.searchFascicolo = searchFascicolo;
	}

	public String fascicoloDettaglio() throws Exception {
		return SUCCESS;
	}
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}
	public EntityItem getCartella() {
		return cartella;
	}
	public GetDocumentiEsattorialiNonCartelleWSResponse getDocumenti() {
		return documenti;
	}
	public Fascicolo getFascicolo() {
		return fascicolo;
	}
	public GetFascicoloWSRequest getGetFascicoloWSRequest() {
		return getFascicoloWSRequest;
	}
	public GetPdfDocumentoWSRequest getGetPdfDocumentoWSRequest() {
		return getPdfDocumentoWSRequest;
	}
	public GetRelateWSRequest getGetRelateWSRequest() {
		return getRelateWSRequest;
	}

	public GetCartellaWSRequest getInCartellaWSRequest() {
		return inCartellaWSRequest;
	}

	public InsertTelefonoWSRequest getInTelefonoWSRequest() {
		return inTelefonoWSRequest;
	}
	public void setDocumenti(GetDocumentiEsattorialiNonCartelleWSResponse documenti) {
		this.documenti = documenti;
	}
	public void setFascicolo(Fascicolo fascicolo) {
		this.fascicolo = fascicolo;
	}
	public void setGetFascicoloWSRequest(GetFascicoloWSRequest getFascicoloWSRequest) {
		this.getFascicoloWSRequest = getFascicoloWSRequest;
	}
	public void setGetPdfDocumentoWSRequest(
			GetPdfDocumentoWSRequest getPdfDocumentoWSRequest) {
		this.getPdfDocumentoWSRequest = getPdfDocumentoWSRequest;
	}
	public void setGetRelateWSRequest(GetRelateWSRequest getRelateWSRequest) {
		this.getRelateWSRequest = getRelateWSRequest;
	}
	public void setInCartellaWSRequest(GetCartellaWSRequest inCartellaWSRequest) {
		this.inCartellaWSRequest = inCartellaWSRequest;
	}
	public void setInTelefonoWSRequest(InsertTelefonoWSRequest inTelefonoWSRequest) {
		this.inTelefonoWSRequest = inTelefonoWSRequest;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}

	private HSSFWorkbook createDatiFascicolo(Element doc, HSSFRow row,HSSFSheet sheet, HSSFWorkbook workbook,int cellIndex, HSSFCell cell, CellStyleCacheManager styleManager){

		Element datiFascicolo = doc.getElementById("datiFascicolo");
		Elements htmlRows = datiFascicolo.getElementsByTag("tr");

		int rowIndex = workbook.getSheetAt(0).getLastRowNum();

		row = sheet.createRow(rowIndex++);
		cell = row.createCell(cellIndex);
		HSSFCellStyle style = styleManager.getGeneralStyle();
		style.setFont(fonts.get(FONT_14));
		styleManager.setCellStyle(cell, style);
		cell.setCellValue(datiFascicolo.getElementsByTag("caption").get(0).text());

		for (Element htmlRow : htmlRows) {

			row = sheet.createRow(rowIndex++);
			Elements elements = htmlRow.children();
			for(Element element:elements){
				if(element.tagName().equals("th")||element.tagName().equals("td")){
					style = styleManager.getGeneralStyle();
					if(rowIndex==2){
						style.setBorderTop(CellStyle.BORDER_MEDIUM);
						style.setTopBorderColor(IndexedColors.BLACK.getIndex());
					}
					if(cellIndex==0){
						style.setBorderLeft(CellStyle.BORDER_MEDIUM);
						style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
					}
					cell = row.createCell(cellIndex++);
					if(element.tagName().equals("th")){
						style.setFont(fonts.get(FONT_10_BOLD));
					}else if(element.tagName().equals("td")){
						style.setFont(fonts.get(FONT_10_NORMAL));
					}
					if(cellIndex==elements.size()){
						style.setBorderRight(CellStyle.BORDER_MEDIUM);
						style.setRightBorderColor(IndexedColors.BLACK.getIndex());
					}
					if(rowIndex==htmlRows.size()+1){
						style.setBorderBottom (CellStyle.BORDER_MEDIUM);
						style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					}
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(element.text());
				}
			}
			cellIndex=0;
		}
		row = sheet.createRow(sheet.getLastRowNum()+1);
		return workbook;
	}

	private HSSFWorkbook createDatiAnagrafici(Element doc, HSSFRow row,HSSFSheet sheet, HSSFWorkbook workbook,int cellIndex, HSSFCell cell, CellStyleCacheManager styleManager){
		HSSFCellStyle style = styleManager.getGeneralStyle();

		Element datiFascicolo = doc.getElementById("datiAnagrafici");
		cellIndex=0;

		int rowIndex = workbook.getSheetAt(0).getLastRowNum()+1;

		row = sheet.createRow(rowIndex++);
		cell = row.createCell(cellIndex);
//		font.setFontHeightInPoints((short) 14);
//
		style.setFont(fonts.get(FONT_14));
		styleManager.setCellStyle(cell, style);
		cell.setCellValue(datiFascicolo.getElementsByTag("caption").get(0).text());

		//XXX:SOGGETTO
		Elements soggetto = datiFascicolo.getElementById("soggetto").children();
		row = sheet.createRow(rowIndex++);
		for (Element htmlCell:soggetto){
			style = styleManager.getGeneralStyle();
			style.setBorderTop(CellStyle.BORDER_MEDIUM);
			style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			cell = row.createCell(cellIndex++);
			if(htmlCell.nodeName().equals("th")){
				style.setFont(fonts.get(FONT_10_BOLD));
			}else{
				style.setFont(fonts.get(FONT_10_NORMAL));
			}
			if(datiFascicolo.getElementById("indirizzoPrincipale")==null){
				style.setBorderBottom (CellStyle.BORDER_MEDIUM);
				style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			}
			if(soggetto.size()==cellIndex){
				style.setBorderRight (CellStyle.BORDER_MEDIUM);
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			}

			styleManager.setCellStyle(cell, style);
			cell.setCellValue(htmlCell.text());
		}
		style = styleManager.getGeneralStyle();
		//XXX:INDIRIZZO PRINCIPALE
		if(datiFascicolo.getElementById("indirizzoPrincipale")!=null){
			soggetto = datiFascicolo.getElementById("indirizzoPrincipale").children();
			row = sheet.createRow(rowIndex++);
			cellIndex = 0;
			for (Element htmlCell:soggetto){
				style = styleManager.getGeneralStyle();
				cell = row.createCell(cellIndex++);
				if(htmlCell.nodeName().equals("th")){
					style.setFont(fonts.get(FONT_10_BOLD));
				}else{
					style.setFont(fonts.get(FONT_10_NORMAL));
				}
				styleManager.setCellStyle(cell, style);
				cell.setCellValue(htmlCell.text());
			}
			cell = row.createCell(cellIndex+1);

			style = styleManager.getGeneralStyle();

			style.setBorderRight(CellStyle.BORDER_MEDIUM);
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			styleManager.setCellStyle(cell, style);

			if(datiFascicolo.getElementById("indirizziAlternativi").children().size()>0){
				soggetto = datiFascicolo.getElementById("indirizziAlternativi").children();
				row = sheet.createRow(rowIndex++);

				//XXX:INDIRIZZI ALTERNATIVI
				cellIndex=0;
				style = styleManager.getGeneralStyle();
				cell = row.createCell(cellIndex);
				style.setFont(fonts.get(FONT_10_BOLD));
				styleManager.setCellStyle(cell, style);
				cell.setCellValue("Indirizzi Alternativi:");
				cellIndex++;

				for (Element htmlCell:soggetto){
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex);
					style.setFont(fonts.get(FONT_10_NORMAL));

					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCell.text());

				}
				cell = row.createCell(cellIndex+2);

				style.setBorderRight(CellStyle.BORDER_MEDIUM);
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				styleManager.setCellStyle(cell, style);
			}

			//XXX:TELEFONI
			if(datiFascicolo.getElementById("telefoni").children().size()>0){
				style = styleManager.getGeneralStyle();
				soggetto = datiFascicolo.getElementById("telefoni").children();
				row = sheet.createRow(rowIndex++);
				cellIndex=0;
				cell = row.createCell(cellIndex);
				style.setFont(fonts.get(FONT_10_BOLD));
				styleManager.setCellStyle(cell, style);
				cell.setCellValue("Telefoni:");
				cellIndex++;

				for (Element htmlCell:soggetto){
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex);
					style.setFont(fonts.get(FONT_10_NORMAL));
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCell.text());
				}
				cell = row.createCell(cellIndex+2);

				style.setBorderRight(CellStyle.BORDER_MEDIUM);
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				styleManager.setCellStyle(cell, style);
			}

			//XXX:EMAIL
			if(datiFascicolo.getElementById("email").children().size()>0){
				style = styleManager.getGeneralStyle();
				soggetto = datiFascicolo.getElementById("email").children();
				row = sheet.createRow(rowIndex++);
				cellIndex=0;
				cell = row.createCell(cellIndex++);
				style.setFont(fonts.get(FONT_10_BOLD));
				style.setBorderBottom(CellStyle.BORDER_MEDIUM);
				style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				styleManager.setCellStyle(cell, style);
				cell.setCellValue("e-mail:");

				for (Element htmlCell:soggetto){
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex);
					style.setFont(fonts.get(FONT_10_NORMAL));
					style.setBorderBottom(CellStyle.BORDER_MEDIUM);
					style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCell.text());
				}
				cell = row.createCell(cellIndex+1);
				styleManager.setCellStyle(cell, style);

				cell = row.createCell(cellIndex+2);

				style.setBorderBottom(CellStyle.BORDER_MEDIUM);
				style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

				style.setBorderRight(CellStyle.BORDER_MEDIUM);
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				styleManager.setCellStyle(cell, style);
			}
		}
		style = styleManager.getGeneralStyle();

		sheet.createRow(sheet.getLastRowNum()+1);
		return workbook;
	}

	private HSSFWorkbook createListaCartelle(Element doc,HSSFRow row,HSSFSheet sheet, HSSFCell cell,int cellIndex,HSSFWorkbook workbook, CellStyleCacheManager styleManager){

		HSSFCellStyle style = styleManager.getGeneralStyle();

		if(doc.getElementById("listaCartelle")!=null){

			Elements htmlRows = doc.getElementById("listaCartelle").getElementsByTag("tr");

			int rowIndex = workbook.getSheetAt(0).getLastRowNum()+1;

			row = sheet.createRow(rowIndex++);
			cell = row.createCell(cellIndex);
			style.setFont(fonts.get(FONT_14));
			styleManager.setCellStyle(cell, style);
			cell.setCellValue(doc.getElementById("listaCartelle").getElementsByTag("caption").get(0).text());

			int listaFascicoliRowIndex = 0;
			for (Element htmlRow : htmlRows) {
				row = sheet.createRow(rowIndex++);
				Elements htmlCellHeadings = htmlRow.getElementsByTag("th");
				int renderingType3668index = 0;
				for(Element htmlCellHeading : htmlCellHeadings){
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex++);
					style.setWrapText(true);
					if(Integer.parseInt(htmlCellHeading.attr("renderingType"))>=32){
						renderingType3668index++;
						style.setBorderTop(CellStyle.BORDER_MEDIUM);
						style.setTopBorderColor(IndexedColors.BLUE.getIndex());
						if(Integer.parseInt(htmlCellHeading.attr("renderingType"))==40){
							style.setBorderLeft(CellStyle.BORDER_MEDIUM);
							style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
							style.setFont(fonts.get(FONT_10_BOLD));
						}
						if(renderingType3668index==htmlRow.getElementsByAttributeValue("renderingType", "40").size()+htmlRow.getElementsByAttributeValue("renderingType", "72").size()){
							style.setBorderRight(CellStyle.BORDER_MEDIUM);
							style.setRightBorderColor(IndexedColors.BLUE.getIndex());
						}
					}
					style.setBorderBottom(CellStyle.BORDER_THIN);
					style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCellHeading.text());
					if(Integer.parseInt(htmlCellHeading.attr("renderingType"))==40){
						cell.setCellValue("Totale "+htmlCellHeading.text());
					}
				}
				cellIndex = 0;
				Elements htmlCells = htmlRow.getElementsByTag("td");
				renderingType3668index = 0;
				for(Element htmlCell : htmlCells){
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex++);
					if(Integer.parseInt(htmlCell.attr("renderingType"))>=32){
						renderingType3668index++;
						if(Integer.parseInt(htmlCell.attr("renderingType"))==40){
							style.setBorderLeft(CellStyle.BORDER_MEDIUM);
							style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
							style.setFont(fonts.get(FONT_10_BOLD));
						}
						if(listaFascicoliRowIndex==(htmlRows.size()-1)){
							style.setBorderBottom(CellStyle.BORDER_MEDIUM);
							style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
						}
						if(renderingType3668index==htmlRow.getElementsByAttributeValue("renderingType", "40").size()+htmlRow.getElementsByAttributeValue("renderingType", "72").size()){
							style.setBorderRight(CellStyle.BORDER_MEDIUM);
							style.setRightBorderColor(IndexedColors.BLUE.getIndex());
						}
					}
					if(rowIndex % 2 != 0){
						style.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
					}
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCell.text());
				}
				cellIndex = 0;
				listaFascicoliRowIndex++;
			}
			row = sheet.createRow(sheet.getLastRowNum()+1);
		}
		return workbook;
	}
	private HSSFWorkbook createDettaglioCartella(Element doc,HSSFRow row,HSSFSheet sheet, HSSFCell cell,int cellIndex,HSSFWorkbook workbook, CellStyleCacheManager styleManager){
		HSSFCellStyle style = styleManager.getGeneralStyle();

		if(doc.getElementById("dettaglioCartella")!=null){
			Elements htmlRows = doc.getElementById("dettaglioCartella").getElementsByTag("tr");
			int rowIndex = workbook.getSheetAt(0).getLastRowNum()+1;
			row = sheet.createRow(rowIndex++);
			cell = row.createCell(cellIndex);
			style.setFont(fonts.get(FONT_14));
			styleManager.setCellStyle(cell, style);
			cell.setCellValue(doc.getElementById("dettaglioCartella").getElementsByTag("caption").get(0).text());

			int listaFascicoliRowIndex = 0;
			for (Element htmlRow : htmlRows) {
				row = sheet.createRow(rowIndex++);
				Elements htmlCellHeadings = htmlRow.getElementsByTag("th");
				int renderingType3668index = 0;
				for(Element htmlCellHeading : htmlCellHeadings){
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex++);
					style.setWrapText(true);
					if(Integer.parseInt(htmlCellHeading.attr("renderingType"))>=32){
						renderingType3668index++;
						style.setBorderTop(CellStyle.BORDER_MEDIUM);
						style.setTopBorderColor(IndexedColors.BLUE.getIndex());
						if(Integer.parseInt(htmlCellHeading.attr("renderingType"))==40){
							style.setBorderLeft(CellStyle.BORDER_MEDIUM);
							style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
							style.setFont(fonts.get(FONT_14));
						}
						if(renderingType3668index==htmlRow.getElementsByAttributeValue("renderingType", "40").size()+htmlRow.getElementsByAttributeValue("renderingType", "72").size()+htmlRow.getElementsByAttributeValue("renderingType", "65").size()){
							style.setBorderRight(CellStyle.BORDER_MEDIUM);
							style.setRightBorderColor(IndexedColors.BLUE.getIndex());
						}
					}
					style.setBorderBottom(CellStyle.BORDER_THIN);
					style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCellHeading.text());
					if(Integer.parseInt(htmlCellHeading.attr("renderingType"))==40){
						cell.setCellValue("Totale "+htmlCellHeading.text());
					}
				}
				cellIndex = 0;
				Elements htmlCells = htmlRow.getElementsByTag("td");
				renderingType3668index = 0;
				for(Element htmlCell : htmlCells){
					style = styleManager.getGeneralStyle();
					cell = row.createCell(cellIndex++);
					if(Integer.parseInt(htmlCell.attr("renderingType"))>=32){
						renderingType3668index++;
						if(Integer.parseInt(htmlCell.attr("renderingType"))==40){
							style.setBorderLeft(CellStyle.BORDER_MEDIUM);
							style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
							style.setFont(fonts.get(FONT_10_BOLD));
						}
						if(listaFascicoliRowIndex==(htmlRows.size()-1)){
							style.setBorderBottom(CellStyle.BORDER_MEDIUM);
							style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
						}
						if(renderingType3668index==htmlRow.getElementsByAttributeValue("renderingType", "40").size()+htmlRow.getElementsByAttributeValue("renderingType", "72").size()+htmlRow.getElementsByAttributeValue("renderingType", "65").size()){
							style.setBorderRight(CellStyle.BORDER_MEDIUM);
							style.setRightBorderColor(IndexedColors.BLUE.getIndex());
						}
					}
					if(rowIndex % 2 != 0){
						style.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
					}
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(htmlCell.text());
				}
				cellIndex = 0;
				listaFascicoliRowIndex++;
			}
			row = sheet.createRow(sheet.getLastRowNum()+1);
		}
		return workbook;
	}
	private HSSFWorkbook createListaItems(Document doc, HSSFRow row,
			HSSFSheet sheet, HSSFCell cell, int cellIndex, HSSFWorkbook workbook, CellStyleCacheManager styleManager) {

		int rowIndex = workbook.getSheetAt(0).getLastRowNum()+1;
		if(doc.getElementsByClass("item")!=null){
			for(Element item:doc.getElementsByClass("item")){
				HSSFCellStyle style = styleManager.getGeneralStyle();
				Elements htmlRows = item.getElementsByTag("tr");
				if(item.hasClass("sub")){cellIndex++;}

				if(item.getElementsByTag("caption").size()!=0){
					if(item.hasClass("sub")){style.setFont(fonts.get(FONT_12));}else{rowIndex+=2;}
					row = sheet.createRow(rowIndex++);
					style.setFont(fonts.get(FONT_14));
					cell = row.createCell(cellIndex);
					styleManager.setCellStyle(cell, style);
					cell.setCellValue(item.getElementsByTag("caption").get(0).text());
				}

				int listaFascicoliRowIndex = 0;
				for (Element htmlRow : htmlRows) {
					row = sheet.createRow(rowIndex++);
					Elements htmlCellHeadings = htmlRow.getElementsByTag("th");
					int renderingType3668index = 0;
					for(Element htmlCellHeading : htmlCellHeadings){
						style = styleManager.getGeneralStyle();
						cell = row.createCell(cellIndex++);
						style.setWrapText(true);
						if(Integer.parseInt(htmlCellHeading.attr("renderingType"))>=32){
							renderingType3668index++;
							style.setBorderTop(CellStyle.BORDER_MEDIUM);
							style.setTopBorderColor(IndexedColors.BLUE.getIndex());
							if(Integer.parseInt(htmlCellHeading.attr("renderingType"))==40||Integer.parseInt(htmlCellHeading.attr("renderingType"))==33){
								style.setBorderLeft(CellStyle.BORDER_MEDIUM);
								style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
								if(Integer.parseInt(htmlCellHeading.attr("renderingType"))==40){
									style.setFont(fonts.get(FONT_10_BOLD));
								}
							}
							if(renderingType3668index==htmlRow.getElementsByAttributeValue("renderingType", "40").size()+htmlRow.getElementsByAttributeValue("renderingType", "72").size()+htmlRow.getElementsByAttributeValue("renderingType", "65").size()+htmlRow.getElementsByAttributeValue("renderingType", "33").size()){
								style.setBorderRight(CellStyle.BORDER_MEDIUM);
								style.setRightBorderColor(IndexedColors.BLUE.getIndex());
							}
						}
						style.setFont(fonts.get(FONT_12));
						style.setBorderBottom(CellStyle.BORDER_THIN);
						style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

						styleManager.setCellStyle(cell, style);
						cell.setCellValue(htmlCellHeading.text());
					}
					cellIndex = 0;if(item.hasClass("sub")){cellIndex++;}
					Elements htmlCells = htmlRow.getElementsByTag("td");
					renderingType3668index = 0;
					for(Element htmlCell : htmlCells){
						style = styleManager.getGeneralStyle();
						cell = row.createCell(cellIndex++);
						if(Integer.parseInt(htmlCell.attr("renderingType"))>=32){
							renderingType3668index++;
							if(Integer.parseInt(htmlCell.attr("renderingType"))==40||Integer.parseInt(htmlCell.attr("renderingType"))==33){
								style.setBorderLeft(CellStyle.BORDER_MEDIUM);
								style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
								if(Integer.parseInt(htmlCell.attr("renderingType"))==40){
									style.setFont(fonts.get(FONT_10_BOLD));
								}
							}
							if(listaFascicoliRowIndex==(htmlRows.size()-1)){
								style.setBorderBottom(CellStyle.BORDER_MEDIUM);
								style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
							}
							if(renderingType3668index==htmlRow.getElementsByAttributeValue("renderingType", "40").size()+htmlRow.getElementsByAttributeValue("renderingType", "72").size()+htmlRow.getElementsByAttributeValue("renderingType", "65").size()+htmlRow.getElementsByAttributeValue("renderingType", "33").size()){
								style.setBorderRight(CellStyle.BORDER_MEDIUM);
								style.setRightBorderColor(IndexedColors.BLUE.getIndex());
							}
						}
						if(workbook.getSheetAt(0).getLastRowNum() % 2 != 0){
							style.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
						}
						styleManager.setCellStyle(cell, style);
						cell.setCellValue(htmlCell.text());
					}
					cellIndex = 0;
					listaFascicoliRowIndex++;
				}
			}
		}
		return workbook;
	}

	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String pageLista() throws Exception
	{	setFascicolo(null);
		if(getErrorMessage()!=null)
			addActionError(getErrorMessage());
		return lista();
	}

	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String pageDettaglio() throws Exception
	{
		if(getErrorMessage()!=null)
			addActionError(getErrorMessage());

		return dettaglio();
	}

	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String pageCerca() throws Exception
	{
		if(getErrorMessage()!=null)
			addActionError(getErrorMessage());

		return execute();
	}



}