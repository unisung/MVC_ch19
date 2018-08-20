/**
 * XMLHttpRequest 객체 생성 메소드
 */
 /* IE인 경우 */
 function getXMLHttpRequest(){
	 var xmlhttp;
	 if(window.ActiveXObject){//IE의 XMLHttp객체
		try{
		     xmlhttp= new ActiveXObject("Msxml2.XMLHTTP");//IE6이후
		}catch(e){
			try{
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");//IE5이전
			}catch(e1){
				xmlhttp=null;
			}
		}    
 }else if(window.XMLHttpRequest){//IE 이외의 브라저내의 XMLHttpRequest객체
  try{
	  xmlhttp = new XMLHttpRequest();
  }catch(e){
	  xmlhttp=null;
  }
 }else{
	 xmlhttp=null;
 }

	if(xmlhttp==null) errorMessage();
	 return xmlhttp;
 }//getXMLHttpRequest() 메소드 끝.
 
function errorMessage(){
	 alert('지원할수 없는 브라우저 입니다.');
 } 

//사용자 정의 함수
function sendRequest(url,params,callback,method){
	alert(url+':'+params+':'+method);
	//xmlHttpRequest객체 얻기
	httpRequest = getXMLHttpRequest();
	var httpMethod = method?method:'get';//매개변수로 넘어온 method가 null이아니면(true)전송방식,
	if(httpMethod!='get' && httpMethod!='post'){   //전송방식이 없으면 default인 'get'으로 설정
		httpMethod='get';
	}
	//요청할 파라미터 처리
	var httpParams =(params==null||params=='')?null:params;
	//요청 보낼 경로
	var httpUrl =url;
	//'get'방식인 경우 경로 파라미터 설정
	if(httpMethod=='get' && httpParams!=null){
		httpUrl = httpUrl + "?"+httpParams;//hello.jsp?name="홍길동"
	}
	//XMLHttpRequest객체 호출
	httpRequest.open(httpMethod,httpUrl,true);//open(전송방식,경로,비동기)
	httpRequest.setRequestHeader(
			'Content-Type','application/x-www-form-urlencoded'
	);
	httpRequest.onreadystatechange=callback;//상태값바뀌태 callback()함수 호출
	//요청보내기(전송방식이 'post'이면 파라미터 전송, 'get'이면 null값 전송)
	httpRequest.send(httpMethod=='post'?httpParams:null);
}

function log(msg){
	var con = document.getElementById('console');
	if(msg!=null){
		con.innerHTML+=msg+"<br>";
	}
}
