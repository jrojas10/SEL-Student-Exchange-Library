<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>SEL - Verification</title>
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
			<li><a href="Profile">User Profile</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="active"><a href="SignUp"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="Login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">
		<div class="page-header">
			<h1>
				Verification <small>SEL</small>
			</h1>
		</div>
		<h3>A 4 digit verification code has been seen to your email,
			please enter the code to complete your registration</h3>

		<form action="AddUser" method="post">
			<div class="form-group">
			<label class="control-label">Verification Code</label>
				<input  type="text" name = "key">
			</div>
			<button type="submit" class="btn btn-primary">Verify</button>
		</form>


	</div>

</body>
</html>