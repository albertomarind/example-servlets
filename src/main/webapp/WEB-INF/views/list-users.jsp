<%@ include file="../common/header.jspf"%>

<div class="container-fluid">
	<div class="row">
		<%@ include file="../common/menu.jspf"%>
		<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
			<h2>Users</h2>
			<div class="text-end">
				<a class="btn btn-primary" href="/add-user.do">Add user</a>
			</div>
			<div class="table-responsive">
				<table class="table table-striped table-sm">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Username</th>
							<th scope="col">Role</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.id}</td>
								<td>${user.username}</td>
								<td>${user.role.description}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</main>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>
