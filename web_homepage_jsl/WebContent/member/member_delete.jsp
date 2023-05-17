<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*" %>
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
			mem.method="post";
			mem.action="db_member_delete.jsp";
			mem.submit();
		}
	</script>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>회원가입</h2>
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
                        <li></li>
                    </ul>
                </div>
            <form name="mem">
    
                    <tr>
                        <th><label for="pw">비밀번호 확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input size="40" type="password" name="t_pw" id="scrtNo" class="w300">
                            <p class="guideTxt"><span class="tc_point"></p>
                        </td>
                    </tr>
             	</tbody>
            </table>
            </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:goDelete()" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
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
