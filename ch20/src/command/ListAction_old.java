package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;

public class ListAction_old implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, 
			     HttpServletResponse response) throws Throwable {
		
		 //검색 추가
		 String gubun = request.getParameter("searchOption");
		 String cont = request.getParameter("searchCont");
		 
		 BoardDao dao = BoardDao.getInstance();
         List<BoardDTO> list = dao.getBoardList(gubun, cont);

         request.setAttribute("list", list);
         
		return "list.jsp";
	}

}
