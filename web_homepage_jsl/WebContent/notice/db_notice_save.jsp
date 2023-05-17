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
		int maxSize= 1024*1024*10;										//최대 용량 (byte)
		
		MultipartRequest mpr = new MultipartRequest(request, noticeDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		//cos.jar 파일 안에 들어있는 클래스. 기본 제공 안되니까 따로 설치해야 함
		// MultipartRequest(request, 첨부파일 저장경로, 최대 사이즈, 한글깨지지마, 같은 파일이 여러개 올라오면 파일명 리네임)
		// enctype을 지정하면 reqeust.getParameter가 아니라 mpr.getParameter로 받아야함
		//input type이 file일 경우 mpr.getFilesystemName으로 받아옴
		

		String no= dao.getMaxNo();
		String title= mpr.getParameter("t_title");
		title = title.replaceAll("\'", "\''");
		String content= mpr.getParameter("t_content");
		content = content.replaceAll("\'", "\''");
		String attach= mpr.getFilesystemName("t_attach");
		if(attach==null) attach="";
		String reg_id= sessionId;
		String reg_date= CommonUtil.getTodayTime();
		
		NoticeDto dto= new NoticeDto(no, title, content, attach, reg_id, reg_date);
		int result= dao.saveNotice(dto);
		String message ="";
		if(result == 1) message="등록이 완료되었습니다.";
		else message="등록에 실패했습니다.";
		
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