<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>


<script type="text/javascript">
	function goSave(){
		if(checkValue(qna.t_title,"제목을 입력하세요"))return;
		if(qna.t_title.value.length > 50){
			alert("50자 이내의 제목으로 입력하세요");
			return;
		}
		if(checkValue(qna.t_content,"내용을 입력하세요"))return;
		if(qna.t_content.value.length > 1000){
			alert("1000자 이내의 내용으로 입력하세요");
			return;
		}
		
		qna.t_gubun.value="write";
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
</script>
		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			
			<form name="qna">
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
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${sessionName}</td>
						<th>RegDate</th>
						<td>${t_today}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    