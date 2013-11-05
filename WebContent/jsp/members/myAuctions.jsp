<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'My Auctions', 'location': 'my-auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>


<h3>My Auctions</h3>

<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading ">
				<h4 class="noPaddingHeader">Status of my auctions</h4>
			</div>
			
				<table class="table table-striped table-hover table-responsive table-condensed">
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
</div>
<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-7">
		<div class="panel panel-default">
			<div class="panel-heading ">
				<h4 class="noPaddingHeader">My relevant auctions</h4>
			</div>

			<table class="table table-striped table-hover table-condensed table-responsive">
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

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-5">
		<div class="panel panel-default">
			<div class="panel-heading ">
				<h4 class="noPaddingHeader">My bid history</h4>
			</div>
			
				<table class="table table-hover table-striped table-responsive table-condensed">
					<tr>
						
						<th>bidCoins:</th>
						<th>Product:</th>
						<th>Date:</th>

					</tr>
					<s:iterator value="allBids">
						<s:include value="/includes/myListBidAuction.jsp" />
					</s:iterator>
				</table>
		
		</div>
	</div>

</div>

<s:push value="#{'progressTimers':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>