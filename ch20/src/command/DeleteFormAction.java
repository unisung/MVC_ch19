package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, 
			      HttpServletResponse response) throws Throwable {
		
		return "writeForm.jsp";
	}
}
