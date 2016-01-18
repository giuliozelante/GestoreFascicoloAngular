package it.equitalia.gestorefascicolo.web.action;

import it.equitalia.gestorefascicolo.web.util.Log4jFactory;
import it.equitalia.gestorefascicolows.dati.Utenza;

import org.apache.log4j.Logger;
import org.softwareforge.struts2.breadcrumb.BreadCrumb;
import org.softwareforge.struts2.breadcrumb.BreadCrumbInterceptor;
import org.softwareforge.struts2.breadcrumb.BreadCrumbTrail;
import org.softwareforge.struts2.breadcrumb.NameComparator;
import org.softwareforge.struts2.breadcrumb.RewindMode;


public class StartUpAction extends BaseAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 7940862895603951791L;
	private static final Logger logger = Log4jFactory.getLogger(StartUpAction.class);

	@Override
	public String execute(){
		logger.info("INIZIO");
		super.setUtenza((Utenza)super.getSession().getAttribute(SESSION_UTENZA));
		if((getOtherParams()!=null&&!getOtherParams().equals("NONE"))
				&&(super.getUtenza()!=null&&super.getUtenza().getXpar_FSCidChiamante()!=null&&!super.getUtenza().getXpar_FSCidChiamante().equals(""))){
			return "dettaglioFascicolo";
		}
		
	
		
		
		return "home";
	}

	public String dettaglioFascicolo(){
		logger.info("FINE");
		return "dettaglioFascicoloCrm";
	}

	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String home(){
		BreadCrumbTrail trail = (BreadCrumbTrail) getSession().getAttribute(BreadCrumbInterceptor.CRUMB_KEY);

		// rewinding at position -1 has the effect of clearing the entire trail
		if(trail!=null){trail.rewindAt(-1);}
		deferredName = getProperties().getString("crumb.homepage");
		getRequest().setAttribute("showHome", "visible");
		
		getSession().setAttribute("navigazione", "home");
		
		
		logger.info("FINE");
		return SUCCESS;
	}
}
