<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%
	Dao dao = new Dao();
	ArrayList<Dto> arr = dao.getIncomingList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민</title>
</head>
<body>

	<header>
		<h1>(과정평가형 정보처리산업기사)물류창고 입출고 프로그램  ver2020-02</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="productList.jsp">제품조회</a></li>
			<li><a href="incomingSave.jsp">입출고 등록</a></li>
			<li><a href="incomingList.jsp">입출고 내역조회</a></li>
			<li><a href="salesProfit.jsp">출고매출 이익</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<h2>입출고 내역 조회</h2>
		<table>
			<colgroup>
				<col width="20%">
				<col width="10%">
				<col width="20%">
				<col width="15%">
				<col width="10%">
				<col width="10%">
				<col width="15%">
			</colgroup>
			
			<tr>
				<th>입출고번호</th>
				<th>제품코드</th>
				<th>제품명</th>
				<th>입출고구분</th>
				<th>수량</th>
				<th>거래처</th>
				<th>거래일자</th>
			</tr>
			<%for(int i=0; i<arr.size(); i++) {%>
				<tr>
					<td><%=arr.get(i).getT_no() %></td>
					<td><%=arr.get(i).getP_code() %></td>
					<td><%=arr.get(i).getP_name() %></td>
					<td><%=arr.get(i).getT_type() %></td>
					<td><%=arr.get(i).getT_cnt() %></td>
					<td><%=arr.get(i).getC_name() %></td>
					<td><%=arr.get(i).getT_date() %></td>
				</tr>		
			<%} %>	
		</table>
	</section>
	
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>