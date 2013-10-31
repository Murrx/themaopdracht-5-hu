<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auction Info', 'location': 'auctions', 'parent' : 'allAuctions', 'parentName' : 'Auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>




	<h2>
		<s:property value='auction.product.name' />
	</h2>

	<div class="col-sm-12 col-md-8 col-lg-8">
		<!-- leftContainer -->

		<div class="row">
			<!-- ImageContainer & AuthorContainer -->

			<div class="col-sm-12 col-md-12 col-lg-6">
				<!-- AUCTION IMAGE PANEL -->
				<div class="panel panel-default" data-id="<s:property value='auction.auctionId'/>">
					<div class="panel-body individualAuctionImage">

						<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive">

					</div>
				</div>
				<!-- END AUCTION IMAGE PANEL  -->


			</div>
			<!-- ImageColumn -->
			<div class="col-sm-12 col-md-12 col-lg-6">
				<!-- BEGIN AUTHOR PANEL -->

				<div class="panel panel-default">

					<p>
						display name:
						<s:property value="auction.owner.displayName" />
					</p>
				</div>
			</div>
			<!-- END AUTHOR PANEL -->

		</div>


		<div class="row">
			<div class="progress <s:if test='%{percentage != 100}'>progress-striped active </s:if>text-center">
				<div id="pbar<s:property value='auction.auctionId'/>" class="progress-bar" role="progressbar" aria-valuenow="<s:property value='auction.percentage'/>" aria-valuemin="0" aria-valuemax="100"></div>
				<span class="progress-bar-label" id="timer<s:property value='auction.auctionId'/>"></span>

			</div>



		</div>

		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body fullimage">
						<p>
							start bid:
							<s:property value="auction.startBid" />
						</p>
						<br />

						<p>
							description:
							<s:property value="auction.product.description" />
						</p>
						<br />
						<p>
							status:
							<s:property value="auction.status" />
						</p>
						<p>
							category:
							<s:property value="auction.category" />
						</p>
						<p>
							user id:
							<s:property value="auction.owner.userId" />
						</p>



					</div>
				</div>

			</div>


		</div>



	</div>

	<div class="col-sm-12 col-md-4 col-lg-4 ">


		<div class="panel panel-default">



			<s:url action="placeBidAction.action" namespace="/member" var="urlTag">
				<s:param name="auctionId">
					<s:property value="%{#parameters.id}" />
				</s:param>
			</s:url>
			<s:a href="%{urlTag}" cssClass="btn btn-default">Place new bid! (<i class='fa fa-btc'></i>
				<s:property value="nextBidAmount" />
			</s:a>
			<br /> <br /> Bid History <br />

			<s:iterator value="auction.bids">

				<s:property value="bidAmount" />
				<s:property value="user.displayName" />
				<br />


			</s:iterator>

			Example:

			<ul>
				<li>31-10-2013 :: Admin,</li>

			</ul>
		</div>



	</div>












<s:push value="#{'progressTimersOneAuction':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>