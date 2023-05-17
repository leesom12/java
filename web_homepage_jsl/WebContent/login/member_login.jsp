<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ include file="../common_header.jsp" %>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>접속자 로그인</h2>
	<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
			<div class="member_boxL">
                <h2>개인회원</h2>
                <div class="login_form">
                    <script type="text/javascript">
                    	function fn_login(){
                    		if(checkValue(mem.t_id, "아이디를 입력하세요")) return;
                    		if(checkValue(mem.t_password, "비밀번호를 입력하세요"))return;
                    	 	mem.method="post";
                        	mem.action="db_member_login.jsp";
                        	mem.submit();
                    	}
                    	
                    	function idCheck(){
                    		var keyValue= event.keyCode;
                    		if(keyValue==13){
                    			if(checkValue(mem.t_id, "아이디를 입력하세요")) return;
                    			mem.t_password.focus();
                    		}
                    	}
                    	
                    	function pwCheck(){
                    		var keyValue= event.keyCode;
                    		if(keyValue==13){
                    			if(checkValue(mem.t_password, "비밀번호를 입력하세요"))return;
                    			mem.method="post";
                            	mem.action="db_member_login.jsp";
                            	mem.submit();
                    		}
                    	}
                    </script>
                    
                    <form name="mem">
                    <div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" autofocus onkeypress="idCheck()" id="t_id" type="text"></div>
                    <div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="t_password" onkeypress="pwCheck()" id="t_password" type="password"></div>
                    <a class="btn_login btn_Blue" href="javascript:fn_login();">로그인</a>
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

