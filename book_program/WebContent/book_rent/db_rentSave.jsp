<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	BookDao dao= new BookDao();
	String msg="도서대여 정보가 정상적으로 등록되었습니다!";
	String url="index.jsp";
	
	String no1= request.getParameter("b_no");
	int no= Integer.parseInt(no1);
	String p_no= request.getParameter("p_no");
	int p_count= dao.checkPNo(p_no);
	if(p_count == 0){
		msg="존재하지 않는 회원번호 입니다";
		url="rent_save.jsp";
	}
	String code= request.getParameter("b_code");
	int b_count= dao.checkBCode(code);
	if(b_count == 0){
		msg="존재하지 않는 도서번호 입니다";
		url="rent_save.jsp";
	}
	String rent_date= request.getParameter("rent_date");
	
	BookDto dto= new BookDto(no, p_no, code, rent_date);
	int result= dao.rentSave(dto);
	if(result != 1) msg="등록 실패. 관리자에 문의 요망.";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
</head>
<body>

</body>
</html>