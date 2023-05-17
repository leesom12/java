<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	SnackDao dao= new SnackDao();
	String p_code= request.getParameter("t_p_code");
	String p_name=request.getParameter("t_p_name");
	String price=request.getParameter("t_price");
	price= price.replaceAll(" ", "");
	int price2= Integer.parseInt(price);
	String m_code= request.getParameter("t_m_code");
	
	SnackDto dto= new SnackDto(p_code, p_name, m_code, price2);
	
	int result= dao.updateSnack(dto);
	String message="수정을 완료했습니다";
	if(result != 1) message="수정에 실패했습니다.";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("<%=message%>");
	location.href="snack_list.jsp";
</script>
</head>
<body>

</body>
</html>