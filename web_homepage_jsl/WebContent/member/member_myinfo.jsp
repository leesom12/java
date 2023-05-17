<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%
	MemberDao dao= new MemberDao();
	request.setCharacterEncoding("UTF-8");
	String sessionId= (String)session.getAttribute("sessionId");
	if(sessionId == null){
%>
		<script type="text/javascript">
			alert("로그인 정보가 만료되었습니다. 다시 로그인 해 주세요.");
			location.href="../login/member_login.jsp";
		</script>
<%
	} else{
		MemberDto dto= dao.viewInfo(sessionId);
%>
 <%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function goDelete(){
		var yn= confirm("정말 탈퇴하시겠습니까?");
		if(yn){
			location.href="member_delete.jsp";
		}
	}
</script>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>MY PAGE</h2>
	<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                        	<input type="text" name="mobile" value="<%=dto.getName() %>" readonly style="border:none;font-size:17.5px;">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>
                        	<input type="text" name="mobile" value="<%=dto.getId() %>" readonly style="border:none;font-size:17.5px;">
                        </td>
                    </tr>
                    
                    <tr>
                        <th>소속<span class="must"></th>
                     	<td>
                        	<input type="text" name="job" value="<%=dto.getJob() %>" readonly style="border:none;font-size:17.5px;">
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                        	<%if(dto.getTell_1() != null){%>
	                        	<input type="text" size="3" name="tell_1" value="<%=dto.getTell_1() %>" readonly style="border:none;font-size:17.5px;text-align:center;">-
	                        	<input type="text" size="3" name="tell_2" value="<%=dto.getTell_2() %>" readonly style="border:none;font-size:17.5px;text-align:center;">-
	                        	<input type="text" size="4" name="tell_3" value="<%=dto.getTell_3() %>" readonly style="border:none;font-size:17.5px;text-align:center;">
                        	<%} %>
                        </td>
                        
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                        	<input type="text" size="3" name="mobile" value="<%=dto.getMobile().substring(0,3)+"-" %>" readonly style="border:none;font-size:17.5px;">
                        	<input type="text" size="4" name="mobile" value="<%=dto.getMobile().substring(3,7)+"-" %>" readonly style="border:none;font-size:17.5px;">
                        	<input type="text" size="4" name="mobile" value="<%=dto.getMobile().substring(7) %>" readonly style="border:none;font-size:17.5px;">
                        </td>
                        
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <input type="text" name="email" id="email" class="w300 css-style" value="<%=dto.getEmail() %>" readonly style="border:none;font-size:17.5px;" >
                        </td>
                    </tr>
                    <tr>
                    	<th>가입일</th>
                        <td><input type="text" name="date" value="<%=dto.getReg_date() %>" readonly style="border:none;font-size:17.5px;"></td>
                    </tr>
                    
                </tbody>
            </table>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="../index.jsp" class="btn_round btn_large btn_BlueGray w180"><b>홈페이지</b></a>
        <a href="member_update.jsp" class="btn_round btn_large btn_pointColor w180"><b>회원정보 수정</b></a>
        <a href="javascript:goDelete();" style="background:#FE2E2E; color:white;" class="btn_round btn_large w180"><b>회원 탈퇴</b></a>
    </div>
	
	
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
<%} %>

