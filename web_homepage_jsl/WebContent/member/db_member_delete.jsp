<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_session.jsp" %>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao= new MemberDao();
	String msg="";
	String url="";
	
	String pw= request.getParameter("t_pw");
	pw= dao.encryptSHA256(pw);
	String name= dao.checkLogin(sessionId, pw);
	if(name.equals("")){
		msg="비밀번호가 일치하지 않습니다. 다시 입력하세요";
		url="member_delete.jsp";
	}else{
		dao.deleteMember(sessionId);
		session.invalidate();
		msg="탈퇴가 완료되었습니다";
		url="../index.jsp";		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");		
	location.href="<%=url%>";		
</script>
</head>
<body>

</body>
</html>