<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	String entry_no = request.getParameter("entry_no");
	Sub2Dto dto = dao.getResult(entry_no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_국악경연</title>
</head>

<script type="text/javascript">
	function goBack(){
		history.back();
	}
</script>

<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)국악경연프로그램 ver 2021-06</h1>
	</header>
	<nav>
		<ul>
			<li><a href="경연점수등록.jsp">경연점수등록</a></li>
			<li><a href="경연결과조회.jsp">경연결과조회</a></li>
			<li><a href="최종등수조회.jsp">최종등수조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		
		<%if(dto!=null) {%>
		<h2>참가번호: <%=dto.getEntry_no() %>님의 경연결과조회</h2>
		<table>
			<colgroup>
				<col width="40%">
				<col width="60%">
			</colgroup>
			<form name="tbl">
			<tr>
				<th>참가번호</th>
				<td><%=dto.getEntry_no() %></td>
			</tr>
			<tr>
				<th>성명</th>
				<td><%=dto.getEntry_name() %>(<%=dto.getEntry_gender() %>)</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><%=dto.getEntry_birth() %></td>
			</tr>
			<tr>
				<th>참가부분</th>
				<td><%=dto.getEntry_type() %></td>
			</tr>
			<tr>
				<th>지역</th>
				<td><%=dto.getEntry_area() %></td>
			</tr>
			<tr>
				<th>김심사</th>
				<td><%=dto.getScore1() %></td>
			</tr>
			<tr>
				<th>이심사</th>
				<td><%=dto.getScore2() %></td>
			</tr>
			<tr>
				<th>박심사</th>
				<td><%=dto.getScore3() %></td>
			</tr>
			<tr>
				<th>황심사</th>
				<td><%=dto.getScore4() %></td>
			</tr>
			<tr>
				<th>조심사</th>
				<td><%=dto.getScore5() %></td>
			</tr>
			<tr>
				<th>총점</th>
				<td><%=dto.getS_tot() %></td>
			</tr>
			<tr>
				<th>평균</th>
				<td><%=dto.getS_ave() %></td>
			</tr>
			</form>
			<tr>
				<td colspan="2">
					<button onclick="goBack()">돌아가기</button>
				</td>
			</tr>
		</table>
		<%} else{%>
			<h2>경연점수가 존재하지 않습니다!</h2>
			<div style="width:100px;margin:0 auto;"><button onclick="goBack()">돌아가기</button></div>
		<%} %>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2021 All Rights reserved. Human Development Service of Korea.</h4>
	</footer>
</body>
</html>