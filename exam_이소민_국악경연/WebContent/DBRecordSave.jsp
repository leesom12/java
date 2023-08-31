<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	request.setCharacterEncoding("utf-8");
	
	String entry_no = request.getParameter("entry_no");
	String s_score1 = request.getParameter("score1");
	String s_score2 = request.getParameter("score2");
	String s_score3 = request.getParameter("score3");
	String s_score4 = request.getParameter("score4");
	String s_score5 = request.getParameter("score5");
	
	int score1 = Integer.parseInt(s_score1);
	int score2 = Integer.parseInt(s_score2);
	int score3 = Integer.parseInt(s_score3);
	int score4 = Integer.parseInt(s_score4);
	int score5 = Integer.parseInt(s_score5);
	
	int[] array = new int[] {score1, score2, score3, score4, score5};
	//최대값
	int s_max = score1;
	for(int i=1; i<array.length; i++){
		if(s_max<array[i]){
			s_max=array[i];
		}
	}
	//최소값
	int s_min = score1;
	for(int i=1;i<array.length;i++){
		if(s_min>array[i]){
			s_min = array[i];
		}
	}
	//총점
	int s_tot=0;
	for(int i=0;i<array.length;i++){
		s_tot = s_tot+array[i];
	}
	s_tot = s_tot-(s_max+s_min);
	//평균
	double s_ave = s_tot/3.0;
	s_ave = Math.round(s_ave*100)/100.0;
	
	Sub1Dto dto = new Sub1Dto( entry_no, score1, score2, score3, score4, score5, s_max, s_min, s_tot, s_ave);
	int result = dao.saveRecord(dto);
	String msg="경연점수정보가 등록되었습니다!";
	if(result != 1) msg="등록 실패!!";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="index.jsp";
</script>
<body>

</body>
</html>