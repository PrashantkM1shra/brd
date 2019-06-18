<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
<spring:url value="/Resources/css/addCustomer.css" var="coreCss" />
<spring:url value="/Resources/Bootstrap/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
<jsp:include page="userHeader.jsp" />
	<div class="container-fluid">
		<br>
		<div class="row">
			<div class=" col-md-6 mx-left">
				<!-- <div class="card card-signin my-5">
					<div class="card-body"> -->

						<h2 class="card-title text-center">Enter User Details</h2>
						<div >
						<!-- </div>class="formContainer"> -->
							<span style="color: red">${error}</span> <span
								style="color: green">${success}</span> <span
								style="color: red">${message}</span>
							<form:form class="form-horizontal"
								 action="saveCustomer"
								method="post" modelAttribute="customer" onsubmit="return formValidation()">

								<form:hidden path="customerCode" />
								<div class="form-group">
									<label for="customerName" class="col-sm-5 control-label">Customer
										Name</label>
									<div class="col-sm-9">
										<form:input path="customerName" placeholder="Customer Name"
											class="form-control" required="true" />
										<p id="p1"></p>
										<form:errors path="customerName"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerAddress" class="col-sm-5 control-label">Customer
										Address</label>
									<div class="col-sm-9">
										<form:input path="customerAddress"
											placeholder="Customer Address" class="form-control"
											required="true" />
										<p id="p2"></p>
										<form:errors path="customerAddress"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerPinCode" class="col-sm-5 control-label">Customer
										PinCode</label>
									<div class="col-sm-9">
										<form:input path="customerPinCode"
											placeholder="Customer PinCode" class="form-control"
											required="true" />
										<p id="p3"></p>
										<form:errors path="customerPinCode"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerEmail" class="col-sm-5 control-label">Customer
										Email</label>
									<div class="col-sm-9">
										<form:input path="customerEmail" placeholder="Customer Email"
											class="form-control" required="true" />
										<p id="p4"></p>
										<form:errors path="customerEmail"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label for="customerNumber" class="col-sm-5 control-label">Contact
										Number</label>
									<div class="col-sm-9">
										<form:input path="customerNumber"
											placeholder="Customer Number" class="form-control"
											required="true" />
										<p id="p5"></p>
										<form:errors path="customerNumber"></form:errors>
									</div>
								</div>
								<form:hidden path="registrationDate" />
								<form:errors path="registrationDate"></form:errors>

								<form:hidden path="createdBy" />
								<form:errors path="createdBy"></form:errors>

								<form:hidden path="modifiedDate" />
								<form:errors path="modifiedDate"></form:errors>

								<div class="col-sm-9">
									<button type="submit" value="Save" 
										class="btn btn-primary btn-block">Save</button>
								</div>
								

							</form:form>
							<!-- /form -->
						 </div>
						<!-- ./formContainer -->
					
					</div>
					<div class=" col-md-6 mx-right">
					<br>
					<br>
					<iframe width="100%" height="100%" src="/SpringMvcHibernate/viewAll"></iframe>
					</div>
					</div>
				</div>
			
			
		<!-- </div>
	</div> -->
<spring:url value="/Resources/js/addCustomer.js" var="coreJS" />
<script src="${coreJS}"></script>
<script>

</script>
</body>
</html>