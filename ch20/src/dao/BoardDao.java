package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import service.BoardService;

public class BoardDao extends DaoManager implements BoardService {
	public static BoardDao instance;
	private BoardDao() {}

	public static BoardDao getInstance() {
		if(instance==null) instance=new BoardDao();
		return instance;
	}


	@Override
	public int insertBoard(BoardDTO board) throws SQLException{
		int result = 0;
		String sql = "insert into board values(board_seq.nextval,?,?,?,?)";
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, board.getName());
		pstmt.setString(2, board.getTitle());
		pstmt.setString(3, board.getContent());
		pstmt.setString(4, board.getPassword());
		
        result = pstmt.executeUpdate();		
		
        close(pstmt, conn);
        return result;
	}

	@Override
	public List<BoardDTO> getBoardList() throws Exception{
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board order by no";
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BoardDTO board = new BoardDTO();
			board.setNo(rs.getInt(1));
			board.setName(rs.getString(2));
			board.setTitle(rs.getString(3));
			board.setContent(rs.getString(4));
			board.setPassword(rs.getString(5));
			
			list.add(board);
		}
		 close(pstmt,rs,conn);
		return list;
	}//getBoardList() 메소드 끝.

	@Override
	public List<BoardDTO> getBoardList(String gubun, String search) throws Exception {
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board where ";
		
		search = "%"+search+"%";
		
		System.out.println("search="+search);
		
		if(gubun.equals("title"))
			 sql += " title like ? ";
		else if(gubun.equals("content"))
			 sql+= "content like ? ";
		
		System.out.println(sql);
		conn= getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, search);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			BoardDTO board = new BoardDTO();
			board.setNo(rs.getInt(1));
			board.setName(rs.getString(2));
			board.setTitle(rs.getString(3));
			board.setContent(rs.getString(4));
			
			list.add(board);
		}
		close(pstmt, rs, conn); 
		return list;
	}

	@Override
	public int updateBoard(BoardDTO board) throws Exception {
        int result = 0;
        String sql = "update board set name=?, "
        		   + " title=?,content=? where no=?";
        conn = getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, board.getName());
        pstmt.setString(2, board.getTitle());
        pstmt.setString(3, board.getContent());
        pstmt.setInt(4, board.getNo());
        result = pstmt.executeUpdate();
        close(pstmt, conn);
		return result;
	}//updateBoard()메소드 끝.

	@Override
	public int deleteBoard(int no) throws Exception {
		int count=0;
		String sql = "delete from board where no=?";
		conn=getConnection();
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		count = pstmt.executeUpdate();
		if(count>0)
			conn.commit();
		else
			conn.rollback();
		conn.setAutoCommit(true);
		close(pstmt, conn);
		return count;
	}//deleteBoard()메소드 끝.

	@Override
	public BoardDTO getContent(int no) throws Exception {
		BoardDTO board = new BoardDTO();
        String sql = "select * from board where no=?";
        
        conn = getConnection();
        pstmt =conn.prepareStatement(sql);
        pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
		if(rs.next()) 		
		{
			board.setNo(no);
			board.setName(rs.getString(2));
			board.setTitle(rs.getString(3));
			board.setContent(rs.getString(4));
			board.setPassword(rs.getString(5));
		}
		close(pstmt, rs, conn);
		return board;
	}//getContent(int no) 메소드 끝.

	//해당글의 비번 확인
	@Override
	public boolean getBoardPass(int no, String password)throws Exception{
		  boolean isTrue=false;
		  String sql = "select password from board where no=?";
		  conn = getConnection();
		  pstmt = conn.prepareStatement(sql);
		  pstmt.setInt(1, no);
		  rs = pstmt.executeQuery();
		  if(rs.next()) {
			  if(password.equals(rs.getString(1)))
				  isTrue=true;  
		  }
		 close(pstmt, rs, conn); 
		return isTrue;
	}//getBoardPass() 메소드 끝.

	
}
