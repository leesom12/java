<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민_올림픽</title>
<link href="index.css" rel="stylesheet">
</head>

<script type="text/javascript">
	function goSave(){
		if(olympic.player_no.value==""){
			alert("선수번호가 입력되지 않았습니다.");
			olympic.player_no.focus();
			return;
		}
		if(olympic.point_1.value==""){
			alert("심사위원 1 점수가 입력되지 않았습니다.");
			olympic.point_1.focus();
			return;
		}
		if(olympic.point_2.value==""){
			alert("심사위원 2 점수가 입력되지 않았습니다.");
			olympic.point_2.focus();
			return;
		}
		if(olympic.point_3.value==""){
			alert("심사위원 3 점수가 입력되지 않았습니다.");
			olympic.point_3.focus();
			return;
		}
		if(olympic.point_4.value==""){
			alert("심사위원 4 점수가 입력되지 않았습니다.");
			olympic.point_4.focus();
			return;
		}
		
		olympic.method="post";
		olympic.action="DbPointSave.jsp";
		olympic.submit();
	}
	
	function goUpdate(){
		if(olympic.player_no.value==""){
			alert("선수번호가 입력되지 않았습니다.");
			olympic.player_no.focus();
			return;
		}
		if(olympic.point_1.value==""){
			alert("심사위원 1 점수가 입력되지 않았습니다.");
			olympic.point_1.focus();
			return;
		}
		if(olympic.point_2.value==""){
			alert("심사위원 2 점수가 입력되지 않았습니다.");
			olympic.point_2.focus();
			return;
		}
		if(olympic.point_3.value==""){
			alert("심사위원 3 점수가 입력되지 않았습니다.");
			olympic.point_3.focus();
			return;
		}
		if(olympic.point_4.value==""){
			alert("심사위원 4 점수가 입력되지 않았습니다.");
			olympic.point_4.focus();
			return;
		}
		
		olympic.method="post";
		olympic.action="DbPointUpdate.jsp";
		olympic.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다");
		olympic.reset();
		olympic.player_no.focus();
	}
</script>


<body>

	<header>
		<h1>(과정평가형정보처리산업기사)올림픽 체조경기 관리 프로그램 ver2021-08</h1>
	</header>
	<nav>
		<ul>
			<li><a href="참가자목록조회.jsp">참가자목록조회</a></li>
			<li><a href="심사점수등록.jsp">심사점수등록</a></li>
			<li><a href="심사점수조회.jsp">심사점수조회</a></li>
			<li><a href="참가자등수조회.jsp">참가자등수조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>심사점수 등록</h2>
		<form name="olympic">
			<table>
				<colgroup>
					<col width="35%">
					<col width="65%">
				</colgroup>
				<tr>
					<th>선수번호</th>
					<td class="input"><input type="text" name="player_no" value=""></td>
				</tr>
				<tr>
					<th>심사위원1</th>
					<td class="input"><input type="text" name="point_1" value="">최소 1, 최대 10</td>
				</tr>
				<tr>
					<th>심사위원2</th>
					<td class="input"><input type="text" name="point_2" value="">최소 1, 최대 10</td>
				</tr>
				<tr>
					<th>심사위원3</th>
					<td class="input"><input type="text" name="point_3" value="">최소 1, 최대 10</td>
				</tr>
				<tr>
					<th>심사위원4</th>
					<td class="input"><input type="text" name="point_4" value="">최소 1, 최대 10</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="goSave()">등록</button>
						<button type="button" onclick="goUpdate()">수정</button>
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