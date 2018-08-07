package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/ControllerURI")*/
public class ControllerURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//command에 해당하는 instance를 저장하기 위한 맵
	private Map<String, Object> commandMap = new HashMap<>();
	@Override
	public void init(ServletConfig config) throws ServletException {
		//web.xml의 초기화 파일정보을 읽어서 Properties객체에 저장
		String props = config.getInitParameter("propertyConfig");
		Properties pr = new Properties();
		FileInputStream f=null;
		try {
			  String configFilePath = 
					        config.getServletContext().getRealPath(props);
			  f=new FileInputStream(configFilePath);
			  pr.load(f);//저장{키=값}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(f!=null)try {f.close();}catch(Exception e) {e.printStackTrace();}
		}
		//properties객체 저장 완료
		Iterator<Object> keyiterator = pr.keySet().iterator();
		while(keyiterator.hasNext()) {
			String command=(String)keyiterator.next();
			String className=pr.getProperty(command);
		try {
			  Class commandClass = Class.forName(className);//클래정보
			  Object commandInstance = commandClass.newInstance();//instance
			  commandMap.put(command, commandInstance);
		}catch(Exception e) {System.out.println(e.getMessage());}
		}
	}

	protected void doGet(HttpServletRequest request,
			 HttpServletResponse response) throws ServletException, IOException {
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
