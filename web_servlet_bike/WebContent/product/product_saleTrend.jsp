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
			PRODUCT
		</a></li>
		<li><a href="ProductSale">
			판매리스트
		</a></li>
		<li><a href="javascript:goSaleTrend()">
			<span class="fnt"><i class="fas fa-apple-alt"></i></span>
			판매현황
		</a></li>
	</ul>
</div>

<script type="text/javascript">
	function goSaleTrend(){
		product.t_gubun.value="saleTrend";
		product.method="post";
		product.action="ProductSale";
		product.submit();
	}
	
	function goSearch(){
		searchForm.t_gubun.value="saleTrend";
		searchForm.method="post";
		searchForm.action="ProductSale";
		searchForm.submit();
	}
</script>

<form name="product">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

<div id="b_right">
	<p class="n_title">
		판매현황
	</p>
	<form name="searchForm">
		<input type="hidden" name="t_nowPage">
		<input type="hidden" name="t_gubun">
		<p class="select_box select_box_right" style="width:525px;">
		
		<select name="t_select" class="sel_box" style="width:90px;">
			<option value="s.product_no" <c:if test="${t_search eq 's.product_no'}">selected</c:if>>제품코드</option>
			<option value="p.p_name" <c:if test="${t_search eq 'p.p_name'}">selected</c:if>>제품명</option>
		</select>
		
		<input type="text" name="t_search" class="sel_text" value="${t_search}">
		<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
		</p>
	</form>		
	
	<table class="boardList">
		<colgroup>
			<col width="33.3%">
			<col width="33.3%">
			<col width="33.3%">
		</colgroup>
		<thead>
			<tr>
				<th>판매연월</th>
				<th>주문건수</th>
				<th>총 판매액</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${t_arr}" var="arr">
				<tr>
					<td><a href="">${arr.getSaleTrend_date()}</a></td>
					<td>${arr.getSale_count()}</td>
					<td>${arr.getPrice_sum()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</div>









<%@include file="../common_footer.jsp" %>
</body>
</html>