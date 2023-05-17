<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.*, dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	SnackDao dao= new SnackDao();
	String p_code= request.getParameter("t_p_code");
	String p_name= request.getParameter("t_p_name");
	String price= request.getParameter("t_price");
	int price2= Integer.parseInt(price);
	String m_code= request.getParameter("t_m_code");
	
	int result=0;
	String message= "등록이 완료되었습니다";
	int check= dao.checkPCode(p_code);
	if(check == 0){
		SnackDto dto= new SnackDto(p_code, p_name, m_code, price2);
		result= dao.snackSave(dto);
		if(result != 1) message="등록에 실패했습니다";
	}else{
		message="이미 존재하는 코드입니다";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("<%=message%>");
	if(<%=result%>!=1){
		//location.href="snack_write.jsp";
		window.history.back();
	}else{
		location.href="snack_list.jsp";
	}
	
</script>
</head>
<body>

</body>
</html>