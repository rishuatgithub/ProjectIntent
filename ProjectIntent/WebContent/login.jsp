<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Intent - Login Page</title>
</head>
<body>

<h2>Project Intent</h2>
<div class="linkedin_btn">
	<s:url action="welcome.action" var="url" ></s:url>
	<s:a href="%{url}"><img src="images/linkedin_btn.png"/></s:a>
</div>

</body>
</html>