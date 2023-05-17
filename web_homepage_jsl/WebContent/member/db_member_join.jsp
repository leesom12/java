<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*, common.CommonUtil"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao= new MemberDao();
	AdminDao daoA= new AdminDao();

	String id= request.getParameter("t_id");
	String name= request.getParameter("t_name");
	String pass= request.getParameter("t_pw_1");
	int passLength= pass.length();
	String password= dao.encryptSHA256(pass);
	String job= request.getParameter("t_job");
	String tell_1= request.getParameter("telNo1");
	String tell_2= request.getParameter("t_tell_2");
	String tell_3= request.getParameter("t_tell_3");
	String mo_1= request.getParameter("t_mobile_1");
	String mo_2= request.getParameter("t_mobile_2");
	String mo_3= request.getParameter("t_mobile_3");
	String mobile= mo_1+mo_2+mo_3;
	String email= request.getParameter("t_email");
	String reg_date= CommonUtil.getTodayTime();
	
	MemberDto dto= new MemberDto(id, name, password, passLength , job, tell_1, tell_2, tell_3, mobile, email, reg_date);
	int result= dao.saveMember(dto);
	String msg= name+"님 환영합니다!";
	if(result != 1) msg="회원가입에 실패했습니다. 관리자에게 문의 바랍니다.";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="../login/member_login.jsp";

</script>
</head>
<body>

</body>
</html>