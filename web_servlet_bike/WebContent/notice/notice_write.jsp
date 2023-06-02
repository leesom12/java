<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<c:if test="${sessionLevel ne 'admin'}">
	<script>
		alert("관리자 전용 화면입니다!");
		location.href="Notice";
	</script>
</c:if>

<script type="text/javascript">
	function goSave(){					
		if(checkValue(notice.t_title,"제목을 입력하세요"))return;
		if(checkValue(notice.t_content,"내용을 입력하세요"))return;
		
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		var fileName = notice.t_attach.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
	//		if(extension != "jpg" && extension != "gif" && extension != "png"){
			if(extension != "pdf" && extension != "hwp" && extension != "png"){
				alert(extension +" 형식 파일은 업로드 안됩니다. 한글, PDF, PNG 파일만 가능!");
				return;
			}		
		}
		
		// 2.첨부 용량 체크	
		var file = notice.t_attach;
		var fileMaxSize  = 5; // 첨부 최대 용량 설정
		if(file.value !=""){
			// 사이즈체크
			var maxSize  = 1024 * 1024 * fileMaxSize;
			var fileSize = 0;
			// 브라우저 확인
			var browser=navigator.appName;
			// 익스플로러일 경우
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
			// 익스플로러가 아닐경우
				fileSize = file.files[0].size;
			}
	
			if(fileSize > maxSize){
				alert(" 첨부파일 사이즈는 "+fileMaxSize+"MB 이내로 등록 가능합니다. ");
				return;
			}	
		}
		
		notice.method="post";
		notice.action="Notice?t_gubun=save"; 	//enctype으로 할 때는 request.getParameter 못 쓰기 때문에 input으로 보내면 controller에서 인식 못한다!!!
		notice.submit();
	}
</script>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="notice" enctype="multipart/form-data">			<!-- 폼에서 첨부파일을 보내려면 enctype="multipart/form-data"을 지정해야 함 -->
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><input type="file" class="input600" name="t_attach"></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${sessionName}</td>
						<th>RegDate</th>
						<td>${t_today}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Notice" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    