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
	String no= dao.getNo();
	String title= request.getParameter("t_title");
	title = title.replaceAll("\'", "\''");
	title = title.replaceAll("\"", "&quot;");
	String content= request.getParameter("t_content");
	content = content.replaceAll("\'", "\''");
	content = content.replaceAll("\"", "&quot;");
	content = content.replaceAll("\r\n", "<br/>");
	String reg_id= sessionId;
	String reg_date= CommonUtil.getTodayTime();
	
	FaqDto dto= new FaqDto(no, title, content, reg_id, reg_date);
	int result= dao.saveFaq(dto);
	String msg= "등록이 완료되었습니다";
	if(result!=1) msg="등록에 실패했습니다";
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





