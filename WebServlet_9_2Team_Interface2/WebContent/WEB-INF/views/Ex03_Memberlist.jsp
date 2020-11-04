<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
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
						<header class="panel-heading"> 회원 리스트 </header>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>사용자 ID</th>
										<th>가입한 IP</th>
										<th>회원 정보 삭제</th>
										<th>회원 정보 수정</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="col" items="${requestScope.memberList}" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td><a href='detail.member?id=${col.id}'>${col.id}</a></td>
										<td>${col.ip}</td>
										<td><a href="delete.member?id=${col.id}">Delete</a></td>
										<td><a href="Edit.member?id=${col.id}">Update</a></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</section>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-3 col-md-offset-3" style="padding:15px 0;margin:15px auto;" data-aos="fade-left">
					<h2>회원명으로 계정 검색</h2>
					<form action="search.member" method="post">
						<div class="form-row">
							<div class="form-group">
								<input type="text" name="search" class="form-control mb-4" style="size:100;" id="name"/>
								<button type="submit" class="btn btn-primary">이름 검색해보기</button>
							</div>
						</div>
					</form>
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