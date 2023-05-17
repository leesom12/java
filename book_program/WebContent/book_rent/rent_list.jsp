<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	BookDao dao = new BookDao();
	ArrayList<BookDto> arr= dao.rentList();
%>
		<section>
			<h3> 도서 대여 이력 조회</h3>
	
			<form name="member" >
				<table>
				<colgroup>
					<col style="width:10%;">
					<col style="width:15%;">
					<col style="width:40%;">
					<col style="width:10%;">
					<col style="width:10%;">
				</colgroup>
					<tr>
						<th>대여번호</th>
						<th>회원명</th>
						<th>도서명</th>
						<th>대여일자</th>
						<th>반납일자</th>
					</tr>
					<%for(int k=0; k<arr.size(); k++) {%>
						<tr>
							<td><%=arr.get(k).getNo() %></td>
							<td>[<%=arr.get(k).getP_no() %>]<%=arr.get(k).getP_name() %></td>
							<td>[<%=arr.get(k).getCode() %>]<%=arr.get(k).getB_name() %></td>
							<td><%=arr.get(k).getRent_date() %></td>
							<td><%=arr.get(k).getReturn_date() %></td>
						</tr>
					<%} %>
				</table>
			</form>
		
		</section>
<%@include file="../common_footer.jsp" %>
	</body>
</html>