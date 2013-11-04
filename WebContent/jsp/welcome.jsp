<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Welcome', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<!-- Preparing for "popular" auctions -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12">
		<h3>Popular auctions:</h3>
	</div>
</div>
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12">
		<div class="row">
			<s:if test="popularAuctions != null">
				<s:iterator value="popularAuctions">
					<s:include value="/includes/auctionBox.jsp" />
				</s:iterator>
			</s:if>
			<s:else>
				<div class="text-center">
					<span>There are no popular auctions. <a href="<s:url action='addAuctionForm' namespace='/member'/>">Create one!</a></span>
				</div>
			</s:else>
		</div>
		<hr>
	</div>
</div>

<!-- Preparing 2 latest auctions -->

<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading ">
				<h4 class="noPaddingHeader">Recently added auctions:</h4>
			</div>
			<s:if test="latestAuctions != null">
				<div class="panel-body">
					<s:iterator value="latestAuctions">
						<s:include value="/includes/auctionBoxLatest.jsp" />
					</s:iterator>
				</div>
			</s:if>
			<s:else>
				<div class="panel-body text-center">
					<span>There are no new auctions. <a href="<s:url action='addAuctionForm' namespace='/member'/>">Create one!</a></span>
				</div>
			</s:else>
		</div>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
		<!-- Example -->
		<div class="panel panel-default">
			<div class="panel-heading ">
				<h4 class="noPaddingHeader">Recent bids:</h4>
			</div>
			<s:if test="latestBids.size > 0">
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-hover">
							<s:iterator value="latestBids">
								<s:include value="/includes/listBid.jsp" />
							</s:iterator>
						</table>
					</div>
				</div>
			</s:if>
			<s:else>
				<div class="panel-body text-center">
					<span>There are no bids placed recently. <a href="<s:url action='allAuctions' />">Select an auction</a> and start bidding!</span>
				</div>
			</s:else>
		</div>
	</div>
</div>

<hr>

<div class="row">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<h4>Start Auctifying in 4 simple steps!</h4>
	</div>
	<div class="col-sm-12 col-md-6 col-lg-6 tutContainer">
		<span class="glyphicon glyphicon-edit tutImage"></span>
		<h4>1. Register a new account</h4>
		Register a new account <a href="<s:url action='registerForm' namespace='/' />">here</a> to start using Auctify.
	</div>
	<div class="col-sm-12 col-md-6 col-lg-6 tutContainer">
		<span class="glyphicon glyphicon-plus tutImage"></span>
		<h4>2. Buy BidCoins</h4>
		Auctify uses BidCoins. To bid on an auction you need BidCoins. Buy some BidCoins <a href="<s:url action='buyBidCoinsForm' namespace='/member' />">here</a>!
	</div>
	<div class="col-sm-12 col-md-6 col-lg-6 tutContainer">
		<span class="glyphicon glyphicon-search tutImage"></span>
		<h4>3. Look for an auction and bid on it!</h4>
		Either use the Search bar at the top of this page, or click Auctions to display all active auctions. After you've found an interesting auction, click on it and start bidding!
	</div>
	<div class="col-sm-12 col-md-6 col-lg-6 tutContainer">
		<span class="glyphicon glyphicon-sort tutImage"></span>
		<h4>4. Remain the highest bidder</h4>
		If when the auction ends, you are still the highest bidder... You'll win the auction. So make sure to keep an eye out on the auctions you participate in!
	</div>
</div>

<s:push value="#{'progressTimersPopularAuctions':true, 'progressTimersLatestAuctions':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>