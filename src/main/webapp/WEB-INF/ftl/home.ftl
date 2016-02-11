<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.pvelychko.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home page</title>
	    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="icon" type="image/png" href="./imgages/favicon.ico" />
		
		<link rel="stylesheet" href="./css/bootstrap.min.css" />
		<link rel="stylesheet" href="./css/styles.css" />
	</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					<img alt="Library" src="./images/logo.png" />
				</a>
				
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">
					Project name
				</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="#">Home</a>
					</li>
					<li>
						<a href="#about">About</a>
					</li>
					<li>
						<a href="#contact">Contact</a>
					</li>
				</ul>
			</div>
		</div>
    </nav>


	<nav role="navigation">
	    <ul>
	    <#if !currentUser??>
	        <li><a href="./login">Log in</a></li>
	    </#if>
	    <#if currentUser??>
	        <li>
	            <form action="./logout" method="post">
	                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	                <button type="submit">Log out</button>
	            </form>
	        </li>
	        <li>
	        	<a href="./user/${currentUser.id}">View myself</a>
	        </li>
	    </#if>
	    <#if currentUser?? && currentUser.role == "ADMIN">
	        <li>
	        	<a href="./user/create">Create a new user</a>
	        </li>
	        <li>
	        	<a href="./users">View all users</a>
	        </li>
	    </#if>
	    </ul>
	</nav>
	
	<script type="text/javascript" src="./js/bootstrap.min.js" />
</body>
</html>