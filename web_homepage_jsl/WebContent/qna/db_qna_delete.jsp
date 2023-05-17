<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp"%>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	QnaDao dao= new QnaDao();
	String no= request.getParameter("t_no");
	QnaDto dto= dao.qnaView(no);

	
	if(!sessionId.equals(dto.getReg_id()) && !sessionLevel.equals("top")){ %>
		<script type="text/javascript">
			alert("작성자만 이용 가능한 화면입니다");
			location.href="/web_homepage_jsl/qna/qna_list.jsp";
		</script>
<%} else if(dto.getAnswer_content() != null){ %>
		<script type="text/javascript">
		alert("답변이 등록되어 수정/삭제할 수 없습니다");
		location.href="/web_homepage_jsl/qna/qna_list.jsp";
		</script>
<%} else{
		int result= dao.questionDelete(no);
		String msg="삭제가 완료되었습니다";
		if(result != 1) msg="삭제에 실패했습니다";
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
<%}%>