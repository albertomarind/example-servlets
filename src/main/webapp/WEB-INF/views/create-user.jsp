<%@ include file="../common/header.jspf"%>
<div class="container">
	<form action="/user.do" method="post">
		<div class="row mb-3">
			<label for="inputUsername" class="col-sm-2 col-form-label">Username</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputUsername" name="username">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password" id="inputPassword3">
			</div>
		</div>
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">Rol</legend>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios1" value="admin" checked> <label
						class="form-check-label" for="gridRadios1"> Administrador </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios2" value="user"> <label
						class="form-check-label" for="gridRadios2"> Usuario </label>
				</div>
			</div>
		</fieldset>
		<button type="submit" class="btn btn-primary">Registrar</button>
	</form>
</div>
<%@ include file="../common/header.jspf"%>