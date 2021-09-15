<%@ include file="../common/header.jspf"%>
<div class="container-fluid">
	<div class="row">
		<%@ include file="../common/menu.jspf"%>
		<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 mt-3">
			<h1 class="h2">Add user</h1>
			<form action="/add-user.do" method="post">
				<div class="row mb-3">
					<input type="hidden" name="action" value="1"> <label
						for="inputUsername" class="col-sm-2 col-form-label">Username</label>
					<div class="col-sm-10">
						<input type="text" required class="form-control" id="inputUsername"
							name="username">
					</div>
				</div>
				<div class="row mb-3">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" required class="form-control" name="password"
							id="inputPassword3">
					</div>
				</div>
				<fieldset class="row mb-3">
					<legend class="col-form-label col-sm-2 pt-0">Rol</legend>
					<div class="col-sm-10">
						<c:forEach var="rol" items="${roles}" varStatus="loop">
							<div class="form-check">
								<input required class="form-check-input" type="radio" name="idRole"
									id="gridRadios${loop.index}" value="${rol.id}"> <label
									class="form-check-label" for="gridRadios${loop.index}"
									${loop.index == 0 ? 'checked' : ''}> ${rol.description}
								</label>
							</div>
						</c:forEach>
					</div>
				</fieldset>
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