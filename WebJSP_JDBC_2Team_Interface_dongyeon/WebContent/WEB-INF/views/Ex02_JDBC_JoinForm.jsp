<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- script & Css CDN를 묶은 Head.jsp -->
<jsp:include page="/common/Head.jsp"></jsp:include>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	//jquery 로 간단하게 유효성 check 하기
	
	
	$(function() {
		$('#joinForm').submit(validate);
		$("#idcheck").click(function() {
								if ($("#id").val() === "") {
									alert("아이디를 입력하세요.");
								} else {
									$.ajax({
										url : "http://localhost:8090/WebJSP_JDBC_2Team_service/IdCheckServlet",
										type : "POST",
										dataType : "html",
										data : {
											data : $("#id").val()
										},
										success : function(responsedata) {
											if (responsedata === "true") {
												alert("존재하는 ID입니다. 다시 입력해주세요.");
												$("#id").val('').focus();
												$("#idcheck").val('중복검사');
												}else {
													alert("사용가능한 ID입니다.");
													$("#pwd").focus();
												$("#idcheck").val('사용가능한 ID입니다.');
												//받은 데이터가 false
											}
											
										}
								});
							}
					});
	});
	function validate() {
		if ($('#id').val() == "") { // 아이디 검사
			alert('ID를 입력해 주세요.');
			$('#id').focus();
			return false;
		}else if ($('#idcheck').val() === "중복검사") { 
			alert('ID중복확인을 해주세요');
			$('#id').focus();
			return false;
		} else if ($('#pwd').val() == "") { // 비밀번호 검사
			alert('PWD를 입력해 주세요.');
			$('#pwd').focus();
			return false;
		} else if ($('#mname').val() == "") { // 이름 검사
			alert('mname를 입력해 주세요.');
			$('#mname').focus();
			return false;
		} else if ($('#age').val() == "") { // 나이 검사
			alert('age를 입력해 주세요.');
			$('#age').focus();
			return false;
		} else if ($('#email').val() == "") { // 우편번호
			alert('email를 입력해 주세요.');
			$('#email').focus();
			return false;
		}
	}
</script>
<jsp:include page="/common/Head.jsp"></jsp:include>
</head>
<body>
	<!-- Top 부분 header와 nav를 묶은 Top.jsp -->
	<jsp:include page="/common/Top.jsp"></jsp:include>

	<section id="hero">
		<div class="container">
			<!-- 회원가입 Form -->
			<div class="row">
				<div class="col-md-12 col-lg-12 ">
					<section class="panel">
						<header class="panel-heading mb-5 text-center">
							<h2>회원 가입</h2>
						</header>
						<div class="panel-body">
							<div class="form">

								<!-- 회원 정보 수정하는 Form엘리먼트 속 데이터 -->
								<form action="join.member" id="joinForm"
									class="form-validate form-horizontal" method="post">
									<div class="form-group ">
										<label for="id" class="control-label col-lg-2"> 아이디 </label>
										<div class="col-lg-12">
											<input class="form-control" name="id" id="id" type="text" />
											<input class="form-control mt-5" type="button" value="중복검사"
												id="idcheck">
										</div>
									</div>

									<div class="form-group ">
										<label for="pwd" class="control-label col-lg-2"> 비밀번호
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="pwd" id="pwd"
												type="password" />
										</div>
									</div>

									<div class="form-group ">
										<label for="pwdcheck" class="control-label col-lg-2">
											비밀번호 확인 </label>
										<div class="col-lg-12">
											<input class="form-control" name="pwdcheck" id="pwdcheck"
												type="password" />
										</div>
									</div>

									<div class="form-group ">
										<label for="mname" class="control-label col-lg-2"> 이름
											<span class="required">*</span>
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="mname" id="mname"
												type="text" />
										</div>
									</div>

									<div class="form-group ">
										<label for="cname" class="control-label col-lg-2"> 나이<span
											class="required">*</span>
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="age" id="age" type="number" />
										</div>
									</div>

									<div class="form-group ">
										<label for="gender" class="control-label col-lg-2"> 성별<span
											class="required">*</span>
										</label>
										<div class="col-lg-12">
											<input type="radio" name="gender" id="gender" value="여">여
											<input type="radio" name="gender" id="gender" value="남">남
										</div>
									</div>

									<div class="form-group ">
										<label for="email" class="control-label col-lg-2">이메일<span
											class="required">*</span>
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="email" id="email"
												type="text" />
										</div>
									</div>

									<div class="form-group" style="margin: 50px auto;">
										<div class="col-lg-12 col-md-3 col-md-offset-3">
											<button class="btn btn-primary" type="submit">회원가입
												요청</button>
											<input type="reset" value="모두 비우기" />
										</div>
									</div>
								</form>
								<!-- //Form -->

							</div>
						</div>
					</section>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer부분의 jsp -->
	<jsp:include page="/common/Bottom.jsp"></jsp:include>
	<!-- Template 자체 Animation 및 Vendor 파일을 묶은 Foot.jsp -->
	<jsp:include page="/common/Foot.jsp"></jsp:include>
</body>
</html>