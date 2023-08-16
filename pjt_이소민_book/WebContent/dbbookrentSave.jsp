<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%
	BookDao dao = new BookDao();

	String p_rentno = request.getParameter("t_rentNo");
	String p_no = request.getParameter("t_memNo");
	String b_code = request.getParameter("t_bookCode");
	String p_s_date = request.getParameter("t_rentDate");
	
	BookDto dto = new BookDto(p_no, p_rentno, b_code, p_s_date, "");
	int result = dao.bookrentSave(dto);
	
	String msg="";
	if(result ==1) msg="도서대여 정보가 정상적으로 등록되었습니다!";
	else msg="등록 실패";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="index.jsp";
</script>
<body>

</body>
</html>