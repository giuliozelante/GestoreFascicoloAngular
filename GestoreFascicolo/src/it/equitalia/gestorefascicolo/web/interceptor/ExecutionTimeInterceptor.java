package it.equitalia.gestorefascicolo.web.interceptor;

import it.equitalia.gestorefascicolo.web.util.Log4jFactory;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ExecutionTimeInterceptor implements Interceptor{
	
	private static final Logger logger = Log4jFactory.getLogger(ExecutionTimeInterceptor.class);
	
	public void destroy() {
	   
	}


public void init() {
   
}
public String intercept(ActionInvocation invocation) throws Exception {

long startTime = System.currentTimeMillis();
   
String result = invocation.invoke();

long endTime = System.currentTimeMillis();
  
String className = invocation.getAction().getClass().getName();

logger.info("//////////// TEMPO DI ESECUZIONE DELLA CLASSE " + (className) + " : " + (endTime - startTime) + " ms ////////////");

return result;
}

}
