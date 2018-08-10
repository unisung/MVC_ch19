package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ParamUpperCaseRequestWrapper extends HttpServletRequestWrapper {
	HttpServletRequest request;
	public ParamUpperCaseRequestWrapper(HttpServletRequest request) {
		super(request);
	    this.request=request;
	}
	//일반 request
	public String getParameter(String name) {
		String value = request.getParameter(name);
		String nVal = value.toUpperCase();
		return nVal;
	}
	//배열 형태 request
	public String[] getParameterValues(String name) {
		  String[] value = request.getParameterValues(name);
		  String[] nVal = new String[value.length];
		  for(int i=0;i<value.length;i++)
			  nVal[i] = value[i].toUpperCase();
		  
		  return nVal;
	}
	//map형태의 request
	public Map getParameterMap() {
		Map map = request.getParameterMap();
		HashMap<String,String[]> newMap = new HashMap<>();
		Object name[] = map.keySet().toArray();
		for(int cnt=0;cnt<name.length;cnt++) {
			String value[] = (String[])map.get(name[cnt]);
			for(int index=0;index<value.length;index++)
				value[index]=value[index].toUpperCase();
			newMap.put((String)name[cnt], value);
		}
		return newMap;
	}
	
}
