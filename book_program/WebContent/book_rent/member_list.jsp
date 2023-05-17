<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@page import="dao.*, dto.*" %>
<%
request.setCharacterEncoding("UTF-8");
	MemberDao dao= new MemberDao();
	ArrayList<MemberDto> arr= dao.memberList();
%>
		<section>
			<h3>회원 조회</h3>
	
			<form name="member" >
				<table>
				<colgroup>
					<col style="width:10%;">
					<col style="width:10%;">
					<col style="width:20%;">
					<col style="width:10%;">
					<col style="width:20%;">
					<col style="width:20%;">
				</colgroup>
					<tr>
						<th>회원번호</th>
						<th>회원명</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>회원가입일</th>
					</tr>
					<%for(int k=0; k<arr.size(); k++) {%>
						<tr>
							<td><%=arr.get(k).getNo() %></td>
							<td><%=arr.get(k).getName() %></td>
							<td><%=arr.get(k).getBirth() %></td>
							<td><%=arr.get(k).getGender() %></td>
							<td><%=arr.get(k).getTell() %></td>
							<td><%=arr.get(k).getReg_date() %></td>
						</tr>
					<%} %>					
				</table>
			</form>
		
		</section>
<%@include file="../common_footer.jsp" %>
	</body>
</html>