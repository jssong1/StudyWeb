<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAO"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl"%>
<%@ page import = "bitcamp.java142.ch5.jswjf.vo.JswMemberVO"%>
<%@ page import = "java.util.ArrayList"%>

<% request.setCharacterEncoding("EUC-KR"); %>
    
<% 
	//request : ������ ������Ʈ
	//getParameter()�Լ��� �ܺο��� jsp�� ��û�ϴ� �����͸� �޴� �Լ�/ �����ʹ� ���ڿ��� �޴´�.
	
	
	String id = request.getParameter("id"); 
	String pw = request.getParameter("pw");
/*	System.out.println("id >>> : " + id); 
	System.out.println("pw >>> : " + pw);
	out.println(id);
	out.println(pw);
*/	
	
	//String �����Ͱ� �������� ���ư����ϹǷ� nullüũ�ؾ���
	//Front end�� back end �� logic tier�� �����ϴ� �κ�
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
			alert("�α��� ���� !!");
			location.href="/babyWeb/loginJswMember/index.html";
		</script>
<% 		
 	}else{
 		
 		if (aList.size() == 1){	
%>
		<script>
			alert("�α��� �ߺ�!!");
			location.href="/babyWeb/loginJswMember/index.html";
		</script>
<% 		
 		}else{
 		
%>
		<script>
			alert("�α��ο� ���� �߽��ϴ�. !!");
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