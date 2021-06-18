<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container mt-20">
		<div class="row">
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">LOGIN</h3>
					</div>
					<div class="panel-body">
						<form action="/Assignment/Login" method="post">
							<div class="form-group">
								<label>UserID:</label> <input type="text" class="form-control"
									name="id" />
							</div>

							<div class="form-group">
								<label>Password:</label> <input type="password"
									class="form-control" name="password" />
							</div>

							<div class="checkbox">
								<label> <input type="checkbox" name="remember" />
									Remember me ?
								</label>
							</div>

							<button class="btn btn-primary">Login</button>
							<h4 style="color: red"></h4>
						</form>
						<div>
							<c:if test="${not empty error }">
								<h5 style="color: red">${error }</h5>
							</c:if>

							<c:if test="${not empty message }">
								<h5 style="color: red">${message }</h5>
							</c:if>
						</div>

						<br /> <a href="homeServlet">Return Main Page</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>