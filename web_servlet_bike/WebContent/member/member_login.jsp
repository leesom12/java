<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function memberLogin(){
		if(checkValue(frmLogin.t_id, "아이디를 입력하세요")) return;
		if(checkValue(frmLogin.t_pw, "비밀번호를 입력하세요"))return;
		frmLogin.method="post";
		frmLogin.action="Member";
		frmLogin.submit();
	}
	                    	
	function idCheck(){
		var keyValue= event.keyCode;
		if(keyValue==13){
		if(checkValue(frmLogin.t_id, "아이디를 입력하세요")) return;
			frmLogin.t_pw.focus();
		}
	}
	                    	
	function pwCheck(){
		var keyValue= event.keyCode;
		if(keyValue==13){
			if(checkValue(frmLogin.t_pw, "비밀번호를 입력하세요"))return;
			frmLogin.method="post";
			frmLogin.action="Member";
			frmLogin.submit();
		}
	}
</script>	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('memberJoin')"> JOIN</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER LOGIN
			</p>
			
			<div class="login">
				<div class="member_boxL">
					<h2>LOGIN</h2>
					<div class="login_form">
						<form name="frmLogin">
							<input type="hidden" name="t_gubun" value="login">
							<div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" id="mbrId" type="text" autofocus onkeypress="idCheck()"></div>
							<div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="t_pw" id="scrtNo" type="password" onkeypress="pwCheck()"></div>
							<a class="btn_login btn_Blue" href="javascript:memberLogin()">로그인</a>
							<div style="height:10px;width:300px"></div>
							<div style="font-size:13px;">아이디 입력</div>
						</form>
					</div>
				   
				</div>		
			</div>
			
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






