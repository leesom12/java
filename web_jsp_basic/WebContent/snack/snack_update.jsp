<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*" %>
<%
	SnackDao dao= new SnackDao();
	String p_code=request.getParameter("t_p_code");
	SnackDto dto= dao.snackSearch(p_code);
	ArrayList<SnackDto> arr= dao.getComapanyList();
	
	String m_name= dto.getM_name();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdate(){
			if(snack.t_p_name.value==""){
				alert("제품명을 입력하세요");
				snack.t_p_name.focus();
				return;
			}
			
			if(snack.t_price.value==""){
				alert("제품 가격을 입력하세요");
				snack.t_price.focus();
				return;
			}
			
			var price= snack.t_price.value;
			var newPrice= price.replaceAll(",","");
			snack.t_price.value= newPrice;
			
			snack.method="post";
			snack.action="db_snack_update.jsp";
			snack.submit();
		}
	</script>

</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<a href="snack_list.jsp"><img src="../images/jsl_logo.png"></a><h1>TRACK11 이소민 SNACK</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<form name="snack">
						<input name="t_p_code" value="<%=dto.getP_code() %>" type="hidden">
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
									<input name="t_price" value="<%=dto.getStrPrice()%>" class="input_100px" style="text-align:right;" type="text">
								</td>
							</tr>
							<tr>
								<th>제조사</th>
								<td class="th_left">
									<select name="t_m_code"  class="select">
										<%for(int k=0; k<arr.size(); k++) {%>
											<option value="<%=arr.get(k).getM_code()%>" <%if(m_name.equals(arr.get(k).getM_name()))out.print("selected"); %>> <%=arr.get(k).getM_name() %> </option>
										<%} %>
									</select>								
								</td>
							</tr>
						</tbody>
					</form>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='snack_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>


