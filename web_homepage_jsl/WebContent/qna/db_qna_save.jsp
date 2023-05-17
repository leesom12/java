<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp"%>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	QnaDao dao= new QnaDao();
	String no= dao.getNo();
	String title= request.getParameter("t_title");
	title = title.replaceAll("\'", "\''");
	title = title.replaceAll("\"", "&quot;");
	String content= request.getParameter("t_content");
	content = content.replaceAll("\'", "\''");
	content = content.replaceAll("\"", "&quot;");
	String reg_id= sessionId;
	String reg_date= CommonUtil.getTodayTime();
	
	
	if(sessionLevel.equals("member")){
		QnaDto dto= new QnaDto(no, title, content, reg_id, reg_date);
		String msg="등록이 완료되었습니다";
		int result= dao.questionSave(dto);
		if(result != 1) msg="등록에 실패했습니다";
%>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			alert("<%=msg%>");
			location.href="qna_list.jsp";
		</script>
		</head>
		<body>
		
		</body>
		</html>
<%} else {%>

	<script type="text/javascript">
		alert("회원이 아니거나 세션이 만료되었습니다!");
		location.href="qna_list.jsp";
	</script>
<%}%>







