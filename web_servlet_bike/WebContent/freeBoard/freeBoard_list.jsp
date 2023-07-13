<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>	
<script type="text/javascript">
	function goWriteForm(){
		freeboard.t_gubun.value="writeForm";
		freeboard.method="post";
		freeboard.action = "FreeBoard";
		freeboard.submit();
	}
	
	function goView(no){
		freeboard.t_gubun.value="view";
		freeboard.t_no.value=no;
		freeboard.method="post";
		freeboard.action = "FreeBoard";
		freeboard.submit();
	}
	
	function goSearch(){
		searchForm.method="post";
		searchForm.action = "FreeBoard";
		searchForm.submit();
	}
	
	function goPage(pageNum){
		searchForm.t_nowPage.value= pageNum;
		searchForm.method="post";
		searchForm.action="FreeBoard";
		searchForm.submit();
	}
</script>
<form name="freeboard">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

		<div id="b_right">
			<p class="n_title">
				Free Board
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount} </span>건</p>
			</div>			
			
			<form name="searchForm">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="f.title">제목</option>
					<option value="f.content">내용</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">

				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="53%">
					<col width="7%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>첨부</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
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
			<c:if test="${not empty sessionId}">
				<a href="javascript:goWriteForm()" class="write">글쓰기</a>
			</c:if>	
			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    