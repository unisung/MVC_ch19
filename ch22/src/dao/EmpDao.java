package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Emp;
import dto.Emp2;

public class EmpDao {
	public static EmpDao instance;
	private EmpDao() {}
	public static EmpDao getInstance() {
		if(instance==null) instance=new EmpDao();
		return instance;
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	private Connection getConnection() {
		try {
			  Context init = new InitialContext();
			  DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OraDB");
			  conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}//getConntection() 메소드 끝.
	
	//사원리스트 출력
	public List<Emp> selectList(String job){
		List<Emp> list=new ArrayList<>();
		String sql="select * from emp where job=? order by eno";
		try {
			  conn = getConnection();
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, job);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				  int i=0;
				  Emp emp = new Emp();
				  emp.setEno(rs.getInt(++i));
				  emp.setEname(rs.getString(++i));
				  emp.setJob(rs.getString(++i));
				  emp.setManager(rs.getInt(++i));
				  emp.setHiredate(rs.getDate(++i));
				  emp.setSalary(rs.getInt(++i));
				  emp.setCommission(rs.getInt(++i));
				  emp.setDno(rs.getInt(++i));
				  
				  list.add(emp);
			  }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			pstmt.close();
			conn.close();
			}catch(Exception e) {}	
		}
		return list;
	}//메소드 끝.

	//Json데이타 출력
	public List<Emp2> selectJList(String job){
		List<Emp2> list = new ArrayList<>();
		String sql="select * from emp where job=? order by eno";
		try {
			  conn = getConnection();
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, job);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				  int i=0;
				  Emp2 emp = new Emp2();
				  emp.setEno(String.valueOf(rs.getInt(++i)));
				  emp.setEname(rs.getString(++i));
				  emp.setJob(rs.getString(++i));
				  emp.setManager(String.valueOf(rs.getInt(++i)));
				  emp.setHiredate(String.valueOf(rs.getDate(++i)));
				  emp.setSalary(String.valueOf(rs.getInt(++i)));
				  emp.setCommission(String.valueOf(rs.getInt(++i)));
				  emp.setDno(String.valueOf(rs.getInt(++i)));
				  
				  list.add(emp);
			  }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			pstmt.close();
			conn.close();
			}catch(Exception e) {}	
		}
		return list;
		
	}
	
	
	
	public List<String> jobList(){
		List<String> jobList= new ArrayList<>();
		
		String sql="select distinct job from emp";
		try {
			  conn = getConnection();
			  pstmt = conn.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				  int i=0;
				 String job = new String(rs.getString(1));
				  jobList.add(job);
			  }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			pstmt.close();
			conn.close();
			}catch(Exception e) {}	
		}
		return jobList;	
	}
	
	 public List<String> deptList(){
		 List<String> deptList = new ArrayList<>();
		 String sql="select no||'.'||dname no from dept order by no";
			try {
				  conn = getConnection();
				  pstmt = conn.prepareStatement(sql);
				  rs = pstmt.executeQuery();
				  while(rs.next()) {
					 String job = new String(rs.getString(1));
					 deptList.add(job);
				  }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
				rs.close();
				pstmt.close();
				conn.close();
				}catch(Exception e) {}	
			}
				 
		 return deptList;
	 }
	 
	 public List<Emp2> selectJDeptEmp(String dno){
		 List<Emp2> list = new ArrayList<>();
		 String sql=" select eno, ename, dname,loc " + 
		 		    "   from emp e, dept d "+ 
		 		    "  where e.dno = d.no " + 
		 		    "    and e.dno=?";
			try {
				  conn = getConnection();
				  pstmt = conn.prepareStatement(sql);
				  pstmt.setInt(1, Integer.parseInt(dno));
				  rs = pstmt.executeQuery();
				  while(rs.next()) {
					 Emp2 emp = new Emp2();
					 emp.setEno(rs.getInt(1)+"");
					 emp.setEname(rs.getString(2));
					 emp.setJob(rs.getString(3));
					 emp.setDno(rs.getString(4));
					 
					 list.add(emp);
				  }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
				rs.close();
				pstmt.close();
				conn.close();
				}catch(Exception e) {}	
			}
		 return list; 
		 
	 }
	 
	 
	 public List<Emp> selectDeptEmp(String dno){
		 List<Emp> list =new ArrayList<>();
		 
		 String sql=" select eno, ename, dname,loc " + 
		 		    "   from emp e, dept d "+ 
		 		    "  where e.dno = d.no " + 
		 		    "    and e.dno=?";
			try {
				  conn = getConnection();
				  pstmt = conn.prepareStatement(sql);
				  pstmt.setInt(1, Integer.parseInt(dno));
				  rs = pstmt.executeQuery();
				  while(rs.next()) {
					 Emp emp = new Emp();
					 emp.setEno(rs.getInt(1));
					 emp.setEname(rs.getString(2));
					 emp.setJob(rs.getString(3)+"."+rs.getString(4));
					 
					 list.add(emp);
				  }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
				rs.close();
				pstmt.close();
				conn.close();
				}catch(Exception e) {}	
			}
		 return list;
	 }
}
