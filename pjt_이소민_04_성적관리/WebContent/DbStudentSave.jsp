<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	ScoreDao dao = new ScoreDao();
	
	String syear = request.getParameter("syear");
	String sclass = request.getParameter("sclass");
	String sno = request.getParameter("sno");
	String sname = request.getParameter("sname");
	String birth = request.getParameter("birth");
	String gender = request.getParameter("gender");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	
	StudentSaveDto dto = new StudentSaveDto(syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3);
	String msg="학생등록이 정상적으로 등록되었습니다!";
	int result = dao.studentSave(dto);
	if(result != 1) msg="학생등록 실패!!";
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