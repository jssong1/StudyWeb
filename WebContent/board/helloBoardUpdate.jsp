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
		
	if (isudType !=null){
		System.out.println("isudType >>> : " + isudType);
		boolean bool = "U".equals(isudType.toUpperCase());
		
		if (bool){
			HelloBoardDAO jbdao = new HelloBoardDAOImpl();
			System.out.println("jbdao >>> : " + jbdao);
			
			HelloBoardVO jbVo = null;
			jbVo = new HelloBoardVO();			
			jbVo.setJno(chkInJno);
			
			ArrayList<HelloBoardVO> aListS = jbdao.boardSelect(jbVo);
			int nCnt = aListS.size();
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ��� �� ����</title>
<script type="text/javascript">
			
		function boardUpdateFunction(str){
				var strValue = str;
				alert(strValue);
				
				if ('UOK' == strValue){														
					document.boardUpdate.action = "/babyWeb/board/helloBoardUpdateOK.jsp";
					alert(' UOK >>> : ' + document.boardUpdate.action);
				}		
				if ('SALL' == strValue){
					document.boardUpdate.action = "/babyWeb/board/helloBoardSelectAll.jsp";
					alert(' SALL >>> : ' + document.boardUpdate.action);
				}
				
				document.boardUpdate.submit();
			}
		
		</script>
</head>
<body>
		<center>
		<form name="boardUpdate" method="POST">
			<table border="1" align="center">

<%
			if (1 >= nCnt){
				for (int i=0; i < nCnt; i++){
					HelloBoardVO jbVo_ = aListS.get(i);
%>
					<tr>
						<td colspan="2" align="center">�Խ��� �� �����ϱ�</td>				
					</tr>
					<tr>
						<td align="center">�۹�ȣ</td>
						<td><input type="text" name="jno" id="jno" size="20" readonly value=<%= jbVo_.getJno()%>></td>
					</tr>
					<tr>
						<td align="center">����</td>
						<td><input type="text" name="jsubject" id="jsubject" size="53" value=<%= jbVo_.getJsubject()%>></td>
					</tr>
					<tr>
						<td  align="center">�̸�</td>
						<td><input type="text" name="jname" id="jname" size="53" value=<%= jbVo_.getJname()%>></td>			</tr>			
					<tr>
						<td  align="center">�Է���</td>
						<td><input type="text" name="jinsertdate" size="20" disabled value=<%= jbVo_.getJinsertdate()%>></td>
					</tr>
						<tr>
						<td  align="center">������</td>
						<td><input type="text" name="jupdatedate" size="20" disabled value=<%= jbVo_.getJupdatedate()%>></td>
					</tr>
					<tr>
						<td  align="center">����</td>
						<td>
							<textarea name="jmemo" id="jmemo" cols="50" rows="10"><%= jbVo_.getJmemo()%></textarea>
						</td>
					</tr>
					<tr>
						<td  align="center">��й�ȣ</td>
						<td>
							<input type="password" name="jpw" id="jpw" size="20" >
							<input type="button" id="jpwChek" value="��й�ȣȮ��">
						</td>
					</tr>
<%				
				}
%>
					<tr>
						<td colspan="2" align="center">
						<input type="hidden" name="ISUD_TYPE" value="UOK">
							<input type="button" value="�ۼ���" onclick="boardUpdateFunction('UOK')">
							<input type="button" value="�۸��" onclick="boardUpdateFunction('SALL')">					
						</td>				
					</tr>
				</table>
				</form>
<%			
			}else{
%>
				<script>
					alert(" ������ �����Ͱ� �����ϴ�. ");
				</script>
<%
			}
		
		}else{
			
		}		
	}else{
		
	}
%>	
</body>
</html>