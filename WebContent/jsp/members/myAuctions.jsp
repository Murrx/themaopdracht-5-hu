<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'My Auctions', 'location': 'my-auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>
<div class="col-xs-12 col-sm-12 col-md-8">
<h3 class="headerPurple">My Auctions</h3>

<div class="table-responsive table-condensed">
		<table class="table table-hover">
			<tr>
				<th>Product:</th>
				<th>End Time:</th>
				<th>Start bid:</th>
				<th>Highest bid:</th>
				<th>Status</th>
			</tr>
	<s:if test="allAuctions != null">
		<s:iterator value="allAuctions">
			<s:include value="/includes/myAuctionsList.jsp" />
		</s:iterator>
	</s:if>
	<s:else>
		No auctions available
		</s:else>
		</table>
</div>
</div>
<div class="col-xs-12 col-sm-12 col-md-8">

	<h3>My Relevant auctions</h3>
	<div class="table-responsive table-condensed">
		<table class="table table-hover">
			<tr>
				<th>Product:</th>
				<th>Date:</th>
				<th>BidCoins:</th>
				<th>Status:</th>
			</tr>
			<s:if test="allAuctions != null">
				<s:iterator value="relevantAuctions.values()">
					<s:include value="/includes/myRelevantBidAuction.jsp" />
				</s:iterator>
			</s:if>
			<s:else>
		No auctions available
		</s:else>
		</table>
	</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-4 ">
	<span class="headerPurple"><strong> Bid history: </strong></span><br />
	<br />


	<table class="table table-striped">
		<tr>
			<th>Product:</th>
			<th>bidCoins:</th>
			<th>Date:</th>

		</tr>
		<s:iterator value="allBids">
			<s:include value="/includes/myListBidAuction.jsp" />
		</s:iterator>
	</table>
</div>

<s:push value="#{'progressTimers':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>