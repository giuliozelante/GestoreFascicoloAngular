package it.equitalia.gestorefascicolo.web.delegate;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import org.apache.axis.encoding.Base64;

public class UtilWSDelegate {

	 
	public static String getUser(HttpServletRequest request) throws UnsupportedEncodingException {
		String[] values = getBasicAuthorization(request);
		return values[0];
	}
	 
	public static String getPassword(HttpServletRequest request) throws UnsupportedEncodingException {
		String[] values = getBasicAuthorization(request);
		return values[1];
	}
	 
	private static String[] getBasicAuthorization(HttpServletRequest request) throws UnsupportedEncodingException {
		String[] values = new String[2];
		String authorization = request.getHeader("Authorization");
	    if (authorization != null && authorization.startsWith("Basic")) {
	        // Authorization: Basic base64credentials
	        String base64Credentials = authorization.substring("Basic".length()).trim();
	        String credentials = new String(Base64.decode(base64Credentials), "UTF-8");
	        // credentials = username:password
	        values = credentials.split(":",2);
//	        _call.setUsername(values[0]);
//	        _call.setPassword(values[1]);
	    } 
        return values;
	}

}
