package service;

import java.util.List;

import dao.BoardDao;
import dto.BoardDTO;
import util.ArticlePage;

public class ListArticleServie {
  private BoardDao dao = BoardDao.getInstance();
  private int size=3;
  int total=0;
  List<BoardDTO> list=null;
  public ArticlePage getArticlePage(int pageNum) {
	  try {
		    total = dao.selectCount();
		    list = dao.select((pageNum-1)*size+1,size); //시작글번호, 사이즈=>끝글번호:시작글번호 + size  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return new ArticlePage(size,total,pageNum,list);
  }
}