<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>



<script type="text/javascript">
	/*
	var id = "#"+id;
	$(id).val()
	*/
	function goView(no){
		etc.t_gubun.value="view";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
	
	function saveComment(no, depth){
		if(checkValue(comm.t_comment,"댓글을 작성하세요"))return;
		comm.t_gubun.value="commentWrite";
		comm.t_no.value=no;
		comm.t_depth.value=depth;
		comm.method="post";
		comm.action="Etc";
		comm.submit();
	}
	
	function reComment(no, depth){
		if(checkValue(comm2.t_recomment,"댓글을 작성하세요"))return;
		comm2.t_gubun2.value="RecommentWrite";
		comm2.t_no2.value=no;
		comm2.t_depth2.value=depth;
		comm2.method="post";
		comm2.action="Etc";
		comm2.submit();
	}
	
	function goUpdateForm(no){
		etc.t_gubun.value="updateForm";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
	
	function goDelete(no){
		var yn = confirm("삭제하시겠습니까?");
		if(yn){
			etc.t_gubun.value="delete";
			etc.t_no.value=no;
			etc.method="post";
			etc.action="Etc";
			etc.submit();
		}
	}
	
	
</script>
<style>
	.faq-group .accordion {text-align:left;border:0 none; background:transparent; border-bottom:1px solid #ddd; cursor:pointer;}
	.faq-group .accordion:after {content:"\f0fe";font-family:FontAwesome; float:right;}
	.faq-group .panel {padding:20px 18px; border-bottom:1px solid #ddd; line-height:1.8; display:none;}
	.faq-group .active:after {content:"\f068";font-family:FontAwesome; float:right;}
</style>
<script>
	$(function() {
		$(".accordion").on("click",function() {
			$(".panel").not($(this).next().slideToggle()).slideUp();
			$(".accordion").not($(this)).removeClass("active");
			$(this).toggleClass("active");
		});

	});
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
						<td colspan="3"><textarea style="width:98%; height:300px; padding:5px; border:none;" readonly>${t_dto.getContent()}</textarea></td>
					</tr>		
					<c:choose>
						<c:when test="${empty t_dto.getUpdate_date()}">
							<tr>
								<th>작성자</th>
								<td>${t_dto.getReg_name()}</td>
								<th>작성일</th>
								<td>${t_dto.getReg_date()}</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<th rowspan="2">작성자</th>
								<td rowspan="2">${sessionName}</td>
								<th>작성일</th>
								<td>${t_dto.getReg_date()}</td>
							</tr>	
							<tr>
								<th>수정일</th>
								<td>${t_dto.getUpdate_date()}</td>
							</tr>
						</c:otherwise>
					</c:choose>

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
							<div style="display: flex;justify-content: space-between;">
								<div style="width:85%">
									<form name="comm">
										<input type="hidden" name="t_gubun">
										<input type="hidden" name="t_no">
										<input type="hidden" name="t_depth">
										<textarea style="width:100%; height:50px; padding:5px;" name="t_comment"></textarea>
									</form>	
								</div>
								<div style="width:50px; height: 50px; line-height: 60px; padding-right:10px;">
									<input style="width: 50px; height:30px;" type="button" onclick="saveComment('${t_dto.getNo()}', '${t_dto.getDepth()}')"  value="등록">
								</div>
							</div>
						</td>
					</tr>	
	
					<c:forEach items="${t_arr2}" var="arr2">
						<tr>
							<td style="border-bottom:none;"></td>
							<td colspan="3" style="border-bottom:none;">
								<div class="faq-group">
									<div class="accordion">
										<div>
											<c:if test="${arr2.getDepth() > 1}"> 
												<c:forEach begin="0" end="${arr2.getDepth()}">&nbsp;&nbsp;&nbsp;</c:forEach>
												<i class="fa-solid fa-arrow-right-long" style="color: #030303;"></i>
											</c:if>
											${arr2.getTitle()}
										</div>
										<div style="font-size:11px;padding-top:5px;color:grey;text-align:right;">
											등록자: ${arr2.getReg_name()} 등록일: ${arr2.getReg_date()}
										</div>
									</div>
									<div class="panel">
										
										<form name="comm2">
											<input type="hidden" name="t_gubun2">
											<input type="hidden" name="t_no2">
											<input type="hidden" name="t_depth2">
											<textarea style="width:100%;height:50px;" name="t_recomment"></textarea>
										</form>
										
										<div style="width:50px; height:30px; line-height: 60px; padding-right:10px;">
											<input style="width: 50px; height:30px;" type="button" onclick="reComment('${arr2.getNo()}','${arr2.getDepth()}')"  value="등록">
										</div>
									</div>
								</div>
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
				<c:if test="${sessionId eq t_dto.getReg_id() && empty t_arr2}">
					<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
					<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				</c:if>
				<a href="Etc" class="butt">List</a>			
			</div>	
		
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    