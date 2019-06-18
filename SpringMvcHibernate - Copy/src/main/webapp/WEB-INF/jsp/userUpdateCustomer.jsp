<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
<spring:url value="/Resources/css/addCustomer.css" var="coreCss" />
<spring:url value="/Resources/Bootstrap/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<jsp:include page="userHeader.jsp" />
	<div class="container">
		<br>
		<div class="row">
			<div class=" col-md-12 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">

						<h2 class="card-title text-center">Enter User Details</h2>
						<div class="formContainer">
							<span style="color: red">${error}</span> <span
								style="color: red">${message}</span> <span
								style="color: yellow">${warning}</span>
							<form:form class="form-horizontal"
								onsubmit="return formValidation1()" action="updateCustomer"
								method="post" modelAttribute="customer">
								<div class="form-group">
									<label for="customerCode" class="col-sm-3 control-label">Customer
										Code</label>
									<div class="col-sm-9">
										<form:input path="customerCode"
											value="${customer.customerCode}" readonly="true" />

										<form:errors path="customerCode"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerName" class="col-sm-3 control-label">Customer
										Name</label>
									<div class="col-sm-9">
										<form:input path="customerName"
											value="${customer.customerName}" />
										<p id="p1"></p>
										<form:errors path="customerName"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerAddress" class="col-sm-3 control-label">Customer
										Address</label>
									<div class="col-sm-9">
										<form:input path="customerAddress"
											value="${customer.customerAddress}" />

										
										<form:errors path="customerAddress"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerPinCode" class="col-sm-3 control-label">Customer
										PinCode</label>
									<div class="col-sm-9">
										<form:input path="customerPinCode"
											value="${customer.customerPinCode}" />
										<p id="p2"></p>
										<form:errors path="customerPinCode"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerEmail" class="col-sm-3 control-label">Customer
										Email</label>
									<div class="col-sm-9">
										<form:input path="customerEmail"
											value="${customer.customerEmail}" />
										<p id="p3"></p>
										<form:errors path="customerEmail"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerNumber" class="col-sm-3 control-label">Contact
										Number</label>
									<div class="col-sm-9">
										<form:input path="customerNumber"
											value="${customer.customerNumber}" />
										<p id="p4"></p>
										<form:errors path="customerNumber"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerNumber" class="col-sm-3 control-label">Registration
										Date</label>
									<div class="col-sm-9">
										<form:input path="registrationDate"
											value="${customer.registrationDate}" readonly="true" />
										<form:errors path="registrationDate"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerNumber" class="col-sm-3 control-label">Created
										By</label>
									<div class="col-sm-9">
										<form:input path="createdBy" value="${customer.createdBy}"
											readonly="true" />
										<form:errors path="createdBy"></form:errors>
									</div>
								</div>
								<form:hidden path="modifiedDate" />
								<div class="col-sm-9">
									<button type="submit" value="Save"
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
	<spring:url value="/Resources/js/updateCustomer.js" var="coreJS" />
	<script src="${coreJS}"></script>
</body>
</html>