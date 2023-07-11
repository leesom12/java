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
	
				
			<div style="width:900px; heigth:700px;">
				<canvas id="myChart"></canvas>
			</div>
	
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
	
	
</div>









<%@include file="../common_footer.jsp" %>
</body>
</html>