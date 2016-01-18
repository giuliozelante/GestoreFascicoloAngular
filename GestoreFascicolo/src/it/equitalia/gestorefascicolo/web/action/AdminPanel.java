package it.equitalia.gestorefascicolo.web.action;

import org.softwareforge.struts2.breadcrumb.ActionComparator;
import org.softwareforge.struts2.breadcrumb.BreadCrumb;
import org.softwareforge.struts2.breadcrumb.BreadCrumbInterceptor;
import org.softwareforge.struts2.breadcrumb.BreadCrumbTrail;
import org.softwareforge.struts2.breadcrumb.RewindMode;

public class AdminPanel extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3482486022462667012L;

	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=ActionComparator.class)
	public String execute(){
		
		
		if(getRequest().getSession().getAttribute("navigazione")==null)
			return "pageHome";
		
		
		BreadCrumbTrail trail = (BreadCrumbTrail) getSession().getAttribute(BreadCrumbInterceptor.CRUMB_KEY);

		// rewinding at position -1 has the effect of clearing the entire trail
		if(trail!=null){trail.rewindAt(0);}
		
		deferredName=getProperties().getString("crumb.aprichiudiFascicolo");
		return SUCCESS;
	}
//	@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String apertura(){
	 	getRequest().setAttribute("AdminPanel_apertura", true);
		return SUCCESS;
	}

	//@BreadCrumb(value="%{deferredName}", afterAction=true, rewind=RewindMode.AUTO, comparator=NameComparator.class)
	public String chiusura(){
	 	getRequest().setAttribute("AdminPanel_chiusura", true);
		return SUCCESS;
	}
}
