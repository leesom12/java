<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>


<script type="text/javascript">
	
	function goSearch(){
		searchForm.t_gubun.value="saleList";
		searchForm.method="post";
		searchForm.action="ProductSale";
		searchForm.submit();
	}
	
	function goPage(pageNum){
		searchForm.t_nowPage.value= pageNum;
		searchForm.t_gubun.value="saleList";
		searchForm.method="post";
		searchForm.action="ProductSale";
		searchForm.submit();
	}
	
	function goSaleView(no){
		product.t_gubun.value="saleView";
		product.t_no.value= no;
		product.method="post";
		product.action="ProductSale";
		product.submit();
	}
	
	function goSaleTrend(){
		product.t_gubun.value="saleTrend";
		product.method="post";
		product.action="ProductSale";
		product.submit();
	}
</script>

<c:choose>
	<c:when test="${sessionLevel eq 'admin'}">
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
					<span class="fnt"><i class="fas fa-apple-alt"></i></span>
					판매리스트
				</a></li>
				<li><a href="javascript:goSaleTrend()">
					판매현황
				</a></li>
			</ul>
		</div>
	</c:when>
</c:choose>


<form name="product">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

		<div id="b_right">
			<p class="n_title">
				판매리스트
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총판매수<span> ${t_totalCount} </span>건</p>
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
				
				<select name="t_select" class="sel_box">
					<option value="s.no">주문번호</option>
					<option value="s.product_no" <c:if test="${t_select eq 's.product_no'}">selected</c:if>>제품번호</option>
					<option value="s.member_id" <c:if test="${t_select eq 's.member_id'}">selected</c:if>>구매자ID</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">
				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<div style="width:900px; heigth:700px;">
				<canvas id="myChart"></canvas>
			</div>
			
			<table class="boardList">
				<colgroup>
					<col width="7%">
					<col width="18%">
					<col width="10%">
					<col width="27%">
					<col width="10%">
					<col width="15%">
					<col width="13%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>주문번호</th>
						<th>제품번호</th>
						<th>제품명</th>
						<th>구매자</th>
						<th>구매일</th>
						<th>진행상태</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="num" value="${t_order}"></c:set>
					<c:forEach items="${t_arr}" var="arr">
						<tr>
							<td>${num}<c:set var="num" value="${num-1}"></c:set></td>
							<td><a href="javascript:goSaleView('${arr.getNo()}')">${arr.getNo()}</a></td>
							<td>${arr.getProduct_no()}</td>
							<td>${arr.getProduct_name()}</td>
							<td>${arr.getMem_id()}</td>
							<td>${arr.getPurchase_date()}</td>
							<td>${arr.getProcess_state()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
<script type="text/javascript">
            var context = document
                .getElementById('myChart')
                .getContext('2d');
            var myChart = new Chart(context, {
                type: 'bar', // 차트의 형태
                data: { // 차트에 들어갈 데이터
                    labels: [
                        //x 축
                        '1','2','3','4','5','6','7'
                    ],
                    datasets: [
                        { //데이터
                            label: 'test1', //차트 제목
                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                            data: [
                                21,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
                            ],
                            backgroundColor: [
                                //색상
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                //경계선 색상
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1 //경계선 굵기
                        }/* ,
                        {
                            label: 'test2',
                            fill: false,
                            data: [
                                8, 34, 12, 24
                            ],
                            backgroundColor: 'rgb(157, 109, 12)',
                            borderColor: 'rgb(157, 109, 12)'
                        } */
                    ]
                },
                options: {
                    scales: {
                        yAxes: [
                            {
                                ticks: {
                                    beginAtZero: true
                                }
                            }
                        ]
                    }
                }
            });
        </script>

			<div class="paging">
				${t_paging}
			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    