<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.TsetDto" %>
<%@page import="dao.TestDao" %>
<%@page import="java.util.ArrayList"%>
<%
	TsetDto dto= new TsetDto("홍길동", "대전", 22);    
	TestDao dao= new TestDao();
	int total= dao.getTotal(10, 20);
	ArrayList<TsetDto> dtos= dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
성명: <%=dto.getName() %><br>
지역: <%=dto.getArea() %><br>
나이: <%=dto.getAge() %><br>
총점: <%=total %><br><br><hr>

<%
for(int k=0; k<dtos.size(); k++){
	out.print(dtos.get(k).getName()+"\t");
	out.print(dtos.get(k).getArea()+"\t");
	out.print(dtos.get(k).getAge()+"<br>");
}
%>
<br><br><hr>
<%
for(int k=0; k<dtos.size(); k++){
%>	
	이름: <%=dtos.get(k).getName() %>
	지역: <%=dtos.get(k).getArea() %>
	나이: <%=dtos.get(k).getAge() %><br>
<%
}
%>

</body>
</html>