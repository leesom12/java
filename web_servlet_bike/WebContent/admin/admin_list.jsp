<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
	<div id="b_left">
		<P>Admin</P>
		<ul>
			<li><a href="Admin">
				<span class="fnt"><i class="fas fa-apple-alt"></i></span>
				MEMBER
			</a></li>
			<li><a href="Product">
				PRODUCT
			</a></li>
		</ul>
	</div>



<script type="text/javascript">
	function goSearch(){
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
	
	function goPage(pageNum){
		admin.t_nowPage.value= pageNum;
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
	
	function goView(id){
		view.t_gubun.value="member_view";
		view.t_id.value=id;
		view.method="post";
		view.action="Admin";
		view.submit();
	}
</script>
<form name="view">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_id">
</form>

		<div id="b_right">
			<p class="n_title">
				Admin
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총회원<span> ${t_totalCount} </span>건</p>
			</div>			
			
			<form name="admin">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_pageNum" class="sel_box" style="width:90px;">
					<option value="5">5개씩정렬</option>
					<option value="10" <c:if test="${t_list_count eq 10}">selected</c:if> >10개씩정렬</option>
				</select>
				<select name="t_select" class="sel_box">
					<option value="id">ID</option>
					<option value="name" <c:if test="${t_select eq 'name'}">selected</c:if> >NAME</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">

				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>ID</th>
						<th>성명</th>
						<th>지역</th>
						<th>연락처</th>
						<th>가입일자</th>
						<th>로그인정보</th>
						<th>탈퇴</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="num" value="${t_order}"></c:set>
					<c:forEach items="${t_arr}" var="arr">	
						<tr>
							<td>${num}<c:set var="num" value="${num-1}"></c:set></td>
							<td class="t_left"><a href="javascript:goView('${arr.getId()}')">${arr.getId()}</a></td>
							<td>${arr.getName()}</td>
							<td>${arr.getArea()}</td>
							<td>${arr.getMobile()}</td>
							<td>${arr.getReg_date()}</td>
							<td>${arr.getLogin_time()}</td>
							<c:set var="exit" value="${arr.getExit_date()}"></c:set>
							<c:if test="${not empty arr.getExit_date()}"> <c:set var="exit" value="탈퇴"></c:set> </c:if>
							<td>${exit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="paging">
			${t_paging}
<!--  
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
-->

			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    