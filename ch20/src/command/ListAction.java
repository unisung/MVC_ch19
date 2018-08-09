package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDTO;
import service.ListArticleServie;
import util.ArticlePage;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, 
			     HttpServletResponse response) throws Throwable {
		System.out.println("여기로...");

		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null?"1":pageNum;
		
		 ListArticleServie list = new ListArticleServie();
		 ArticlePage page = list.getArticlePage(Integer.parseInt(pageNum));
		
		 System.out.println("현재페이지:"+page.getCurrentPage());
		 System.out.println("페이지 사이즈:"+page.getSize());
		 System.out.println("시작페이지:"+page.getStartPage());
		 System.out.println("종료페이지:"+page.getEndPage());
		 System.out.println("전체 건수:"+page.getTotal());
		 System.out.println("전체 페이지:"+page.getTotalPages());
		 for(int i=0;i<page.getBoard().size();i++) {
			 System.out.println(page.getBoard().get(i).getContent());
			 System.out.println(page.getBoard().get(i).getName());
			 System.out.println(page.getBoard().get(i).getContent());
		 }
		 
		 request.setAttribute("list", page);
		
	/*	 
       //검색 추가
		 String gubun = request.getParameter("searchOption");
		 String cont = request.getParameter("searchCont");
		 
		 //null값 처리
		 gubun = gubun==null?"":gubun;
		 cont = cont==null?"":cont;
		 
		 BoardDao dao = BoardDao.getInstance();
         List<BoardDTO> list = dao.getBoardList(gubun, cont);
         
         System.out.println("listSize="+list.size());
         request.setAttribute("list", list);*/
         
		return "list.jsp";
	}

}
