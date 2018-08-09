package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;

public class DeleteProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		  String no=request.getParameter("no");

		  BoardDao dao = BoardDao.getInstance();
		  int result = dao.deleteBoard(Integer.parseInt(no));
		  
		  String view="";
		  String msg = "";
		  
		  if(result>0) {
			 msg = "삭제 성공";
			 view = "List.do";
		  }else {
			  msg ="삭제 실패";
			  view ="deleteForm.do?no="+no;
		  }
		  
		  request.setAttribute("msg", msg);
		/*return "list.jsp";*/
		  return view;
	}

}
