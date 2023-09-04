<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	ArrayList<Sub2Dto> arr = dao.getSaleInfo();
	String totalCost = dao.getTotalCost();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_주유관리</title>
</head>
<body>
	
	<header>
		<h1>(과정평가형 정보처리산업기사)주유소 관리 프로그램 Ver 2020-10</h1>
	</header>
	<nav>
		<ul>
			<li><a href="매출등록.jsp">매출등록</a></li>
			<li><a href="전체매출조회.jsp">전체매출조회</a></li>
			<li><a href="일자별매출통계.jsp">일자별매출통계</a></li>
			<li><a href="index.jsp">홈</a></li>
		</ul>
	</nav>
	<section>
		<h2>전체매출조회</h2>
		<table>
			<colgroup>
				<col width="10%">
				<col width="15%">
				<col width="8%">
				<col width="6%">
				<col width="6%">
				<col width="7.5%">
				<col width="7.5%">
				<col width="15%">
				<col width="15%">
				<col width="10%">
			</colgroup>
			<tr>
				<th>매출번호</th>
				<th>주유일자</th>
				<th>유종</th>
				<th>주유량</th>
				<th>결제방법</th>
				<th>회원성명</th>
				<th>회원번호</th>
				<th>전화번호</th>
				<th>카드번호</th>
				<th>금액</th>
			</tr>
			<%for(Sub2Dto dto : arr) {%>
			<tr>
				<td><%=dto.getSaleno() %></td>
				<td><%=dto.getOildate() %></td>
				<td><%=dto.getOilname() %></td>
				<td><%=dto.getAmount() %></td>
				<td><%=dto.getPaytype() %></td>
				<td><%=dto.getCustname() %></td>
				<td><%=dto.getCustno() %></td>
				<td><%=dto.getCusttel() %></td>
				<td><%=dto.getCreditcart() %></td>
				<td style="text-align: right;"><%=dto.getOilcost() %></td>
			</tr>
			<%} %>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>매출총액</td>
				<td style="text-align: right;"><%=totalCost %></td>
			</tr>

		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2020 All rights reserve. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>