package it.equitalia.gestorefascicolo.web.action;

import it.equitalia.gestorefascicolo.web.listener.ServletContextHolder;
import it.equitalia.gestorefascicolo.web.util.Log4jFactory;
import it.equitalia.gestorefascicolows.dati.Utenza;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.PrincipalProxy;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BaseAction extends ActionSupport implements Preparable {
	/**
	 *
	 */
	private static final long serialVersionUID = 85729800141517323L;
	public static final String SESSION_UTENZA = "utenza";
	private Map<String, Object> baseMap = new HashMap<String, Object>();
	private PropertiesConfiguration properties;
	private static final Logger logger = Log4jFactory.getLogger(BaseAction.class);
	private Utenza utenza = new Utenza();
	private Map<String, Object> sessionMap;
	private StringBuffer previous;
	private String otherParams;
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContextHolder sch;

	protected PrincipalProxy principal;

	private String token;

	//XXX:BreadCrumb name
	protected String deferredName;

	public void prepare() throws Exception {
		logger.info("INIZIO");

		this.request = ServletActionContext.getRequest();
		logger.info("request: "+this.request.getRequestURL());
		this.session = this.request.getSession();

		printRequest(ServletActionContext.getRequest());

		this.properties = (PropertiesConfiguration) ServletContextHolder.getServletContext().getAttribute("resourceProperties");

		utenza = (Utenza)session.getAttribute(SESSION_UTENZA)!=null?(Utenza)session.getAttribute(SESSION_UTENZA):new Utenza();

		if(request.getHeader(getOtherParamsName())!=null)
			utenza.setCRM(true);
		else
			utenza.setCRM(false);
		
		
		setOtherParams(request.getHeader(getOtherParamsName())!=null?request.getHeader(getOtherParamsName()):request.getParameter(getOtherParamsName()));
		//Controllo sull'Header il Codice Fiscale se non c'e' lo prendo da parameter, se non lo trovo neanche qui lo prendo da RemoteUser
		getUtenza().setCf_user(request.getHeader(getCfUserName())!=null?
				               request.getHeader(getCfUserName()):
			                  ((request.getParameter(getCfUserName())!=null&&!"".equals(request.getParameter(getCfUserName())))?
					                    request.getParameter(getCfUserName()):
						                request.getRemoteUser()));

		logger.info("RemoteUser: "+request.getRemoteUser());
		if(request.getRemoteUser()!=null){
			logger.info("UserPrincipal Name: "+request.getUserPrincipal().getName());
		}

		if(utenza==null){
			Enumeration<String> headerNames = request.getHeaderNames();
			logger.info("Header Parameters:");
			while(headerNames.hasMoreElements()){
				String name = headerNames.nextElement();
				logger.debug(name+"="+request.getHeader(name));
			}
			logger.info("cf-user: "+getUtenza().getCf_user());
			logger.info("other-params: "+getOtherParams());

		}

		initializeUtenza();

		getSession().setAttribute(SESSION_UTENZA, getUtenza());

		logger.info("UTENZA: "+utenza);
//		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
//	    Object myToken = context.get("token");
//	    if (myToken == null) {
//	        myToken = TokenHelper.setToken("token");
//	        context.put("token", myToken);
//	    }
//	    token = myToken.toString();
		logger.info("FINE");
	}
	public void setBaseMap(Map<String, Object> baseMap) {
		this.baseMap = baseMap;
	}
	public void setOtherParams(String otherParams) {
		this.otherParams = otherParams;
	}
	public void setPrevious(StringBuffer previous) {
		this.previous = previous;
	}
	public void setPrincipalProxy(PrincipalProxy principalProxy) {
		this.principal = principalProxy;

	}
	public void setProperties(PropertiesConfiguration properties) {
		this.properties = properties;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setUtenza(Utenza utenza) {
		this.utenza = utenza;
	}
	private void printRequest(HttpServletRequest request){
		Enumeration<?> params = request.getParameterNames();
		logger.info("Request Parameters:");
		while(params.hasMoreElements()){
		 String paramName = (String)params.nextElement();
		 logger.info("Attribute Name - "+paramName+", Value - "+request.getParameter(paramName));
		}
	}
	public String getDeferredName() {
		return deferredName;
	}

	public Map<String, Object> getBaseMap() {
		return baseMap;
	}

	public String getCartelleNonPresenti(){
		return this.properties.getString("cartelle.non.presenti");
	}

	public String getCfUserName(){
		return this.properties.getString("cf.user");
	}

	public String getDocumentiNoCRTNonPresenti(){
		return this.properties.getString("documentiNoCRT.non.presenti");
	}

	public Integer getEmailMax(){
		return this.properties.getInt("email.max");
	}

	public Integer getFascicoloChiuso(){
		return this.properties.getInt("fascicolo.chiuso");
	}

	public String getIdChiamanteName(){
		return this.properties.getString("id.chiamante");
	}

	public String getIdFascicoloName(){
		return this.properties.getString("id.fascicolo");
	}

	public Integer getIndirizziAlternatiMax(){
		return this.properties.getInt("indirizzi.alternativi.max");
	}

	public String getMsgEmailErrata(){
		return this.properties.getString("msg.email.errata");
	}

	public String getMsgFormatoDataErrato(){
		return this.properties.getString("msg.formato.data.errato");
	}

	public String getMsgNoFascicoli(){
		return this.properties.getString("msg.no.fascicoli");
	}

	public String getMsgRangeDateErrato(){
		return this.properties.getString("msg.range.date.errato");
	}

	public String getMsgTelefonoErrato(){
		return this.properties.getString("msg.telefono.errato");
	}

	public String getOtherParams() {
		return otherParams;
	}

	public String getOtherParamsName(){
		return this.properties.getString("other.params");
	}

	public StringBuffer getPrevious() {
		return previous;
	}

	public PropertiesConfiguration getProperties() {
		return properties;
	}

	public String getRavSeparator(){
		return this.properties.getString("rav.separator");
	}

	public String getRegexDateFormat(){
		return this.properties.getString("regex.date.format");
	}

	public String getRegexEmailFormat(){
		return this.properties.getString("regex.email.format");
	}
	public String getRegexTelephoneFormat(){
		return this.properties.getString("regex.telephone.format");
	}

	public String getMenuAdmin(){
		return this.properties.getString("menu.admin");
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	public HttpSession getSession() {
		return session;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public Integer getTelefoniMax(){
		return this.properties.getInt("telefoni.max");
	}
	public String getToken() {
		return token;
	}
	public Utenza getUtenza() {
		return utenza;
	}
	private void initializeUtenza() {
		if(getOtherParams()!=null&&getOtherParams().indexOf("xpar")!=-1){
			String[] doppietta = this.getOtherParams().split(",");
			if(doppietta.length==2){
				String[] par1 = doppietta[0].split("=");
				String[] par2 = doppietta[1].split("=");

				if(par1.length==2){
					logger.debug("Pair 1:" +par1[0]+" - "+par1[1]);
					getUtenza().setXpar_FSCidFascicolo(par1[0].equalsIgnoreCase(getIdFascicoloName())?par1[1]:par2[1]);
				}
				if(par2.length==2){
					logger.debug("Pair 2:" +par2[0]+" - "+par2[1]);
					getUtenza().setXpar_FSCidChiamante(par2[0].equalsIgnoreCase(getIdChiamanteName())?par2[1]:par1[1]);
				}
			}
		}else{
			setOtherParams("NONE");
			utenza.setUser(true);
		}
	}
	public ServletContextHolder getSch() {
		return sch;
	}
	public void setSch(ServletContextHolder sch) {
		this.sch = sch;
	}
}
