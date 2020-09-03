<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAO"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.vo.JswMemberVO"%>
<%@ page import = "java.util.ArrayList"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> 수정된 회원 정보 </title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %> 
		<script>
						alert( " 회원 정보 수정 중 ");
						
		</script>				
	<%
	String jkname = request.getParameter("jkname");   
	String jmem = request.getParameter("jmem");   
			
	JswMemberDAO jdao = new JswMemberDAOImpl();
	
	JswMemberVO jvo = null;
	jvo = new JswMemberVO();
	jvo.setJkname(jkname); 
	jvo.setJmem(jmem);
	boolean bFlag = jdao.updateJswMember(jvo);
	
	if (bFlag){
%>
		<script>
						alert( "회원 정보 수정 완료");
						location.href="/babyWeb/loginJswMember/selectJswMember.jsp?jmem=" + "<%=jmem%>";
		</script>				
<%		
	}else{
%>
		<script>
						alert( "회원 정보 수정 실패");
						location.href="/babyWeb/loginJswMember/member.html";
		</script>						
<%	}// 출력if-else 끝
	%>








</body>
</html>