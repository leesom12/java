<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	AuditionDao dao = new AuditionDao();

	
	String artist_id = request.getParameter("artist_id");
	String men_1 = request.getParameter("men_1");
	String men_2 = request.getParameter("men_2");
	String men_3 = request.getParameter("men_3");
	
	String msg="점수 등록이 완료되었습니다";
	
	int serial_no = dao.getMaxNo();
	MetoDto dto = new MetoDto( artist_id,  "J001",  serial_no,  men_1);
	int result1 = dao.saveMentoPoint(dto);
	
	serial_no = dao.getMaxNo();
	dto = new MetoDto( artist_id,  "J002",  serial_no,  men_2);
	int result2 = dao.saveMentoPoint(dto);
	
	serial_no = dao.getMaxNo();
	dto = new MetoDto( artist_id,  "J003",  serial_no,  men_3);
	int result3 = dao.saveMentoPoint(dto);
	
	if(result1 != 1 || result2 != 1 || result3 != 1) msg="등록 실패!!";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="멘토점수조회.jsp";
</script>

<body>

</body>
</html>