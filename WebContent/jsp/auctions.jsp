<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auctions', 'location': 'auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1>Alle Auctions</h1>

<div class="row">
	<s:iterator status="stat" value="(25).{ #this }" >
		<s:include value="/includes/auctionBox.jsp" />
	</s:iterator>
</div>

<s:include value="/includes/footer.jsp" />