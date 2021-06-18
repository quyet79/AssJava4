<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="utf-8">


<!-- Carousel -->
<img class="d-block w-100" src="./images/banner4.jpg" alt="Fouth slide"
	style="height: 550px">

<!-- jumbotron -->





<hr class="my-5">

<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1>WELCOME TO THE WORLD OF FASHION</h1>
		</div>
		<div class="col-12"></div>
	</div>
</div>
<hr class="setHR">

<div id="content">

	<form method="post" action="/Assignment/homeServlet">
		<div class="form-group">
			<div class="row  justify-content-center">
				<div class="col-5 ">
					<input type="text" name="tensanpham" class="form-control"
						placeholder="Bạn đang tìm sản phẩm gì ...?" />
				</div>
				<button class="btn btn-primary">
					<i class="fa fa-search" aria-hidden="true"></i>
				</button>

			</div>
		</div>

		<div class="container">
			<div class="col">
				<c:if test="${not empty message }">
					<div class="alert alert-success">${message }</div>
				</c:if>
				<c:if test="${not empty error }">
<<div class="alert alert-danger">${error }</div>
				</c:if>
			</div>
		</div>

		<div class="container-fluid padding ">
			<div class="row padding">
				<c:forEach var="item" items="${listSP }">
					<div class="col-md-3">
						<div class="card">
							<img class="card-img-top" src="./images/${item.hinhanh }"
								width="200px" height="300px" />
							<div class="card-body">
								<h4 class="card-title">${item.tensanpham }</h4>
								<h6 style="color: blue" class="card-text">${item.giasanpham }</h6>

								<a href="LikeProduct?id=${item.id }"
									class="btn btn-outline-danger"><i class="fa fa-gratipay "
									aria-hidden="true"></i> Favorite</a> <a
									href="ShareProduct?id=${item.id }"
									class="btn btn-outline-success"><i
									class="fa fa-share-square" aria-hidden="true"></i> Share</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</form>

	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Previous" style="font-weight: bold"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li class="page-item"><a class="page-link"
				style="font-weight: bold"></a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next" style="font-weight: bold"> <span
					aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</div>