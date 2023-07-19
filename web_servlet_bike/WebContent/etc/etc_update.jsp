<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<c:if test="${empty sessionId}">
	<script type="text/javascript">
		alert("회원 전용 화면입니다. 로그인 후 이용해주세요");
		location.href="Member";
	</script>
</c:if>


<script type="text/javascript">
	function goUpdate(no){
		if(checkValue(etc.t_title,"제목을 입력하세요"))return;
		if(checkValue(etc.t_content,"내용을 입력하세요"))return;
		etc.t_gubun.value="update";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
</script>

		
		<div id="b_right">
			<p class="n_title">
				Etc
			</p>
			<form name="etc">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_no">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title" class="input600" value="${t_dto.getTitle()}"></td>
					</tr>	
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250">${t_dto.getContent()}</textarea></td>
					</tr>			
					<tr>
						<th rowspan="2">작성자</th>
						<td rowspan="2">${sessionName}</td>
						<th>작성일</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	
					<tr>
						<th>수정일</th>
						<td>${t_today}</td>
					</tr>
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goUpdate('${t_dto.getNo()}')" class="butt">Update</a>
				<a href="Etc" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    