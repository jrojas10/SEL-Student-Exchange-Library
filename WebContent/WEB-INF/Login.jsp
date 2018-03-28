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

<title>SEL-Login</title>
</head>
<body>
 <div class="container">
        <div class="page-header">
            <h1>Login</h1>
        </div>
        <form action="Profile" method="post">
            <div class="form-group">
                <label>Username (E-mail Address)</label>
                <input class="form-control" type="email" name="email" placeholder="Email">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input class="form-control" type="password" name="password" placeholder="Password">

            </div>
            <div class="checkbox">
                <label><input type="checkbox" name="rememberMe"> Remember Username</label>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>

    </div>
</body>
</html>