package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
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
	private Map<String, CommandProcess> commandMap = new HashMap<>();
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()메소드 실행시작");
		//1. 프로퍼티파일의  내용 저장
		//web.xml의 초기화 파일정보을 읽어서 Properties객체에 저장
		String props = config.getInitParameter("propertyConfig");
		//프로퍼티 파일을 저장할 properties객체 생성
		Properties pr = new Properties();
		//프로퍼티 파일로 부터 값을 읽어 들일 inputStream객체 생성
		FileInputStream f=null;
		try {
			  //프로퍼티 파일의 절대 경로 읽어서 configFilePath에 저장
			  String configFilePath = 
					        config.getServletContext().getRealPath(props);
			  //프로퍼티 파일의 절대 경로로 입력스트림생성
			  f=new FileInputStream(configFilePath);
			  //입력스트림으로 부터 프로퍼티에 저장(load(f))
			  pr.load(f);//저장{키=값}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(f!=null)try {f.close();}catch(Exception e) {e.printStackTrace();}
		}
		//properties객체 저장 완료 - (프로퍼티는 map계열의 자료구조)
		
		//2. commandMap에 명령어와 인스턴스객체 저장
		//프로퍼티로 부터 키를 뽑아서 iterator에 저장
		Iterator<Object> keyiterator = pr.keySet().iterator();
		//반복하면서 작업(commandMap에 저장-Map객체)
		while(keyiterator.hasNext()) {
			String command=(String)keyiterator.next();
			String className=pr.getProperty(command);
		try {
			  //문자열로 입력된 클래스명 정보을 얻음. Class.forName(문자열);
			  Class commandClass = Class.forName(className);//클래정보
			  //클래스명.newInstanc() 클래스를 instance화(메모리에 생성
			  // 클래스 변수 = new 클래스(); 와 같은 역할 ) 
			  CommandProcess commandInstance = (CommandProcess)commandClass.newInstance();//instance
			  //Map에 커멘드(명령어)와 해당 클래스객체로 저장
			  commandMap.put(command.substring(command.indexOf('/')+1),commandInstance);
		}catch(Exception e) {System.out.println(e.getMessage());}
		}//while문 끝.
		/*  map에 커멘드와 instance객체 저장 완료 */
		System.out.println("init()메소드 실행 끝.");
	}

	protected void doGet(HttpServletRequest request,
			 HttpServletResponse response) throws ServletException, IOException {
		    requestPro(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//request로 넘어온 요청을 requestPro에서처리, 응답도 여기서 처리
	private void requestPro(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
		String view = null;
		//interface객체 생성(이 인터페이스로 구현된 모든 클래스는 대입가능)
		CommandProcess com=null;
		try {
			  //1.입력된 커멘드분석 command구하기
			  String command = request.getRequestURI();
			  System.out.println("command="+command);
			  System.out.println("request.getContextPath()="+request.getContextPath());
			  //2.uri경로에서 커멘드의 위치및 값 구하기 
			  //indexOf()메소드에서 해당값이 없으면 -1을 리턴
			  if(command.indexOf(request.getContextPath())==0) {
				  command=command.substring(request.getContextPath().length()+1);
				  System.out.println("command="+command);
			  }
			  //3.command에 해당하는 instance를 map에서 구함.
			  //map에서 해당 instance객체 구함. -> 부모객체에 대입
			  com = (CommandProcess)commandMap.get(command);//instance객체
			  System.out.println(com==null?"해당객체 없음":"해당객체 있음");
			  //부모객체의 메소드가 실행 ->
			  //재정의된 메소드는 부모객체로 프로모션되더라도 자식객체의 내용이 실행
			  //메소드의 다형성을 이용한 실행
			  //4. 메소드 실행
			  view = com.requestPro(request,response);//이동할 뷰
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		//이동할 경로 설정
		 RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		 //이동
		 dispatcher.forward(request, response);
	}
}
