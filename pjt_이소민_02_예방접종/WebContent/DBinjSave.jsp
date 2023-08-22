<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	InjectionDao dao = new InjectionDao();

	String p_seno= request.getParameter("p_seno");
	String p_no= request.getParameter("p_no");
	String i_code = request.getParameter("i_code");
	String p_date = request.getParameter("p_date");
	
	InjectionDto dto = new InjectionDto( p_no,  p_seno,  i_code,  p_date);
	int result = dao.saveOrderList(dto);
	String msg ="예방접종등록 정보가 정상적으로 등록되었습니다!";
	if(result != 1) msg="등록에 실패했습니다";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="index.jsp";
</script>
<body>

</body>
</html>