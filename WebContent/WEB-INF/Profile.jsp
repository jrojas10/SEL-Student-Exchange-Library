<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>SEL-Profile</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Home">SEL</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="Home">Home</a></li>
			<li><a href="Post">Post</a></li>
			<li class="active"><a href="Profile">User Profile</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="SignUp"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>
			<li><a href="Login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>${user.firstName}${user.lastName}</h1>

			<a class="btn btn-primary" href="Logout">Logout</a> <a
				class="btn btn-primary" href="Post">Post a book</a> <a
				class="btn btn-primary" href="Search">Search</a>
		</div>
		<h3>
			Books<small>${user.firstName} ${user.lastName}</small>
		</h3>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Book</th>
				<th>Author</th>
				<th>ISBN #</th>
			</tr>
			<tr>
				<td>Book1</td>
				<td>Author1</td>
				<td>123</td>
			</tr>
			<tr>
				<td>Book2</td>
				<td>Author2</td>
				<td>456</td>
			</tr>
			<tr>
				<td>Book3</td>
				<td>Author3</td>
				<td>789</td>
			</tr>
		</table>
	</div>

</body>
</html>