<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<script type="text/javascript">
	function saveReply(no){
		qna.t_gubun.value="replySave";
		qna.t_no.value = no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
</script>


		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			
				<input type="hidden" name="t_gubun">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3">${t_dto.getTitle()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250">${t_dto.getContent()}</textarea></td>
					</tr>	
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

				</tbody>
			</table>
			
			<form name="qna">
				<input name="t_gubun" type="hidden">
				<input name="t_no" type="hidden">
				<table class="boardForm">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="10%">
						<col width="40%">
					</colgroup>
					<tbody>	
						<tr>
							<th>Reply</th>
							<td colspan="3"><textarea name="t_reply" class="textArea_H250"></textarea></td>
						</tr>	
						<tr>
							<th rowspan="2">Writer</th>
							<td rowspan="2">${sessionName}</td>
							<th>ReplyDate</th>
							<td>${t_today}</td>
						</tr>		
					</tbody>
				</table>
			</form>
			
			
			
			<div class="buttonGroup">

				
				<a href="javascript:saveReply('${t_dto.getNo()}')" class="butt">Save</a>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>
