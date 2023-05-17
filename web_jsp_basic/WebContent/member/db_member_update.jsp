<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "dto.*, dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao = new MemberDao();
	String id= request.getParameter("t_id");
	String name= request.getParameter("t_name");
	String age= request.getParameter("t_age");
	if(age.equals("")) age="0";
	int ageNumber= Integer.parseInt(age);
	String reg_date= request.getParameter("t_reg_date");
	
	MemberDto dto= new MemberDto(id, name, ageNumber, reg_date);
	int result= dao.memberUpadate(dto);
	String msg= "수정 성공";
	if(result != 1) msg="수정 실패";   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("<%=msg%>");
	location.href="member_list.jsp";
</script>
</head>
<body>

</body>
</html>