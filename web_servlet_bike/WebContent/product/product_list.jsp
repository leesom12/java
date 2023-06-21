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

<script type="text/javascript">
	function goWriteForm(){
		product.t_gubun.value="writeForm";
		product.method= "post";
		product.action="Product";
		product.submit();
	}
</script>

<form name="product">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount} </span>건</p>
			</div>			
			
			<form name="news">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="">제품번호</option>
					<option value="" <c:if test="${t_select eq ''}">selected</c:if>>제품명</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">
				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="15%">
					<col width="15%">
					<col width="35%">
					<col width="19%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th></th>
						<th>제품번호</th>
						<th>제품명</th>
						<th>가격</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					
						<tr>
							<td>1</td>
							<td><a href="">사진</a></td>
							<td class="t_left"><a href="">제품번호</a></td>
							<td>제품명</td>
							<td>가격</td>
							<td>조회수</td>
						</tr>
					
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
			<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goWriteForm()" class="write">글쓰기</a>
			</c:if>	

			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    