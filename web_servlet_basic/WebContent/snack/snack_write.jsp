<%@page import="dto.SnackDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SnackDao dao = new SnackDao();
	ArrayList<SnackDto> arr= dao.getComapanyList();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >		
	<script type="text/javascript">
		function goSave(){
			if(snack.t_p_code.value ==""){
				alert("제품 코드를 입력하세요");
				snack.t_p_code.focus();
				return;
			}
			if(snack.t_p_name.value == ""){
				alert("제품 이름을 입력하세요");
				snack.t_p_name.focus();
				return;
			}
			if(snack.t_price.value==""){
				alert("가격을 입력하세요");
				snack.t_price.focus();
				return;
			}
			
			snack.method="post";
			snack.action="Snack";
			snack.submit();
		}
	</script>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 이소민 SNACK</h1>
		</div>		
		<div class="write_wrap">
			<form name="snack">
			<input type="hidden" name="t_gubun" value="save">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>제품번호</th>
							<td class="th_left">
								<input name="t_p_code" maxlength="4" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>제품명</th>
							<td class="th_left">
								<input name="t_p_name" maxlength="10" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>가격</th>
							<td class="th_left">
								<input name="t_price" maxlength="6" class="input_100px inputRight" type="text">
							</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td class="th_left">
								<select name="t_m_code" class="select">
									<%for(int k=0; k<arr.size(); k++){ %>
										<option value="<%=arr.get(k).getM_code()%>"><%out.print(arr.get(k).getM_name());%></option>
									<%} %>
									
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" value="등록" class="btn_ok" onclick="goSave()">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='Snack'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















    