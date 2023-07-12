<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<script type="text/javascript">
	function goReply(no){
		qna.t_gubun.value="replyForm";
		qna.t_no.value = no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	
	function goUpdate(no){
		qna.t_gubun.value="updateForm";
		qna.t_no.value = no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	
	function goDelete(no){
		var cf= confirm("삭제하시겠습니까?");
		if(cf){
			qna.t_gubun.value="delete";
			qna.t_no.value = no;
			qna.method="post";
			qna.action="Qna";
			qna.submit();
		}
	}
	
	function replyUpdate(no){
		qna.t_gubun.value="replyUpdateForm";
		qna.t_no.value = no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	
	function replyDelete(no){
		var cf= confirm("삭제하시겠습니까?");
		if(cf){
			qna.t_gubun.value="replyDelete";
			qna.t_no.value = no;
			qna.method="post";
			qna.action="Qna";
			qna.submit();
		}
	}
</script>
<form name="qna">
	<input name="t_gubun" type="hidden">
	<input name="t_no" type="hidden">
</form>
		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			
				<input type="hidden" name="t_gubun">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3">${t_dto.getTitle()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250" readonly>${t_dto.getContent()}</textarea></td>
					</tr>	
					
					<c:if test="${not empty t_dto.getUpdate_date()}">
					<tr>
						<th rowspan="2">Writer</th>
						<td rowspan="2">${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>
					<tr>
						<th>UpdateDate</th>
						<td>${t_dto.getUpdate_date()}</td>
					</tr>
					</c:if>
					
					<c:if test="${empty t_dto.getUpdate_date()}">
						<tr>
							<th>Writer</th>
							<td>${t_dto.getReg_name()}</td>
							<th>RegDate</th>
							<td>${t_dto.getReg_date()}</td>
						</tr>
					</c:if>		

				</tbody>
			</table>
			
			<c:if test="${not empty t_dto.getReply()}">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>	
					<tr>
						<th>Reply</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250" readonly>${t_dto.getReply()}</textarea></td>
					</tr>	
					<tr>
						<th rowspan="2">Writer</th>
						<td rowspan="2">${t_dto.getReply_name()}</td>
						<th>ReplyDate</th>
						<td>${t_dto.getReply_date()}</td>
					</tr>		
				</tbody>
			</table>
			</c:if>
			
			
			
			<div class="buttonGroup">
				<c:if test="${empty t_dto.getReply() and t_dto.getReg_id() eq sessionId}">
					<a href="javascript:goUpdate('${t_dto.getNo()}')" class="butt">Update</a>
					<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
				</c:if>
				<c:if test="${sessionLevel eq 'admin'}">
					<c:if test="${not empty t_dto.getReply()}">
						<a href="javascript:replyUpdate('${t_dto.getNo()}')" class="butt">답변수정</a>
						<a href="javascript:replyDelete('${t_dto.getNo()}')" class="butt">답변삭제</a>
						<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">질문삭제</a>
					</c:if>
					<c:if test="${empty t_dto.getReply()}">
						<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
						<a href="javascript:goReply('${t_dto.getNo()}')" class="butt">Reply</a>
					</c:if>
				</c:if>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>
