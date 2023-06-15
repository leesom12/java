<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<style>
	.viewImg{
		width:500px;
		height:300px;
		margin: 0 0 10px 50px;
	}
</style>

<script type="text/javascript">
	function goView(no){
		view.t_gubun.value="view";
		view.t_no.value=no;
		view.method="post";
		view.action="News";
		view.submit();
	}
	
	function goUpdateForm(no){
		view.t_gubun.value="updateForm";
		view.t_no.value=no;
		view.method="post";
		view.action="News";
		view.submit();
	}
	
	function goDelete(no){
		var con = confirm("정말 삭제하시겠습니까?");
		if(con){
			del.t_gubun.value="delete";
			del.t_no.value=no;
			del.method="post";
			del.action="News";
			del.submit();
		}
	}
</script>
<form name="view">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

<form name ="del">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
	<input type="hidden" name="t_attach" value="${t_dto.getAttach()}">
</form>
		<div id="b_right">
			<p class="n_title">
				NEWS
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2">${t_dto.getTitle()}</td>
						<td> <i class="far fa-eye"></i>${t_dto.getHit()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<c:if test="${t_extension eq 'jpg' || t_extension eq 'png' || t_extension eq 'gif' || t_extension eq 'jpeg'}">
								<img src="attach/news/${t_dto.getAttach()}" class="viewImg">
								<br><br>
							</c:if>
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><a href="FileDown?t_fileDir=news&t_fileName=${t_dto.getAttach()}">${t_dto.getAttach()}</a></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>		

				</tbody>
			</table>
			<div class="preNext">
				<c:if test="${not empty t_predto}">
					<a href="javascript:goView('${t_predto.getNo()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<c:set var="title" value="${t_predto.getTitle()}"></c:set>
						<c:if test="${fn:length(t_predto.getTitle()) > 10}"> 
							<c:set var="title" value="${fn:substring(t_predto.getTitle(),0,10)}..."></c:set>
						</c:if>
							<span class="preNextTitle">
									${title}
							</span>
						</p>
					</a>
				</c:if>
				<c:if test="${not empty t_nextdto}">
					<a href="javascript:goView('${t_nextdto.getNo()}')">
						<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
						<c:set var="title" value="${t_nextdto.getTitle()}"></c:set>
						<c:if test="${fn:length(t_nextdto.getTitle()) > 10}"> 
							<c:set var="title" value="${fn:substring(t_nextdto.getTitle(),0,10)}..."></c:set>
						</c:if>
							<span class="preNextTitle">
									${title}
							</span>
						</p>
					</a>
				</c:if>
			</div>			
			<div class="buttonGroup">
				<c:if test="${sessionLevel eq 'admin'}">
					<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
					<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				</c:if>
				<a href="News" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    