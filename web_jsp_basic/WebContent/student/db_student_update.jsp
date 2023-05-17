<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	StudentDao dao = new StudentDao();
	
	String syear= request.getParameter("t_syear");
	String sclass= request.getParameter("t_sclass");
	String sno= request.getParameter("t_sno");
	String name= request.getParameter("t_name");
//	String kor1= request.getParameter("t_kor");
//	String eng1= request.getParameter("t_eng");
//	String mat1= request.getParameter("t_mat");
//	String total1= request.getParameter("t_total");
//	String ave1= request.getParameter("t_ave");

	int kor= Integer.parseInt(request.getParameter("t_kor"));
	int eng= Integer.parseInt(request.getParameter("t_eng"));
	int mat= Integer.parseInt(request.getParameter("t_mat"));
	int total= Integer.parseInt(request.getParameter("t_total"));
	double ave= Double.parseDouble(request.getParameter("t_ave"));
	
	StudentDto dto= new StudentDto(syear, sclass, sno, name, kor, eng, mat, total, ave);
	String message="수정이 완료되었습니다";
	int result= dao.updateStudent(dto);
	if(result != 1){
		message="수정에 실패했습니다";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRACK11 이소민</title>

</head>
<body>
<form name= "stu">
	<input type="hidden" name= "t_syear" value="<%=syear%>">
	<input type="hidden" name= "t_sclass" value="<%= sclass%>">
	<input type="hidden" name= "t_sno" value="<%=sno%>">
</form>
<script type="text/javascript">
	alert("<%=message%>");
	stu.method="post";
	stu.action="student_view.jsp";
	stu.submit();
</script>
</body>
</html>