<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*, common.CommonUtil" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao= new MemberDao();
	String id= request.getParameter("t_id");
	String password= request.getParameter("t_pw");
	password= dao.encryptSHA256(password);
	String name= request.getParameter("t_name");
	String job= request.getParameter("t_job");
	String tell_1= request.getParameter("telNo1");
	String tell_2= request.getParameter("t_tell_2");
	String tell_3=request.getParameter("t_tell_3");
	String mo1= request.getParameter("t_mobile_1");
	String mo2= request.getParameter("t_mobile_2");
	String mo3= request.getParameter("t_mobile_3");
	String mobile= mo1+mo2+mo3;
	String email=request.getParameter("t_email");
	MemberDto dto = new MemberDto(id, name, job, tell_1, tell_2, tell_3, mobile, email);
	
	int count= dao.checkPassword(id, password);

	if(count == 1){
		String message="";
		int result= dao.updateMember(dto);
		if(result==1) message="수정이 완료되었습니다.";
		else message="수정에 실패했습니다. 관리자에 문의 요망";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=message%>");
	location.href="member_myinfo.jsp";
	
</script>
</head>
<body>

</body>
</html>
<%} else{
	String msg="비밀번호가 일치하지 않습니다. 다시 입력해 주세요!";
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="member_update.jsp";
	
</script>
<%} %>










