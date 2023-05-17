<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	PdsDao dao= new PdsDao();
	request.setCharacterEncoding("utf-8");
	
	String PdsDir = CommonUtil.getFile_dir_pds();
	int maxSize= 1024*1024*10;
	
	MultipartRequest mpr= new MultipartRequest(request, PdsDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
	
	String no= mpr.getParameter("t_no");
	String title= mpr.getParameter("t_title");
	title = title.replaceAll("\'", "\''");
	title = title.replaceAll("\"", "&quot;");
	String content= mpr.getParameter("t_content");
	content = content.replaceAll("\'", "\''");
	content = content.replaceAll("\"", "&quot;");
	content = content.replaceAll("\r\n", "<br/>");
	String updateDate= CommonUtil.getTodayTime();
	
	String attachName="";
	
	String oriAttach = mpr.getParameter("t_ori_AttachName");
	if(oriAttach == null) oriAttach="";
	
	String deleteAttach = mpr.getParameter("t_deleteFile");
	if(deleteAttach != null){
		File file= new File(PdsDir, deleteAttach);
		boolean tf= file.delete();
		if(!tf) System.out.print("pds update 중 파일 삭제 실패!!"+deleteAttach);
	} else attachName= oriAttach;
	
	String attach= mpr.getFilesystemName("t_attach");
	if(attach == null) {
		attach="";
	} else {
		if(!oriAttach.equals("")){
			File file= new File(PdsDir, oriAttach);
			boolean tf= file.delete();
			if(!tf) System.out.print("pds update 중 파일 삭제 실패!!"+oriAttach);
		}
		attachName=attach;
	}
	
	PdsDto dto = new PdsDto(no, title, content, attachName, updateDate);
	
	int result= dao.updatePds(dto);
	String msg= "수정이 완료되었습니다";
	if(result != 1) msg="수정 실패!!";	
	
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