<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	VoteDao dao = new VoteDao();
	ArrayList<Sub1Dto> arr = dao.getNumberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민_지역구의원</title>
<link href="index.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function goSave(){
		if(form1.v_jumin.value==""){
			alert("주민번호가 입력되지 않았습니다!");
			form1.v_jumin.focus();
			return;
		}
		if(form1.v_name.value==""){
			alert("성명이 입력되지 않았습니다!");
			form1.v_name.focus();
			return;
		}
		if(form1.m_no.value==""){
			alert("후보번호를 선택하세요!");
			form1.m_no.focus();
			return;
		}
		if(form1.v_time.value==""){
			alert("투표시간이 입력되지 않았습니다!");
			form1.v_time.focus();
			return;
		}
		if(form1.v_area.value==""){
			alert("투표장소가 입력되지 않았습니다!");
			form1.v_area.focus();
			return;
		}
		if(form1.v_confirm.value==""){
			alert("유권자확인을 선택하세요!");
			form1.v_confirm.focus();
			return;
		}
		
		form1.method="post";
		form1.action ="DbVoteSave.jsp"
		form1.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다");
		form1.reset();
		form1.v_jumin.focus();
	}
</script>
<body>

	<header>
		<h1>(과정형평가 정보처리산업기사)지역구의원 투표프로그램</h1>
	</header>
	<nav>
		<ul>
			<li><a href="후보조회.jsp">후보조회</a></li>
			<li><a class="click" href="투표하기.jsp">투표하기</a></li>
			<li><a href="투표검수조회.jsp">투표검수조회</a></li>
			<li><a href="후보자등수.jsp">후보자등수</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>투표하기</h2>
		<form name="form1">
			<table class="save">
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<tr>
					<th>주민번호</th>
					<td class="input"><input type="text" name="v_jumin" value="">예)9901011000001</td>
				</tr>
				<tr>
					<th>성명</th>
					<td class="input"><input type="text" name="v_name" value=""></td>
				</tr>
				<tr>
					<th>후보번호</th>
					<td class="input">
						<select name="m_no">
							<option value="">후보번호</option>
							<%for(int i=0;i<arr.size();i++) {%>
								<option value="<%=arr.get(i).getM_no() %>">[<%=arr.get(i).getM_no() %>]<%=arr.get(i).getM_name() %></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr>
					<th>투표시간</th>
					<td class="input"><input type="text" name="v_time" value=""></td>
				</tr>
				<tr>
					<th>투표장소</th>
					<td class="input"><input type="text" name="v_area" value=""></td>
				</tr>
				<tr>
					<th>유권자확인</th>
					<td style="text-align: left;">
						<input type="radio" name="v_confirm" value="Y"> 확인
						<input type="radio" name="v_confirm" value="N"> 미확인
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="goSave()">투표하기</button>
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