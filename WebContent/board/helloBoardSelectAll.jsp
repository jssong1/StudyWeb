<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import = "java.util.ArrayList"%>   
<%@ page import = "bitcamp.java142.board.dao.HelloBoardDAO"%>
<%@ page import = "bitcamp.java142.board.dao.HelloBoardDAOImpl"%>
<%@ page import = "bitcamp.java142.board.vo.HelloBoardVO"%>
 
<% request.setCharacterEncoding("EUC-KR"); %>
<script>
						alert( " �Խ��� ��� ��ȸ �� ");
						
</script> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ��� ���</title>
	<style type="text/css">
		.tt{
			text-align: center;
			font-weight: bold;
		}
	</style>
	<script type="text/javascript">		
	
		function boardFunction(str){
			var strValue = str;
			alert(strValue);
		
			if ('I' == strValue){				
				document.boardForm.action = "/babyWeb/board/helloBoard.html";				
				alert(' I >>> : ' + document.boardForm.action);
			}
			if ('SALL' == strValue){
				document.boardForm.ISUD_TYPE.value = "SALL";
				
				document.boardForm.action = "/babyWeb/board/helloBoardSelectAll.jsp"
				alert(' SALL >>> : ' + document.boardForm.action);
			}			
			if ('U' == strValue){
				document.boardForm.ISUD_TYPE.value = "U";
				document.boardForm.action = "/babyWeb/board/helloBoardUpdate.jsp"
				alert(' U >>> : ' + document.boardForm.action);
			}
			if ('D' == strValue){
				document.boardForm.ISUD_TYPE.value = "D";
				document.boardForm.action = "/babyWeb/board/helloBoardDelete.jsp"
				alert(' D >>> : ' + document.boardForm.action);				
			}
			
			document.boardForm.submit();
		}
	</script>

</head>
<body>


<%
System.out.println("(log)TestBoard.main ��ü��ȸ SELECT ALL START>>>>>");

System.out.println("(log)--SALL>>TestBoard.selectJswBoard() START>>>>>");

HelloBoardDAO jdao = new HelloBoardDAOImpl();
ArrayList<HelloBoardVO> aListAll = jdao.selectAllJswBoard();

System.out.println("(log) HelloBoardDAOImpl.selectJswBoard���� ���ϵ� �� ����>>>>> " + aListAll);

int nCnt = aListAll.size();
System.out.println("(log) nCnt = aListAll.size()>>>>> : " + nCnt);
System.out.println("(log)--SALL>>TestBoard.selectJswBoard() END>>>>>");

System.out.println("(log)TestBoard.main ��ü��ȸ SELECT ALL END>>>>>");	
%>

<center>
		<form name="boardForm" methdo="POST">
		<table border="1" align="center">
			<thead>
			<tr>
				<td colspan="10" align="center">
					<h2>�Խ���</h2>
				</td>
			</tr>
			<tr>				
				<td colspan="10" align="right">																					
					<input type="button" value="�۾���" onclick="boardFunction('I')">
					<input type="button" value="�۸��" onclick="boardFunction('SALL')">
					<input type="button" value="�ۼ���" onclick="boardFunction('U')">
					<input type="button" value="�ۻ���" onclick="boardFunction('D')">														
				</td>								
			</tr>					
			<tr>
				<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
				<td class="tt">�۹�ȣ</td>
				<td class="tt">����</td>
				<td class="tt">�̸�</td>
				<td class="tt">��й�ȣ</td>
				<td class="tt">����</td>
				<td class="tt">�Է���</td>
				<td class="tt">������</td>			
			</tr>
			</thead>
				 
<%				  							
			for (int i=0; i < nCnt; i++)
			{
				HelloBoardVO jVo = (HelloBoardVO)aListAll.get(i);						
%>
				<tbody>
				<tr>
					<td align="center">
						<input type="checkbox" name="chkInJno" 
								id="chkInJno"  value=<%= jVo.getJno()%>
						 	    onclick="checkOnly(this)">
					</td>
					<td align="center"><%= jVo.getJno() %></td>
					<td align="center"><%= jVo.getJsubject() %></td>
					<td align="center"><%= jVo.getJname() %></td>
					
					<td align="center"><%= jVo.getJpw() %></td>	
					<td align="center"><%= jVo.getJmemo() %></td>		
					<td align="center"><%= jVo.getJinsertdate() %></td>
					<td align="center"><%= jVo.getJupdatedate() %></td>			
				</tr>			
<% 			  						 
			}	
		
%>
				<tr>
					<td colspan="10" align="right">	
						<input type="hidden" name="ISUD_TYPE">												
						<input type="button" value="�۾���" onclick="boardFunction('I')">
						<input type="button" value="�۸��" onclick="boardFunction('SALL')">
						<input type="button" value="�ۼ���" onclick="boardFunction('U')">
						<input type="button" value="�ۻ���" onclick="boardFunction('D')">					
					</td>					
				</tr>
				</tbody>								
		</table>
		</form>
	</center>





























</body>
</html>