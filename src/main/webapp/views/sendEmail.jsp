<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Send Email</title>
</head>
<body>
	<main class="container">
		<section class="row">
			<div class="offset-3 col-6">
				<form action="ShareProduct" method="post">
					<input type="hidden" name="id" value="${productId }" />
					<div class="card">
						<div class="card-header">Send Video To Your Friends</div>
						<div class="card-body">
							<div class="row">
								<div class="col">
									<c:if test="${not empty message }">
										<div class="alert alert-success">${message }</div>
									</c:if>
									<c:if test="${not empty error }">
										<div class="alert alert-danger">${error }</div>
									</c:if>
								</div>
							</div>

							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="email">Your Friends' Email:</label> <input
											type="text" class="form-control" name="email" id="email"
											aria-describedby="emailHelperId" placeholder="Emails ?" />
									</div>

									<div class="form-group">
										<label for="subject">Title:</label> <input type="text"
											class="form-control" name="subject" id="subject"
											aria-describedby="emailHelperId" placeholder="Title ?" />
									</div>

									<div class="form-group">
										<label for="subject">Content:</label>
										<textarea rows="3" cols="3" class="form-control"
											name="content" id="content" aria-describedby="emailHelperId"
											placeholder="Content ?"></textarea>
									</div>

								</div>
							</div>


						</div>
						<div class="card-footer">
							<button class="btn btn-success">Send</button>
							<a href="homeServlet" class="btn btn-success">Home</a>
						</div>
					</div>
				</form>
			</div>
		</section>
	</main>

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