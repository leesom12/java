<%@page import="java.util.ArrayList"%>
<%@page import="dto.Tdto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name= (String)request.getAttribute("t_name");
	int age= (int)request.getAttribute("t_age");
	Tdto dto= (Tdto)request.getAttribute("t_dto");
	ArrayList<Tdto> dtos= (ArrayList<Tdto>)request.getAttribute("t_dtos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=name %>	<br>
<%=age %> <br>
성명: <%=dto.getName() %>
나이: <%=dto.getAge() %>
지역: <%=dto.getArea() %>
<br>

<%for(Tdto dto1 : dtos) {
	out.print(dto1.getName());
	out.print(dto1.getArea());
	out.print(dto1.getAge());
 }
%>

</body>
</html>