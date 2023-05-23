<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<script type="text/javascript">
	
	function goSave(){
		if(checkValue(mem.t_id,"id를 입력하세요"))return;
		var id= mem.t_id.value;
		if(id.length<3 || id.length>20){
			alert("3자 이상 20자 이내의 ID로 입력하세요");
			mem.t_id.focus();
			return;
		}
		if(checkValue(mem.t_name,"성명을 입력하세요"))return;
		if(checkValue(mem.t_pw,"비밀번호를 입력하세요"))return;
		if(checkValue(mem.t_pw_ch,"비밀번호 확인을 입력하세요"))return;
		if(mem.t_pw.value != mem.t_pw_ch.value){
			alert("비밀번호가 일치하지 않습니다");
			mem.t_pw_ch.focus();
			return;
		}
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
		
		if(checkValue(mem.t_gender,"성별을 선택하세요"))return;
		
		if(checkValue(mem.t_idCheckValue,"ID 중복검사 실행"))return;
		if(mem.t_idCheck.value == "이미 존재하는 ID"){
			alert("이미 존재하는 ID입니다");
			mem.t_id.focus();
			return;
		}
		if(mem.t_id.value != mem.t_idCheckValue.value){
			alert("ID 중복검사 실행");
			return;
		}
		
		mem.t_gubun.value= "memberSave";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}
	
	function checkId(){
		if(checkValue(mem.t_id, "ID를 입력하세요"))return;
		var idLength= mem.t_id.value.length;
		
		$.ajax({
			type : "POST",
			url : "CheckId",
			data: "t_id="+mem.t_id.value,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				var result= $.trim(data);
				if(idLength<3 || idLength>20){
					mem.t_idCheck.value= "3~20자리로 입력";	
				}else{
					mem.t_idCheck.value= result;
					if(result == "사용 가능"){
						mem.t_idCheckValue.value = mem.t_id.value;
					} else{
						mem.t_idCheckValue.value ="";
					}
				}
			}
		});				
	}

</script>
		
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('memberJoin')"><span class="fnt"><i class="fas fa-apple-alt"></i></span> JOIN</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
			</p>
		<form name="mem">
		<input type="hidden" name="t_gubun">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					<input name="t_id" type="text" size="10" id="id" title="id입력하세요">
					<input type="button" onclick="checkId()" value="ID중복검사" class="checkB">
					<input type="text" name="t_idCheck" readonly size="15" style="border:none;font-size:11px;">
					<input type="hidden" name="t_idCheckValue">
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input type="text" name="t_name" size="8" id="nana" maxlength="20"></td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td><input type="password" name="t_pw" size="13" maxlength="70"></td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input type="password" name="t_pw_ch" size="13" maxlength="70"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="부산">부산</option>
						<option value="대구">대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input type="text" name="t_address" size="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input type="text" name="t_mobile_1" size="2" maxlength="3"> -
					<input type="text" name="t_mobile_2" size="3" maxlength="4"> -
					<input type="text" name="t_mobile_3" size="3" maxlength="4">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="F" name="t_gender" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="M" name="t_gender" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="" name="t_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="" name="t_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="" name="t_sports" class="middleCheck" /> 운동
				  </td>
				</tr>
			  </tbody>
			</table>
		</form>
		
			<div class="buttonGroup_center">
				<a href="javascript:goSave()" class="butt">JOIN</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






