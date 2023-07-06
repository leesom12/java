<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>

<c:if test="${sessionLevel ne 'admin'}">
	<script type="text/javascript">
		alert("관리자 전용 페이지입니다!");
		location.href="Index";
	</script>	
</c:if>	

<form name="sale">
	<input type="hidden" name="t_gubun">
</form>
	<div id="b_left">
		<P>Admin</P>
		<ul>
			<li><a href="Admin">
				MEMBER
			</a></li>
			<li><a href="Product">
				<span class="fnt"><i class="fas fa-apple-alt"></i></span>
				PRODUCT
			</a></li>
			<li><a href="ProductSale">
				판매리스트
			</a></li>
			<li><a href="javascript:goSaleTrend()">
				판매현황
			</a></li>
		</ul>
	</div>

<style>
	#preview-image{
		border: 1px solid grey;
		width: 400px;
		height: 400px;
		margin: 0 0 10px 50px;
		display: none;
	}
</style>
<script type="text/javascript">
	function goSaleTrend(){
		pro.t_gubun.value="saleTrend";
		pro.method="post";
		pro.action="ProductSale";
		pro.submit();
	}
</script>

<form name="pro">
	<input type="hidden" name="t_gubun">
</form>

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
		if(checkValue(product.t_title,"상품명을 입력하세요"))return;
		if(product.t_title.value.length > 50){
			alert("50자 이내의 상품명으로 입력하세요");
			return;
		}
		if(checkValue(product.t_content,"상세설명을 입력하세요"))return;
		if(product.t_content.value.length > 1000){
			alert("1000자 이내의 상세설명으로 입력하세요");
			return;
		}
		if(checkValue(product.t_size,"상품 규격을 입력하세요"))return;
		if(checkValue(product.t_price,"상품 가격을 입력하세요"))return;
		if(checkValue(product.t_level,"우선순위를 선택하세요"))return;
		if(checkValue(product.t_attach,"첨부 이미지를 선택하세요"))return;
		
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		var fileName = product.t_attach.value;
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
		var file = product.t_attach;
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

		product.method="post";
		product.action="Product?t_gubun=save";
		product.submit();
		

	}
</script>
		
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<form name="product" enctype="multipart/form-data">			<!-- 폼에서 첨부파일을 보내려면 enctype="multipart/form-data"을 지정해야 함 -->
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>상품명</th>
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>상세설명</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>규격</th>
						<td><input type="text" name="t_size" style="width:260px;height:22px;text-align:right;"></td>
						<th>가격</th>
						<td><input type="text" name="t_price" style="width:260px;height:22px;text-align:right;"></td>
					</tr>
					<tr>
						<th>우선순위</th>
						<td colspan="3">
							<input type="radio" name="t_level" value="1"> 보통 &nbsp;&nbsp;
							<input type="radio" name="t_level" value="2"> 중요
						</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td colspan="3">
							*이미지 첨부 필수 400*400 권장 <br><br>
							<img id="preview-image">
							<input type="file" class="input600" name="t_attach" id="input-image">
						</td>
					</tr>	

					<tr>
						<th>등록자</th>
						<td>${sessionName}</td>
						<th>등록일</th>
						<td>${t_todayTime}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Product" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






    