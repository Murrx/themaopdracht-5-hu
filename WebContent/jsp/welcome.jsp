<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="/includes/header.jsp">
   <s:param name="title">Welcome</s:param>
</s:include>

	<div class="bodyContent">
	<h2>Welcome!</h2>
	<p>Welcome to Auctify, <s:property value="username" />!</p>
	
	</div>
  
<s:include value="/includes/footer.jsp" />