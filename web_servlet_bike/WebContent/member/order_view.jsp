<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>

		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('myPage')"> MEMBER</a></li>
				<li><a href="javascript:goWork('orderDetails')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>ORDER</a></li>
			</ul>
		</div>


<style>
	.viewImg{
		width:200px;
		height:200px;
	}
</style>


		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
	
	<script type="text/javascript">
		function orderDelete(no){
			pro.t_gubun.value="orderDelete";
			pro.t_no.value= no;
			pro.method="post";
			pro.action="ProductSale";
			pro.submit();
		}
	</script>	
			
<form name="pro">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr>
						<th colspan="2" rowspan="3"> <img src="attach/product/${t_dto.getAttach()}" class="viewImg"> </th>
						<th>주문번호</th>
						<td>${t_dto.getNo()}</td>
					</tr>
					<tr>
						<th>상품번호</th>
						<td>${t_dto.getProduct_no()}</td>
					</tr>
					<tr>
						<th>상품명</th>
						<td>${t_dto.getProduct_name()}</td>
					</tr>



					<tr>
						<th>배송주소</th>
						<td colspan="3">${t_dto.getAddress()}</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td colspan="3">${t_dto.getMobile()}</td>
					</tr>
					<tr>
						<th>구매가격</th>
						<td>${t_dto.getStrPrice()}</td>
						<th>구매일자</th>
						<td>${t_dto.getPurchase_date()}</td>
					</tr>
					<tr>
						<th>지불방법</th>
						<td>${t_dto.getPayment()}</td>
						<th>배송상태</th>
						<td>${t_dto.getProcess_state()}</td>
					</tr>
					<c:if test="${t_dto.getProcess_state() eq '배송완료'}">
						<tr>
							<th>배송완료일</th>
							<td colspan="3">${t_dto.getDelivery_date()}</td>
						</tr>
					</c:if>				

				</tbody>
			</table>

			<div class="preNext">
			</div>	
			
					
			<div class="buttonGroup">
				<a href="javascript:goWork('orderDetails')" class="butt">List</a>
				<c:if test="${t_dto.getProcess_state() eq '입금확인중'}">
					<a href="javascript:orderDelete('${t_dto.getNo()}')" class="butt">주문취소</a>
				</c:if>
			</div>	
		</div>	

<%@include file="../common_footer.jsp" %>
</body>
</html>






    