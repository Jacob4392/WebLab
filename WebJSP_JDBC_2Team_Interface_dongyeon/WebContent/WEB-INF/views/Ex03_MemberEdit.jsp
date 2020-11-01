<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 	회원정보 수정하기
	1.DB 쿼리 : 2개 (수정정보 : select , 수정정보반영 : update)
	 1.1 : select * from koreamember where id=?
	 1.2 : update koreamember set ename=? where id=?		 
	2.화면 1개(기존에 입력내용 보여주는 것)-> 처리 1개 (수정처리)
	 2.1  DB select 한 결과 화면 출력 
	   <input type="text" value="rs.getString(id)">
	      수정안하고 .. 화면 .. 전송(x) : <td>rs.getString("id")</td>
	      수정안하고 .. 화면 .. 전송   : <input type="text" value="rs.getString(id)" readonly>
	      수정하고 ..화면  ..전송   :  <input type="text" value="rs.getString(id)"> -->

<!DOCTYPE html>
<html>
<head>
<!-- script & Css CDN를 묶은 Head.jsp -->
<jsp:include page="/common/Head.jsp"></jsp:include>
</head>
<body>
	<!-- Top 부분 header와 nav를 묶은 Top.jsp -->
	<jsp:include page="/common/Top.jsp"></jsp:include>

	<section id="hero">
		<div class="container">
			<!-- Form validations -->
			<div class="row">
				<div class="col-md-12 col-lg-12 ">
					<section class="panel" >
					<c:set var="member" value="${requestScope.koreamember}" />
						<header class="panel-heading mb-5 text-center"><h2><i>[ ${member.id} ]</i> 회원 정보 수정</h2></header>
						<div class="panel-body">
							<div class="form">
							
								<!-- 회원 정보 수정하는 Form엘리먼트 속 데이터 -->
								<form action="update.member"
									class="form-validate form-horizontal" method="post">
									<div class="form-group ">
										<label class="control-label col-lg-2"> 아이디
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="id" value="${member.id}"
												type="text" readonly />
										</div>
									</div>

									<div class="form-group ">
										<label class="control-label col-lg-2">
											비밀번호 </label>
										<div class="col-lg-12">
											<input class="form-control" value="${member.pwd}" type="text"
												readonly />
										</div>
									</div>
									<div class="form-group ">
										<label class="control-label col-lg-2"> 이름
											<span class="required">*</span>
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="name"
												value="${member.name}" type="text" />
										</div>
									</div>

									<div class="form-group ">
										<label class="control-label col-lg-2"> 나이<span
											class="required">*</span>
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="age" value="${member.age}"
												type="number" />
										</div>
									</div>
									<div class="form-group ">
										<label class="control-label col-lg-2"> 성별<span
											class="required">*</span>
										</label>
										<div class="col-lg-12">
											<c:choose>
												<c:when test="${member.gender=='여'}">
													<input type="radio" name="gender" id="gender" value="여"
														checked>여
											<input type="radio" name="gender" id="gender" value="남">남
										</c:when>
												<c:otherwise>
													<input type="radio" name="gender" id="gender" value="여">여
											<input type="radio" name="gender" id="gender" value="남"
														checked> 남
										</c:otherwise>
											</c:choose>
										</div>
									</div>
									<div class="form-group ">
										<label class="control-label col-lg-2">이메일<span
											class="required">*</span>
										</label>
										<div class="col-lg-12">
											<input class="form-control" name="email"
												value="${member.email}" type="text" />
										</div>
									</div>
									<div class="form-group" style="margin:50px auto;">
										<div class="col-lg-12 col-md-3 col-md-offset-3">
											<button class="btn btn-primary" type="submit">수정하기</button>
											<a class="btn-get-started scrollto" href='MemberList.member'>리스트로 이동</a>
										</div>
									</div>
								</form><!-- //Form -->
								
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

