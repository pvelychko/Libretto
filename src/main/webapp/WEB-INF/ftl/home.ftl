<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.pvelychko.domain.CurrentUser" -->
<#-- @ftlvariable name="categories" type="java.util.List<com.pvelychko.domain.Category>" -->
<#-- @ftlvariable name="currentCategory" type="com.pvelychko.domain.Category" -->
<#-- @ftlvariable name="books" type="java.util.List<com.pvelychko.domain.Book>" -->
<#-- @ftlvariable name="currentBook" type="com.pvelychko.domain.Book" -->
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home page</title>
	    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8"></meta>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
		<meta content="IE=9" http-equiv="X-UA-Compatible"></meta>
		<link rel="icon" type="image/png" href="/images/favicon.ico"></link>
		<link rel="stylesheet" href="/css/bootstrap.min.css"></link>
		<link rel="stylesheet" href="/css/styles.css"></link>
		<script type="text/javascript" src="/js/jquery.min.js"></script>
		<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	</head>
<body>
	<img src="/images/background.png" class="background grayscale dimmed"></img>

	<nav class="navbar navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href=".">
					<img alt="Library" src="/images/logo.png" />	
				</a>
				
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">
					Library
				</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav pull-right">
					<li class="active">
						<a href="/">Home</a>
					</li>
					<#if !currentUser??>
						<li class="divider-vertical hidden-xs hidden-sm" />
						<li>
							<a href="/login" class="text-warning">Log in</a>
						</li>
					</#if>
	    			<#if currentUser?? && currentUser.role == "ADMIN">
				        <li class="divider-vertical hidden-xs hidden-sm" />
				        <li>
				        	<a href="/user/create">Create a new user</a>
				        </li>
				        <li class="divider-vertical hidden-xs hidden-sm" />
				        <li>
				        	<a href="/users">View all users</a>
				        </li>
				    </#if>
				    <#if currentUser??>
	    				<li class="divider-vertical hidden-xs hidden-sm" />
						<li>
				        	<a href="/user/${currentUser.id}">${currentUser.name}</a>
				        </li>
				        <li class="divider-vertical hidden-xs hidden-sm" />
						<li class="hasbutton">
							<form action="/logout" method="post">
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
			<h1 class="text-center">ALL BOOKS</h1>
			
			<div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-1 text-center">
				<h3>Categories</h3>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" style="width: 100%;" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						<span style="text-overflow: ellipsis; display: block; overflow: hidden;">
							<#if currentCategory??>
								${currentCategory.name}
							<#else>
								All Categories
							</#if>
							<span class="caret"></span>
						</span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li>
							<a href="/">All Categories</a>
						</li>
						<li role="separator" class="divider"></li>
						<#list categories as category>
							<li>
								<a href="/category/${category.id}">${category.name}</a>
							</li>
						</#list>
					</ul>
				</div>
			</div>
			<div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-2 text-center">
				<h3>Titles</h3>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" style="width: 100%;" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						<span style="text-overflow: ellipsis; display: block; overflow: hidden;">
							<#if currentBook??>
								${currentBook.name}
							<#else>
								All Titles
							</#if>
							<span class="caret"></span>
						</span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li>
							<a href="/">All Titles</a>
						</li>
						<li role="separator" class="divider"></li>
						<#list books as book>
							<li>
								<a href="/book/${book.id}">${book.name}</a>
							</li>
						</#list>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="row">	
			<div class="col-md-12">	
				<table class="table table-bordered semi-transparent">
				    <thead>
					    <tr>
					        <th>Title</th>
					        <th class="hidden-xs">Author</th>
					        <th>Category</th>
					        <#if currentUser??>
					        	<th>Check</th>
					        </#if>
					    </tr>
				    </thead>
				    <tbody>
				    	<#if currentBook??>
				    		<tr>
						        <td>${currentBook.name}</td>
						        <td class="hidden-xs">${currentBook.author}</td>
						        <td><em>${currentBook.category.name}</em></td>
						        <#if currentUser??>
							        <td class="text-center">
							        	<#if currentBook.student??>
							        		<#if currentBook.student.id == currentUser.id>
												<a href="/user/${currentUser.id}/book/${currentBook.id}/return" class="btn btn-warning">Return</a>
											<#else>
												<#if currentBook.student.id != currentUser.id>
													<span class="text-muted">Borrowed</span>
												</#if>
											</#if>
											<#else>
												<a href="/user/${currentUser.id}/book/${currentBook.id}/borrow" class="btn btn-success">Borrow</a>
										</#if>
									</td>
								</#if>
						    </tr>
				    	<#else>
					    <#list books as book>
						    <tr>
						        <td>${book.name}</td>
						        <td class="hidden-xs">${book.author}</td>
						        <td><em>${book.category.name}</em></td>
						        <#if currentUser??>
							        <td class="text-center">
							        	<#if book.student??>
							        		<#if book.student.id == currentUser.id>
												<a href="/user/${currentUser.id}/book/${book.id}/return" class="btn btn-warning">Return</a>
											<#else>
												<#if book.student.id != currentUser.id>
													<span class="text-muted">Borrowed</span>
												</#if>
											</#if>
											<#else>
												<a href="/user/${currentUser.id}/book/${book.id}/borrow" class="btn btn-success">Borrow</a>
										</#if>
									</td>
								</#if>
						    </tr>
					    </#list>
					    </#if>
				    </tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>