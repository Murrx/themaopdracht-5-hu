<%@ taglib prefix="s" uri="/struts-tags"%>
					<div class="row">
						<nav class="col-sm-12">
							<!-- Navigation -->
							<ul class="nav nav-tabs">
								<li <s:if test='location == "home"'>class="active"</s:if>><a href="<s:url action='welcome' namespace="/"/>">Home</a></li>
								<li <s:if test='location == "auctions"'>class="active"</s:if>><a href="<s:url action='allAuctions' namespace="/"/>">Auctions</a></li>
								<li <s:if test='location == "mass-auctions"'>class="active"</s:if>><a href="#">Mass Auctions</a></li>
								<li <s:if test='location == "create-new-auction"'>class="active"</s:if>><a href="<s:url action='addAuctionForm' namespace="/member"/>">Create New Auction</a></li>
								<li <s:if test='location == "buy-bidcoins"'>class="active"</s:if>><a href="<s:url action='buyBidCoinsForm' namespace="/member"/>">Buy BidCoins</a></li>
								<li <s:if test='location == "edit-profile"'>class="active"</s:if>><a href="<s:url action='editProfileForm' namespace="/member"/>">Edit profile</a></li>
							</ul>
						</nav>
					</div>