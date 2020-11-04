<%@ page language="java" contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>MVC 게시판</title>

<!-- 썸머노트 + Head : SummerNote.jsp -->
<jsp:include page="/common/SummerNote.jsp"></jsp:include>
<script>
	function addboard() {
		boardform.submit();
	}

$(function(){
    $('#summernote').summernote({
        placeholder: 'Hello summernote',
        tabsize: 2,
        height: 120,
        toolbar: [
				['style', ['style']
			],
			['font', 
				['bold', 'underline', 'clear']
			],
	        ['color', 
	        	['color']
	        ],
	        ['para', 
	        	['ul', 'ol', 'paragraph']
	        ],
	        ['table', 
	        	['table']
	        ],
	        ['insert', 
	        	['link', 'picture', 'video']
	        ],
	        ['view', 
	        	['fullscreen', 'codeview', 'help']
	        ]
        ]
      });
});
</script>
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
							<!-- 게시판 등록 -->
							<form action="BoardAddAction.do" method="post"
								enctype="multipart/form-data" name="boardform">
								<table class="table" cellpadding="0" cellspacing="0">
									<tr align="center" valign="middle">
										<td colspan="5">MVC 게시판</td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12" height="16">
											<div align="center">글쓴이</div>
										</td>
										<td><input name="BOARD_NAME" type="text" size="10"
											maxlength="10" value="" /></td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12" height="16">
											<div align="center">비밀번호</div>
										</td>
										<td><input name="BOARD_PASS" type="password" size="10"
											maxlength="10" value="" /></td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12" height="16">
											<div align="center">제 목</div>
										</td>
										<td><input name="BOARD_SUBJECT" type="text" size="50"
											maxlength="100" value="" /> 공지사항 <input type="checkbox"
											name="notice" value="Y"></td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12">
											<div align="center">내 용</div>
										</td>
										<td><textarea id="summernote" class="summernote" name="BOARD_CONTENT"
												cols="67" rows="15"></textarea></td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12">
											<div align="center">파일 첨부</div>
										</td>
										<td><input name="BOARD_FILE" type="file" /></td>
									</tr>
									<tr bgcolor="cccccc">
										<td colspan="2" style="height: 1px;"></td>
									</tr>
									<tr>
										<td colspan="2">&nbsp;</td>
									</tr>
									<tr align="center" valign="middle">
										<td colspan="5"><a href="javascript:addboard()">[등록]</a>&nbsp;&nbsp;
											<a href="javascript:history.go(-1)">[뒤로]</a></td>
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