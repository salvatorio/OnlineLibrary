<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form"  uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title> Login | OnlineLibrary</title>
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1">

	<link
			href="/resources/css/bootstrap.min.css"
			rel="stylesheet">

	<style type="text/css">
		.panel-heading {
			padding: 5px 15px;
		}

		.panel-footer {
			padding: 1px 15px;
			color: #A0A0A0;
		}

		.profile-img {
			width: 96px;
			height: 96px;
			margin: 0 auto 10px;
			display: block;
			-moz-border-radius: 50%;
			-webkit-border-radius: 50%;
			border-radius: 50%;
		}
	</style>
</head>

<body>
	<div class="container" style="margin-top:40px">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading" align="center">
						<strong> Sign in to continue</strong>
					</div>
					<div class="panel-body">
						<form:form  role="form" action="j_spring_security_check" modelAttribute="users" method="POST">
							<fieldset>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
													<span class="input-group-addon">
														Username
													</span>
												<form:input class="form-control" path="username" name="loginname" type="text"/>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
													<span class="input-group-addon">
														Password
													</span>
													<form:input class="form-control" path="password" name="password" type="password" value=""/>
											</div>
										</div>
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-default btn-block" value="Sign in">
										</div>
									</div>
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/resources/js/jquery-2.1.4.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/modal.js"></script>
</body>
</html>







