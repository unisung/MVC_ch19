package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProcess implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request,
			          HttpServletResponse response) throws Throwable {
		System.out.println("requetPro시작");
		String msg = "요청 파라미터로 명령어를 전달하세요.";
		//전달할 객체를 request에 저장
		 request.setAttribute("message", msg);
		 System.out.println("객체 저장");
		//이동할 경로를 리턴
		return "process.jsp";
	}
}
