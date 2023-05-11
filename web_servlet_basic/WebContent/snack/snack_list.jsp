<%@page import="dto.SnackDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<SnackDto> arr= (ArrayList<SnackDto>)request.getAttribute("t_arr");
	String select= (String)request.getAttribute("t_select");
	String search= (String)request.getAttribute("t_search");
	
	ArrayList<SnackDto> com = (ArrayList<SnackDto>)request.getAttribute("t_company");
	String company = (String)request.getAttribute("t_companyRadio");
	
%>
<!DOCTYPE html>

<html> 
<head>

<script type="text/javascript">
	function goSearch(){
		snack.method="post";
		snack.action="Snack";
		snack.submit();
	}
	
	function goView(p_code){
		Box.t_p_code.value=p_code;
		Box.t_gubun.value="view";
		Box.method="post";
		Box.action="Snack";
		Box.submit();
	}
	
	function goWrite(){
		Box.t_gubun.value="write";
		Box.method="post";
		Box.action="Snack";
		Box.submit();
	}
</script>
<form name="Box">
	<input type="hidden" name="t_p_code">
	<input type= "hidden" name="t_gubun">
</form>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 이소민</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 이소민 SNACK</h1>
		</div>		
		<form name="snack">
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span><%=arr.size() %></span>건</p>
			</div>			
			
			<div class="search_group">
				<select class="select" name="t_select">
					<option value="h.p_code" >제품번호</option>
					<option value="h.p_name"  <%if(select.equals("h.p_name")) out.print("selected"); %>>제품명</option>
				</select>
				<input type="text" class="search_word" value="<%=search%>" name="t_search">
				<button onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
				<div style="height:10px;"></div>
				<div >
					<label><input type="radio" name="t_company" value="" OnClick="goSearch()" checked>전체</label>&nbsp;
					<%for(SnackDto dto : com){%>
					<label><input type="radio" name="t_company" value="<%=dto.getM_code()%>" OnClick="goSearch()" 
						<%if(company.equals(dto.getM_code())) out.print("checked"); %>>
						<%=dto.getM_name()%>
					</label>
					&nbsp;
					<%} %>
				</div>
				
			</div>
				
		</div>
			
		</form>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>제품번호</th>
					<th>제품명</th>
					<th>제조사명</th>
					<th>가격</th>
				</tr>
			</thead>
			
			<tbody>
			<%for(SnackDto dto : arr) {%>	
				<tr>
					<td><a href="javascript:goView('<%=dto.getP_code() %>')"><%=dto.getP_code() %></a></td>
					<td><a href="javascript:goView('<%=dto.getP_code() %>')"><%=dto.getP_name() %></a></td>
					<td><%=dto.getM_name() %></td>
					<td><%=dto.getStrPrice() %></td>
				</tr>	
			<%} %>
			</tbody>
		</table>
		<div class="paging">
			<a href="javascript:goWrite()" class="write">제품등록</a>
		</div>
	</div>
 </body>
</html>







    