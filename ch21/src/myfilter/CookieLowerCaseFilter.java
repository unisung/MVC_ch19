package myfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import util.CookieLowerCaseResponseWrapper;

@WebFilter("/sub4/*")
public class CookieLowerCaseFilter implements Filter {

    public CookieLowerCaseFilter() {  }

	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here 
		System.out.println("CookieLowerCaseFilter실행");
		  CookieLowerCaseResponseWrapper wrapper
		  = new CookieLowerCaseResponseWrapper((HttpServletResponse)response);
    
		// pass the request along the filter chain
		chain.doFilter(request, wrapper);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
