<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
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
						<form class="form-signin" action="customerUpdate"
							method="post">
							<div class="form-label-group">
								<input type="text" id="customerCode" class="form-control"
									name="customerCode" placeholder="Enter Customer Code" required
									autofocus>
							</div>
							<br>
							<button class="btn btn-lg btn-primary btn-block" name="c"
								value="Update1" type="submit">Update Customer Data</button>
							<span style="color: red">${message}</span>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- <form action="customerUpdate" method="post">
<table>
<tr>
<td>Enter Customer Code:<input type="text" id="customerCode" name="customerCode"/></td>
</tr>
<tr>
<td><input type="submit" value="Update" /></td>
</tr>
</table>
</form> -->

</body>
</html>