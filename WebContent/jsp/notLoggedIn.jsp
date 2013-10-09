<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Acces denied', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<h2>Authorization required!</h2>
		<p>We appreciate you trying to access this page, you do need to be signed in however!</p>
		<p>You can sign in using the box on the top of the page.</p>
<s:include value="/includes/footer.jsp" />