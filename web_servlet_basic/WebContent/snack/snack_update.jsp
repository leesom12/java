<%@page import="java.util.ArrayList"%>
<%@page import="dao.SnackDao"%>
<%@page import="dto.SnackDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SnackDao dao = new SnackDao();
	ArrayList<SnackDto> arr= dao.getComapanyList();

	SnackDto dto= (SnackDto)request.getAttribute("t_dto");
	String m_name= dto.getM_name();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	
	<script type="text/javascript">
		function goUpdate(){
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
		<input type="hidden" name="t_p_code" value="<%=dto.getP_code() %>">
		<input type="hidden" name="t_gubun" value="updateSave">
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
								<%=dto.getP_code() %>
							</td>
						</tr>
						<tr>
							<th>제품명</th>
							<td class="th_left">
								<input name="t_p_name" value="<%=dto.getP_name() %>" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>가격</th>
							<td class="th_left">
								<%
									String price= dto.getStrPrice();
									price= price.replaceAll(",", "");
								%>
								<input style="text-align:right;" name="t_price" value="<%=price %>" class="input_100px" type="text">
							</td>
						</tr>
							<tr>
							<th>제조사</th>
							<td class="th_left">
								<select name="t_m_code" class="select">
									<%for(int k=0; k<arr.size(); k++){ %>
										<option value="<%=arr.get(k).getM_code()%>" <%if(m_name.equals(arr.get(k).getM_name()))out.print("selected"); %>>
											<%out.print(arr.get(k).getM_name());%>
										</option>
									<%} %>
									
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='Snack'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



















    