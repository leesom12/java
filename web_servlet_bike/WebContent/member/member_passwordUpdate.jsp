<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function passUpdate(){
		if(checkValue(frmLogin.t_now_pw, "현재 비밀번호를 입력하세요")) return;
		if(checkValue(frmLogin.t_pw, "새 비밀번호를 입력하세요"))return;
		if(checkValue(frmLogin.t_pw_2, "새 비밀번호 확인를 입력하세요"))return;
		if(frmLogin.t_pw.value != frmLogin.t_pw_2.value){
			alert("비밀번호 확인이 일치하지 않습니다");
			frmLogin.t_pw_2.focus();
			return; 
		}
		frmLogin.method="post";
		frmLogin.action="Member";
		frmLogin.submit();
	}
	
	function goPw(){
		frmLogin.t_pw.focus();
	}
	function goPw2(){
		frmLogin.t_pw_2.focus();
	}
</script>	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a> <span class="fnt"><i class="fas fa-apple-alt"></i></span>MEMBER</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER PASSWORD CHANGE
			</p>
			
			<div class="login">
				<div class="member_boxL">
					<h2>PASSWORD CHANGE</h2>
					<div class="login_form">
						<form name="frmLogin">
							<input type="hidden" name="t_gubun" value="memberPasswordUpdate">
							
							<div class="fl_clear"><label class="pw_label" for="mbrId">현재 비밀번호</label><input class="t_id" name="t_now_pw" id="mbrId" type="password" onkeypress="if(event.keyCode==13){goPw()}" autofocus></div>
							<div class="fl_clear"><label class="pw_label" for="scrtNo">새 비밀번호</label><input class="t_id" name="t_pw" id="scrtNo" type="password" onkeypress="if(event.keyCode==13){goPw2()}"></div>
							<div class="fl_clear"><label class="pw_label" for="scrtNo">새 비밀번호 확인</label><input class="t_id" name="t_pw_2" id="scrtNo" type="password" onkeypress="if(event.keyCode==13){passUpdate()}"></div>
							<a class="btn_passChange btn_Blue" href="javascript:passUpdate()">비밀번호변경</a>
						</form>
					</div>
				   
				</div>		
			</div>
			
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






