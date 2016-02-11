<#-- @ftlvariable name="user" type="com.pvelychko.domain.User" -->
<!DOCTYPE html>
<html lang="en">
	<head>
	    <title>User details</title>
	    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta content="IE=9" http-equiv="X-UA-Compatible" />
		<link rel="icon" type="image/png" href="./images/favicon.ico" />
		
		<link rel="stylesheet" href="./css/bootstrap.min.css" />
		<link rel="stylesheet" href="./css/styles.css" />
	</head>
<body>
	<img src="./images/background.png" class="background grayscale dimmed" />

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
					Library
				</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="./../">Home</a>
					</li>
					<li>
						<form action="./logout" method="post">
			                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			                <button type="submit" class="btn btn-danger">Log out</button>
			            </form>
					</li>
				</ul>
			</div>
		</div>
    </nav>

	<nav role="navigation">
	    <ul>
	        <li><a href="./../">Home</a></li>
	    </ul>
	</nav>
	
	<h1>User details</h1>
	
	<p>E-mail: ${user.email}</p>
	
	<p>Role: ${user.role}</p>
</body>
</html>