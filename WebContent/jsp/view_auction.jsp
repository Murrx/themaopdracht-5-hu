<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auction info', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

		<h2>Auction info!</h2>
		<p>This page will soon display info about the auction you just selected.</p>
		
		<h3>Auction info</h3>
		<p>id: <s:property value="auction.auctionId" /></p>
		<p>start time: <s:property value="auction.startTime.toString()" /></p>
		<p>end time: <s:property value="auction.endTime.toString()" /></p>
		<p>start bid: <s:property value="auction.startBid" /></p>
		<br/>
		<p>name: <s:property value="auction.product.name" /></p>
		<p>description: <s:property value="auction.product.description" /></p>
		<br/>
		<p>status: <s:property value="auction.status" /></p>
		<p>category: <s:property value="auction.category" /></p>
		<p>user: <s:property value="auction.user" /></p>
<s:include value="/includes/footer.jsp" />