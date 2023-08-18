<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%
	Dao dao = new Dao();	
	String t_no = dao.getMaxNo();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민</title>
</head>

<script type="text/javascript">
	function goSave(){
		if(form1.p_code.value==""){
			alert("제품코드가 입력되지 않았습니다!");
			form1.p_code.focus();
			return;
		}
		if(form1.t_cnt.value==""){
			alert("수량이 입력되지 않았습니다!");
			form1.t_cnt.focus();
			return;
		}
		if(form1.t_date.value==""){
			alert("거래일자가 입력되지 않았습니다!");
			form1.t_date.focus();
			return;
		}
		if(form1.c_code.value=="null"){
			alert("거래처를 선택하세요!");
			return;
		}
		
		form1.method="post";
		form1.action="dbIncomeSave.jsp";
		form1.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다");
		form1.reset();
		form1.p_code.focus();
	}
</script>

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
		<h2>입출고 등록</h2>
		<form name="form1">
			<table>
				<colgroup>
					<col width="35%">
					<col width="65%">
				</colgroup>
				
				<tr>
					<th>입출고 번호</th>
					<td class="input"><input class="text" name="t_no" value="<%=t_no%>" readonly></td>
				</tr>
				<tr>
					<th>제품코드</th>
					<td class="input"><input class="text" name="p_code" value=""></td>
				</tr>
				<tr>
					<th>입출고 구분</th>
					<td class="input">
						<input type="radio" name="t_type" value="I" checked> 입고 
						<input type="radio" name="t_type" value="O"> 출고 
					</td>
				</tr>
				<tr>
					<th>수량</th>
					<td class="input"><input class="text" name="t_cnt" value="" ></td>
				</tr>
				<tr>
					<th>거래일자</th>
					<td class="input"><input class="text" name="t_date" value="" ></td>
				</tr>
				<tr>
					<th>거래처</th>
					<td class="input">
						<select name="c_code">
							<option value="null">거래처명</option>
							<option value="10">서울공장</option>
							<option value="20">울산공장</option>
							<option value="30">부산상사</option>
							<option value="40">광주상사</option>
							<option value="50">대전상사</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="goSave()">입출고 등록</button>
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