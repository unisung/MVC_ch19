package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, 
			     HttpServletResponse response) throws Throwable {
		
		 BoardDao dao = BoardDao.getInstance();
         List<BoardDTO> list = dao.getBoardList();
         
         request.setAttribute("list", list);
         
		return "list.jsp";
	}

}
