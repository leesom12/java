<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%@include file="../common_menu.jsp" %>

<c:if test="${empty sessionId}">
	<script type="text/javascript">
		alert("회원 전용 화면입니다. 로그인 후 이용해주세요");
		location.href="Member";
	</script>
</c:if>

<style>
	#preview-image{
		border: 1px solid grey;
		width: 400px;
		height: 400px;
		margin: 0 0 10px 50px;
		display: none;
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
	function goSave(){					
		if(checkValue(freeboard.t_title,"제목을 입력하세요"))return;
		if(freeboard.t_title.value.length > 50){
			alert("50자 이내의 제목으로 입력하세요");
			return;
		}
		if(checkValue(freeboard.t_content,"내용을 입력하세요"))return;
		if(freeboard.t_content.value.length > 1000){
			alert("1000자 이내의 내용으로 입력하세요");
			return;
		}
		
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		var fileName = freeboard.t_attach.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
	//		if(extension != "jpg" && extension != "gif" && extension != "png"){
			if(extension != "pdf" && extension != "hwp" && extension != "png" && extension != "jpg" && extension != "gif"){
				alert(extension +" 형식 파일은 업로드 안됩니다. 한글, PDF, PNG, jpg, gif 파일만 가능!");
				return;
			}		
		}
		
		// 2.첨부 용량 체크	
		var file = freeboard.t_attach;
		var fileMaxSize  = 10; // 첨부 최대 용량 설정
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
		
		freeboard.method="post";
		freeboard.action="FreeBoard?t_gubun=write";
		freeboard.submit();
	}
</script>
		
		<div id="b_right">
			<p class="n_title">
				Free Board
			</p>
			<form name="freeboard" enctype="multipart/form-data">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>첨부</th>
						<td colspan="3">
							<img id="preview-image">
							<input type="file" class="input600" name="t_attach" id="input-image">
						</td>
					</tr>	
					<tr>
						<th>작성자</th>
						<td>${sessionName}</td>
						<th>작성일</th>
						<td>${t_today}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="FreeBoard" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    