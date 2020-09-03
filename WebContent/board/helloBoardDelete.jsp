<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<%@ page import = "java.util.ArrayList"%>   
<%@ page import = "bitcamp.java142.board.dao.HelloBoardDAO"%>
<%@ page import = "bitcamp.java142.board.dao.HelloBoardDAOImpl"%>
<%@ page import = "bitcamp.java142.board.vo.HelloBoardVO"%>    
    
<% request.setCharacterEncoding("EUC-KR"); %>     
    
 <%
	String isudType = request.getParameter("ISUD_TYPE");
	String chkInJno = request.getParameter("chkInJno");
	String jno = request.getParameter("jno");
	String jsubject = request.getParameter("jsubject");
	String jname = request.getParameter("jname");
	String jpw = request.getParameter("jpw");
	String jmemo = request.getParameter("jmemo");
	
	if("D".equals(isudType.toUpperCase())){
		System.out.println(" ISUD_TYPE >>> : " + isudType);
		
		// delete logic
		HelloBoardDAO jbdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		
		jbvo.setJno(chkInJno); //???????????
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " +  jbvo.getJno());
		int nCntD = jbdao.deleteJswBoard(jbvo);
		System.out.println("(log)--U>>TestBoard.deleteJswBoard() END>>>>>");
		
		if (nCntD == 1){
			System.out.println(" 삭제성공 페이지로 보내기 ");
%>
			<script>
				alert("게시판 글삭제 성공 !!");
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