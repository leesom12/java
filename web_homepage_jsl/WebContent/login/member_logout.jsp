<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionName= (String)session.getAttribute("sessionName");
	if(sessionName == null){
		sessionName="";
	}else{
		sessionName= sessionName+"님";
	}
	session.invalidate();		// session.invalidate(); 세션 변수값을 모두 없앰
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=sessionName%> 로그아웃 되었습니다");
	location.href="../index.jsp"
</script>
</head>
<body>

</body>
</html>