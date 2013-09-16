<jsp:include page="/includes/header.jsp" />
	<h2>Login Application</h2>
	<s:actionerror />
	<s:form action="login.action" method="post">

		<s:textfield name="username" key="label.username" size="20" />
		<s:password name="password" key="label.password" size="20" />

		<s:submit method="execute" key="label.login" align="center" />
	</s:form>
<jsp:include page="/includes/footer.jsp" />
