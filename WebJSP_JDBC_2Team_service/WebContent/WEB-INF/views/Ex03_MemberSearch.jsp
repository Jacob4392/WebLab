<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<div class="row">
				<div class="col-lg-12">
					<section class="panel">
						<header class="panel-heading"> 회원 검색 결과 </header>
						<!-- BootStrap Table 이용해 Table에 MemberList EL로 출력 -->
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>이름</th>
										<th>Email</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="cnt" value="${requestScope.countmember}" />
									<c:choose>
										<c:when test="${cnt > 0}">
											<c:forEach var="member" items="${requestScope.memberlist}">
												<tr>
													<td>${member.id}</td>
													<td>${member.name}</td>
													<td>${member.email}</td>
												</tr>
											</c:forEach>

											<tr>
												<td colspan='3'><b>"${requestScope.search}" 조회 결과
														${cnt}건 조회</b></td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan='3'><b>[${requestScope.search}] 조회 결과가
														없습니다.</b></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</section>
				</div>
			</div>
			<hr>
			<div class="row">
				<a class="btn-get-started scrollto" href="MemberList.member">회원목록으로 돌아가기</a>
			</div>
		</div>
	</section>
	<!-- Footer부분의 jsp -->
	<jsp:include page="/common/Bottom.jsp"></jsp:include>
	<!-- Template 자체 Animation 및 Vendor 파일을 묶은 Foot.jsp -->
	<jsp:include page="/common/Foot.jsp"></jsp:include>
</body>
</html>

