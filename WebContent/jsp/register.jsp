<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="/includes/header.jsp">
   <s:param name="title">Register</s:param>
</s:include>

	<div class="bodyContent">
	
		<h2>Register Application</h2>
		<s:actionerror />
		<s:form action="register.action" method="post">
			<s:textfield name="register_email" key="label.email" size="20" placeholder="Email" cssClass="form-control" />
			<s:password name="register_password" key="label.password" size="20" placeholder="Password" cssClass="form-control" />
			<s:password name="register_password2" key="label.password" size="20" placeholder="Password" cssClass="form-control" />
			<s:textfield name="register_displayName" key="label.displayname" placeholder="Display Name" size="20" cssClass="form-control" />
			<s:submit method="execute" key="label.register" align="center" cssClass="btn btn-default" />
		</s:form>
	</div>
		
<s:include value="/includes/footer.jsp" />