<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>



<style>
	.faq-group .accordion {text-align:left;border:0 none; background:transparent; border-bottom:1px solid #ddd; cursor:pointer;}
	.faq-group .panel {padding:20px 18px; border-bottom:1px solid #ddd; line-height:1.8; display:none; }
</style>
<script>
/*
	$(function() {
			$(".accordion").on("click",function() {
				$(".panel").not($(this).next().slideToggle()).slideUp();
				$(".accordion").not($(this)).removeClass("active");
				$(this).toggleClass("active");
			});
	
		});
*/
</script>

<script type="text/javascript">
	/*
	var id = "#"+id;
	$(id).val()
	*/
	function goView(no){
		etc.t_gubun.value="view";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
	
	function saveComment(){
		if(checkValue(comm.t_comment,"댓글을 작성하세요"))return;
		
		$.ajax({
			type : "POST",
			url : "EtcComment",
			data: "t_no="+comm.t_no.value+"&t_depth="+comm.t_depth.value+"&t_comment="+comm.t_comment.value,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				commentsList();
				comm.t_comment.value="";
			}
		});	
		
	}
	
	
	// &#39; 작은 따옴표
	
	//페이지 실행할 때 바로 실행
	$(document).ready(function(){
		commentsList();
	});
	function commentsList(){
		
		$.ajax({
			type : "POST",
			url : "CommentsList",
			data: "t_no="+comm.t_no.value,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				data = JSON.parse(data);
				console.log(data);
				
				var tb = "<div class='faq-group'>";
				tb+="<script>$(function() {$('.accordion').on('click',function() {$('.panel').not($(this).next().slideToggle()).slideUp();";
				tb+="$('.accordion').not($(this)).removeClass('active');$(this).toggleClass('active');});});<\/script>";
				for (var i=0; i<data.t_arr.length; i++){
					var jsob = JSON.parse(JSON.stringify(data.t_arr[i]));
					var group_no = jsob.group_no;
					var comm_no = jsob.comm_no;
					var title = jsob.title;
					var content = jsob.content;
					var depth = jsob.depth;
					var reg_id = jsob.reg_id;
					var reg_name = jsob.reg_name;
					var reg_date = jsob.reg_date;
					
					tb+="<div class='accordion'>";
					tb+="<div style='font-size:13px;'>";
					tb+="<div style='display:flex;justify-content: space-between; margin: 5px 0 5px 0;'>";
					tb+="<div style='font-size:12px;padding-top:5px;font-weight:600;'>";
					tb+=reg_name;
					tb+="</div>";
					tb+="<div style='font-size:11px;padding-top:5px;color:grey;text-align:right;'>";
					tb+=reg_date;
					tb+="</div>";
					tb+="</div>";
					tb+=title;
					tb+="</div>";
					tb+="<div style='font-size:13px;padding-top:5px;color:grey;text-align:left;margin: 10px 0 10px 0;'>";
					tb+="답글달기";
					tb+="</div>";
					tb+="</div>";
					tb+="<div class='panel'>";
					//
					tb+="<form name='"+comm_no+"'>"
					tb+="<textarea style='width:85%;height:40px;' name='t_comment' id='t_comment'></textarea>";
					tb+="<div style='width:50px; height:30px; line-height: 45px; padding-right:10px; float:right;'>";
					tb+="<input style='width:50px;height:30px;' type='button' onclick='reComment(&#39;"+comm_no+"&#39;,&#39;"+depth+"&#39;)'  value='등록'>";
					tb+="</div>";
					tb+="</form>";
					tb+="</div>";
					
				}tb+="</div>";
				$(".faq-group").html(tb);
				console.log(tb);
				
			}
		});	
	}
	
	function reComment(no, depth){
		alert($(this).val())
		document.getElementById(no).
		$.ajax({
			type : "POST",
			url : "EtcComment",
			data: {"t_no":no,"t_depth":depth,"t_comment":no.t_comment.value},
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				no.t_comment.value="";
			}
		});		
	}
	
	function goUpdateForm(no){
		etc.t_gubun.value="updateForm";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
	
	function goDelete(no){
		var yn = confirm("삭제하시겠습니까?");
		if(yn){
			etc.t_gubun.value="delete";
			etc.t_no.value=no;
			etc.method="post";
			etc.action="Etc";
			etc.submit();
		}
	}
</script>


<form name="etc">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>


		<div id="b_right">
		
			<p class="n_title">
				Free Board
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">${t_dto.getTitle()}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea style="width:98%; height:300px; padding:5px; border:none;" readonly>${t_dto.getContent()}</textarea></td>
					</tr>		
					<c:choose>
						<c:when test="${empty t_dto.getUpdate_date()}">
							<tr>
								<th>작성자</th>
								<td>${t_dto.getReg_name()}</td>
								<th>작성일</th>
								<td>${t_dto.getReg_date()}</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<th rowspan="2">작성자</th>
								<td rowspan="2">${sessionName}</td>
								<th>작성일</th>
								<td>${t_dto.getReg_date()}</td>
							</tr>	
							<tr>
								<th>수정일</th>
								<td>${t_dto.getUpdate_date()}</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</tbody>
				
			</table>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="25%">
					<col width="25%">
				</colgroup>
				<tbody>
					
					<tr>
						<th>댓글</th>
						<td colspan="3">
							<div style="display: flex;justify-content: space-between;">
								<div style="width:85%">
									<form name="comm">
										<input type="hidden" name="t_gubun">
										<input type="hidden" name="t_no" value="${t_dto.getNo()}">
										<input type="hidden" name="t_depth" value="${t_dto.getDepth()}">
										<c:choose>
											<c:when test="${not empty sessionId}">
												<textarea style="width:100%; height:50px; padding:5px;" name="t_comment"></textarea>
											</c:when>
											<c:otherwise>
												<textarea  readonly style="width:100%; height:50px;padding:5px 0 5px 5px;color:grey;">로그인 후 이용해 주세요.</textarea>
											</c:otherwise>
										</c:choose>
									</form>	
								</div>
								<div style="width:50px; height: 50px; line-height: 60px; padding-right:10px;">
									<c:if test="${not empty sessionId}">
										<input style="width: 50px; height:30px; border:1px solid #BDBDBD;" type="button" onclick="saveComment()"  value="등록">
									</c:if>
								</div>
							</div>
						</td>
					</tr>	
	
				
					<tr>
						<td style="border-bottom:none;"></td>
						<td colspan="3" style="border-bottom:none;">
							<div class="faq-group">
								
							</div>
						</td>
					</tr>

					
					
				</tbody>
			</table>
			
			
			<div class="preNext">
				<c:if test="${not empty t_preDto}">
					<a href="javascript:goView('${t_preDto.getNo()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
							<span class="preNextTitle">
									<c:set var="title" value="${t_preDto.getTitle()}"></c:set>
									<c:if test="${fn:length(t_preDto.getTitle()) > 10}"> 
										<c:set var="title" value="${fn:substring(t_preDto.getTitle(),0,10)}..."></c:set>
									</c:if>
									${title}
							</span>
						</p>
					</a>
				</c:if>
				<c:if test="${not empty t_nextDto}">
					<a href="javascript:goView('${t_nextDto.getNo()}')">
						<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
							<span class="preNextTitle">
									<c:set var="title" value="${t_nextDto.getTitle()}"></c:set>
									<c:if test="${fn:length(t_nextDto.getTitle()) > 10}"> 
										<c:set var="title" value="${fn:substring(t_nextDto.getTitle(),0,10)}..."></c:set>
									</c:if>
									${title}
							</span>
						</p>
					</a>
				</c:if>
				
			</div>			
			
			<div class="buttonGroup">
				<c:if test="${sessionId eq t_dto.getReg_id() && empty t_arr2}">
					<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
					<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				</c:if>
				<a href="Etc" class="butt">List</a>			
			</div>	
		
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    