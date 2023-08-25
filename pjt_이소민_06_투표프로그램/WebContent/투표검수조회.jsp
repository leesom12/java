<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	VoteDao dao = new VoteDao();
	ArrayList<SUb3Dto> arr = dao.getVoteConfirmList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민_지역구의원</title>
<link href="index.css" rel="stylesheet">
</head>
<body>

	<header>
		<h1>(과정형평가 정보처리산업기사)지역구의원 투표프로그램</h1>
	</header>
	<nav>
		<ul>
			<li><a href="후보조회.jsp">후보조회</a></li>
			<li><a href="투표하기.jsp">투표하기</a></li>
			<li><a class="click" href="투표검수조회.jsp">투표검수조회</a></li>
			<li><a href="후보자등수.jsp">후보자등수</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>투표검수조회</h2>
		<form name="form1">
			<table>
				<colgroup>
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
				</colgroup>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<%for(int i=0;i<arr.size();i++) {%>
					<tr>
						<td><%=arr.get(i).getV_name() %></td>
						<td><%=arr.get(i).getV_birth() %></td>
						<td><%=arr.get(i).getV_age() %></td>
						<td><%=arr.get(i).getV_gender() %></td>
						<td><%=arr.get(i).getM_no() %></td>
						<td><%=arr.get(i).getV_time() %></td>
						<td><%=arr.get(i).getV_confirm() %></td>
					</tr>
				<%} %>
			</table>
		</form>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>
	
</body>
</html>