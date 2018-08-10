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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//urlPatterns={}
@WebFilter(urlPatterns= {"/sub1/*", "/sub2/*"})
public class SimpleFilter2 implements Filter {

    public SimpleFilter2() {  }


	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// place your code here
          System.out.println("SimpleFileter2 필터가 시작 되었습니다");
		
         HttpServletRequest  httpRequest = (HttpServletRequest)request;
         HttpServletResponse httpResponse= (HttpServletResponse)response;
         
         HttpSession session = httpRequest.getSession();
         if(session==null) {
        	 httpResponse.sendRedirect("../LoginForm.html");
         }
         String id=(String)session.getAttribute("id");
         if(id==null)
        	 httpResponse.sendRedirect("../LoginForm.html"); 
          
		chain.doFilter(request, response);
		
		 System.out.println("SimpleFileter2 필터가 종료되었습니다.");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("SimpleFilter2초기화 메소드");

	}

}
