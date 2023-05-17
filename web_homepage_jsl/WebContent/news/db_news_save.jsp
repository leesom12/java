<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*" %>
<%@ include file="../common_session.jsp"%>
<%
	NewsDao dao= new NewsDao();
	request.setCharacterEncoding("UTF-8");	

	if(sessionLevel.equals("top")){
	String no= dao.getNewsNo();
	String title= request.getParameter("t_title");
	title = title.replaceAll("\'", "\''");
	String content= request.getParameter("t_content");
	content = content.replaceAll("\'", "\''");
	String reg_id= sessionId;
	String reg_date= CommonUtil.getTodayTime();
	
	NewsDto dto= new NewsDto(no, title, content, reg_id, reg_date);
	int result= dao.saveNews(dto);
	String message="등록이 완료되었습니다";
	if(result != 1) message="등록에 실패했습니다";
%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		alert("<%=message%>");
		location.href="news_list.jsp";
	</script>
	</head>
	<body>
	
	</body>
	</html>
<%	}
	else{
%>
		<script type="text/javascript">
			alert("관리자 화면이거나 세션이 만료되었습니다");
			location.href="news_list.jsp";
		</script>

<%
	}

%>