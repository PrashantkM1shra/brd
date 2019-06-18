<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="userHeader.jsp" />
<div class="container-fluid">
		<br>
		<br>
		<br>
		<br>
		<h3 class="text-center">Record of all Customers</h3>
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
				<c:forEach items="${customerData}" var="customer">
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
		</c:forEach>
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
<script type="text/javascript">
   setTimeout(function(){
       location.reload();
   },10000);
</script>
</body>
</html>