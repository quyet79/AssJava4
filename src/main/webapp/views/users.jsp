<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<base href="/Assignment/" />
<div class="container mt-3">
	<h4 style="font-family: impact; color: red">LIST USER</h4>
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
			<form action="UserServlet" method="post">
				<div class="form-group">
					<label>User ID:</label> <input type="text" name="id"
						class="form-control" readonly value="${user.id }" />
				</div>

				<div class="form-group">
					<label>Fullname:</label> <input type="text" name="fullname"
						class="form-control" readonly value="${user.fullname }" />
				</div>

				<div class="form-group">
					<label>Username:</label> <input type="text" name="username"
						class="form-control" readonly value="${user.username }" />
				</div>

				<div class="form-group">
					<label>Password:</label> <input type="password" name="password"
						class="form-control" readonly value="${user.password }" />
				</div>

				<div class="form-group">
					<label>Email:</label> <input type="text" name="email"
						class="form-control" readonly value="${user.email }" />
				</div>

				<div class="form-check form-check-inline">
					<label>Role:</label> <label class="ml-2"><input
						type="radio" name="role" class="form-check-input" value="true"
						${user.role?'checked':'' } />Admin</label> <label class="ml-2"><input
						type="radio" name="role" class="form-check-input" value="false"
						${!user.role?'checked':'' } />User</label>
				</div>

				<div class="form-group">
					<button formaction="UserServlet/update" class="btn btn-primary">Update</button>
					<button formaction="UserServlet/delete" class="btn btn-danger">Delete</button>
				</div>

				<button class="btn btn-light">
					<i class="fa fa-search" aria-hidden="true"></i> Search User
				</button>
			</form>
		</div>
	</div>

	<div class="row">
		<div class="col">

			<table class="table table-stripe mt-1">
				<thead class="table-dark">
					<tr>
						<th>User ID</th>
						<th>Full name</th>
						<th>Role</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${lists1 }">
						<tr style="background-color: #F0E68C">
							<td>${item.id }</td>
							<td>${item.fullname }</td>
							<td>${item.role?"admin":"user" }</td>
							<td><a href="UserServlet/edit?id=${item.id }">Edit</a> <a
								href="UserServlet/delete?id=${item.id }">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>