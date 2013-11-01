<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'My Auctions', 'location': 'my-auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1>My Auctions</h1>

<div class="row" id="allAuctions">
	<s:iterator value="allAuctions"  >
		<s:include value="/includes/auctionBox.jsp" />
	</s:iterator>
</div>

<h3 class="headerPurple">Most recent bids:</h3>
<s:iterator value="allBids" >
<s:property value='bid.bidAmount'/>"
<s:property value='bid.action.owner.displayname'/>"
<s:property value='auction.auctionId'/>"
</s:iterator>

<s:push value="#{'progressTimers':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>