package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;

public class UpdateFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, 
			      HttpServletResponse response) throws Throwable {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = BoardDao.getInstance();
		BoardDTO board = dao.getContent(no);
		request.setAttribute("board", board);
		
		return "updateForm.jsp";
	}
}
