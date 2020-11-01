<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <a href="Ex02_JDBC_Main.jsp">Main</a>&nbsp;&nbsp;&nbsp;||
<c:if test="${empty sessionScope.userid}">
	<a href="Ex02_JDBC_Login.jsp">Login</a>&nbsp;&nbsp;&nbsp;||
	<a href="Ex02_JDBC_JoinForm.jsp">Register</a>&nbsp;&nbsp;&nbsp;||
</c:if>
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;
 --%>
<!-- Ex02_JDBC_loginok.jsp애서 로그인 시에 session객체에 setAttribute("userid",..)
	JSTL sessionScope 이용-->


<!-- ======= Header ======= -->
<header id="header" class="fixed-top">
	<div class="container d-flex">

		<div class="logo mr-auto">
			<h1 class="text-light">
				<a href="Ex02_JDBC_Main.jsp"><span>Team2_&nbsp;JDBC</span></a>
			</h1>
		</div>

		<nav class="nav-menu d-none d-lg-block">
			<ul>
				<li class="active"><a href="Ex02_JDBC_Main.jsp">Main</a></li>
				<c:if test="${empty sessionScope.userid}">
					<li><a href="Login.member">Login</a></li>
					<li><a href="Joinform.member">Register</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.userid}">
					<li><a href="Logout.member">Log out</a></li>
				</c:if>
				<li class="drop-down"><a href="">DROP-DOWN</a>
					<ul>
						<li><a href="#">---</a></li>
						<li><a href="#">---</a></li>
						<li><a href="#">---</a></li>
						<li class="drop-down"><a href="#">Deep Drop Down</a>
							<ul>
								<li><a href="#">Deep Drop Down 1</a></li>
								<li><a href="#">Deep Drop Down 2</a></li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</nav>
		<!-- .nav-menu -->
	</div>
</header>
<!-- End Header -->

