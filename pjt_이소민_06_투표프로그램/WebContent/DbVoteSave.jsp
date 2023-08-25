<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	VoteDao dao = new VoteDao();
	
	String v_jumin = request.getParameter("v_jumin");
	String v_name = request.getParameter("v_name");
	String m_no = request.getParameter("m_no");
	String v_time = request.getParameter("v_time");
	String v_area = request.getParameter("v_area");
	String v_confirm = request.getParameter("v_confirm");
	
	Sub2Dto dto = new Sub2Dto(v_jumin, v_name, m_no, v_time, v_area, v_confirm);
	String msg="투표하기 정보가 정상적으로 등록되었습니다!";
	int result = dao.saveVote(dto);
	if(result != 1) msg="투표 등록 실패!!";
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