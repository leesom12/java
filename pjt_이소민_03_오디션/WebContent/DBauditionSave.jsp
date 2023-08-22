<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	AuditionDao dao = new AuditionDao();

	String artist_id = request.getParameter("artist_id");
	String artist_name = request.getParameter("artist_name");
	String birth_1 = request.getParameter("birth_1");
	String birth_2 = request.getParameter("birth_2");
	String birth_3 = request.getParameter("birth_3");
	String artist_birth = birth_1+birth_2+birth_3;
	String artist_gender = request.getParameter("artist_gender");
	String talent = request.getParameter("talent");
	String agency = request.getParameter("agency");
	
	AuditionDto dto = new AuditionDto(artist_id, artist_name, artist_gender, artist_birth, talent, agency);
	String msg="참가 신청이 정상적으로 등록 되었습니다";
	int result = dao.auditionSave(dto);
	if(result != 1) msg="참가 신청 실패!!";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="참가자목록조회.jsp";
</script>

<body>

</body>
</html>