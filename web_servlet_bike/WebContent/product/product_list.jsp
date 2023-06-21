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
	
	function goSearch(){
		searchForm.method="post";
		searchForm.action="Product";
		searchForm.submit();
	}
	
	function goPage(pageNum){
		searchForm.t_nowPage.value= pageNum;
		searchForm.method="post";
		searchForm.action="Product";
		searchForm.submit();
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
			
			<form name="searchForm">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="no">제품번호</option>
					<option value="p_name" <c:if test="${t_select eq 'p_name'}">selected</c:if>>제품명</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">
				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="20%">
					<col width="8%">
					<col width="30%">
					<col width="15%">
					<col width="20%">
					<col width="7%">
				</colgroup>
				<thead>
					<tr>
						<th></th>
						<th>제품번호</th>
						<th>제품명</th>
						<th>가격</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${t_arr}" var="arr">
						<tr>
							<td><a href=""><img src="attach/product/${arr.getAttach()}" width="50px" height="50px"></a></td>
							<td class="t_left"><a href="">${arr.getNo()}</a></td>
							<td><a href="">${arr.getP_name()}</a></td>
							<td>${arr.getStrPrice()}</td>
							<td>${arr.getReg_date()}</td>
							<td>${arr.getHit()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
			
				<a href="javascript:goWriteForm()" class="write">제품등록</a>
			

			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    