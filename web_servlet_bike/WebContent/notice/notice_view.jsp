<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2">구매 절차 과정 안내 드립니다.</td>
						<td> <i class="far fa-eye"></i> 152</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>구매 절차 과정 안내 드립니다.구매 절차 과정 안내 드립니다.구매 절차 과정 안내 드립니다.</textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">구매안내.hwp</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>관리자</td>
						<th>RegDate</th>
						<td>2020-09-01</td>
					</tr>	

				</tbody>
			</table>
			<div class="preNext">
				<a href="javascript:goView('N002')">
					<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<span class="preNextTitle">
									이전 게시물 제목...
						</span>
					</p>
				</a>
				<a href="javascript:goView('N004')">
					<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
						<span class="preNextTitle">
									다음 게시물 제목...
						</span>
					</p>
				</a>
				
			</div>			
			<div class="buttonGroup">
				<a href="" class="butt">Delete</a>
				<a href="notice_update.html" class="butt">Update</a>
				<a href="notice_list.html" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    