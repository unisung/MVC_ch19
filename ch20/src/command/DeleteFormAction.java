package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, 
			      HttpServletResponse response) throws Throwable {
		
	  String no = request.getParameter("no");
	  if(!(no==null || "".equals(no)))
	  //뷰에 보낼 객체를 request에 속성으로 저장
	   request.setAttribute("no", no);
		 
		return "deleteForm.jsp";
	}
}
