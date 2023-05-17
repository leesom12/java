<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<!-- sub contents -->
<script type="text/javascript">
	function fn_login(){
		if(checkValue(admin.t_id, "아이디를 입력하세요")) return;
		if(checkValue(admin.t_password, "비밀번호를 입력하세요"))return;
		admin.method="post";
		admin.action="db_admin_login.jsp";
		admin.submit();
	}
	                    	
	function idCheck(){
		var keyValue= event.keyCode;
		if(keyValue==13){
			if(checkValue(admin.t_id, "아이디를 입력하세요")) return;
			admin.t_password.focus();
		}
	}
	                    	
	function pwCheck(){
		var keyValue= event.keyCode;
		if(keyValue==13){
			if(checkValue(admin.t_password, "비밀번호를 입력하세요"))return;
			admin.method="post";
			admin.action="db_admin_login.jsp";
			admin.submit();
		}
	}
</script>
	<div class="sub_title">
		<h2>관리자 로그인</h2>
		<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="bg_admim">
		<div class="container">
			<div class="grap">
				<form name="admin">
					<fieldset>
						<legend class="sr-only">관리자로그인</legend>
						<label for="id" class="sr-only">아이디</label><input name="t_id" width="20" autofocus onkeypress="idCheck()" id="t_id" type="text">
                    	<label for="pw" class="sr-only">비밀번호</label><input name="t_password" onkeypress="pwCheck()" id="t_password" type="password">
						<a href="javascript:fn_login()"  class="btn_admin">로그인</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<!-- end contents -->


	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

	<%@ include file="../common_footer.jsp" %>
 </body>
</html>









