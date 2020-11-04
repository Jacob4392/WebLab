<%@page import="kr.or.bit.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
	Board board = (Board) request.getAttribute("boarddata");
%>

<html>
<head>
<title>MVC 게시판</title>
<script
  src="assets/vendor/jquery/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript">
	function modifyboard() {
		modifyform.submit();
	}
	
	$(function(){
	    $('#summernote').summernote({
	        placeholder: '',
	        tabsize: 2,
	        height: 120,
	        toolbar: [
	          ['style', ['style']],
	          ['font', ['bold', 'underline', 'clear']],
	          ['color', ['color']],
	          ['para', ['ul', 'ol', 'paragraph']],
	          ['table', ['table']],
	          ['insert', ['link', 'picture', 'video']],
	          
	          
	          ['view', ['fullscreen', 'codeview', 'help']]
	        ]
	      });

	});
</script>
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
							<!-- 게시판 수정 -->
							<form action="BoardModifyAction.do" method="post"
								name="modifyform">
								<input type="hidden" name="BOARD_NUM"
									value=<%=board.getBoard_num()%>>
								<table cellpadding="0" cellspacing="0">
									<tr align="center" valign="middle">
										<td colspan="5">MVC 게시판</td>
									</tr>
									<tr>
										<td height="16" style="font-family: 돋음; font-size: 12">
											<div align="center">제 목</div>
										</td>
										<td><input name="BOARD_SUBJECT" size="50" maxlength="100"
											value="<%=board.getBoard_subject()%>"></td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12">
											<div align="center">내 용</div>
										</td>
										<td><textarea id="summernote" name="BOARD_CONTENT" cols="67" rows="15"><%=board.getBoard_content()%></textarea>
										</td>
									</tr>
									<%
										if (!(board.getBoard_file() == null)) {
									%>
									<tr>
										<td style="font-family: 돋음; font-size: 12">
											<div align="center">파일 첨부</div>
										</td>
										<td>&nbsp;&nbsp;<%=board.getBoard_file()%>
										</td>
									</tr>
									<%
										}
									%>
									<tr>
										<td height="16" style="font-family: 돋음; font-size: 12">
											<div align="center">비밀번호</div>
										</td>
										<td><input name="BOARD_PASS" type="password"></td>
									</tr>

									<tr bgcolor="cccccc">
										<td colspan="2" style="height: 1px;"></td>
									</tr>
									<tr>
										<td colspan="2">&nbsp;</td>
									</tr>

									<tr align="center" valign="middle">
										<td colspan="5"><font size=2> <a
												href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp; <a
												href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
										</font></td>
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
		<!-- Template 자체 Animation 및 Vendor 파일을 묶은 Foot.jsp -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
</body>
</html>