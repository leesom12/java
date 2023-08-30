<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	String empno = request.getParameter("empno");
	ArrayList<Sub2Dto> arr = dao.getContractList(empno);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_자율좌석</title>
</head>
<script type="text/javascript">
	function goBack(){
		history.back();
	}
</script>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)자율좌석예약 프로그램 ver 2021-08</h1>
	</header>
	<nav>
		<ul>
			<li><a href="근무좌석예약.jsp">근무좌석예약</a></li>
			<li><a href="좌석예약조회.jsp">좌석예약조회</a></li>
			<li><a href="근무일수집계.jsp">근무일수집계</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<%if(arr.size() > 0) {%>
		<h2>사원번호: <%=empno %>님의 좌석예약조회</h2>
		<table>
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="30%">
				<col width="10%">
				<col width="15%">
				<col width="15%">
			</colgroup>
	
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>근무일자</th>
				<th>좌석번호</th>
				<th>좌석위치</th>
				<th>내선번호</th>
			</tr>
			<%for(Sub2Dto dto : arr) {%>
			<tr>
				<td><%=dto.getEmpno() %></td>
				<td><%=dto.getEmpname() %></td>
				<td><%=dto.getResvdate() %></td>
				<td><%=dto.getSeatno() %></td>
				<td><%=dto.getOffice() %></td>
				<td><%=dto.getCallno() %></td>
			</tr>
			<%} %>
			<tr>
				<td colspan="6">
					<button onclick="goBack()">돌아가기</button>
				</td>
			</tr>
			<%}else{ %>
				<h2>좌석예약정보가 존재하지 않습니다!</h2>
				<div style="width: 100px;margin: 0 auto;"><button onclick="goBack()">돌아가기</button></div>
			<%} %>
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2021 All Rights reserved. Human Development Service of Korea.</h4>
	</footer>
</body>
</html>