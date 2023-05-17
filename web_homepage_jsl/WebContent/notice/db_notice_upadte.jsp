<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		
		String noticeDir= CommonUtil.getFile_dir_notice();				//저장 경로
		int maxSize= 1024*1024*10;										//최대 용량 (byte), 10메가
		
		MultipartRequest mpr = new MultipartRequest(request, noticeDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String no= mpr.getParameter("t_no");
		String title= mpr.getParameter("t_title");
		title = title.replaceAll("\'", "\''");
		String content= mpr.getParameter("t_content");
		content = content.replaceAll("\'", "\''");
		
		String attach= mpr.getFilesystemName("t_attach");
		if(attach == null) attach="";
		
		String oriAttach= mpr.getParameter("t_saveAttachName");
		if(oriAttach == null) oriAttach="";
		
		String deleteAttach = mpr.getParameter("t_deleteFile");
		String saveAttachName= "";
		
		if(deleteAttach != null){
			File file= new File(noticeDir, deleteAttach);				// 자바에 있는 첨부파일 (폴더경로, 파일명)
			boolean tf = file.delete();									// 파일 삭제. return 타입 boolean.
			if(!tf) System.out.print("notice 첨부파일 삭제 실패: "+tf);
		} else saveAttachName= oriAttach;
		
		if(!attach.equals("")) {
			if(!oriAttach.equals("")){
				File file= new File(noticeDir, oriAttach);				
				boolean tf = file.delete();
			}
			saveAttachName= attach;
		}
		
		String reg_id= sessionId;
		
		NoticeDto dto= new NoticeDto(no, title, content, saveAttachName);
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