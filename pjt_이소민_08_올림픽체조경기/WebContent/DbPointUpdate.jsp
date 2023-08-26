<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	OlympicDao dao = new OlympicDao();
	request.setCharacterEncoding("utf-8");

	String player_no = request.getParameter("player_no");
	String p1 = request.getParameter("point_1");
	String p2 = request.getParameter("point_2");
	String p3 = request.getParameter("point_3");
	String p4 = request.getParameter("point_4");
	
	int point_1 = Integer.parseInt(p1);
	int point_2 = Integer.parseInt(p2);
	int point_3 = Integer.parseInt(p3);
	int point_4 = Integer.parseInt(p4);
	
	int max =0;
	int point= dao.getSkillPoint(player_no);
	
	if(point_1 >= point_2 && point_1 >= point_3 && point_1 >= point_4){
		max= point_1;
	}else if(point_2 >= point_1 && point_2 >= point_3 && point_2 >= point_4){
		max= point_2;
	}else if(point_3 >= point_1 && point_3 >= point_2 && point_3 >= point_4){
		max= point_3;
	}else if(point_4 >= point_1 && point_4 >= point_2 && point_4 >= point_3){
		max= point_4;
	}
	
	int total = (point_1+point_2+point_3+point_4)-max;
	double ave = total/3.0;
	
	if(point==5){
		ave = ave + (ave*0.05);
	}else if(point==4){
		ave = ave + (ave*0.04);
	}else if(point==3){
		ave = ave + (ave*0.03);
	}else if(point==2){
		ave = ave + (ave*0.02);
	}else if(point==1){
		ave = ave + (ave*0.01);
	}
	
	ave = Math.round(ave*100)/100.0;
	
	Sub2Dto dto = new Sub2Dto(player_no, point_1, point_2, point_3, point_4, total, ave);
	int result = dao.updatePoint(dto);
	String msg="심사점수가 정상적으로 등록 되었습니다";
	if(result != 1) msg="등록 실패";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="심사점수조회.jsp";
</script>
</head>
<body>

</body>
</html>