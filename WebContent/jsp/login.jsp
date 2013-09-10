<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Application</h2>
	<s:actionerror />
	<s:form action="login.action" method="post">

		<s:textfield name="username" key="label.username" size="20" />
		<s:password name="password" key="label.password" size="20" />

		<s:submit method="execute" key="label.login" align="center" />
	</s:form>
</body>

</html>