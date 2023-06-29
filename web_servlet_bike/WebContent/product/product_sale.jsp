<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>

<c:if test="${sessionLevel ne 'member'}">
	<script type="text/javascript">
		alert("로그인 후 이용해 주세요");
		location.href="Member";
	</script>	
</c:if>	

<div id="b_left">
	<P>Product</P>
		<ul>
			<li><a href="Product">
				<span class="fnt"><i class="fas fa-apple-alt"></i></span>
				PRODUCT
			</a></li>
		</ul>
</div>

<style>
	#preview-image{
		border: 1px solid grey;
		width: 400px;
		height: 400px;
		margin: 0 0 10px 50px;
	}
</style>


<script type="text/javascript">
	function goSale(){
		if(checkValue(product.t_address, "배송받을 주소를 입력하세요")) return;
		if(checkValue(product.t_payment, "결제 수단을 선택하세요")) return;
		
		product.t_gubun.value="sale";
		product.method="post";
		product.action="Product";
		product.submit();
	}

</script>
		
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<form name="product">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<input type="hidden" name="t_price" value="${t_dto.getPrice()}">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>상품명</th>
						<td colspan="3">${t_dto.getP_name()}</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td colspan="3">
							<img src="attach/product/${t_dto.getAttach()}" id="preview-image">
						</td>
					</tr>		
					<tr>
						<th>상세설명</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250" readonly>${t_dto.getDetail()}</textarea></td>
					</tr>	
					<tr>
						<th>규격</th>
						<td>${t_dto.getP_size()}</td>
						<th>가격</th>
						<td>${t_dto.getStrPrice()}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td colspan="3">
							<input type="text" class="input600" name="t_address">
						</td>
					</tr>
					<tr>
						<th>결제 방법</th>
						<td colspan="3">
							<input type="radio" name="t_payment" value="card"> 카드 &nbsp;&nbsp;
							<input type="radio" name="t_payment" value="cash"> 무통장입금
						</td>
					</tr>



				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSale()" class="butt" style="background-color:#E0BDBD;">주문하기</a>
				<a href="Product" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    