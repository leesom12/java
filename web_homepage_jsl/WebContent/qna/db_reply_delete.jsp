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
	
	int result= dao.replyDelete(no);
	String msg= "답변 삭제가 완료되었습니다";
	if(result != 1)msg="답변 삭제에 실패했습니다";
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