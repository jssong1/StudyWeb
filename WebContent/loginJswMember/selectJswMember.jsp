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
<title>키워드 해당 회원 정보</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %> 
	<% 
		String jmem = request.getParameter("jmem");
	
		JswMemberDAO jdao = null; 
		jdao = new JswMemberDAOImpl();
	
		JswMemberVO jvoi = null;
		jvoi = new JswMemberVO();
		jvoi.setJmem(jmem);
 		ArrayList<JswMemberVO> aList = jdao.searchJswMember(jvoi);
		
		int aListSize = aList.size();
			if (aListSize == 0){

%>	
		<script>
			alert("조회 실패");
			location.href="/babyWeb/loginJswMember/member.html";
		</script>	
		<% 		
 			}else{
		%>
		<script>
			alert("조회 성공");
		</script>
 <table border="1">
		<tr>
			<td colspan="16" align="center"><h3>조회된 회원정보</h3></td>
		</tr>	
		<tr>
		 	<td>회원번호 :</td>
			<td>한글이름 :</td>
			<td>닉네임(별칭):</td>
			<td>아이디  :</td>
			<td>패스워드 : </td>
			<td>성별 : </td>
			<td>휴대폰번호 : </td>
			<td>생년월일:  </td>
			<td>이메일 :  </td>
			<td>우편번호 : </td>
			<td>주소 : </td>
			<td>삭제여부 :  </td>
			<td>등록일 : </td>
			<td>삭제일 :</td> 
		</tr>
	 		
	<% 		for(int i =0; i<aListSize ; i++){  
				JswMemberVO jvo = aList.get(i); 
	%>
		<tr>
		    
			<td><%=jvo.getJmem()%></td>
			<td><%=jvo.getJkname()%></td>
			<td><%=jvo.getJalias()%></td>
			<td><%=jvo.getJid()%></td>
			<td><%=jvo.getJpw()%></td>
			<td><%=jvo.getJgender()%></td>
			<td><%=jvo.getJhp()%></td>
			<td><%=jvo.getJbirth()%></td>
			<td><%=jvo.getJemail()%></td>
			<td><%=jvo.getJpostno()%></td>
			<td><%=jvo.getJaddr()%></td>
			<td><%=jvo.getJdeleteYN()%></td>
			<td><%=jvo.getJinsertdate()%></td>
			<td><%=jvo.getJupdatedate()%></td>	
			
		</tr>
	<%			} 
		} %>
		</table>
</body>
</html>