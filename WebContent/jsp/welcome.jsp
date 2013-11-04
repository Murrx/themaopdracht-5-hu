<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Welcome', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<!-- Preparing for "popular" auctions -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12">
		<div class="col-xs-12 col-sm-12 col-md-12">
			<h3 class="headerPurple">Popular auctions:</h3>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
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
		</div>
	</div>
</div>
<hr>

<!-- Preparing 2 latest auctions -->

<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading ">
					<h4 class="headerPurple noPaddingHeader">Recently added auctions:</h4>
				</div>
				
				<s:if test="latestAuctions != null">
					<s:iterator value="latestAuctions">
						<s:include value="/includes/auctionBoxLatest.jsp" />
					</s:iterator>
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
					<h4 class="headerPurple noPaddingHeader">Recent bids:</h4>
				</div>
				
				<s:if test="latestBids != null">
					<div class="table-responsive">
						<table class="table table-hover">
							<s:iterator value="latestBids">
								<s:include value="/includes/listBid.jsp" />
							</s:iterator>
						</table>
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
</div>

<hr>

<div class="row">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<div class="tutHeader">Start Auctifying in 4 simple steps!</div>

	</div>
	<div class="col-sm-12 col-md-6 col-lg-6">
		<div class="col-sm-12 col-md-12 col-lg-12 tutContainer">
			<span class="glyphicon glyphicon-edit tutImage"></span>
			<div class="tutText">
				<h4>1. Register a new account</h4>
				Register a new account <a href="<s:url action='registerForm' namespace='/' />">here</a> to start using Auctify.
			</div>
		</div>
		<br />
		<div class="col-sm-12 col-md-12 col-lg-12 tutContainer">
			<span class="glyphicon glyphicon-plus tutImage"></span>
			<div class="tutText">
				<h4>2. Buy BidCoins</h4>
				Auctify uses BidCoins. To bid on an auction you need BidCoins. Buy some BidCoins <a href="<s:url action='buyBidCoinsForm' namespace='/member' />">here</a>!
			</div>
		</div>
	</div>

	<div class="col-sm-12 col-md-6 col-lg-6">
		<div class="col-sm-12 col-md-12 col-lg-12 tutContainer">
			<span class="glyphicon glyphicon-search tutImage"></span>

			<div class="tutText">
				<h4>3. Look for an auction and bid on it!</h4>
				Either use the Search bar at the top of this page, or click Auctions to display all active auctions. After you've found an interesting auction, click on it and start bidding!
			</div>
		</div>
		<div class="col-sm-12 col-md-12 col-lg-12 tutContainer">
			<span class="glyphicon glyphicon-sort tutImage"></span>
			<div class="tutText">
				<h4>4. Remain the highest bidder</h4>
				If when the auction ends, you are still the highest bidder... You'll win the auction. So make sure to keep an eye out on the auctions you participate in!
			</div>
		</div>
	</div>
</div>

<s:push value="#{'progressTimersPopularAuctions':true, 'progressTimersLatestAuctions':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>