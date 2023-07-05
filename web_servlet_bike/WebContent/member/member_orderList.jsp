<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>


<script type="text/javascript">
	function goView(no){
		pro.t_gubun.value="orderView";
		pro.t_no.value= no;
		pro.method="post";
		pro.action="ProductSale";
		pro.submit();
	}
	
	function goSearch(){
		searchForm.t_gubun.value="orderDetails";
		searchForm.method="post";
		searchForm.action="Member";
		searchForm.submit();
	}
	
	function goPage(pageNum){
		searchForm.t_nowPage.value= pageNum;
		searchForm.t_gubun.value="orderDetails";
		searchForm.method="post";
		searchForm.action="Member";
		searchForm.submit();
	}
</script>
<form name="pro">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>


		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('myPage')"> MEMBER</a></li>
				<li><a href="javascript:goWork('orderDetails')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>ORDER</a></li>
			</ul>
		</div>

		<div id="b_right">
			<p class="n_title">
				구매내역
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount} </span>건</p>
			</div>			
			
			<form name="searchForm">
			<input type="hidden" name="t_nowPage">
			<input type="hidden" name="t_gubun">
			<p class="select_box select_box_right">
				<select name="t_pageNum" class="sel_box" style="width:90px;">
					<option value="5">5개씩정렬</option>
					<option value="10" <c:if test="${t_list_count eq 10}">selected</c:if> >10개씩정렬</option>
				</select>
				
				<select name="t_process" class="sel_box" style="width:90px;">
					<option value="">진행상태</option>
					<option value="입금확인중" <c:if test="${t_process eq '입금확인중'}">selected</c:if> >입금확인중</option>
					<option value="배송중" <c:if test="${t_process eq '배송중'}">selected</c:if>>배송중</option>
					<option value="배송완료" <c:if test="${t_process eq '배송완료'}">selected</c:if> >배송완료</option>
					<option value="주문취소" <c:if test="${t_process eq '주문취소'}">selected</c:if> >주문취소</option>
				</select>
				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="15%">
					<col width="30%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>주문번호</th>
						<th>구매제품</th>
						<th>구매가격</th>
						<th>구매일</th>
						<th>진행상태</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="num" value="${t_order}"></c:set>
					<c:forEach items="${t_arr}" var="arr">
						<tr>
							<td>${num}<c:set var="num" value="${num-1}"></c:set></td>
							<td><a href="javascript:goView('${arr.getNo()}')">${arr.getNo()}</a></td>
							<td><a href="javascript:goView('${arr.getNo()}')">${arr.getProduct_name()}</a></td>
							<td>${arr.getStrPrice()}</td>
							<td>${arr.getPurchase_date()}</td>
							<td>${arr.getProcess_state()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    