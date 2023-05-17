<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	BookDao dao= new BookDao();
	int no= dao.getRentNo();
%>
<script>
	function check(){
		alert("정보를 지우고 처음부터 다시 입력 합니다");
		rent.p_no.focus();
		return;
	}
	function goSave(){
		if(rent.p_no.value==""){
			alert("회원번호가 입력되지 않았습니다!");
			rent.p_no.focus();
			return;
		}
		if(rent.b_code.value==""){
			alert("도서코드가 입력되지 않았습니다!");
			rent.b_code.focus();
			return;
		}
		if(rent.rent_date.value==""){
			alert("대여일자가 입력되지 않았습니다!");
			rent.rent_date.focus();
			return;
		}
		rent.method="post";
		rent.action="db_rentSave.jsp";
		rent.submit();
	}
</script>

		<section>
			<h3>도서 대여 등록</h3>
	
			<form name="rent" >
				<table>
				<colgroup>
					<col style="width:40%;">
					<col style="width:70%;">
				</colgroup>
					<tr>
						<th>대여번호 (자동발생)</th>
						<td class="text_left"><input type="text" readonly name="b_no" value="<%=no%>"></td>
					</tr>
					<tr>
						<th>회원번호</th>
						<td class="text_left"><input type="text" value="" name="p_no"></td>
					</tr>
					<tr>
						<th>도서코드</th>
						<td class="text_left"><input type="text" value="" name="b_code"></td>
					</tr>
					<tr>
						<th>도서대여일자</th>
						<td class="text_left"><input type="text" value="" name="rent_date"></td>
					</tr>	
					<tr>
						<td colspan="2" class="col2">
							<input type="button" onclick="goSave()" value="등록">
							<input type="reset" onclick="check()"  value="다시쓰기">
						</td>
					</tr>					
				</table>
			</form>
		
		</section>
<%@include file="../common_footer.jsp" %>
	</body>
</html>