package util;
import java.util.List;
import dto.BoardDTO;

public class ArticlePage {
	private int size;
	private int total;
	private int currentPage;
	private List<BoardDTO> board;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ArticlePage(int size, int total, int currentPage, List<BoardDTO> board) {
		this.size = size;
		this.total = total;
		this.currentPage = currentPage;
		this.board = board;
		if(total==0) {
			totalPages=0;
			startPage=0;
			endPage=0;
		}else {
			totalPages=total/size;
			if(total%size>0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage /5 * 5 + 1;
			if(modVal==0) startPage -=5;
			
			endPage = startPage + 4 ;
			if(endPage > totalPages) endPage = totalPages;
		}
	}

	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<BoardDTO> getBoard() {
		return board;
	}

	public void setBoard(List<BoardDTO> board) {
		this.board = board;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
	
	
	
	

}
