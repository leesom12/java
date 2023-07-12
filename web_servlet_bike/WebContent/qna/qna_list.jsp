<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<script type="text/javascript">
	function goWrite(){
		qna.t_gubun.value="writeForm";
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	
	function goSearch(){
		searchForm.method="post";
		searchForm.action="Qna";
		searchForm.submit();
	}
	
	function goView(no){
		qna.t_gubun.value="view";
		qna.t_no.value=no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	
	function goPage(pageNum){
		searchForm.t_nowPage.value= pageNum;
		searchForm.method="post";
		searchForm.action="Qna";
		searchForm.submit();
	}
	
</script>

<form name="qna">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>

<style type="text/css">
	.complet{
		width: 60px;
		heigth: 30px;
		border: 3px solid #2F579D;
		background-color: #2F579D;
		color: white;
		font-weight: 450;
	}
	
	.waiting{
		width: 60px;
		heigth: 30px;
		border: 3px solid #A4A4A4;
		background-color: #A4A4A4;
		font-weight: 450;
	}
</style>



		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount} </span>건</p>
			</div>			
			
			<form name="searchForm">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_pageNum" class="sel_box" style="width:90px;">
					<option value="5">5개씩정렬</option>
					<option value="10" <c:if test="${t_pageNum eq '10'}">selected</c:if>>10개씩정렬</option>
				</select>
				<select name="t_select" class="sel_box">
					<option value="q.title">제목</option>
					<option value="q.content" <c:if test="${t_select eq 'q.content'}">selected</c:if>>내용</option>
				</select>
				<input type="text" name="t_search" class="sel_text" value="${t_search}">
				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="7%">
					<col width="40%">
					<col width="15%">
					<col width="16%">
					<col width="15%">
					<col width="7%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>답변상태</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					<c:set var="num" value="${t_order}" ></c:set>
					<c:forEach items="${t_arr}" var="arr">
						<tr>
							<td>
								${num}
								<c:set var="num" value="${num-1}"></c:set>
							</td>
							<c:set var="title" value="${arr.getTitle()}"></c:set>
							<c:if test="${fn:length(arr.getTitle()) > 20}"> 
								<c:set var="title" value="${fn:substring(arr.getTitle(),0,20)}..."></c:set>
							</c:if>
							<td><a href="javascript:goView('${arr.getNo()}')">${title}</a></td>
							<td>${arr.getReg_name()}</td>
							<td>${arr.getReg_date()}</td>
							<c:if test="${arr.getState() eq '답변대기'}"><td><span class="waiting">답변대기</span></td></c:if>
							<c:if test="${arr.getState() eq '답변완료'}"><td><span  class="complet">답변완료</span></td></c:if>
							<td>${arr.getHit()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			

			
			
			<div class="paging">
				${t_paging}
			<c:if test="${not empty sessionId}">
				<a href="javascript:goWrite()" class="write">글쓰기</a>
			</c:if>
			</div>
			
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    