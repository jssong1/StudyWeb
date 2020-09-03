<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@ page import="bitcamp.java142.board.dao.HelloBoardDAOImpl" %> 
<%@ page import="bitcamp.java142.board.dao.HelloBoardDAO" %>   
<%@ page import="bitcamp.java142.board.vo.HelloBoardVO" %>   
<%@ page import="java.util.ArrayList" %>  

 <% request.setCharacterEncoding("EUC-KR"); %>  
 
 
 <%
	String isudType = request.getParameter("ISUD_TYPE");
	String chkInJno = request.getParameter("chkInJno");
	String jno = request.getParameter("jno");
	String jsubject = request.getParameter("jsubject");
	String jname = request.getParameter("jname");
	String jpw = request.getParameter("jpw");
	String jmemo = request.getParameter("jmemo");
	
	if("UOK".equals(isudType.toUpperCase())){
		System.out.println(" ISUD_TYPE >>> : " + isudType);
		
		// update logic
		HelloBoardDAO jbdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		jbvo.setJno(jno);
		jbvo.setJname(jname);
		jbvo.setJsubject(jsubject);
		jbvo.setJmemo(jmemo);
	
		int nCntU = jbdao.updateJswBoard(jbvo);
		
		if (nCntU == 1){
			System.out.println(" 수정성공 페이지로 보내기 ");
%>
			<script>
				alert("게시판 글수정 성공 !!");
				location.href="/babyWeb/board/helloBoardSelectAll.jsp";
			</script>
<%			
		}else{
			out.println(" 에러 페이지로 보내기 ");
		}		
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
</body>
</html>