<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	SmartDao dao = new SmartDao();
	request.setCharacterEncoding("utf-8");
	
	String w_workno = request.getParameter("w_workno");
	String p_p1 = request.getParameter("p_p1");
	String p_p2 = request.getParameter("p_p2");
	String p_p3 = request.getParameter("p_p3");
	String w_lastdate = request.getParameter("w_lastdate");
	String w_lasttime = request.getParameter("w_lasttime");
	
	Sub4Dto dto = new Sub4Dto(w_workno, p_p1, p_p2, p_p3, w_lastdate, w_lasttime);
	
	String msg="작업공정입력이 정상적으로 등록되었습니다!";
	int result = dao.saveProcessList(dto);
	if(result != 1) msg="작업공정입력 실패!!";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="작업공정조희.jsp";
</script>

<body>

</body>
</html>