<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
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

						<h2 class="card-title text-center">Enter User Details</h2>
						<div class="formContainer">
							<span style="color: red">${error}</span> <span style="color: red">${message}</span>
							<span style="color: yellow">${warning}</span>
							<form:form class="form-horizontal"
								onsubmit="return formValidation2()" action="saveUserData"
								method="post" modelAttribute="user">
								<div class="form-group">
									<label for="userName" class="col-sm-3 control-label">User
										Name</label>
									<div class="col-sm-9">
										<form:input class="form-control" path="userName"
											placeholder="User Name" required="true" />
										<p id="p1"></p>
										<form:errors path="userName"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-sm-3 control-label">User
										Password</label>
									<div class="col-sm-9">
										<form:input path="password" placeholder="User Password"
											class="form-control" required="true" />
										<p id="p2"></p>
										<form:errors path="password"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="user_role" class="col-sm-3 control-label">User
										Role</label>
									<div class="col-sm-9">
										<form:radiobutton path="user_role"
											value="ROLE_ADMIN" label="Admin" />
										<form:radiobutton path="user_role"
											value="ROLE_USER" label="User" />
										<%-- <form:input path="user_role" placeholder="User Role"
											 class="form-control" required="true"/> --%>
										<p id="p3"></p>
										<form:errors path="user_role"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="userName" class="col-sm-3 control-label">User
										Enabled</label>
									<div class="col-sm-9">
										<form:radiobutton path="enabled" 
											value="1" label="TRUE" />
										<form:radiobutton path="enabled" value="0"
											label="FALSE" />
										<%-- <form:input path="enabled" placeholder="User Enabled"
											 class="form-control" required="true"/> --%>
										<p id="p4"></p>
										<form:errors path="enabled"></form:errors>
									</div>
								</div>

								<div class="col-sm-9">
									<button type="submit" value="Add"
										class="btn btn-primary btn-block">Add</button>
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

	<%-- <form:form action="saveUserData" method="post" modelAttribute="user">
<table>
<tr>
<td>User Name:<form:input path="userName"/></td>
<td><form:errors path="userName"></form:errors></td>
</tr>
<tr>
<td>User Password:<form:input path="password"/></td>
<td><form:errors path="password"></form:errors></td>
</tr>
<tr>
<td>User Role:<form:input path="user_role"/></td>
<td><form:errors path="user_role"></form:errors></td>
</tr>
<tr>
<td>User Enabled:<form:input path="enabled"/></td>
<td><form:errors path="enabled"></form:errors></td>
</tr>
<tr>
<td><input type="submit" value="Add User" /></td>
</tr>
</table>
</form:form>
${message} --%>
	<spring:url value="/Resources/js/addUser.js" var="bootstrapJS" />
	<script src="${bootstrapJS}"></script>
</body>
</html>