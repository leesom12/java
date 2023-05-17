<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>    
<%
	StudentDao dao = new StudentDao();
	String syear  = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno 	  = request.getParameter("t_sno");
	
	StudentDto dto =
		       dao.getStudentView(syear,sclass,sno);
	
%>    
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >		
	
	<script type="text/javascript">
		function goUpdateForm(){
			stu.method="post";
			stu.action="student_update.jsp";
			stu.submit();
		}
		
		function goDelete(){
			if(confirm("삭제하시겠습니까?")==true){
				stu.method="post";
				stu.action="db_student_delete.jsp";
				stu.submit();
			}else{
				location.href="student_list.jsp";
			}
		}
	</script>
</head>
<body>
<form name="stu">
	<input type="hidden" name="t_syear" value="<%=dto.getSyear()%>">
	<input type="hidden" name="t_sclass" value="<%=dto.getSclass()%>">
	<input type="hidden" name="t_sno" value="<%=dto.getSno()%>">
</form>
	<div class="container">

		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 이소민 성적관리</h1>
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
							<th>학 년</th>
							<td class="th_left">
								<%=dto.getSyear()%> 학년
							</td>
						</tr>
						<tr>
							<th>반</th>
							<td class="th_left">
								<%=dto.getSclass()%> 반
							</td>
						</tr>
						<tr>
							<th>번호</th>
							<td class="th_left">
								<%=dto.getSno()%> 번
							</td>
						</tr>
						<tr>
							<th>성 명</th>
							<td class="th_left">
								<%=dto.getName()%> 
							</td>
						</tr>
						<tr>
							<th>국 어</th>
							<td class="th_left">
								<%=dto.getKor()%> 점
							</td>
						</tr>
						<tr>
							<th>영 어</th>
							<td class="th_left">
								<%=dto.getEng()%> 점
							</td>
						</tr>
						<tr>
							<th>수 학</th>
							<td class="th_left">
								<%=dto.getMat()%> 점
							</td>
						</tr>
						<tr>
							<th>총 점</th>
							<td class="th_left">
								<%=dto.getTotal()%> 점
							</td>
						</tr>
						<tr>
							<th>평 균</th>
							<td class="th_left">
								<%=dto.getAve()%> 점
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		
			<div class="btn_wrap">
				<input type="button" value="목록" onclick="location.href='student_list.jsp'" class="btn_list">&nbsp;&nbsp;
				<input type="button" value="수정" onclick="goUpdateForm()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="goDelete()" class="btn_ok">
			</div>
		</div>
	</div>
</body>
</html>






