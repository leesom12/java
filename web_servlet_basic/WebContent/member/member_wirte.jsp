<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="/web_servlet_basic/css/common.css" rel="stylesheet">
	<link href="/web_servlet_basic/css/layout.css" rel="stylesheet" >		
	
	<script type="text/javascript">
		function goSave(){
			if(mem.t_id.value==""){
				alert("아이디 입력");
				mem.t_id.focus();
				return;
			}
			if(mem.t_name.value==""){
				alert("이름 입력");
				mem.t_name.focus();
				return;
			}
			if(mem.t_reg_date.value==""){
				alert("가입일 입력");
				return;
			}
			
			mem.method="post"; 		// post(눈에 보이지 않게 넘김), get(url 주소에 보여주면서 넘김) 두 가지만 존재
			mem.action="Member";
			mem.submit();
		};

	</script>

</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<a href="member_list.jsp"><img src="/web_servlet_basic/images/jsl_logo.png"></a><h1>TRACK11 이소민 회원관리</h1>
		</div>		
		<div class="write_wrap">
			<form name="mem">
			<input type="hidden" name="t_gubun" value="memberSave">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>ID</th>
							<td class="th_left">
								<input name="t_id"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name"  class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<input name="t_age"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="th_left">
								<input name="t_reg_date"  class="input_200px" type="date">							
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" value="등록" onclick="goSave()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='Member'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>


