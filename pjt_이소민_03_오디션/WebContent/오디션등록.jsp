<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			alert("참가번호가 입력되지 않았습니다.");
			audition.artist_id.focus();
			return;
		}
		if(audition.artist_name.value==""){
			alert("참가자명이 입력되지 않았습니다.");
			audition.artist_name.focus();
			return;
		}
		if(audition.birth_1.value==""){
			alert("생년월일이 입력되지 않았습니다.");
			audition.birth_1.focus();
			return;
		}
		if(audition.birth_2.value==""){
			alert("생년월일이 입력되지 않았습니다.");
			audition.birth_2.focus();
			return;
		}
		if(audition.birth_3.value==""){
			alert("생년월일이 입력되지 않았습니다.");
			audition.birth_3.focus();
			return;
		}
		if(audition.artist_gender.value==""){
			alert("성별이 선택되지 않았습니다.");
			audition.artist_gender.focus();
			return;
		}
		if(audition.talent.value==""){
			alert("특기가 선택되지 않았습니다.");
			audition.talent.focus();
			return;
		}
		if(audition.agency.value==""){
			alert("소속사가 입력되지 않았습니다.");
			audition.agency.focus();
			return;
		}
		
		audition.method="post";
		audition.action="DBauditionSave.jsp";
		audition.submit();
		
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다");
		audition.reset();
		audition.artist_id.focus();
	}
</script>
<body>

	<header>
		<h1>(과정평가형 정보처리산업기사)오디션 관리</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="오디션등록.jsp" class="click">오디션등록</a></li>
			<li><a href="참가자목록조회.jsp">참가자목록조회</a></li>
			<li><a href="멘토점수등록.jsp">멘토점수등록</a></li>
			<li><a href="멘토점수조회.jsp">멘토점수조회</a></li>
			<li><a href="참가자등수조회.jsp">참가자등수조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<h2>오디션 등록</h2>
		<form name="audition">
		<table>
			<colgroup>
				<col style="width:30%">
				<col style="width:70%">
			</colgroup>
			<tr>
				<th>참가번호</th>
				<td class="input"><input type="text" name="artist_id" value="">*참가번호는 (A000) 4자리입니다.</td>
			</tr>
			<tr>
				<th>참가자명</th>
				<td class="input"><input type="text" name="artist_name" value=""></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td class="birth">
					<input type="text" name="birth_1" value="" size="10">년
					<input type="text" name="birth_2" value="" size="10">월
					<input type="text" name="birth_3" value="" size="10">일
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td class="input">
					<input class="radio" type="radio" name="artist_gender" value="M">남성
					<input class="radio" type="radio" name="artist_gender" value="F">여성
				</td>
			</tr>
			<tr>
				<th>특기</th>
				<td class="input">
					<select name="talent">
						<option value="1">댄스</option>
						<option value="2">랩</option>
						<option value="3">노래</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>소속사</th>
				<td class="input"><input type="text" name="agency" value=""></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="goSave()">오디션등록</button>
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









