<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/Resources/css/login.css" var="coreCss" />
<spring:url value="/Resources/Bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />

<title>Login</title>
</head>
<body>
<%--  <jsp:include page="_menu.jsp" /> --%>
     
     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
  <div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Log In</h5>
						<form class="form-login" name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
							<div class="form-label-group">
								<input type="text" name="username"
									class="form-control"
									placeholder="User Name" required autofocus> <label
									for="inputEmail">User Name</label>
							</div>

							<div class="form-label-group">
								<input type="password" name="password"
									class="form-control" placeholder="Password" required> <label
									for="inputPassword">Password</label>
							</div>

							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								name="s" value="LogIn" type="submit">Log in</button>
							<br>
							<span style="color: red">${warning}</span>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript -->
	<spring:url value="/Resources/JQuery/jquery.min.js" var="jqueryJS" />
	<spring:url value="/Resources/Bootstrap/js/bootstrap.bundle.min.js" var="bootstrapJS" />
	<script src="${jqueryJS} }"></script>
	<script src="${bootstrapJS}"></script>
</body>
</html>