<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>
<%@ include file="../common_session.jsp"%>
<%if(!sessionLevel.equals("top")){ %>
	<script type="text/javascript">
		alert("관리자 화면입니다!");
		location.href="/web_homepage_jsl/notice/notice_list.jsp";
	</script>
<%} %>
<%
	String no= request.getParameter("t_no");

	PdsDao dao= new PdsDao();
	request.setCharacterEncoding("utf-8");
	
	String PdsDir= CommonUtil.getFile_dir_pds();
	String attachName= request.getParameter("t_attach");
	
	String msg="";
	int result = dao.deletePds(no);
	if(result == 1){
		if(!attachName.equals("")){
			File file= new File(PdsDir, attachName);
			boolean tf= file.delete();
			if(tf){
				msg="삭제가 완료되었습니다";
			}else{
				msg="pds delete 중 파일 삭제 실패";
			}
		}else msg="삭제가 완료되었습니다";
	}else{
		msg="삭제 실패!!";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="pds_list.jsp";
</script>
</head>
<body>

</body>
</html>