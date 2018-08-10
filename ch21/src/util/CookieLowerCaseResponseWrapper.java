package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CookieLowerCaseResponseWrapper extends HttpServletResponseWrapper {
	//필드
	HttpServletResponse response;
	
	public CookieLowerCaseResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response=response;
	}
   //사용할 응답객체와 signature가 동일한 메소드 생성
	public void addCookie(Cookie cookie) {
		String value = cookie.getValue();
		String newValue = value.toLowerCase();
		cookie.setValue(newValue);
		response.addCookie(cookie);
	}
}
