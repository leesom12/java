<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	request.setCharacterEncoding("utf-8");
	
	String resvno= request.getParameter("resvno");
	int count = dao.resvnoCount(resvno);
	
	String msg="좌석예약정보가 등록되었습니다!";
	if(count == 0){
		String empno= request.getParameter("empno");
		String resvdate= request.getParameter("resvdate");
		String seatno= request.getParameter("seatno");
		
		Sub1Dto dto = new Sub1Dto(resvno, empno, resvdate, seatno);
		
		int result = dao.saveContract(dto);
		if(result != 1) msg="예약 실패!!";
	}else{
		msg="이미 존재하는 예약번호입니다. 다시 입력해 주세요.";
	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	alert("<%=msg%>");
	if(<%=count%> == 0){
		location.href="index.jsp"
	}else{
		history.go(-1)
	};
	
</script>
<body>

</body>
</html>