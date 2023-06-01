<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>	
<script type="text/javascript">
	function goSearch(){
		noti.method="post";
		noti.action="Notice";
		noti.submit();
	}
	
	function goPage(pageNum){
		noti.t_nowPage.value= pageNum;
		noti.method="post";
		noti.action="Notice";
		noti.submit();
	}
	
	function goView(no){
		goNotice.t_gubun.value="view";
		goNotice.t_no.value=no;
		goNotice.method="post";
		goNotice.action="Notice";
		goNotice.submit();
	}
	
	function goWriteForm(){
		goNotice.t_gubun.value="writeForm";
		goNotice.method="post";
		goNotice.action="Notice";
		goNotice.submit();
	}
</script>
<form name="goNotice">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount} </span>건</p>
			</div>			
			
			<form name="noti">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="n.title">Title</option>
					<option value="n.content" <c:if test="${t_select eq 'n.content'}">selected</c:if> >Content</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">

				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="55%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="num" value="${t_order}"></c:set>
					<c:forEach items="${t_arr}" var="arr">
						<tr>
							<td>
								${num}
								<c:set var="num" value="${num-1}"></c:set>
							</td>
							<td class="t_left"><a href="javascript:goView('${arr.getNo()}')">${arr.getTitle() }</a></td>
							<td>
								<c:if test="${not empty arr.getAttach()}">
									<img src="images/clip.png">
								</c:if>
							</td>
							<td>${arr.getReg_name() }</td>
							<td>${arr.getReg_date() }</td>
							<td>${arr.getHit() }</td>
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
			<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goWriteForm()" class="write">글쓰기</a>
			</c:if>	
			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    