package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Upper extends HttpServletRequestWrapper {
	HttpServletRequest request;
	public Upper(HttpServletRequest request) {
		super(request);
	    this.request=request;
	}
	
	public String getParameter(String name) {
		String value = request.getParameter(name);
		String nVal = value.toUpperCase();
		return nVal;
	}
	public String[] getParameterValues(String name) {
		  String[] value = request.getParameterValues(name);
		  String[] nVal = new String[value.length];
		  for(int i=0;i<value.length;i++)
			  nVal[i] = value[i].toUpperCase();
		  
		  return nVal;
	}
}
