<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>



<script type="text/javascript">
	function goView(no){
		etc.t_gubun.value="view";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
	
	function saveComment(no){
		if(checkValue(comm.t_comment,"댓글을 작성하세요"))return;
		comm.t_gubun.value="commentWrite";
		comm.t_no.value=no;
	}
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
						<td colspan="3">${t_dto.getTitle()}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea style="width:98%; height:300px; padding:5px;" readonly>${t_dto.getContent()}</textarea></td>
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
						<td colspan="3">
							<form name="comm">
								<input type="hidden" name="t_gubun">
								<input type="hidden" name="t_no">
								<textarea style="width:85%; height:50px; padding:5px;" name="t_comment"></textarea>
							</form>	
							<div style="width:10%; float:right; text-align:center; height:50px; line-height:60px;">
								<input type="button" onclick="saveComment('${t_dto.getNo()}')" style="display:inline-block;" value="작성">
							</div>
						</td>
					</tr>	
	
					<c:forEach items="${t_arr2}" var="arr2">
						<tr>
							<td style="border-bottom:none;"></td>
							<td colspan="3" style="border-bottom:none;">
								<c:if test="${arr2.getDepth() > 1}"> 
									<c:forEach begin="0" end="${arr2.getDepth()}">&nbsp;&nbsp;&nbsp;</c:forEach>
									<i class="fa-solid fa-arrow-right-long" style="color: #030303;"></i>
								</c:if>
								${arr2.getTitle()}
							</td>
						</tr>
						<tr>
							<td></td>
							<td colspan="3" style="font-size:11px;padding-top:5px;color:grey;text-align:right;">
								등록자: ${arr2.getReg_name()} 등록일: ${arr2.getReg_date()}
							</td>
						</tr>
					</c:forEach>
					
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






    