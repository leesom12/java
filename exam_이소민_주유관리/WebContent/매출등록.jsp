<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_주유관리</title>
</head>

<script type="text/javascript">
	function goSave(){
		if(oil.saleno.value==""){
			alert("매출번호가 입력되지 않았습니다!");
			oil.saleno.focus();
			return;
		}
		if(oil.oildate.value==""){
			alert("주유일자가 입력되지 않았습니다!");
			oil.oildate.focus();
			return;
		}
		if(oil.oiltype.value==""){
			alert("유종이 선택되지 않았습니다!");
			oil.oiltype.focus();
			return;
		}
		if(oil.amount.value==""){
			alert("주유량이 입력되지 않았습니다!");
			oil.amount.focus();
			return;
		}
		if(oil.paytype.value==""){
			alert("결제방법이 입력되지 않았습니다!");
			oil.paytype.focus();
			return;
		}
		if(oil.oilcost.value==""){
			alert("금액이 입력되지 않았습니다!");
			oil.oilcost.focus();
			return;
		}
		
		oil.method="post";
		oil.action="DBpaySave.jsp";
		oil.submit();

	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다.");
		oil.reset();
		oil.saleno.focus();
	}
</script>

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
		<h2>매출등록</h2>
		<table class="save">
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>
			<form name="oil">
				<tr>
					<th>매출번호</th>
					<td><input name="saleno" value=""> &nbsp; 예)9001</td>
				</tr>
				<tr>
					<th>주유일자</th>
					<td><input name="oildate" value=""> &nbsp; 예)20201001</td>
				</tr>
				<tr>
					<th>유종</th>
					<td>
						<select name="oiltype">
							<option value="">유종선택</option>
							<option value="1">[1]휘발유</option>
							<option value="2">[2]고급휘발유</option>
							<option value="3">[3]경유</option>
							<option value="4">[4]등유</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>주유량</th>
					<td><input name="amount" value=""> &nbsp;리터</td>
				</tr>
				<tr>
					<th>결제방법</th>
					<td><input name="paytype" value=""> &nbsp; (1:현금/2:카드)</td>
				</tr>
				<tr>
					<th>고객번호</th>
					<td><input name="custno" value=""></td>
				</tr>
				<tr>
					<th>카드번호</th>
					<td>
						<input size="5" name="credit1" value=""> &nbsp; - &nbsp; 
						<input size="5" name="credit2" value=""> &nbsp; - &nbsp;
						<input size="5" name="credit3" value=""> &nbsp; - &nbsp;
						<input size="5" name="credit4" value="">
					</td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input name="oilcost" value=""> </td>
				</tr>
			</form>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button onclick="goSave()">결제</button>
					<button onclick="goReset()">다시쓰기</button>
				</td>
			</tr>
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2020 All rights reserve. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>