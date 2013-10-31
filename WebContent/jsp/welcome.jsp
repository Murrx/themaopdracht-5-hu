<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Welcome', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<!-- Preparing for "random" auctions -->


<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12">
		<div class="col-xs-12 col-sm-12 col-md-12">
			<h3 class="headerPurple">Popular Auctions:</h3>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div class="col-xs-12 col-sm-6 col-md-4">
					<div class="panel panel-default" data-id="<s:property value='auction.auctionId'/>">
						<div class="panel-body individualAuctionImage">
							<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive">
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-4">
					<div class="panel panel-default" data-id="<s:property value='auction.auctionId'/>">
						<div class="panel-body individualAuctionImage">
							<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive">
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-4">
					<div class="panel panel-default" data-id="<s:property value='auction.auctionId'/>">
						<div class="panel-body individualAuctionImage">
							<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Preparing for 5 most recent bids -->

<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
			<h3 class="headerPurple">Newest auction:</h3>
			<div class="col-xs-12 col-sm-6 col-md-6">
				<div class="panel panel-default" data-id="<s:property value='auction.auctionId'/>">
					<div class="panel-body individualAuctionImage">
						<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive">
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-6">
				<div class="panel panel-default" data-id="<s:property value='auction.auctionId'/>">
					<div class="panel-body individualAuctionImage">
						<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive">
					</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
			<h3 class="headerPurple">Most recent bids:</h3>

			<!-- Example -->

			<div class="list-group">
				<a href="#" class="list-group-item">Admin -  <i class='fa fa-btc'></i> 50 <em>31-10-2013</em> - Supper lekker broodje</a>
				<a href="#" class="list-group-item">Admin -  <i class='fa fa-btc'></i> 50 <em>31-10-2013</em> - Supper lekker broodje</a>
				<a href="#" class="list-group-item">Admin -  <i class='fa fa-btc'></i> 50 <em>31-10-2013</em> - Supper lekker broodje</a>
				<a href="#" class="list-group-item">Admin -  <i class='fa fa-btc'></i> 50 <em>31-10-2013</em> - Supper lekker broodje</a>
				
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
				Auctify uses BidCoins. To bid on an auction you need BidCoins, more information here!
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


<s:include value="/includes/footer.jsp" />