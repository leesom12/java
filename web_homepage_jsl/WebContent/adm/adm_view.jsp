<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp"%>
<%
	AdminDao dao= new AdminDao();
	request.setCharacterEncoding("UTF-8");
	if(!sessionLevel.equals("top")){
%>
		<script type="text/javascript">
			alert("관리자 화면입니다");
			location.href="../index.jsp";
		</script>
<%
	} else if(sessionId == null){
%>
		<script type="text/javascript">
			alert("로그인 정보가 만료되었습니다. 다시 로그인 해 주세요.");
			location.href="../login/member_login.jsp";
		</script>		
<%
	} else{
		String id= request.getParameter("t_id");
		AdminDto dto = dao.getMemberView(id);

%>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>회원 상세 정보</h2>
	<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
		<div class="con_title">
            <h1>회원정보(관리자)</h1>
         <p>HOME / 관리자 / 회원정보(관리자)</p>
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
                        <td><%=dto.getName() %></td>
                    </tr>
                    <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td><%=dto.getId() %></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><%=dao.getPasswordLength(id, dto.getPass_length()) %></td>
                    </tr>
                    
                    <tr>
                        <th>소속<span class="must"></th>
                     	<td><%=dto.getJob() %></td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td><%=dto.getTell() %></td>
                        
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td><%=dto.getMobile() %></td>
                        
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td><%=dto.getEmail() %></td>
                    </tr>
                    <tr>
                    	<th>가입일</th>
                        <td><%=dto.getReg_date() %></td>
                    </tr>
                    <tr>
                    	<th>최근 로그인 일시</th>
                        <td><%=dto.getLogin_time() %></td>
                    </tr>
                    
                </tbody>
            </table>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="../index.jsp" class="btn_round btn_large btn_BlueGray w180"><b>홈페이지</b></a>
        <a href="adm_list.jsp" class="btn_round btn_large btn_pointColor w180"><b>회원목록</b></a>
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

