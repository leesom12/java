<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	SnackDao dao = new SnackDao();
	String p_code=request.getParameter("t_p_code");
	int result= dao.deleteSnack(p_code);
	String message= "삭제를 완료했습니다";
	if(result != 1) message="삭제에 실패했습니다";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=message%>");
	location.href="snack_list.jsp";
</script>
</head>
<body>

</body>
</html>