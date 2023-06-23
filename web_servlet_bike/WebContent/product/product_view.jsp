<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
	<div id="b_left">
		<P>Admin</P>
		<ul>
			<li><a href="Admin">
				MEMBER
			</a></li>
			<li><a href="Product">
				<span class="fnt"><i class="fas fa-apple-alt"></i></span>
				PRODUCT
			</a></li>
		</ul>
	</div>

<style>
	.viewImg{
		width:400px;
		height:400px;
		margin: 0 0 10px 50px;
	}
</style>

<script type="text/javascript">
	function goView(no){
		view.t_gubun.value="view";
		view.t_no.value=no;
		view.method="post";
		view.action="Product";
		view.submit();
	}
	
	function goUpdateForm(no){
		view.t_gubun.value="updateForm";
		view.t_no.value=no;
		view.method="post";
		view.action="Product";
		view.submit();
	}
	
	function goDelete(no){
		var yn = confirm("정말 삭제하시겠습니까?");
		if(yn){
			view.t_gubun.value="delete";
			view.t_no.value= no;
			view.method= "post";
			view.action= "Product";
			view.submit();
		}

	}
</script>

<form name="view">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
	<input type="hidden" name="t_attach" value="${t_dto.getAttach()}">
</form>

		<div id="b_right">
			<p class="n_title">
				PRODUCT
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
						<td colspan="2">${t_dto.getP_name()}</td>
						<td> <i class="far fa-eye"></i>${t_dto.getHit()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<c:if test="${not empty t_dto.getAttach()}">
								<img src="attach/product/${t_dto.getAttach()}" class="viewImg">
								<br><br>
							</c:if>
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getDetail()}</textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><a href="FileDown?t_fileDir=product&t_fileName=${t_dto.getAttach()}">${t_dto.getAttach()}</a></td>
					</tr>
					<tr>
						<th>Size</th>
						<td>${t_dto.getP_size()}</td>
						<th>Price</th>
						<td>${t_dto.getStrPrice()}</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td colspan="3">${t_dto.getReg_name()}</td>
					</tr>		
					<tr>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
						<th>UpdateDate</th>
						<td>${t_dto.getUpdate_date()}</td>
					</tr>

				</tbody>
			</table>
			<div class="preNext">
				<c:if test="${not empty t_predto}">
					<a href="javascript:goView('${t_predto.getNo()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<c:set var="title" value="${t_predto.getP_name()}"></c:set>
						<c:if test="${fn:length(t_predto.getP_name()) > 10}"> 
							<c:set var="title" value="${fn:substring(t_predto.getP_name(),0,10)}..."></c:set>
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
						<c:set var="title" value="${t_nextdto.getP_name()}"></c:set>
						<c:if test="${fn:length(t_nextdto.getP_name()) > 10}"> 
							<c:set var="title" value="${fn:substring(t_nextdto.getP_name(),0,10)}..."></c:set>
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
				<a href="Product" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    