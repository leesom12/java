<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.*, dao.*" %>
<%
	MemberDao dao= new MemberDao();
	String id= request.getParameter("t_id");
	ArrayList<MemberDto> arr= dao.memberList("id", id);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	
	<script type="text/javascript">
		function goUpdate(){
			if(mem.t_name.value==""){
				alert("이름 입력");
				mem.t_name.focus();
				return;
			}else if(mem.t_reg_date.value==""){
				alert("날짜 선택");
				mem.t_reg_date.focus();
				return;
			}
			
			mem.method="post";
			mem.action="db_member_update.jsp?";
			mem.submit();
		}
	</script>
	
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<a href="member_list.jsp"><img src="../images/jsl_logo.png"></a><h1>TRACK11 이소민 회원관리</h1>
		</div>		
		<div class="write_wrap">
		
			<form name="mem">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<form name="mem">
						<input type="hidden" name="t_id" value="<%=id%>">
						<tbody>
							<tr>
								<th>ID</th>
								<td class="th_left">
									<%=arr.get(0).getId() %>
								</td>
							</tr>
							<tr>
								<th>성명</th>
								<td class="th_left">
									<input name="t_name" value="<%=arr.get(0).getName() %>" class="input_300px" type="text">
								</td>
							</tr>
							<tr>
								<th>나이</th>
								<td class="th_left">
									<input name="t_age" value="<%=arr.get(0).getAge() %>" class="input_100px" type="text">
								</td>
							</tr>
							<tr>
								<th>가입일</th>
								<td class="th_left">
									<input name="t_reg_date" value="<%=arr.get(0).getReg_Date() %>" class="input_200px" type="date">							
								</td>
							</tr>
						</tbody>
					</form>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='member_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>
