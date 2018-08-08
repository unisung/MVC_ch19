package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;

public class DeleteProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		  String name=request.getParameter("name");
		  String title=request.getParameter("title");
		  String content=request.getParameter("content");
		  String password = request.getParameter("password");
		  
		  BoardDTO board = new BoardDTO();
		  
		  board.setName(name);
		  board.setTitle(title);
		  board.setContent(content);
		  board.setPassword(password);
		
		  BoardDao dao = BoardDao.getInstance();
		  int result = dao.insertBoard(board);
		  
		  String view="";
		  String msg = "";
		  
		  if(result>0) {
			 msg = "등록 성공";
			 view = "List.do";
		  }else {
			  msg ="등록 실패";
			  view ="writeForm.jsp";
		  }
		  
		  request.setAttribute("msg", msg);
		/*return "list.jsp";*/
		  return view;
	}

}
