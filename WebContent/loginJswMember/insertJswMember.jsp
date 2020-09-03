<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAO"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.vo.JswMemberVO"%>
<%@ page import = "java.util.ArrayList"%>

<% request.setCharacterEncoding("EUC-KR"); %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원정보 등록</title>
</head>
<body>
 <%			
 			 String jkname = request.getParameter("jkname");       
			 String jalias = request.getParameter("jalias"); 
			 String jid = request.getParameter("jid"); 
			 String jpw = request.getParameter("jpw"); 
			 String jgender = request.getParameter("jgender"); 
			 String jhp = request.getParameter("jhp"); 
			 String jbirth = request.getParameter("jbirth"); 
			 String jemail = request.getParameter("jemail"); 
			 String jpostno = request.getParameter("jpost"); 
			 String jaddr = request.getParameter("jaddr"); 
			 	
			JswMemberDAO jdao = new JswMemberDAOImpl();
			
			JswMemberVO jvo = null;
			jvo = new JswMemberVO();

			jvo.setJkname(jkname);
			jvo.setJalias(jalias) ;
			jvo.setJid(jid) ;
			jvo.setJpw(jpw) ;
			jvo.setJgender(jgender);
			jvo.setJhp(jhp);
			jvo.setJbirth(jbirth) ;
			jvo.setJemail(jemail);
			jvo.setJpostno(jpostno);
			jvo.setJaddr(jaddr) ;

			
			boolean bFlag = jdao.insertJswMember(jvo);			
			
			if(bFlag){
%>
<script>
				alert( "회원 정보 등록 완료");
				location.href="/babyWeb/loginJswMember/selectAllJswMember.jsp";
</script>				
<% 						
			}else{
%>		
<script>
				alert( "회원 정보 등록 실패");
				location.href="/babyWeb/loginJswMember/member.html";
</script>				
<% 						
			}// 출력if-else 끝
		
			
%>
</body>
</html>