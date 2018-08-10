package myfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*@WebFilter("/*")*/
public class SimpleFilter implements Filter {
   //생성ㅈ
    public SimpleFilter() {}
    //제거직전 실행되는 메소드
	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			           throws IOException, ServletException {
        System.out.println("필터가 시작되었습니다");
		chain.doFilter(request, response);
		System.out.println("웹 컴포넌트가 완료 되었습니다.");
	}

    //초기화 메소드
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
