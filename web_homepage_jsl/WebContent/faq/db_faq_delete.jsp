<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@page import="dao.*, dto.*" %>
<%@ page import="common.*" %>
<%@ include file="../common_session.jsp"%>
<%
	if(!sessionLevel.equals("top")){
%>
		<script type="text/javascript">
			alert("관리자 화면입니다!");
			location.href="faq_list.jsp";
		</script>
<%
	}
	
	FaqDao dao= new FaqDao();
	request.setCharacterEncoding("utf-8");
	String no= request.getParameter("t_no");
	
	int result= dao.deleteFaq(no);
	String msg= "삭제가 완료되었습니다";
	if(result!=1) msg="삭제에 실패했습니다";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="faq_list.jsp";
</script>
</head>
<body>

</body>
</html>





