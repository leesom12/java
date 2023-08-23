<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
 <%
 	AuditionDao dao = new AuditionDao();
 	ArrayList<AuditionDto> arr = dao.getMemberCheck();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민 오디션</title>
<link href="index.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function goSave(){
		if(audition.artist_id.value==""){
			alert("참가번호를 선택하세요!");
			return;
		}
		if(audition.men_1.value==""){
			alert("함멘토 점수를 입력하세요!");
			audition.men_1.focus();
			return;
		}
		if(audition.men_2.value==""){
			alert("박멘토 점수를 입력하세요!");
			audition.men_2.focus();
			return;
		}
		if(audition.men_3.value==""){
			alert("장멘토 점수를 입력하세요!");
			audition.men_3.focus();
			return;
		}
		audition.method="post";
		audition.action="DbMentoSave.jsp";
		audition.submit();
	}
	
	
	function goReset(){
		alert("모든 정보를 지우고 다시 시작합니다");
		audition.reset();
		
	}
</script>
<body>

	<header>
		<h1>(과정평가형 정보처리산업기사)오디션 관리</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="오디션등록.jsp">오디션등록</a></li>
			<li><a href="참가자목록조회.jsp">참가자목록조회</a></li>
			<li><a href="멘토점수등록.jsp" class="click">멘토점수등록</a></li>
			<li><a href="멘토점수조회.jsp">멘토점수조회</a></li>
			<li><a href="참가자등수조회.jsp">참가자등수조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<h2>멘토 점수 등록</h2>
		<form name="audition">
		<table>
			<colgroup>
				<col style="width:30%">
				<col style="width:70%">
			</colgroup>
			<tr>
				<th>참가번호</th>
				<td class="input">
					<select name="artist_id">
						<option value="">==참가자선택==</option>
						<%for(int i=0;i<arr.size();i++) {%>
							<option value="<%=arr.get(i).getArtist_id()%>"><%=arr.get(i).getArtist_id()%></option>
						<%} %>
					</select>
				</td>
			</tr>

			<tr>
				<th>함멘토 점수</th>
				<td class="input"><input type="text" name="men_1" value=""></td>
			</tr>

			<tr>
				<th>박멘토 점수</th>
				<td class="input"><input type="text" name="men_2" value=""></td>
			</tr>

			<tr>
				<th>장멘토 점수</th>
				<td class="input"><input type="text" name="men_3" value=""></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="goSave()">점수등록</button>
					<button type="button" onclick="goReset()">다시쓰기</button>
				</td>
			</tr>
		</table>
		</form>
	</section>
	
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>









