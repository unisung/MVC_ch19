package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;

public class UpdateProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, 
			                 HttpServletResponse response) throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		  int no = Integer.parseInt(request.getParameter("no"));
		  String name=request.getParameter("name");
		  String title=request.getParameter("title");
		  String content=request.getParameter("content");
		  String password = request.getParameter("password");
		  
		  System.out.println("no="+no);
		  System.out.println("name="+name);
		  System.out.println("title="+title);
		  System.out.println("content="+content);
		  
		  //해당글의 비번 확인
		  boolean isTrue = false;
		  BoardDao dao = BoardDao.getInstance();
		   isTrue = dao.getBoardPass(no, password);
			  
			  String view="";
			  String msg = "";
			  
		   if(!isTrue) {
			   msg ="등록 실패";
			   view ="updateForm.do";
		   }else {
		   
			BoardDTO board = new BoardDTO();
		  
	      board.setNo(no);
		  board.setName(name);
		  board.setTitle(title);
		  board.setContent(content);
		  board.setPassword(password);
		
		   dao = BoardDao.getInstance();
		   int result = dao.updateBoard(board);

		  if(result>0) {
			 msg = "등록 성공";
			 view = "List.do";
		  }else {
			  msg ="등록 실패";
			  view ="updateForm.do";
		  }

		}//else 끝.
			  request.setAttribute("msg", msg);
			  return view;
	}//메소드 끝.
}
