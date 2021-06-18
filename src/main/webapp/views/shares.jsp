<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">

<div class="container mt-3">
	<h4 style="font-family: impact; color: red">LIST OF SHARE PRODUCT</h4>
	<a href="CountShareProduct" class="btn btn-light"><i
		class="fa fa-search" aria-hidden="true"></i> Search</a>
	<table class="table table-striped mt-1">
		<thead class="table-dark">
			<tr>
				<th>Product ID</th>
				<th>Share Count</th>
				<th>Newest Date</th>
				<th>Oldest Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${listSP2 }">
				<tr style="background-color: #AFEEEE">
					<th>${item.group }</th>
					<th>${item.likes }</th>
					<th>${item.newest }</th>
					<th>${item.oldest }</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>