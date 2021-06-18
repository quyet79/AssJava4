<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<base href="/Assignment/" />
<div class="container mt-3">
	<h4 style="font-family: impact; color: red">LIST PRODUCT</h4>
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
			<form action="ProductServlet" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label>Product ID:</label> <input type="text" name="id"
						class="form-control" value="${sanphams.id }" />
				</div>

				<div class="form-group">
					<label>Tên sản phẩm:</label> <input type="text" name="tensanpham"
						class="form-control" value="${sanphams.tensanpham }" />
				</div>

				<div class="form-group">
					<label>Giá sản phẩm:</label> <input type="text" name="giasanpham"
						class="form-control" value="${sanphams.giasanpham }" />
				</div>

				<div class="custom-file">
					<div class="form-group">
						<label for="hinhanh">Hình ảnh:</label> <input id="hinhanh"
							type="file" name="hinhanh" class="form-control"
							value="${sanphams.hinhanh }" />
					</div>
				</div>

				<div class="form-group">
					<label>Mô tả:</label>
					<textarea rows="3" cols="3" name="mota" class="form-control"> ${sanphams.mota } </textarea>
				</div>


				<div class="form-group">
					<button formaction="ProductServlet/insert" class="btn btn-primary">Create</button>
					<button formaction="ProductServlet/update" class="btn btn-warning">Update</button>
					<button formaction="ProductServlet/delete" class="btn btn-danger">Delete</button>
					<button formaction="ProductServlet/reset" class="btn btn-secondary">Reset</button>
				</div>

				<button class="btn btn-light">
					<i class="fa fa-search" aria-hidden="true"></i> Search Product
				</button>
			</form>
		</div>
	</div>

	<div class="row">
		<div class="col">
			<table class="table table-stripe mt-1">
				<thead class="table-dark">
					<tr>
						<th>Product ID</th>
						<th>Tên sản phẩm</th>
						<th>Giá sản phẩm</th>
						<th>Hình ảnh</th>
						<th>Mô tả</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${lists }">
						<tr style="background-color: #D3D3D3">
							<th>${item.id }</th>
							<th>${item.tensanpham }</th>
							<th>${item.giasanpham }</th>
							<th><img src="./images/${item.hinhanh }" width="100px"
								height="100px" /></th>
							<th>${item.mota }</th>
							<th><a href="ProductServlet/edit?id=${item.id }">Edit</a> <a
								href="ProductServlet/delete?id=${item.id }">Delete</a></th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>