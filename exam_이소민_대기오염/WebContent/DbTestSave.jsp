<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	request.setCharacterEncoding("utf-8");
	
	String test_date = request.getParameter("test_date");
	String test_ampm = request.getParameter("test_ampm");
	String pollution = request.getParameter("pollution");
	String city_code = request.getParameter("city_code");
	String value = request.getParameter("test_value");
	int test_value = Integer.parseInt(value);
	
	Sub2Dto dto = new Sub2Dto(test_date, test_ampm, pollution, city_code, test_value);
	String msg="측정 정보가 정상적으로 등록되었습니다!";
	int result = dao.saveTestValue(dto);
	if(result != 1) msg="등록실패!!";
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