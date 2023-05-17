<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	String id= request.getParameter("t_id");
	String message= "삭제 성공";
	int result= dao.memberDelete(id);
	if(result != 1) message="삭제 실패";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("<%=message%>");
	location.href="member_list.jsp";
</script>
</head>
<body>

</body>
</html>