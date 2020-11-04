<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>MVC 게시판</title>
<!-- script & Css CDN를 묶은 Head.jsp -->
<jsp:include page="/common/Head.jsp"></jsp:include>
</head>
<body>
	<!-- Top 부분 header와 nav를 묶은 Top.jsp -->
	<jsp:include page="/common/Top.jsp"></jsp:include>
	<section id="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<section class="panel">
						<div class="table-responsive">
							<form name="deleteForm"
								action="BoardDeleteAction.do?num=<%=num%>" method="post">
								<table class="table" border=1 style="border-color:#444444;">
									<tr>
										<td><font size=2>글 비밀번호 : </font></td>
										<td><input name="BOARD_PASS" type="password"></td>
									</tr>
									<tr>
										<td colspan=2 align=center><a
											href="javascript:deleteForm.submit()">삭제</a> &nbsp;&nbsp; <a
											href="javascript:history.go(-1)">돌아가기</a></td>
									</tr>
								</table>
							</form>
						</div>
					</section>
				</div>
			</div>
		</div>
	</section>
	<!-- End Hero -->
	<!-- Footer부분의 jsp -->
	<jsp:include page="/common/Bottom.jsp"></jsp:include>
	<!-- Template 자체 Animation 및 Vendor 파일을 묶은 Foot.jsp -->
	<jsp:include page="/common/Foot.jsp"></jsp:include>
	
</body>
</html>