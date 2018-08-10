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

@WebServlet("/MemberInfoXml2")
public class MemberInfoXml2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			 String paramJob = request.getParameter("job");
			 EmpDao dao = EmpDao.getInstance();
			 List<Emp> list = dao.selectList(paramJob);
			 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out = response.getWriter();
			 //root생성
			 Element root = new Element("empData");//<empData></empData>
			 
			 for(Emp e:list) {
				Element emp = new Element("emp");//<emp></emp>
				
				Element empno = new Element("empno");//<emono><empno>
				empno.setText(String.valueOf(e.getEno()));//<emono>7369<empno>
				emp.addContent(empno);//<emp><empno>7369</empno></emp>
				
				Element ename = new Element("ename");//<ename></ename>
				ename.setText(e.getEname());//<ename>scott</ename>
				emp.addContent(ename);//<emp><empno>7369</emepno><ename>scott</ename></emp>
				
				Element job = new Element("job");//<job></job>
				job.setText(e.getJob());//<job>Manager</job>
				emp.addContent(job);//<emp><empno>7369</emepno><ename>scott</ename><job>Manager</job></emp>
				
				Element mgr = new Element("mgr");//<mgr></mgr>
				mgr.setText(String.valueOf(e.getManager()));//<mgr>7788</mgr>
				emp.addContent(mgr);//<emp><empno>7369</emepno><ename>scott</ename><job>Manager</job><mgr>7788</mgr></emp>
				
				Element hiredate = new Element("hiredate");//<hiredate></hiredate>
				hiredate.setText(String.valueOf(e.getHiredate()));//<hiredate>78-12-31</hiredate>
				emp.addContent(hiredate);//<emp><empno>7369</emepno><ename>scott</ename><job>Manager</job><mgr>7788</mgr><hiredate>78-12-31</hiredate></emp>
				 
				Element sal = new Element("sal");//<sal></sal>
				sal.setText(String.valueOf(e.getSalary()));//<sal>1500</sal>
				emp.addContent(sal);////<emp><empno>7369</emepno><ename>scott</ename><job>Manager</job><mgr>7788</mgr><hiredate>78-12-31</hiredate><sal>1500</sal></emp>
				 
				Element comm = new Element("comm");//<comm></comm>
				comm.setText(String.valueOf(e.getCommission()));//<comm></comm>
				emp.addContent(comm);////<emp><empno>7369</emepno><ename>scott</ename><job>Manager</job><mgr>7788</mgr><hiredate>78-12-31</hiredate><sal>1500</sal><comm></comm></emp>
				
				Element deptno = new Element("deptno");//<deptno></deptno>
				deptno.setText(String.valueOf(e.getDno()));//<deptno>30</deptno>
				emp.addContent(deptno);//<emp><empno>7369</emepno><ename>scott</ename><job>Manager</job><mgr>7788</mgr><hiredate>78-12-31</hiredate><sal>1500</sal><comm></comm><deptno>30</deptno></emp>
				 
				root.addContent(emp);//<empData><emp><empno>7369</emepno><ename>scott</ename><job>Manager</job><mgr>7788</mgr><hiredate>78-12-31</hiredate><sal>1500</sal><comm></comm><deptno>30</deptno></emp></empData>
				 
			 }
			 //출력
			 //document객체 생성(xml객체로)
			  Document d = new Document(root);
			  //xml출력객체
			  XMLOutputter xml = new XMLOutputter();
			  //fomatting
			  Format f= Format.getPrettyFormat();
			  //문자셋 설정
			  f.setEncoding("utf-8");
			  //format처리
			  xml.setFormat(f);
			  //출력
			  xml.output(d, out);
			  //자원해제
			  out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}


	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
