<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.pvelychko.domain.CurrentUser" -->
<#-- @ftlvariable name="myBooks" type="java.util.List<com.pvelychko.domain.Book>" -->
<!DOCTYPE html>
<html lang="en">
	<head>
	    <title>User details</title>
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

	<nav class="navbar navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href=".">
					<img alt="Library" src="./images/logo.png" />	
				</a>
				
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href=".">
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
							<form action="./../logout" method="post">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<button type="submit" class="btn btn-danger">Log out</button>
				            </form>
						</li>
	    			</#if>
				</ul>
			</div>
				
				
		</div>
    </nav>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>User details</h1>
				<p>E-mail: ${currentUser.email}</p>
				<p>Role: ${currentUser.role}</p>
			
				<h1 class="text-center">MY BOOKS</h1>
				<table class="table table-bordered semi-transparent">
				    <thead>
					    <tr>
					        <th>Title</th>
					        <th class="hidden-xs">Author</th>
					        <th>Category</th>
					        <th>Check</th>
					    </tr>
				    </thead>
				    <tbody>
					    <#list myBooks as book>
						    <tr>
						        <td>${book.name}</td>
						        <td class="hidden-xs">${book.author}</td>
						        <td><em>${book.category.name}</em></td>
						        <td></td>
						    </tr>
					    </#list>
				    </tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>