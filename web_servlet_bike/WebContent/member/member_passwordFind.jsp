<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function memberPassword(){
		if(checkValue(frmLogin.t_id, "아이디를 입력하세요")) return;
		if(checkValue(frmLogin.t_mobile_1, "전화번호를 입력하세요"))return;
		if(checkValue(frmLogin.t_mobile_2, "전화번호를 입력하세요"))return;
		if(checkValue(frmLogin.t_mobile_3, "전화번호를 입력하세요"))return;
		if(checkValue(frmLogin.t_email, "이메일을 입력하세요"))return;
		frmLogin.method="post";
		frmLogin.action="Member";
		frmLogin.submit();
	}
</script>	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('memberJoin')"> JOIN</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				ID / PASSWORD
			</p>
			
			<div class="login">
				<div class="member_boxL">
					<h2>ID / PASSWORD</h2>
					<div class="login_form">
						<form name="frmLogin">
							<input type="hidden" name="t_gubun" value="memberPasswordSend">
							<div class="fl_clear"><label for="mbrId">아이디</label><input class="t_id" name="t_id" id="mbrId" type="text" autofocus></div>
							<div class="fl_clear"><label for="scrtNo">전화번호</label><input class="t_mobile" name="t_mobile_1" id="scrtNo" type="text" maxlength="3">-
								<input class="t_mobile" name="t_mobile_2" id="scrtNo" type="text" maxlength="4">-
								<input class="t_mobile" name="t_mobile_3" id="scrtNo" type="text" maxlength="4">
							</div>
							<div class="fl_clear"><label for="scrtNo">이메일</label><input class="t_id" name="t_email" id="scrtNo" type="text"></div>
							<a class="btn_login btn_Blue" href="javascript:memberPassword()">search</a>
						</form>
					</div>
				   
				</div>		
			</div>
			
		</div>	
	</div>
<%@include file="../common_footer.jsp" %>
</body>
</html>






