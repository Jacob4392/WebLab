<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/common/Head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/common/Top.jsp"></jsp:include>
	<section id="hero">
		<div class="container">
			<div class="row">

				<div
					class="col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column justify-content-center"
					data-aos="fade-up">
					<div>

						<c:choose>
							<c:when test="${not empty sessionScope.userid}">
								<h1>${userid}님!</h1>
								<h2>회원님 로그인을 환영합니다.</h2>
								<c:if test="${sessionScope.userid == 'admin' }">
									<h2 style="color: red;">워우.. 관리자님이시군요..</h2>
									<a class="btn-get-started scrollto" href="MemberList.member">Member
										List</a>
								</c:if>
								<a class="btn-get-started scrollto" href="Logout.member">Log
									out</a>
							</c:when>
							<c:otherwise>
								<h1>Team2 사이트 방문을 환영합니다.</h1>
								<a class="btn-get-started scrollto" href="Joinform.member">Sign
									up</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn-get-started scrollto" href="Login.member">Log in</a>
							</c:otherwise>
						</c:choose>

					</div>
				</div>

				<div class="col-lg-6 order-1 order-lg-2 hero-img"
					data-aos="fade-left">
					<img src="assets/img/hero-img.png" class="img-fluid"
						style="z-index: 988819;" alt="">
				</div>

			</div>
		</div>
	</section>
	<jsp:include page="/common/Bottom.jsp"></jsp:include>
	<jsp:include page="/common/Foot.jsp"></jsp:include>
</body>
</html>


