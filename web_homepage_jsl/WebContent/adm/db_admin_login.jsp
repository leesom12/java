<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.*, dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao = new MemberDao();
	String id= request.getParameter("t_id");
	String password= request.getParameter("t_password");
	password= dao.encryptSHA256(password);
	
	String name= dao.checkLogin(id, password);
	String message="";
	String url="";
	if(name.equals("")){
		message="존재하지 않는 정보입니다. ID나 비밀번호를 확인하세요.";
		url="adm.jsp";
	} else{
		if(id.equals("manager")){
			session.setAttribute("sessionName", name);		//session.setAttribute(String a, Object b): a라는 변수에 b를 대입. session 변수를 만드는 메소드
			session.setAttribute("sessionId", id);
			session.setAttribute("sessionLevel", "top");
			message= name+"님 환영합니다!";
			url="adm_list.jsp";
			session.setMaxInactiveInterval(60*60);			//session.setMaxInactiveInterval(int a): a초 동안 session을 관리. 초 단위.
		} else{
			message="관리자 화면입니다. 회원 로그인 화면에서 로그인 하세요";
			session.invalidate();
			url="/web_homepage_jsl/login/member_login.jsp";
		}
		
		
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	alert("<%=message%>");
	location.href="<%=url%>";
</script>
<body>
</body>
</html>