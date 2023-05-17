<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp"%>
<%@page import="dao.*, dto.*" %>
<%if(!sessionLevel.equals("top")){ %>
		<script type="text/javascript">
			alert("관리자 화면입니다");
			location.href="/web_homepage_jsl/qna/qna_list.jsp";
		</script>
<%}
	request.setCharacterEncoding("UTF-8");
	QnaDao dao= new QnaDao();
	String no= request.getParameter("t_no");
	String answer_content= request.getParameter("t_answer");
	answer_content= answer_content.replaceAll("\"", "&quot;");
	String attach= request.getParameter("t_attach");
	String answer_reg_date= CommonUtil.getTodayTime();
	String answer_update_date= "";
	String answer_id= sessionId;
	
	QnaDto dto= new QnaDto(no, answer_id, answer_content, answer_reg_date, answer_update_date, attach);
	int result= dao.replySave(dto);
	String msg= "답변 등록이 완료되었습니다";
	if(result != 1)msg="답변 등록에 실패했습니다";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		alert("<%=msg%>");
		location.href="/web_homepage_jsl/qna/qna_list.jsp";
</script>
</head>
<body>

</body>
</html>