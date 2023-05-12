<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		<%//jstl문법을 c라는 이름으로 사용하겠다 %>
<%
	//String name= (String)request.getAttribute("t_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
========= el 표현 ==========<br>
${t_name} <br>
${t_age } <br>
${t_arr.size() } <br>
${t_arr[0] } ${t_arr[1] } ${t_arr[2] } ${t_arr[3] }
<br><br>

========= jstl 표현 ==========<br>
<c:if test="${t_name == '홍길동ㄴㄴ' }">
	홍길동이다1<br>
</c:if>
<c:if test="${t_name == '홍길동' }">
	홍길동이다2<br>
</c:if>
<c:if test="${t_name eq '홍길동' }">
	홍길동이다3<br>
</c:if>
<c:if test="${t_name != '홍길동' }">
	홍길동 아니다4<br>
</c:if>
<c:if test="${t_name ne '홍길동' }">
	홍길동 아니다5<br>
</c:if>
<br>
<c:if test="${t_age == 25 }">
	1. 25살 맞음 <br>
</c:if>
<c:if test="${t_age > 20 }">
	2. 20 보다 큼<br>
</c:if>
<c:if test="${t_name eq '홍길동' && t_age>20 }">
	3. 20살 이상이고 홍길동<br>
</c:if>
<c:if test="${t_name eq '홍길동' and t_age>20 }">
	4. 20살 이상이고 홍길동<br>
</c:if>
<c:if test="${t_name eq '홍길동' || t_age>30 }">
	5.홍길동이거나 30살 이상<br>
</c:if>
<c:if test="${t_name eq '홍길동' or t_age>30 }">
	6.홍길동이거나 30살 이상<br>
</c:if>
<br><br>

========= jstl 표현 if else ==========<br>
<c:choose>
	<c:when test="${t_age>40 }">40이상</c:when>
	<c:when test="${t_age>30 }">30이상</c:when>
	<c:when test="${t_age>20 }">20이상</c:when>
	<c:when test="${t_age>10 }">10이상</c:when>
	<c:otherwise>나머지</c:otherwise>
</c:choose>
<br><br>

========= jstl 표현 반복문for ==========<br>
<c:forEach items="${t_arr }" var="area">
	${area} <br>
</c:forEach>
<br>
<c:forEach items="${t_dtos }" var="dto">
	${dto.getName() } ${dto.getArea() } ${dto.getAge() }<br>
</c:forEach>
























</body>
</html>