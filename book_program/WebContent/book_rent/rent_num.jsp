<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	BookDao dao = new BookDao();
	ArrayList<BookDto> arr= dao.bookList();
%>
	
		<section>
			<h3> 도서별 대여 건수</h3>
	
			<form name="member" >
				<table>
				<colgroup>
					<col style="width:10%;">
					<col style="width:40%;">
					<col style="width:20%;">
					<col style="width:20%;">
				</colgroup>
					<tr>
						<th>도서코드</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>대여건수</th>
					</tr>
					<%for(int k=0; k<arr.size(); k++) {%>
						<tr>
							<td><%=arr.get(k).getCode() %></td>
							<td><%=arr.get(k).getB_name() %></td>
							<td><%=arr.get(k).getPublisher() %></td>
							<td><%=dao.getRentNum(arr.get(k).getCode()) %></td>
						</tr>
					<%} %>
				</table>
			</form>
		
		</section>
<%@include file="../common_footer.jsp" %>
	</body>
</html>