<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'My Auctions', 'location': 'my-auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<%-- <h3 class="headerPurple">My Auctions</h3>

<div class="row" id="allAuctions">
		<s:if test="allAuctions != null">
		<s:iterator value="allAuctions">
			<s:include value="/includes/auctionBox.jsp" />
		</s:iterator>
		</s:if>
		<s:else>
		No auctions available
		</s:else>
</div> --%>

<div class="col-xs-12 col-sm-12 col-md-8">

		<h3>My Relevant auctions</h3>
			<div class="table-responsive table-condensed">
				<table class="table table-hover">
				<tr>
				<th>Bid Status:</th>
 				<th>Auction:</th>
  				<th>Product:</th>
  				<th>bidCoins:</th>
  			</tr>
					<s:iterator value="allBids">
						<s:include value="/includes/myRelevantBidAuction.jsp" />
					</s:iterator>
				</table>
			</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-4 ">
		 <span class="headerPurple"><strong> Bid history: </strong></span><br /><br />

			
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