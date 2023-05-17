<%@ page pageEncoding="UTF-8"%>

<%
	String url= request.getServletPath();
	String aa="";
	if(url.contains("notice")){
		aa="공지사항";
	} else if(url.contains("news")){
		aa="뉴스";
	} else if(url.contains("qna")){
		aa="질문과 답변";
	} else if(url.contains("faq")){
		aa="FAQ";
	} else if(url.contains("pds")){
		aa="자료실";
	} else if(url.contains("adm")){
		aa="관리자";
	}
%>
<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="../index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href=""><%=aa %><i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="/web_homepage_jsl/notice/notice_list.jsp">공지사항</a>
						<a href="/web_homepage_jsl/news/news_list.jsp">뉴스</a>
						<a href="/web_homepage_jsl/qna/qna_list.jsp">질문과답변</a>
						<a href="/web_homepage_jsl/faq/faq_list.jsp">FAQ</a>
						<a href="/web_homepage_jsl/pds/pds_list.jsp">자료실</a>
						<%
							String SessionLevel= (String)session.getAttribute("sessionLevel");
							if(SessionLevel == null) SessionLevel="";
							if(SessionLevel.equals("top")){
						%>
							<a href="/web_homepage_jsl/adm/adm_list.jsp">관리자</a>
						<%
							}
						%>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
		
