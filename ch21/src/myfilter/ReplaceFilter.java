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

import util.ReplaceWrapper;


@WebFilter("/sub4/*")
public class ReplaceFilter implements Filter {

    public ReplaceFilter() { }

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("ReplaceFilter 실행");
        ReplaceWrapper replaceWrapper
           = new ReplaceWrapper((HttpServletResponse)response);
		// pass the request along the filter chain
		chain.doFilter(request, replaceWrapper);
		replaceWrapper.modifyAndPrint();
		System.out.println("ReplaceFilter 종료");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
