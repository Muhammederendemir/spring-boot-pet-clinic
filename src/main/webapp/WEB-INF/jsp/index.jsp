<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Example</title>
</head>
<body>
<h1>Muhammed Eren Demir</h1>
<form action="logout" method="POST">
    <input type="submit" value="logout"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>