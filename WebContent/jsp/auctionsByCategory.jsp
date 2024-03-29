<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title': category, 'location': 'auctions', 'parent': 'allAuctions', 'parentName': 'Auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1><s:property value="%{category}" /></h1>

<div class="row">
	<s:iterator value="allAuctions">
		<s:include value="/includes/auctionBox.jsp" />
	</s:iterator>
</div>

<s:include value="/includes/footer.jsp" />