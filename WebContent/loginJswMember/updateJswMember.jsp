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
<title> ������ ȸ�� ���� </title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %> 
		<script>
						alert( " ȸ�� ���� ���� �� ");
						
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
						alert( "ȸ�� ���� ���� �Ϸ�");
						location.href="/babyWeb/loginJswMember/selectJswMember.jsp?jmem=" + "<%=jmem%>";
		</script>				
<%		
	}else{
%>
		<script>
						alert( "ȸ�� ���� ���� ����");
						location.href="/babyWeb/loginJswMember/member.html";
		</script>						
<%	}// ���if-else ��
	%>








</body>
</html>