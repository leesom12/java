<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	SmartDao dao = new SmartDao();
	request.setCharacterEncoding("utf-8");
	
	String w_workno = request.getParameter("w_workno");
	String p_code = request.getParameter("p_code");
	String w_quentity = request.getParameter("w_quentity");
	String w_workdate = request.getParameter("w_workdate");
	
	Sub3Dto dto = new Sub3Dto(p_code, w_workno, w_quentity, w_workdate);
	String msg="작업지시입력이 정상적으로 등록되었습니다!";
	int result = dao.saveWorkList(dto);
	if(result != 1) msg="작업지시입력 실패!!";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="작업지시조회.jsp";
</script>

<body>

</body>
</html>