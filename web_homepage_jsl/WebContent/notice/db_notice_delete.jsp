<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, common.*" %>
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
		String no= request.getParameter("t_no");
		String attach= request.getParameter("t_attach");
		String noticeDir= CommonUtil.getFile_dir_notice();
		
		int result= dao.noticeDelte(no);
		String message="삭제가 완료되었습니다";
		
		if(result != 1) {
			message="삭제에 실패했습니다";
		}else{
			if(!attach.equals("")){
				File file= new File(noticeDir, attach);
				boolean tf= file.delete();
				if(!tf) System.out.print("notice delete: 첨부파일 삭제 오류!!");
			}						
		}

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