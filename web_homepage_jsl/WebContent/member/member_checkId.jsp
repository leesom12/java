<%@page import="dao.*, dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemberDao dao= new MemberDao();
	request.setCharacterEncoding("UTF-8");
	String id= request.getParameter("t_id");
	int count= dao.checkID(id);
	String msg= "";
	if(count == 0) msg="사용 가능한 ID";
	else if(count == 1) msg="이미 존재하는 ID";
	else msg="서버 오류! 관리자에 문의 요망";
	out.print(msg);
%>