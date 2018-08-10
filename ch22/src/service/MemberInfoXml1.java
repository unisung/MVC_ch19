package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dto.Emp;

@WebServlet("/MemberInfoXml1")
public class MemberInfoXml1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				String job = request.getParameter("job");
				EmpDao dao = EmpDao.getInstance();
				List<Emp> list = dao.selectList(job);
				
				PrintWriter out = response.getWriter();
				String str="";
				for(Emp e:list) {
					str = e.getEno()+" "+e.getEname()+" "+
				          e.getJob()+" "+e.getManager()+" "+
						  e.getHiredate()+" "+
						  e.getSalary()+" "+e.getCommission()+" "+
				          e.getDno();
					out.println(str);
				}
				out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
