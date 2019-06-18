<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
<spring:url value="/Resources/css/addCustomer.css" var="coreCss" />
<spring:url value="/Resources/Bootstrap/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<div class="container">
		<br> <br> <br>
		<div class="row">
			<div class=" col-md-12 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">

						<h2 class="card-title text-center">Update User Details</h2>
						<div class="formContainer">
							<span style="color: red">${error}</span> <span
								style="color: red">${message}</span> <span
								style="color: yellow">${warning}</span>
							<form:form class="form-horizontal"
								onsubmit='return formValidation()' action="updateUser"
								method="post" modelAttribute="user">
								<div class="form-group">
									<label for="userId" class="col-sm-3 control-label">User
										Id</label>
									<div class="col-sm-9">
										<form:input class="form-control" path="userId"
											value="${user.userId}" readonly="true" />
										<p id="p1"></p>
										<form:errors path="userId"></form:errors>
										</td>
									</div>
								</div>
								<div class="form-group">
									<label for="userName" class="col-sm-3 control-label">User
										Name</label>
									<div class="col-sm-9">
										<form:input class="form-control" path="userName"
											value="${user.userName}" />
										<p id="p2"></p>
										<form:errors path="userName"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-sm-3 control-label">User
										Password</label>
									<div class="col-sm-9">
										<form:input class="form-control" path="password"
											value="${user.password}" />
										<p id="p3"></p>
										<form:errors path="password"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="user_role" class="col-sm-3 control-label">User
										Role</label>
									<div class="col-sm-9">
										<form:input class="form-control" path="user_role"
											value="${user.user_role}" />
										<p id="p4"></p>
										<form:errors path="user_role"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="userName" class="col-sm-3 control-label">User
										Enabled</label>
									<div class="col-sm-9">
										<form:input class="form-control" path="enabled"
											value="${user.enabled}" />
										<p id="p5"></p>
										<form:errors path="enabled"></form:errors>
									</div>
								</div>

								<div class="col-sm-9">
									<button type="submit" value="Update"
										class="btn btn-primary btn-block">Update</button>
								</div>
								

							</form:form>
							<!-- /form -->
						</div>
						<!-- ./formContainer -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>