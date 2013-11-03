<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auction Info', 'location': 'auctions', 'parent' : 'allAuctions', 'parentName' : 'Auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<!-- Css BugFix Modal Displacement OS X -->
<style type="text/css">
.modal-open, .modal-open .navbar-fixed-top {
margin-right: auto !important;
}
</style>

 <h2><span class="headerPurple"><s:property value='auction.product.name' /></span></h2>


	<!-- Container -->

	<div class="col-sm-12 col-md-12 col-lg-8">
		<!-- leftContainer -->

		<div class="row">
			<!-- ImageContainer & AuthorContainer -->

			<div class="col-sm-12 col-md-12 col-lg-6">
				<!-- AUCTION IMAGE PANEL -->
				<div class="panel panel-default imgpreview" data-id="<s:property value='auction.auctionId'/>">
					<div class="panel-body individualAuctionImage">

						<a data-toggle="modal" data-target="#imgModal"><img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive"></a>

					</div>
					
					
				</div>
				<!-- END AUCTION IMAGE PANEL  -->

			</div>
			<!-- ImageColumn -->
			<div class="col-sm-12 col-md-12 col-lg-3">
				<!-- BEGIN AUTHOR PANEL -->
					
					
					
					
					<span class="headerPurple"><strong> Auction information: </strong></span><br /><br />
					
					
  						<span class="leftImportant">Owner:</span> <span class="rightInfo"> <s:property value="auction.owner.displayName" /> </span> <br />
  						<span class="leftImportant"> <span class="glyphicon glyphicon-arrow-up"></span> Bid:</span><span class="rightInfo"> <s:property value="highestBid.bidAmount" /></span><br />  					
  						<span class="leftImportant"> <span class="glyphicon glyphicon-arrow-up"></span> Bidder:</span>	<span class="rightInfo">	<s:property value="highestBid.user.displayName" /></span><br />
  						<span class="leftImportant"> End date:</span><span class="rightInfo">	<s:property value="endTimeDay" />/<s:property value="endTimeMonth" />/<s:property value="endTimeYear" /></span><br />
  						<span class="leftImportant"> Category: </span><span class="rightInfo">	<s:property value="auction.category" /></span>
							</div><br />
				<div class="col-sm-12 col-md-12 col-lg-3">
			
			<s:url action="placeBidAction.action" namespace="/member" var="urlTag">
				<s:param name="auctionId">
					<s:property value="%{#parameters.id}" />
				</s:param>
			</s:url>
			<s:a href="%{urlTag}" cssClass="btn btn-default btnColor"> (<i class='fa fa-btc'></i><s:property value="nextBidAmount" />) Place new bid! 
				
			</s:a>
			
			
			</div><br />
			<!-- END AUTHOR PANEL -->

		</div>


		<div class="row">
			<div class="progress <s:if test='%{percentage != 100}'>progress-striped active </s:if>text-center">
				<div id="pbar<s:property value='auction.auctionId'/>" class="progress-bar" role="progressbar" aria-valuenow="<s:property value='auction.percentage'/>" aria-valuemin="0" aria-valuemax="100"></div>
				<span class="progress-bar-label" id="timer<s:property value='auction.auctionId'/>"></span>

			</div>
			
			
			<br />

		</div>

		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<span class="headerPurple"><strong> Product description: </strong></span><br /><br />
					
						<div class="well">	<s:property value="auction.product.description" /></div>
						</div>


		</div>



	</div>

	<div class="col-sm-12 col-md-12 col-lg-4 ">
		 <span class="headerPurple"><strong> Bid history: </strong></span><br /><br />

			
			<table class="table table-striped">
			<tr>
				<th>bidCoins</th>
 				<th>Username</th>
  				<th>Date:</th>
  				
  			</tr>
			<s:iterator value="auction.bids">
					<s:include value="/includes/listBidAuction.jsp" />
				</s:iterator>
				</table>
	</div>

	<div class="modal fade" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="imgModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="imgModalLabel"><s:property value='auction.product.name'/></h4>
				</div>
				<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive imgModal">
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<s:push value="#{'progressTimersOneAuction':true}">
		<s:include value="/includes/footer.jsp" />
	</s:push>
