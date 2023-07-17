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

</script>

		
		<div id="b_right">
			<p class="n_title">
				Etc
			</p>
			<form name="freeboard">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>작성</th>
						<td colspan="3"><textarea style="width:98%; height:200px; padding:5px;">ㅇㅇ</textarea></td>
					</tr>		
					<tr>
						<th>작성자</th>
						<td>${sessionName}</td>
						<th>작성일</th>
						<td>${t_today}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Etc" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    