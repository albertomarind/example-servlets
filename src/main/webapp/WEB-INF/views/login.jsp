
<%@ include file="../common/header.jspf"%>
<div class="container">
	<div class="row">
		<div class="col">
			<form action="/login.do" method="post">
				<div class="mb-3">
					<label for="exampleInputText" class="form-label">Email
						address</label> <input type="text" class="form-control"
						id="exampleInputText" name="username">
					<div id="help" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<input type="password" class="form-control" name="password"
						id="exampleInputPassword1">
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>
				</div>
				<button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>
	</div>
	<c:if test="${not empty errorMessage}">
		<div class="row">
			<div class="col">
				<div class="alert alert-danger" role="alert">${errorMessage}</div>
			</div>
		</div>
	</c:if>
</div>
<%@ include file="../common/header.jspf"%>