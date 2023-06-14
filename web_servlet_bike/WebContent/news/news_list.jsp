<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>	

<script type="text/javascript">
	function goSearch(){
		news.method="post";
		news.action="News";
		news.submit();
	}
	
	function goWriteForm(){
		goNews.t_gubun.value="writeForm";
		goNews.method="post";
		goNews.action="News";
		goNews.submit();
	}
	
	function goPage(pageNum){
		news.t_nowPage.value= pageNum;
		news.method="post";
		news.action="News";
		news.submit();
	}
	
	function goView(no){
		goNews.t_gubun.value="view";
		goNews.t_no.value=no;
		goNews.method="post";
		goNews.action="News";
		goNews.submit();
	}
</script>

<form name="goNews">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

		<div id="b_right">
			<p class="n_title">
				NEWS
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount} </span>건</p>
			</div>			
			
			<form name="news">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="n.title">Title</option>
					<option value="n.content" <c:if test="${t_select eq 'n.content'}">selected</c:if>>Content</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">
				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="60%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${t_arr}" var="arr">
						<tr>
							<td><a href="javascript:goView('${arr.getNo()}')">${arr.getNo()}</a></td>
							<td class="t_left"><a href="javascript:goView('${arr.getNo()}')">${arr.getTitle()}</a></td>
							<td>${arr.getReg_name()}</td>
							<td>${arr.getReg_date()}</td>
							<td>${arr.getHit()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
			<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goWriteForm()" class="write">글쓰기</a>
			</c:if>	

			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    