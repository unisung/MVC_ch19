package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ReplaceWrapper extends HttpServletResponseWrapper{
	//필드
	HttpServletResponse response;
	StringWriter stringWriter;//버퍼에 저장
	PrintWriter printWriter;
	//생성자
	public ReplaceWrapper(HttpServletResponse response) {
		super(response);
		this.response=response;
	}
	 
	public PrintWriter getWriter() throws IOException{
		if(stringWriter==null) {
			stringWriter=new StringWriter();
			printWriter=new PrintWriter(stringWriter);
		}
		return printWriter;
	}//getWriter()메소드 끝.

	public void modifyAndPrint() throws IOException{
		//StringWriter의 버퍼내용을 
		//리턴하는 메소드 toString()
		String str1 = stringWriter.toString();
		String str2 = stringWriter.toString();
		System.out.println("str1="+str1.substring(0,str1.indexOf('임')));
		System.out.println("str2="+str2.substring(str1.indexOf('임')));
	
		str1=str1.substring(0,str1.indexOf('임')).replaceAll("홍길동","임꺽정");
		str2=str2.substring(str1.indexOf('임')).replaceAll("임꺽정", "홍길동");
		
		/*String nStr = str.replaceAll("강아지", "멍멍이");*/
		String nStr = str1+str2;
		
		PrintWriter out = response.getWriter();
		out.println(nStr);
		out.flush();
		out.close();
	}
}
