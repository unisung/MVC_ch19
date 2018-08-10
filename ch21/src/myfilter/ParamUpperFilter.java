package myfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import util.ParamUpperCaseRequestWrapper;

@WebFilter("/sub4/*")
public class ParamUpperFilter implements Filter {

    public ParamUpperFilter() {  }

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("ParamUpperFilter 시작.");
		ParamUpperCaseRequestWrapper param 
		 = new ParamUpperCaseRequestWrapper((HttpServletRequest)request);
		// pass the request along the filter chain
		chain.doFilter(param, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
