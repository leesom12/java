<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	StudentDao dao= new StudentDao();
	String syear= request.getParameter("t_syear");
	String sclass= request.getParameter("t_sclass");
	String sno= request.getParameter("t_sno");
	StudentDto dto= new StudentDto(syear, sclass, sno);
	
	String message= "삭제가 완료되었습니다";
	int result= dao.deleteStudent(dto);
	if(result != 1) message="삭제 실패";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=message%>");
	location.href="student_list.jsp";
</script>
</head>
<body>

</body>
</html>