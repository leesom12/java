<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "dto.*, dao.*" %>
<%
	MemberDao dao = new MemberDao();
	String id= request.getParameter("id");
	ArrayList<MemberDto> arr= dao.memberList("id",id);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	
	<script type="text/javascript">
		function goDelete(){
			var tf= confirm("삭제하시겠습니까?");
			if(tf){
				mem.method="post";
				mem.action="db_member_delete.jsp";
				mem.submit();
			}else{
				location.href="member_list.jsp";
			}
		}
		
		function goList(){
			location.href="member_list.jsp";
		}
		
		function goUpdateForm(){
			mem.method="post";
			mem.action="member_update.jsp";
			mem.submit();
		}
	</script>

</head>
<body>
<form name="mem">
	<input type="hidden" name="t_id" value="<%=id%>">
</form>
	<div class="container">
	
		<div class="leftmargin">
			<a href="member_list.jsp"><img src="../images/jsl_logo.png"></a><h1>TRACK11 이소민 회원관리</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
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
								<%=arr.get(0).getName() %>
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<%=arr.get(0).getAge() %>
							</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="th_left">
								<%=arr.get(0).getReg_Date()%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="goList()" value="목록" class="btn_list">
				<input type="button" onClick="goUpdateForm()" value="수정" class="btn_list">
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>

