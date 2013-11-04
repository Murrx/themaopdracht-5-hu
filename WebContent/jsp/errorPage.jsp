<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Welcome', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<h2>Sorry, something went wrong!</h2>
		<p>Additional information about what went wrong:</p>
		
		<s:if test="actionErrors != null && actionErrors.size > 0">
	    	<s:actionerror />
	    </s:if>
		
		<s:if test="%{exception.message !=''}">
			<s:property value="%{exception.message}"/>
	    </s:if>
		
<s:include value="/includes/footer.jsp" />