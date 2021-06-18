<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/Assignment/" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/quyet.css" />

<script src="https://use.fontawesome.com/036b4f2931.js"></script>
<title>Trang chủ</title>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
		<div class="container-fluid">


			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">

					<c:if test="${role==true }">
						<c:url var="item" value="/home" />
						<li class="nav-item"><a class="nav-link"
							href="${item }/products">List Products</a></li>

						<li class="nav-item"><a class="nav-link"
							href="${item }/users">List Users</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${item }/favorites">List of favorite product</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${item }/shares">List of share product</a></li>
					</c:if>


					<c:if test="${isLogin }">
						<li class="nav-item"><a class="nav-link" href="#">Hello,
								${name }</a></li>
					</c:if>


					<li class="nav-item"><a class="nav-link" href="homeServlet">Home</a>
					</li>

					<c:if test="${!isLogin }">
						<li class="nav-item"><a class="nav-link" href="Login">Login</a>
						</li>

						<li class="nav-item"><a class="nav-link" href="signUpServlet">Sign
								up</a></li>
					</c:if>

					<c:if test="${isLogin }">
						<li class="nav-item"><a class="nav-link" href="Logout">Logout</a>
						</li>
					</c:if>

					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<c:if test="${role==true }">
		<jsp:include page="${view }" />
	</c:if>


	<c:if test="${role==false }">
		<jsp:include page="/views/view_home.jsp" />
	</c:if>

	<c:if test="${!isLogin }">
		<jsp:include page="/views/view_home.jsp" />
	</c:if>

	<hr class="setHR">

	<div class="container-fluid padding">
		<div class="row text-center padding">
			<div class="col-12">
				<h2 style="font-family: impact">CONTACT US</h2>
			</div>
			<div class="col-12 social padding"></div>
		</div>
	</div>

	<footer>
		<div class="container-fluid padding">
			<div class="row text-center">
				<div class="col-md-4">
					<hr class="light">
					<h5>Address</h5>
					<hr class="light">
					<p>0979 - 018 - 834</p>
					<p>ntdfashion@gmail.com</p>
					<p>My Dinh Street, Ha Noi, VietNam</p>
				</div>

				<div class="col-md-4">
					<hr class="light">
					<h5>Working hours</h5>
					<hr class="light">
					<p>Monday - Friday: 8AM - 10PM</p>
					<p>Weekend: 8AM - 5PM</p>
				</div>

				<div class="col-md-4">
					<hr class="light">
					<h5>Service</h5>
					<hr class="light">
					<p>Outsourcing</p>
					<p>Website development</p>
					<p>Mobile applications</p>
				</div>

				<div class="col-12">
					<hr class="light-100">
					<h5>&copy; NTD FASHION</h5>
				</div>

			</div>
		</div>
	</footer>

	<!--  -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

</body>
</html>