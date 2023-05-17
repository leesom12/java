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
		function memberUpdate(){
			
			if(checkValue(mem.t_name, "성명을 입력하세요"))return;
			
			var tell2_length= mem.t_tell_2.value.length;
			var tell3_length= mem.t_tell_3.value.length;
			if(mem.telNo1.value != "" && tell3_length == 0 && tell2_length == 0){
				alert("유선번호를 입력하세요");
				mem.telNo1.focus();
				return;
			}
			if(tell2_length != 3 && tell2_length != 0){
				alert("유선전화번호 3자리로 입력하세요");
				mem.t_tell_2.focus();
				return;
			}
			if(tell2_length == 3 && tell3_length == 0){
				alert("유선전화번호 4자리로 입력하세요");
				mem.t_tell_3.focus();
				return;
			}
			if(tell3_length != 4 && tell3_length != 0){
				alert("유선전화번호 4자리로 입력하세요");
				mem.t_tell_3.focus();
				return;
			}
			if(tell3_length == 4 && tell2_length == 0){
				alert("유선전화번호 3자리로 입력하세요");
				mem.t_tell_2.focus();
				return;
			}
			if(mem.telNo1.value == "" && tell3_length == 4 && tell2_length == 3){
				alert("지역번호를 선택하세요");
				mem.telNo1.focus();
				return;
			}
			
			if(checkValue(mem.t_mobile_2,"휴대폰 번호를 입력하세요"))return;
			var mobile= mem.t_mobile_2.value;
			if(mobile.length != 4){
				alert("4자리의 숫자로 입력하세요");
				mem.t_mobile_2.focus();
				return;
			}
			var mobile= mem.t_mobile_3.value;
			if(mobile.length != 4){
				alert("4자리의 숫자로 입력하세요");
				mem.t_mobile_3.focus();
				return;
			}
			if(checkValue(mem.t_mobile_3,"휴대폰 번호를 입력하세요"))return;
			if(checkValue(mem.t_email, "이메일을 입력하세요"))return;
			
			if(checkValue(mem.t_pw, "비밀번호 확인을 입력하세요"))return;
			
			mem.method="post";
			mem.action="db_member_update.jsp";
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
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
            <form name="mem">
             <input type="hidden" name="t_id" value="<%=dto.getId() %>">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>
                           <%= dto.getId() %>
						</td>
                    </tr>
                    
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                            <input type="text" value="<%=dto.getName() %>" name="t_name" id="mbrName" class="w300" autofocus>
                        </td>
                    </tr>
                    
                    
                    <tr>
                        <th>소속<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
                            <select name="t_job" id="mbrClCd">
                                 <option value="기업" <%if(dto.getJob().equals("기업")) out.print("selected");%>>기업</option>
                                 <option value="교수자" <%if(dto.getJob().equals("교수자")) out.print("selected");%>>교수자</option>
                                 <option value="미취업자" <%if(dto.getJob().equals("미취업자")) out.print("selected");%>>미취업자</option>    
                                 <option value="기타" <%if(dto.getJob().equals("기타")) out.print("selected");%>>기타</option>
                            </select>
                            <p class="guideTxt">학생 신분은 '미취업자-학생' 소속으로 선택해주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                            <%
                            	String i="";
                            	if(dto.getTell_1()!=null) i=dto.getTell_1();
                            	String a="";
                            	if(dto.getTell_2()!=null) a=dto.getTell_2();
                            	String b="";
                            	if(dto.getTell_3()!=null) b=dto.getTell_3();
                            %>
                            <input type="hidden" name="telNo" id="telNo" value="">
                            <label for="phone_number1" class="blind">유선전화 앞번호 선택</label>
                            <select name="telNo1" id="telNo1" class="w95">
	                                	<option value="" <%if(i.equals("")) out.print("selected");%>>선택</option>
	                                    <option value="02" <%if(i.equals("02")) out.print("selected"); %>>02</option>
	                                    <option value="042" <%if(i.equals("042")) out.print("selected"); %>>042</option>
	                                    <option value="051" <%if(i.equals("051")) out.print("selected"); %>>051</option>
	                                    <option value="061" <%if(i.equals("061")) out.print("selected"); %>>061</option>
	                                    <option value="070" <%if(i.equals("070")) out.print("selected"); %>>070</option>
                            </select>
                            <input type="text" name="t_tell_2" id="telNo2" class="w95" value="<%=a %>" maxlength="3"><label for="phone_number2" class="blind">중간번호</label>
                            <input type="text" name="t_tell_3" id="telNo3" class="w95" value="<%=b %>" maxlength="4"><label for="phone_number3" class="blind">마지막번호</label>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                            <label for="mphonNo1" class="blind">휴대전화 앞번호 선택</label>
                            <select name="t_mobile_1" id="mphonNo1" class="w95">
                                    <option value="010" <%if(dto.getMobile().substring(0, 3).equals("010")) out.print("selected");%>>010</option>
                                    <option value="011" <%if(dto.getMobile().substring(0, 3).equals("011")) out.print("selected");%>>011</option>
                            </select>
                            <input type="text" name="t_mobile_2" id="mphonNo2" class="w95" value="<%=dto.getMobile().substring(3, 7) %>" maxlength="4"><label for="mphonNo2" class="blind">중간번호</label>
                            <input type="text" name="t_mobile_3" id="mphonNo3" class="w95" value="<%=dto.getMobile().substring(7)%>" maxlength="4"><label for="mphonNo3" class="blind">마지막번호</label>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <input type="email" name="t_email" id="email" class="w300" value="<%=dto.getEmail() %>">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw">비밀번호 확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="t_pw" id="scrtNo" class="w300">
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
        <a href="javascript:memberUpdate()" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
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
