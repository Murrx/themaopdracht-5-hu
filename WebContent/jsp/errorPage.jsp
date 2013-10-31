<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Welcome', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<h2>Sorry, something went wrong.!</h2>
		<p>Additional information about what went wrong: 	<s:actionerror />		</p>
		
<s:include value="/includes/footer.jsp" />