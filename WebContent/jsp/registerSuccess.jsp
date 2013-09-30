<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Registration Complete', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<h2>Registration completed!</h2>
		<p>You have sucessfully registered to Auctify. Please use the log-in form above to start using Auctify.</p>
<s:include value="/includes/footer.jsp" />