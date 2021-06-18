<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<base href="/Assignment/" />

<div class="container mt-3">
	<h4 style="font-family: impact; color: red">LIST OF FAVORITE
		PRODUCT</h4>
	<a href="CountFavoriteProduct" class="btn btn-light"><i
		class="fa fa-search" aria-hidden="true"></i> Search</a>
	<table class="table table-striped mt-1">
		<thead class="table-dark">
			<tr>
				<th>PRODUCT ID</th>
				<th>FAVORITE COUNT</th>
				<th>NEWEST DATE</th>
				<th>OLDEST DATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${listSP1 }">
				<tr style="background-color: #D3D3D3">
					<th>${item.group }</th>
					<th>${item.likes }</th>
					<th>${item.newest }</th>
					<th>${item.oldest }</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>