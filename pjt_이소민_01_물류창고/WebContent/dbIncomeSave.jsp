<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	String t_no = request.getParameter("t_no");
	String p_code = request.getParameter("p_code");
	String t_type = request.getParameter("t_type");
	String t_s_cnt = request.getParameter("t_cnt");
	int t_cnt = Integer.parseInt(t_s_cnt);
	String t_date = request.getParameter("t_date");
	String c_code = request.getParameter("c_code");
	
	Dto dto = new Dto(p_code, c_code, t_no, t_type, t_date, t_cnt);
	
	Dao dao = new Dao();
	int result = dao.incomingSave(dto);
	String msg ="입출고 등록이 정상적으로 등록되었습니다";
	if(result != 1) msg="등록 실패!!";
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