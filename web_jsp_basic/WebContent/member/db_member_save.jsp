<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.*, dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao= new MemberDao();
	
	String id= request.getParameter("t_id");
	String name= request.getParameter("t_name");
	String age= request.getParameter("t_age");
	if(age.equals("")) age="0";
	int ageNumber= Integer.parseInt(age);
	String reg_date= request.getParameter("t_reg_date");
	
	MemberDto dto= new MemberDto(id, name, ageNumber, reg_date);
	int result= dao.memberSave(dto);
	String msg="등록 성공";
	if(result != 1) msg="등록실패";

	
//	out.print("id: "+id+"<br>");
//	out.print("name: "+name+"<br>");
//	out.print("age: "+age+"<br>");
//	out.print("date: "+reg_date+"<br>");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="member_list.jsp";
</script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>