<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<%@ page import="dto.*, dao.*, common.*" %>
<%
	if(!sessionLevel.equals("top")){
%>
		<script type="text/javascript">
			alert("관리자 화면입니다. 자료실로 이동합니다.");
			location.href="pds_list.jsp";
		</script>
<%
	}else{
		String pdsDir= CommonUtil.getFile_dir_pds();
		int maxSize= 1024*1024*10;
		MultipartRequest mpr = new MultipartRequest(request, pdsDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		request.setCharacterEncoding("UTF-8");
		PdsDao dao= new PdsDao();
		
		String no= dao.getMaxNo();
		String title= mpr.getParameter("t_title");
		title = title.replaceAll("\'", "\''");
		title = title.replaceAll("\"", "&quot;");
		String content= mpr.getParameter("t_content");
		content = content.replaceAll("\'", "\''");
		content = content.replaceAll("\"", "&quot;");
		content = content.replaceAll("\r\n", "<br/>");
		String attach= mpr.getFilesystemName("t_attach");
		if(attach == null) attach = "";
		String reg_id= sessionId;
		String reg_date= CommonUtil.getTodayTime();
		
		PdsDto dto= new PdsDto(no, title, content, attach, reg_id, reg_date);
		String msg= "등록이 완료되었습니다";
		int result= dao. savePds(dto);
		if(result != 1) msg="등록 실패!";
		
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
<%
	}
%>