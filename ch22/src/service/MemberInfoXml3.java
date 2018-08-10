package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import dao.EmpDao;
import dto.Emp;

@WebServlet("/MemberInfoXml3")
public class MemberInfoXml3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String dno = request.getParameter("no");
	EmpDao dao = EmpDao.getInstance();
	List<Emp> list = dao.selectDeptEmp(dno);
	
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	
	//root객체 생성--xml 파일은 root요소가 반드시 있어야함.
	Element root = new Element("deptEmp");//<deptEmp></deptEmp>
	
	for(Emp e:list) {
		Element emp = new Element("emp");//<emp></emp>
		
		Element no= new Element("no");//<no></no>
		no.setText(String.valueOf(e.getEno()));//<no>7369</no>
		emp.addContent(no);//<emp><no>7369</no></emp>

		Element name= new Element("name");//<name></name>
		name.setText(String.valueOf(e.getEno()));//<name>scott</name>
		emp.addContent(name);//<emp><no>7369</no><name>scott</name></emp>
		
		Element dname= new Element("dname");//<dname></dname>
		String deptname = String.valueOf(e.getJob().substring(0,e.getJob().indexOf(".")));
		dname.setText(deptname);//<no>7369</no>
		System.out.println(String.valueOf(e.getJob().substring(0,e.getJob().indexOf("."))));
		emp.addContent(dname);//<emp><no>7369</no></emp>
		
		Element loc= new Element("loc");//<no></no>
		loc.setText(e.getJob().substring(e.getJob().indexOf(".")+1));//<no>7369</no>
		System.out.println(e.getJob().substring(e.getJob().indexOf(".")+1));
		emp.addContent(loc);//<emp><no>7369</no></emp>
		
		root.addContent(emp);
		
	}
	   //출력
	   Document document = new Document(root);
	   XMLOutputter xml = new XMLOutputter();
	   Format f = Format.getPrettyFormat();
	   f.setEncoding("utf-8");
	   xml.setFormat(f);
	   xml.output(document, out);
	   out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
