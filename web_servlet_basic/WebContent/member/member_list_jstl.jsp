<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	
	<script type="text/javascript">
		function goSearch(){
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}
		
		function goView(id){
			Form.t_id.value=id;
			Form.t_gubun.value="view";
			Form.method="post";
			Form.action="Member";
			Form.submit();
		}
		
		function goWirte(){
			Form.t_gubun.value="writeForm";
			Form.method="post";
			Form.action="/web_servlet_basic/Member";
			Form.submit();
		}
	</script>
	
</head>
<body>
<form name="Form">
	<input type="hidden" name="t_id">
	<input type="hidden" name="t_gubun">
</form>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 홍길동 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span>${t_arr.size() }</span>건</p>
			</div>
			<form name="mem">
			<div class="search_group">
				<select class="select" name="t_select">
					<option value="id" >ID</option>
					<option value="name" <c:if test="${t_select eq 'name' }">selected</c:if> >성명</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="${t_search }">
				<button onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>
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
					<th>ID</th>
					<th>성명</th>
					<th>나이</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${t_arr }" var="arr">
					<tr>
						<td><a href="javascript:goView('${arr.getId() }')">${arr.getId() }</a></td>
						<td><a href="javascript:goView('${arr.getId() }')">${arr.getName() }</a></td>
						<td>${arr.getAge() }</td>
						<td>${arr.getReg_Date() }</td>					
					</tr>	
				</c:forEach>
			
			</tbody>
		</table>
		<div class="paging">
			<a href="javascript:goWirte()" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>







    