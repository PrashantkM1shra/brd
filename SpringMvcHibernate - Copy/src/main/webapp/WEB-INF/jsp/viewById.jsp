<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="userHeader.jsp" />
	<div class="container">
		<br>
		<br>
		<br>
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Enter Customer Code</h5>
						<br>
						<form class="form-signin" action="viewACustomer"
							method="post">
							<div class="form-label-group">
								<input type="text" id="customerCode" class="form-control"
									name="customerCode" placeholder="Enter Customer Code" required
									autofocus>
							</div>
							<br>
							<button class="btn btn-lg btn-primary btn-block" name="c"
								value="View1" type="submit">View Customer</button>
							<span style="color: red">${message}</span> 
						</form>
					</div>
				</div>
			</div>
		</div>

	<table id="example" cellspacing="0"
			class="table-striped table-bordered display" width="100%">
			<thead>
				<tr>
					<th>Customer Code</th>
					<th>Customer Name</th>
					<th>Address</th>
					<th>Pincode</th>
					<th>Email</th>
					<th>Contact Number</th>
					<th>Registration Date</th>
					<th>Created By</th>
					<th>Modified Date</th>


				</tr>
			</thead>

			<tbody>
				<tr>
						<td>${customer.customerCode}</td>
						<td>${customer.customerName}</td>
						<td>${customer.customerAddress}</td>
						<td>${customer.customerPinCode}</td>
						<td>${customer.customerEmail}</td>
						<td>${customer.customerNumber}</td>
						<td>${customer.registrationDate}</td>
						<td>${customer.createdBy}</td>
						<td>${customer.modifiedDate}</td>
				</tr>
			</tbody>
		</table>



	</div>


	<script src="https://code.jquery.com/jquery-1.12.4.js"
		type="text/javascript"></script>
	<script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script>
$(document).ready(function()
{
    $('#example').DataTable();
} );
</script>



<!-- <form action="viewACustomer" method="post">
<table>
<tr>
<td>Enter Customer Code:<input type="text" id="customerCode" name="customerCode"/></td>
</tr>
<tr>
<td><input type="submit" value="View" /></td>
</tr>
</table>
</form> -->

</body>
</html>
