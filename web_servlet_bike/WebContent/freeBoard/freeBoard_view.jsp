<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<style>
	.viewImg{
		width:400px;
		height:400px;
		margin: 0 0 10px 50px;
	}
</style>


<script type="text/javascript">
	function goView(no){
		freeboard.t_gubun.value="view";
		freeboard.t_no.value=no;
		freeboard.method="post";
		freeboard.action="FreeBoard";
		freeboard.submit();
	}
	
	function goDelete(no){
		var yf = confirm("정말 삭제하시겠습니까?");
		if(yf){
			freeboard.t_gubun.value="delete";
			freeboard.t_no.value=no;
			freeboard.method="post";
			freeboard.action="FreeBoard";
			freeboard.submit();
		}
	}
	
	function goUpdateForm(no){
		freeboard.t_gubun.value="updateForm";
		freeboard.t_no.value=no;
		freeboard.method="post";
		freeboard.action="FreeBoard";
		freeboard.submit();
	}
	
	function goFileDown(){
		var download_count = down.t_DownCount.value;
		download_count = Number(download_count)+1;
		down.t_DownCount.value = download_count;
		
		fileDown.method="post";
		fileDown.action="FileDown";
		fileDown.submit();
	}
	
</script>
<form name="freeboard">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
	<input type="hidden" name="t_attach" value="${t_dto.getAttach()}">
</form>
<form name="fileDown">
	<input type="hidden" name="t_no" value="${t_dto.getNo()}">
	<input type="hidden" name="t_fileDir" value="freeboard">
	<input type="hidden" name="t_fileName" value="${t_dto.getAttach()}">
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
						<td colspan="2">${t_dto.getTitle()}</td>
						<td style="text-align: right;padding-right:15px;"> 
							<i class="far fa-eye"></i> ${t_dto.getHit()}&nbsp;				
							<form name="down" style="display:inline-block;">
								<c:if test="${not empty t_dto.getAttach()}">
								<i class="fa-solid fa-circle-down" style="color: #020203;"></i> 
								<input type="text" name="t_DownCount" readonly style="border:none;width:50px;" value="${t_dto.getDownload_hit()}">
								</c:if>
							</form>
						</td>	
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<c:if test="${t_extension eq 'jpg' || t_extension eq 'png' || t_extension eq 'gif' || t_extension eq 'jpeg' 
							|| t_extension eq 'JPG' || t_extension eq 'PNG' || t_extension eq 'GIF' || t_extension eq 'JPEG'}">
								<img src="attach/freeBoard/${t_dto.getAttach()}" class="viewImg">
								<br><br>
							</c:if>
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>		
					<c:if test="${not empty t_dto.getAttach()}">
						<tr>
							<th>첨부</th>
							<td colspan="3"><a href="javascript:goFileDown()">${t_dto.getAttach()}</a></td>	
						</tr>	
					</c:if>
					
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
				
				<c:choose>
					<c:when test="${sessionId eq t_dto.getReg_id()}">
						<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
						<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
						<a href="FreeBoard" class="butt">List</a>
					</c:when>
					<c:when test="${sessionLevel eq 'admin'}">
						<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
						<a href="FreeBoard" class="butt">List</a>
					</c:when>
					<c:otherwise>
						<a href="FreeBoard" class="butt">List</a>
					</c:otherwise>
				</c:choose>
				
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    