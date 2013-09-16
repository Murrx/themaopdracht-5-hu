<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="/includes/header.jsp">
   <s:param name="title">Login</s:param>
</s:include>

	<h2>Login Application</h2>
	<s:actionerror />
	<s:form action="login.action" method="post" class="form-horizontal">
		<div class="control-group">
		<s:textfield name="username" key="label.username" size="20" />
		<s:password name="password" key="label.password" size="20" />
		<s:submit method="execute" key="label.login" align="center" />
		</div>
	</s:form>
	<a href="<s:url value="/jsp/register.jsp"  />">Register here</a>
	
<s:include value="/includes/footer.jsp" />