<%@ include file="../common/header.jspf"%>
<div class="container-fluid">
	<div class="row">
		<%@ include file="../common/menu.jspf"%>
		<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 mt-3">
			<h1 class="h2">Add Role</h1>
			<form action="/add-role.do" method="post">
				<div class="row mb-3">
					<input type="hidden" name="action" value="1"> <label
						for="desc" class="col-sm-2 col-form-label">Description</label>
					<div class="col-sm-10">
						<input type="text" required class="form-control" id="desc"
							name="description">
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Save</button>
					<c:if test="${not empty infoMessage}">
						<div class="alert alert-primary mt-3" role="alert">${infoMessage}</div>
					</c:if>
					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger mt-3" role="alert">${errorMessage}</div>
					</c:if>
			</form>
		</main>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>