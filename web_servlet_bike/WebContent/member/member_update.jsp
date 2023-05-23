<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<script type="text/javascript">

	function goUpdate(){

		if(checkValue(mem.t_name,"성명을 입력하세요"))return;
		
		if(checkValue(mem.t_address,"주소를 입력하세요"))return;
		if(checkValue(mem.t_mobile_1,"전화번호를 입력하세요"))return;
		var mo1= mem.t_mobile_1.value;
		var mo2= mem.t_mobile_2.value;
		var mo3= mem.t_mobile_3.value;
		if(mo1.length != 3){
			alert("3자리의 번호로 입력하세요");
			mem.t_mobile_1.focus();
			return;
		}
		if(checkValue(mem.t_mobile_2,"전화번호를 입력하세요"))return;
		if(mo2.length != 4 && mo2.length != 3){
			alert("3~4자리의 번호로 입력하세요");
			mem.t_mobile_2.focus();
			return;
		}
		if(checkValue(mem.t_mobile_3,"전화번호를 입력하세요"))return;
		if(mo3.length != 4){
			alert("4자리의 번호로 입력하세요");
			mem.t_mobile_3.focus();
			return;
		}
		
		if(checkValue(mem.t_pw,"비밀번호 확인을 입력하세요"))return;
		
		checkPassword();
		
		if(mem.t_result.value == "no"){
			alert("비밀번호가 일치하지 않습니다");
			mem.t_pw.focus();
			return;
		}
		
		mem.t_gubun.value= "memberUpdate";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}
	
	function checkPassword(){
		$.ajax({
			type : "POST",
			url : "CheckPassword",
			data: "t_id="+mem.t_id.value+"&t_pw="+mem.t_pw.value,
			async: false,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				var result= $.trim(data);
				mem.t_result.value=result;
			}
		});	

	}

</script>
		
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a><span class="fnt"><i class="fas fa-apple-alt"></i></span> MEMBER</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER UPDATE
			</p>
		<form name="mem">
		<input type="hidden" name="t_gubun">
		<input type="hidden" name="t_id" value="${t_dto.getId()}">
		<input type="hidden" name="t_result">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
					<td>${t_dto.getId()} </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input type="text" name="t_name" size="8" id="nana" maxlength="20" value="${t_dto.getName()}"></td>
				</tr>

				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울" <c:if test="${t_dto.getArea() eq '서울' }"> selected </c:if>>서울</option>
						<option value="대전" <c:if test="${t_dto.getArea() eq '대전' }"> selected </c:if>>대전</option>
						<option value="부산" <c:if test="${t_dto.getArea() eq '부산' }"> selected </c:if>>부산</option>
						<option value="대구" <c:if test="${t_dto.getArea() eq '대구' }"> selected </c:if>>대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input type="text" name="t_address" size="40" value="${t_dto.getAddress()}"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input type="text" name="t_mobile_1" size="2" maxlength="3" value="${t_dto.getMobile_1()}"> -
					<input type="text" name="t_mobile_2" size="3" maxlength="4" value="${t_dto.getMobile_2()}"> -
					<input type="text" name="t_mobile_3" size="3" maxlength="4" value="${t_dto.getMobile_3()}">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="F" name="t_gender" class="middleCheck"  <c:if test="${t_dto.getGender() eq '여성' }"> checked </c:if>/> 여&nbsp;&nbsp;        
					  <input type="radio" value="M" name="t_gender" class="middleCheck" <c:if test="${t_dto.getGender() eq '남성' }"> checked </c:if> /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="" name="t_travel" class="middleCheck" <c:if test="${t_dto.getTravel() eq 'Y' }"> checked </c:if> /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="" name="t_reading" class="middleCheck" <c:if test="${t_dto.getReading() eq 'Y' }"> checked </c:if>/> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="" name="t_sports" class="middleCheck" <c:if test="${t_dto.getSports() eq 'Y' }"> checked </c:if>/> 운동
				  </td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${t_dto.getReg_date() }</td>
				</tr>
				<tr>
					<th>최종 수정일</th>
					<td>${t_dto.getUpdate_date() }</td>
				</tr>
				<tr>
					<th>최근 로그인</th>
					<td>${t_dto.getLogin_time() }</td>
				</tr>
				<tr>
				  <th>비밀번호 확인</th>
				  <td><input type="password" name="t_pw" size="13" maxlength="70"></td>
				</tr>
				
			  </tbody>
			</table>
		</form>
		
			<div class="buttonGroup_center">
				<a href="javascript:goUpdate()" class="butt">UPDATE</a>
				
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






