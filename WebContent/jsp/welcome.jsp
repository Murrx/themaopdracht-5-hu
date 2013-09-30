<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Welcome', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<h2>Welcome!</h2>
		<p>Welcome to Auctify, <s:property value="#session.user.displayName" />!</p>
		<p>User in session: <s:property value="#session.user" /></p>
<s:include value="/includes/footer.jsp" />