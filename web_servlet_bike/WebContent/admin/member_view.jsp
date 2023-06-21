<%@page import="dao.MemberDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>


<style type="text/css">
	input[type="checkbox"][disabled] {
    	background-color: #0101DF;
	}
</style>
	<div id="b_left">
		<P>Admin</P>
		<ul>
			<li><a href="Admin">
				<span class="fnt"><i class="fas fa-apple-alt"></i></span>
				MEMBER
			</a></li>
			<li><a href="">
				PRODUCT
			</a></li>
		</ul>
	</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER INFORMATION
			</p>
		

			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${t_dto.getId()} </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td>${t_dto.getName()}</td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td><c:forEach begin="1" end="${t_dto.getPass_length() }">*</c:forEach></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					${t_dto.getArea()}
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td>${t_dto.getAddress()}</td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					${t_dto.getMobile()}
				  </td>
				</tr>
				<tr>
				  <th>성별</th>
				  <td>
					  ${t_dto.getGender()}
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					 <input id="check1" type="checkbox" value="" name="t_travel" class="middleCheck" disabled 
					    <c:if test="${t_dto.getH_travel() eq 'Y' }"> checked </c:if>/> 여행&nbsp;&nbsp; 
					 <input id="check1" type="checkbox" value="" name="t_reading" class="middleCheck" disabled 
					    <c:if test="${t_dto.getH_reading() eq 'Y' }"> checked </c:if>/> 독서&nbsp;&nbsp; 
					 <input id="check1" type="checkbox" value="" name="t_sports" class="middleCheck" disabled 
					    <c:if test="${t_dto.getH_sports() eq 'Y' }"> checked </c:if>/> 운동
				  </td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${t_dto.getReg_date()}</td>
				</tr>
				<tr>
					<th>최종 수정일</th>
					<td>${t_dto.getUpdate_date()}</td>
				</tr>
				<tr>
					<th>최근 로그인</th>
					<td>${t_dto.getLogin_time()}</td>
				</tr>
				<tr>
					<th>탈퇴일</th>
					<td>${t_dto.getExit_date()}</td>
				</tr>
				
			  </tbody>
			</table>
			<div class="buttonGroup_center">
				<a href="Admin" class="butt">목록</a>
			</div>
		
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






