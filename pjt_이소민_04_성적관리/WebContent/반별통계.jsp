<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	ScoreDao dao = new ScoreDao();
	ArrayList<DeptDto> arr = dao.deptScoreList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민_성적관리</title>
<link href="index.css" rel="stylesheet">
</head>
<body>

	<header>
		<h1>(과정평가형 정보처리산업기사)고교성적관리 프로그램 ver2019-06</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="학생등록.jsp">학생등록</a></li>
			<li><a href="성적입력.jsp">성적입력</a></li>
			<li><a href="성적조회.jsp">성적조회</a></li>
			<li><a href="반별통계.jsp" class="click">반별통계</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<h2>반별통계</h2>
		<table>
			<colgroup>
				<col width="4.5%">
				<col width="4.5%">
				<col width="9%">
				<col width="12%">
				<col width="12%">
				<col width="12%">
				<col width="12%">
				<col width="12%">
				<col width="12%">
			</colgroup>
			
			<tr>
				<th>학년</th>
				<th>반</th>
				<th>교사명</th>
				<th>국어총점</th>
				<th>영어총점</th>
				<th>수학총점</th>
				<th>국어평균</th>
				<th>영어평균</th>
				<th>수학평균</th>
			</tr>
			<%for(int i=0;i<arr.size();i++) {%>
				<tr>
					<td><%=arr.get(i).getSyear() %></td>
					<td><%=arr.get(i).getSclass() %></td>
					<td><%=arr.get(i).getTname() %></td>
					<td><%=arr.get(i).getSum_kor() %></td>
					<td><%=arr.get(i).getSum_eng() %></td>
					<td><%=arr.get(i).getSum_mat() %></td>
					<td><%=arr.get(i).getAve_kor() %></td>
					<td><%=arr.get(i).getAve_eng() %></td>
					<td><%=arr.get(i).getAve_mat() %></td>
				</tr>
			<%} %>
		</table>
	</section>
	
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>