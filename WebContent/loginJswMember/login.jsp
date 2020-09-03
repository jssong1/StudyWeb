<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAO"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.vo.JswMemberVO"%>
<%@ page import = "java.util.ArrayList"%>

<% request.setCharacterEncoding("EUC-KR"); %>
    
<% 
	//request : 내장형 오브젝트
	//getParameter()함수는 외부에서 jsp에 요청하는 데이터를 받는 함수/ 데이터는 문자열로 받는다.
	
	
	String id = request.getParameter("id"); 
	String pw = request.getParameter("pw");
/*	System.out.println("id >>> : " + id); 
	System.out.println("pw >>> : " + pw);
	out.println(id);
	out.println(pw);
*/	
	
	//String 데이터가 있을때만 돌아가야하므로 null체크해야함
	//Front end와 back end 중 logic tier와 연결하는 부분
	JswMemberDAO jdao = new JswMemberDAOImpl();
	JswMemberVO jvo = null;
	jvo = new JswMemberVO();
	jvo.setJid(id);
	jvo.setJpw(pw);
	
	ArrayList<JswMemberVO> aList = jdao.loginJswMember(jvo);
	System.out.println("aList.size >>> : " + aList.size());
	if (aList.size() == 1){
%>
		<script>
			alert("로그인 성공 !!");
			location.href="/babyWeb/loginJswMember/index.html";
		</script>
<% 		
 	}else{
 		
 		if (aList.size() == 1){	
%>
		<script>
			alert("로그인 중복!!");
			location.href="/babyWeb/loginJswMember/index.html";
		</script>
<% 		
 		}else{
 		
%>
		<script>
			alert("로그인에 실패 했습니다. !!");
			location.href="/babyWeb/loginJswMember/html5_2.html";
		</script>

<% 	
 		}
 	}
 	
 %>		

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "
http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>