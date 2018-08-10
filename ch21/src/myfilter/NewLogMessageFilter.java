package myfilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
/*
@WebFilter("/*")*/
public class NewLogMessageFilter implements Filter {

    public NewLogMessageFilter() {  }

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// place your code here
		 GregorianCalendar now = new GregorianCalendar();
		 response.setContentType("text/html;charset=utf-8");
		 HttpServletResponse httpResponse = (HttpServletResponse)response;
		 PrintWriter out = httpResponse.getWriter();
		 out.printf("현재일시:%TF%TT%n",now,now);
		 String clientAddress = request.getRemoteAddr();
		 out.printf("클라이언트주소:%s %n", clientAddress);

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		String contentType=response.getContentType();
		System.out.printf("문서의 타입: %s %n", contentType);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
