<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	ScoreDao dao = new ScoreDao();
	ArrayList<ScoreListDto> arr = dao.scoreList();
	ScoreListDto dto = dao.year_scoreList();
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
			<li><a href="성적조회.jsp" class="click">성적조회</a></li>
			<li><a href="반별통계.jsp">반별통계</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<h2>학생 성적 조회</h2>
		<table>
			<colgroup>
				<col width="20%">
				<col width="15%">
				<col width="15%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			
			<tr>
				<th>학년-반-번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
			<%for(int i=0;i<arr.size();i++) {%>
				<tr>
					<td><%=arr.get(i).getSyear() %>-<%=arr.get(i).getSclass() %>-<%=arr.get(i).getSno() %></td>
					<td><%=arr.get(i).getSname() %></td>
					<td><%=arr.get(i).getGender() %></td>
					<td><%=arr.get(i).getKor() %></td>
					<td><%=arr.get(i).getEng() %></td>
					<td><%=arr.get(i).getMat() %></td>
					<td><%=arr.get(i).getTotal() %></td>
					<td><%=arr.get(i).getAve() %></td>
				</tr>
			<%} %>		

			
			<tr>
				<td></td>
				<td></td>
				<td>학년총점</td>
				<td><%=dto.getSum_kor() %></td>
				<td><%=dto.getSum_eng() %></td>
				<td><%=dto.getSum_mat() %></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>학년평균</td>
				<td><%=dto.getAve_kor() %></td>
				<td><%=dto.getAve_eng() %></td>
				<td><%=dto.getAve_mat() %></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</section>
	
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>