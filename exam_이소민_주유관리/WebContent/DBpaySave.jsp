<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="track.*" %>
<%
	Dao dao = new Dao();
	request.setCharacterEncoding("utf-8");
	
	String saleno = request.getParameter("saleno");
	String oildate = request.getParameter("oildate");
	String oiltype = request.getParameter("oiltype");
	String amount = request.getParameter("amount");
	String paytype = request.getParameter("paytype");
	String custno = request.getParameter("custno");
	String credit1 = request.getParameter("credit1");
	String credit2 = request.getParameter("credit2");
	String credit3 = request.getParameter("credit3");
	String credit4 = request.getParameter("credit4");
	String creditcart = credit1+credit2+credit3+credit4;
	String oilcost = request.getParameter("oilcost");
	
	Sub1Dto dto = new Sub1Dto(saleno, oildate, oiltype, amount, paytype, custno, creditcart, oilcost);
	int result = dao.saveSaleInfo(dto);
	String msg ="매출정보가 정상적으로 등록되었습니다!";
	if(result != 1) msg="등록실패!!";
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