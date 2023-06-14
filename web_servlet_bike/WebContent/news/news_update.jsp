<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<script type="text/javascript">

</script>
		
		<div id="b_right">
			<p class="n_title">
				NEWS
			</p>
			<form name="noti" enctype="multipart/form-data">
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
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600" value="${t_dto.getTitle()}"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content">${t_dto.getContent()}</textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
							첨부 &nbsp; 삭제<input type="checkbox" name="t_deleteAttach" value=""><br>
							<input type="file" class="input600" name="t_attach">
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				
				<a href="" class="butt">Update</a>
				<a href="Notice" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<div id="footer_div">	
<%@include file="../common_footer.jsp" %>
	</div>	
</body>
</html>






    