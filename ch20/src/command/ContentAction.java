package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;

public class ContentAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String sno=request.getParameter("no");
		int no=-1;
		if(!(sno==null||"".equals(sno)))
			 no = Integer.parseInt(sno);
		
		 BoardDao dao = BoardDao.getInstance();
		 BoardDTO dto = dao.getContent(no);
		
		 request.setAttribute("board", dto);
		 
		return "content.jsp";
	}

}
