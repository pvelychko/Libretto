<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Log in</title>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8"></meta>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
	<meta content="IE=9" http-equiv="X-UA-Compatible"></meta>
	<link rel="icon" type="image/png" href="./images/favicon.ico"></link>
	<link rel="stylesheet" href="./css/bootstrap.min.css"></link>
	<link rel="stylesheet" href="./css/styles.css"></link>
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
</head>
<body>
	<img src="./images/background.png" class="background grayscale dimmed"></img>

	<nav class="navbar navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./">
					<img alt="Library" src="./images/logo.png" />
				</a>
				
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="./">
					Library
				</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav pull-right">
					<li class="active">
						<a href="./">Home</a>
					</li>
					<#if !currentUser??>
						<li class="divider-vertical hidden-xs hidden-sm" />
						<li>
							<a href="./login" class="text-warning">Log in</a>
						</li>
					</#if>
	    			<#if currentUser?? && currentUser.role == "ADMIN">
				        <li class="divider-vertical hidden-xs hidden-sm" />
				        <li>
				        	<a href="./user/create">Create a new user</a>
				        </li>
				        <li class="divider-vertical hidden-xs hidden-sm" />
				        <li>
				        	<a href="./users">View all users</a>
				        </li>
				    </#if>
				    <#if currentUser??>
	    				<li class="divider-vertical hidden-xs hidden-sm" />
						<li>
				        	<a href="./user/${currentUser.id}">${currentUser.name}</a>
				        </li>
				        <li class="divider-vertical hidden-xs hidden-sm" />
						<li class="hasbutton">
							<form action="./logout" method="post">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<button type="submit" class="btn btn-danger">Log out</button>
				            </form>
						</li>
	    			</#if>
				</ul>
			</div>
		
			<div class="row">
				<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">
					<div class="well semi-transparent">
						<div class="text-center">
							<h3>LOG IN</h3>
							<h5 class="text-muted">Use a local account to log in</h5>
						</div>
						<form role="form" action="login" method="post">
	    					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<div>
								<div class="form-group">
								    <label for="email">Email address</label>
	        						<input id="email" type="email" name="email" class="form-control" placeholder="Email" required autofocus/>
								</div>
								<div class="form-group">
									<label for="password">Password</label>
	        						<input id="password" type="password" name="password" class="form-control" placeholder="Email" required/>
								</div>
								<div>
									<label for="remember-me">Remember me</label>
	        						<input type="checkbox" name="remember-me" id="remember-me"/>
								</div>
							</div>
							<div class="text-right">
								<button type="submit" class="btn btn-primary">Log in</button>
							</div>
						</form>
						
					</div>
				</div>
			</div>

			<#if error??>
			<p>The email or password you have entered is invalid, try again.</p>
			</#if>
		</div>
	</div>
</body>
</html>