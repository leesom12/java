<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<style>
	#preview-image{
		border: 1px solid grey;
		width: 500px;
		height: 300px;
		margin: 0 0 10px 50px;
		
	}
</style>

<script type="text/javascript"> //이미지 미리보기
$(function(){					
	function readImage(input) {
	    // 인풋 태그에 파일이 있는 경우
	    if(input.files && input.files[0]) {
	        // 이미지 파일인지 검사 (생략)
	        // FileReader 인스턴스 생성
	        const reader = new FileReader()
	        // 이미지가 로드가 된 경우
	        reader.onload = e => {
	            const previewImage = document.getElementById("preview-image")
	            previewImage.src = e.target.result;
	        }
	        // reader가 이미지 읽도록 하기
	        reader.readAsDataURL(input.files[0])
	    } else {
	    	// 이미지 안올렸으면
			$("#preview-image").attr('src','');
			$("#preview-image").css("display","none");
	    }
	}
		// input file에 change 이벤트 부여
		const inputImage = document.getElementById("input-image");
		inputImage.addEventListener("change", e => {
			$("#preview-image").css("display","block");
		    readImage(e.target)
		})	
	});	
</script>


<script type="text/javascript">
function goUpdate(){
	if(checkValue(news.t_title,"제목을 입력하세요"))return;
	if(checkValue(news.t_content,"내용을 입력하세요"))return;
	
	/***  첨부파일 검사 ***/
	// 1.확장자 검사
	var fileName = news.t_attach.value;
	if(fileName != ""){ //  C:\fakepath\img_1.png
		var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
		var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
		//파일명.확장자
//		if(extension != "jpg" && extension != "gif" && extension != "png"){
		if(extension != "jpg" && extension != "png" && extension != "gif"){
			alert(extension +" 형식 파일은 업로드 안됩니다. JPG, PNG, GIF 파일만 가능!");
			return;
		}		
	}
	
	// 2.첨부 용량 체크	
	var file = news.t_attach;
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

	
	news.method="post";
	news.action="News?t_gubun=update";
	news.submit();
}
</script>
		
		<div id="b_right">
			<p class="n_title">
				NEWS
			</p>
			<form name="news" enctype="multipart/form-data">
			<input name="t_no" type="hidden" value="${t_dto.getNo()}">
			<input name="t_regId" type="hidden" value="${t_dto.getReg_id()}">
			<input name="t_regDate" type="hidden" value="${t_dto.getReg_date()}">
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
						<td colspan="3"><input type="text" name="t_title" class="input600" value="${t_dto.getTitle()}"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content">${t_dto.getContent()}</textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
							<img src="attach/news/${t_dto.getAttach()}" id="preview-image">
							<input type="hidden" name="t_oriAttach" value="${t_dto.getAttach()}">
							<input type="file" class="input600" name="t_attach" id="input-image">
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="News" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<div id="footer_div">	
<%@include file="../common_footer.jsp" %>
	</div>	
</body>
</html>






    