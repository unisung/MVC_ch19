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
import dto.Emp2;
import net.sf.json.JSONArray;


@WebServlet("/Json1")
public class Json1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		EmpDao dao = EmpDao.getInstance();
		try{
			List<Emp2> list = dao.selectJList(job);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//list로 부터 JSONArray로 전달
			JSONArray json = JSONArray.fromObject(list);
			out.println(json);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
