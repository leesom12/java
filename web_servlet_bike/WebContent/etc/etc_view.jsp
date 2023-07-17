<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>



<script type="text/javascript">

</script>

<form name="etc">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

		<div id="b_right">
			<p class="n_title">
				Free Board
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><textarea style="width:98%; height:200px; padding:5px;" readonly>ㅇㅇ</textarea></td>
					</tr>		
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>
				</tbody>
			</table>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="25%">
					<col width="25%">
				</colgroup>
				<tbody>
					<tr>
						<th>댓글</th>
						<td colspan="2"><input type="text" name="t_comment" ></td>
						<td><input type="button" onclick="saveComment()" style="" value="작성"> </td>
					</tr>		
	
					<tr>
						<td colspan="3" rowspan="2" style="padding:5px 5px 5px 20px;">댓글댓글</td>
						<td style="font-size:11px;">등록자</td>
					</tr>
					<tr>
						<td style="font-size:11px;">등록일</td>
					</tr>
					
				</tbody>
			</table>
			
			
			<div class="preNext">
				<c:if test="${not empty t_preDto}">
					<a href="javascript:goView('${t_preDto.getNo()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
							<span class="preNextTitle">
									<c:set var="title" value="${t_preDto.getTitle()}"></c:set>
									<c:if test="${fn:length(t_preDto.getTitle()) > 10}"> 
										<c:set var="title" value="${fn:substring(t_preDto.getTitle(),0,10)}..."></c:set>
									</c:if>
									${title}
							</span>
						</p>
					</a>
				</c:if>
				<c:if test="${not empty t_nextDto}">
					<a href="javascript:goView('${t_nextDto.getNo()}')">
						<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
							<span class="preNextTitle">
									<c:set var="title" value="${t_nextDto.getTitle()}"></c:set>
									<c:if test="${fn:length(t_nextDto.getTitle()) > 10}"> 
										<c:set var="title" value="${fn:substring(t_nextDto.getTitle(),0,10)}..."></c:set>
									</c:if>
									${title}
							</span>
						</p>
					</a>
				</c:if>
				
			</div>			
			
			<div class="buttonGroup">
				<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				<a href="Etc" class="butt">List</a>			
			</div>	
		
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    