package service;

import java.util.List;
import dto.BoardDTO;

public interface BoardService {
	//글쓰기
	int insertBoard(BoardDTO board) throws Exception;
	//리스트
	List<BoardDTO> getBoardList() throws Exception;
   //리스트
	List<BoardDTO> getBoardList(String gubun, String search) throws Exception;
	//수정
	int updateBoard(BoardDTO board) throws Exception;
	//삭제
	int deleteBoard(int no) throws Exception;
	//내용보기
	BoardDTO getContent(int no) throws Exception;
	//해당글의 비번 확인
	boolean getBoardPass(int no, String password) throws Exception;

}
