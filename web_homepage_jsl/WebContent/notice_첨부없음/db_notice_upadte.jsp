<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*, common.*" %>
<%@ include file="../common_session.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	NoticeDao dao= new NoticeDao();
	if(!sessionLevel.equals("top")){
%>

		<script type="text/javascript">
			alert("로그인 정보가 만료되었거나 관리자가 아닙니다!");
			location.href="notice_list.jsp";
		</script>
<%
	}else{
		String no= request.getParameter("t_no");
		String title= request.getParameter("t_title");
		title = title.replaceAll("\'", "\''");
		String content= request.getParameter("t_content");
		content = content.replaceAll("\'", "\''");
		String attach= request.getParameter("t_attach");
		String reg_id= sessionId;
		
		NoticeDto dto= new NoticeDto(no, title, content, attach);
		int result= dao.updateNotice(dto);
		String message ="";
		if(result == 1) message="수정이 완료되었습니다.";
		else message="수정에 실패했습니다.";
			
%>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			alert("<%=message%>");
			location.href="notice_list.jsp";
		</script>
		</head>
		<body>
		
		</body>
		</html>
<%}%>