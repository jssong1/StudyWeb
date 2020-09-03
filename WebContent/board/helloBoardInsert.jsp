<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import = "java.util.ArrayList"%>   
<%@ page import = "bitcamp.java142.board.dao.HelloBoardDAO"%>
<%@ page import = "bitcamp.java142.board.dao.HelloBoardDAOImpl"%>
<%@ page import = "bitcamp.java142.board.vo.HelloBoardVO"%>

<% request.setCharacterEncoding("EUC-KR"); %>     
 <script>
 	alert("(글쓰기 페이지 이동 >>>>>");
 </script>
 
<%			
			System.out.println("(log)TestBoard.main INSERT START>>>>>");
			String isudType = request.getParameter("ISUD_TYPE");
			String chkInJno = request.getParameter("chkInJno");  
			String jno = request.getParameter("jno");
			String jsubject = request.getParameter("jsubject");
			String jname = request.getParameter("jname");
			String jpw = request.getParameter("jpw"); 
			String jmemo = request.getParameter("jmemo");
			System.out.println(   isudType + " : " + chkInJno + " : "+ jno + " : "+ jsubject + " : "+ jname + " : "+ jpw + " : "+ jmemo);
			
	if (isudType !=null){//????????????
			System.out.println("isudType >>> : " + isudType);
	
			boolean bool = "I".equals(isudType.toUpperCase());
				
		if (bool){

			HelloBoardDAO jbdao = new HelloBoardDAOImpl();
		
			HelloBoardVO jbvo = null;
			jbvo = new HelloBoardVO();
	
			jbvo.setJsubject(jsubject) ;
			jbvo.setJname(jname) ;
			jbvo.setJpw(jpw) ;
			jbvo.setJmemo(jmemo);
			jbvo.setJdeleteyn("Y");
			
			
			System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jbvo.getJsubject()+" ," +jbvo.getJname()+" ,"+jbvo.getJpw()+" ," +jbvo.getJmemo()+ jbvo.getJdeleteyn());
			int nCnt = jbdao.insertJswBoard(jbvo);
			
			if (nCnt >=1 ){
		%>
<script>
				
				alert( "게시판 글쓰기 완료");
				location.href="/babyWeb/board/helloBoardSelectAll.jsp";
</script>				
<%							
			}else{
%>		
<script>		alert( "게시판 글쓰기 실패");
				location.href= "/babyWeb/board/helloBoard.html";
</script>				
<% 						
			}// if (nCnt >=1 ) else 끝
			System.out.println("(log)TestBoard.main INSERT END>>>>>");
		}else{
			out.println("ISUD_TYPE을 잘 넘기세요");
		}//if (bool)-else끝
	}//if (isudType !=null)끝
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