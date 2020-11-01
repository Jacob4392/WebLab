<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th colspan="2">회원 상세 정보</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="member" value="${requestScope.member}" />
									<tr>
										<td style="width: 100px">아이디</td>
										<td style="width: 100px">${member.id}</td>
									</tr>
									<tr>
										<td style="width: 100px">비번</td>
										<td style="width: 100px">${member.pwd}</td>
									</tr>
									<tr>
										<td style="width: 100px">이름</td>
										<td style="width: 100px">${member.name}</td>
									</tr>
									<tr>
										<td style="width: 100px">나이</td>
										<td style="width: 100px">${member.age}</td>
									</tr>
									<tr>
										<td style="width: 100px">성별</td>
										<td style="width: 100px">${member.gender}</td>
									</tr>
									<tr>
										<td style="width: 100px">이메일</td>
										<td style="width: 100px">${member.email}</td>
									</tr>
									<tr>
										<td colspan="2"><a href="MemberList.do">목록으로 돌아가기</a></td>
									</tr>
								</tbody>
							</table>
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