
<%@ include file="../common/header.jspf"%>
<div class="container-fluid">
	<div class="row">
		<div class="col">
			<div class="wrapper-signin text-center">
				<main class="form-signin">
					<form action="/login.do" method="post">
						<img class="mb-4" src="resources/images/bootstrap-logo.svg" alt=""
							width="72" height="57">
						<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

						<div class="form-floating">
							<input type="text" name="username" class="form-control"
								id="floatingInput" placeholder="Username"> <label
								for="floatingInput">Username</label>
						</div>
						<div class="form-floating">
							<input type="password" name="password" class="form-control"
								id="floatingPassword" placeholder="Password"> <label
								for="floatingPassword">Password</label>
						</div>

						<div class="checkbox mb-3">
							<label> <input type="checkbox" value="remember-me">
								Remember me
							</label>
						</div>
						<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
							in</button>
						<p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
						<c:if test="${not empty errorMessage}">
							<div class="row">
								<div class="col">
									<div class="alert alert-danger" role="alert">${errorMessage}</div>
								</div>
							</div>
						</c:if>
					</form>
				</main>
			</div>
		</div>
	</div>

</div>
<%@ include file="../common/footer.jspf"%>