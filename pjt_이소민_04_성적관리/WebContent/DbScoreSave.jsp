<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	ScoreDao dao = new ScoreDao();
	
	String syear = request.getParameter("syear");
	String sclass = request.getParameter("sclass");
	String sno = request.getParameter("sno");
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String mat = request.getParameter("mat");
	
	ScoreSaveDto dto = new ScoreSaveDto(syear, sclass, sno, kor, eng, mat);
	int result = dao.scoreSave(dto);
	
	String msg="성적입력이 정상적으로 등록되었습니다!";
	if(result != 1) msg="성적입력 실패!!";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="성적조회.jsp";
</script>
<body>

</body>
</html>