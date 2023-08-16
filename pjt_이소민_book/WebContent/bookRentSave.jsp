<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%
	BookDao dao = new BookDao();
	String rentNo = dao.getRentNo();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="Index.css" rel="stylesheet">
<title>이소민</title>
</head>
<script type="text/javascript">
	function goSave(){
		if(book.t_memNo.value==""){
			alert("회원번호가 입력되지 않았습니다!");
			book.t_memNo.focus();
			return;
		}
		if(book.t_bookCode.value==""){
			alert("도서코드가 입력되지 않았습니다!");
			book.t_bookCode.focus();
			return;
		}
		if(book.t_rentDate.value==""){
			alert("대여일자가 입력되지 않았습니다!");
			book.t_rentDate.focus();
			return;
		}
		
		book.method="post";
		book.action="dbbookrentSave.jsp";
		book.submit();
	}
	
	function Reset(){
		alert("정보를 지우고 처음부터 다시 입력합니다!");
		book.reset();
		book.t_memNo.focus();
	}
</script>
<body>
	<header>
		<h1>(과정평가형정보처리산업기사)도서대여 프로그램</h1>
	</header>
	<nav>
		<ul>
			<li><a href="memberList.jsp">회원조회</a></li>
			<li><a href="bookRentSave.jsp">도서대여등록</a></li>
			<li><a href="bookRentlist.jsp">대여이력조회</a></li>
			<li><a href="bookRentCount.jsp">도서대여건수</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>도서 대여 등록</h2>
		<form name="book">
			<table>
				<colgroup>
					<col style="width: 30%;">
					<col style="width: 70%;">
				</colgroup>
				<tr>
					<th>대여번호(자동발생)</th>
					<td class="input_td"><input name="t_rentNo" value="<%=rentNo%>" readonly></td>
				</tr>
				<tr>
					<th>회원번호</th>
					<td class="input_td"><input name="t_memNo" value=""></td>
				</tr>
				<tr>
					<th>도서코드</th>
					<td class="input_td"><input name="t_bookCode" value=""></td>
				</tr>
				<tr>
					<th>도서대여일자</th>
					<td class="input_td"><input name="t_rentDate" value=""></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="goSave()">등록</button>
						<button type="button" onclick="Reset()">다시쓰기</button>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
		<p>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</p>
	</footer>
</body>
</html>