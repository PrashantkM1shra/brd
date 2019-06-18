<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/Resources/css/Maker.css" var="coreCss" />
<spring:url value="/Resources/Bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
<div id="topheader">

		<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Admin</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav mr-auto ">
						<li class="nav-item active"><a class="nav-link "
							href="saveUser">Add User </a><span class="sr-only">(current)</span>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="modifyUser">Update User </a></li>
					</ul>
					<ul class="navbar-nav ml-auto ">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Profile </a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Username: ${pageContext.request.userPrincipal.name}</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item btn button"
									href="${pageContext.request.contextPath}/logout">Logout</a>
							</div></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- Bootstrap core JavaScript -->
	<spring:url value="/resources/JQuery/jquery.min.js" var="jqueryJS" />
	<spring:url value="/resources/Bootstrap/js/bootstrap.bundle.min.js" var="bootstrapJS" />
	<script src="${jqueryJS} }"></script>
	<script src="${bootstrapJS}"></script>
	
	<script>
		$(document).ready(function () {
		$('.navbar-dark .dmenu').hover(function () {
	        $(this).find('.sm-menu').first().stop(true, true).slideDown(150);
	    }, function () {
	        $(this).find('.sm-menu').first().stop(true, true).slideUp(105)
	    });
		});  
		
		$( '#topheader .navbar-nav a' ).on( 'click', function () {
			$( '#topheader .navbar-nav' ).find( 'li.active' ).removeClass( 'active' );
			$( this ).parent( 'li' ).addClass( 'active' );
		});
		$(document).ready(function(){
		    $(".dropdown, .btn-group").hover(function(){
		        var dropdownMenu = $(this).children(".dropdown-menu");
		        if(dropdownMenu.is(":visible")){
		            dropdownMenu.parent().toggleClass("open");
		        }
		    });
		});     
	</script>
</body>
</html>