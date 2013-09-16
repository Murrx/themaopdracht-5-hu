<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="/includes/header.jsp">
   <s:param name="title">Register</s:param>
</s:include>

	<h2>Register Application</h2>
	<s:actionerror />
	<s:form action="register.action" method="post">
		<s:textfield name="username" key="label.username" size="20" />
		<s:password name="password" key="label.password" size="20" />
		<s:submit method="execute" key="label.login" align="center" />
	</s:form>
		
<s:include value="/includes/footer.jsp" />