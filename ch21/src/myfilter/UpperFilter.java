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

import util.Upper;


@WebFilter("/sub3/*")
public class UpperFilter implements Filter {

    public UpperFilter() { }


	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
         Upper up = new Upper((HttpServletRequest)request);
		// pass the request along the filter chain
		chain.doFilter(up, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
