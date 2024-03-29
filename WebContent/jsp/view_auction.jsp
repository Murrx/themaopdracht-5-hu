<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auction Info', 'location': 'auctions', 'parent' : 'allAuctions', 'parentName' : 'Auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<!-- Css BugFix Modal Displacement OS X -->
<style type="text/css">
.modal-open,.modal-open .navbar-fixed-top {
	margin-right: auto !important;
}
</style>

<h2>
	<span class="headerPurple"><s:property value='auction.product.name' /></span>
</h2>
<!-- Container -->
<div class="row">
	<div class="col-sm-12 col-md-12 col-lg-8">
		<!-- leftContainer -->
		<div class="row">
			<!-- ImageContainer & AuthorContainer -->
			<div class="col-sm-12 col-md-6 col-lg-6">
				<!-- AUCTION IMAGE PANEL -->
				<div class="panel panel-default imgpreview" data-id="<s:property value='auction.auctionId'/>">
					<div class="panel-body individualAuctionImage">
						<a data-toggle="modal" data-target="#imgModal"><img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>"
							class="img-responsive"></a>
					</div>
				</div>
				<!-- END AUCTION IMAGE PANEL  -->
			</div>
			<!-- ImageColumn -->
			<div class="col-xs-12 col-md-6 col-lg-6">
				<!-- BEGIN AUTHOR PANEL -->

				<h4> Auction information: </h4>
				<span class="leftImportant">Owner:</span> <span class="rightInfo"> <s:url action="ViewMemberAction.action" namespace="/member" var="viewMember">
					<s:param name="userId">
						<s:property value="auction.owner.userId" />
					</s:param>
					</s:url> <s:a href="%{viewMember}">
						<s:property value='auction.owner.displayName' />
					</s:a>


				</span> <br /> 
				<span class="leftImportant">
					<span class="glyphicon glyphicon-arrow-up"></span> Bid:
				</span>
				<span class="rightInfo"> <s:property value="highestBid.bidAmount" /></span><br /> 
				<span class="leftImportant"> 
					<span class="glyphicon glyphicon-arrow-up"></span> Bidder:
				</span> 
				<span class="rightInfo"> 
					<s:url action="ViewMemberAction.action" namespace="/member" var="viewMember">
						<s:param name="userId">
							<s:property value="highestBid.user.userId" />
						</s:param>
					</s:url>
					<s:a href="%{viewMember}">
						<s:property value='highestBid.user.displayName' />
					</s:a>
				</span><br /> 
				<span class="leftImportant">End date:</span><span class="rightInfo"> <s:property value="endTimeDay" />/<s:property value="endTimeMonth" />/<s:property value="endTimeYear" /></span><br />
				<span class="leftImportant">Category:</span><span class="rightInfo"> <s:url action="AuctionsByCategory.action" namespace="/" var="filterAuction">
						<s:param name="category">
							<s:property value="auction.category" />
						</s:param>
					</s:url> <s:a href="%{filterAuction}">
						<s:property value='auction.category' />
					</s:a>

				</span>
			<div class="view-auction-tools">
				<s:if test="auction.status.rightsValue >= 5"> 
					<s:url action="placeBidAction.action" namespace="/member" var="urlTag">
						<s:param name="auctionId">
							<s:property value="auction.auctionId" />
						</s:param>
					</s:url>
					<s:a href="%{urlTag}" cssClass="btn btn-default btnColor">
						(<i class='fa fa-btc'></i><s:property value="nextBidAmount" />) Place new bid!
					</s:a>
				</s:if>
				<s:else>
					<button type="button" class="btn btn-default disabled">Bidding disabled</button>
				</s:else>
				<br />
				<s:if test="%{#session.user.rights.rightsValue >= 128}">
					<s:url action="delete_auction.action" namespace="moderator" var="urlTagDel" >
    					<s:param name="auctionId" value="auction.auctionId" />
					</s:url>
					<s:url action="block_auction.action" namespace="moderator" var="urlTagBlock" >
    					<s:param name="auctionId" value="auction.auctionId" />
					</s:url>
					<s:url action="unblock_auction.action" namespace="moderator" var="urlTagUnblock" >
    					<s:param name="auctionId" value="auction.auctionId" />
					</s:url>
					
					<div class="btn-group">
					  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
					  	Admin tools <span class="caret"></span>
					  </button>
					  <ul class="dropdown-menu" role="menu">
					  	<s:if test="%{auction.status.rightsValue != 0}">
					    	<li><a href="<s:property value='#urlTagBlock'/>"><i class="fa fa-lock"></i> Block Auction</a></li>
					    </s:if>
					    <s:else>
					    	<li><a href="<s:property value='#urlTagUnblock'/>"><i class="fa fa-unlock"></i> Unblock Auction</a></li>
					    </s:else>
					    <li><a href="<s:property value='#urlTagDel' />"><i class="fa fa-trash-o"></i> Delete Auction</a></li>
					  </ul>
					</div>
				</s:if>
				
			</div>
			</div>
			<!-- END AUTHOR PANEL -->
		</div>
		<div class="row singlepbar"
			data-id="<s:property value='auction.auctionId'/>" 
			data-start-year="<s:property value='auction.startTimeYear'/>" 
			data-start-month="<s:property value='auction.startTimeMonth'/>" 
			data-start-day="<s:property value='auction.startTimeDate'/>" 
			data-start-hour="<s:property value='auction.startTimeHours'/>" 
			data-start-min="<s:property value='auction.startTimeMinutes'/>" 
			data-end-year="<s:property value='auction.endTimeYear'/>" 
			data-end-month="<s:property value='auction.endTimeMonth'/>" 
			data-end-day="<s:property value='auction.endTimeDate'/>" 
			data-end-hour="<s:property value='auction.endTimeHours'/>" 
			data-end-min="<s:property value='auction.endTimeMinutes'/>"
		>
			<div class="col-sm-12">
				<div class="single progress <s:if test='%{percentage != 100}'>progress-striped active </s:if>text-center">
					<div id="pbar<s:property value='auction.auctionId'/>" class="progress-bar" role="progressbar" aria-valuenow="<s:property value='auction.percentage'/>" aria-valuemin="0" aria-valuemax="100"></div>
					<span class="progress-bar-label" id="timer<s:property value='auction.auctionId'/>"></span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<span class="headerPurple"><strong> Product description: </strong></span> <br />
				<br />
				<div class="well">
					<s:property value="auction.product.description" />
				</div>
			</div>
		</div>
	</div>


	<div class="col-sm-12 col-md-12 col-lg-4 ">
		<s:if test="%{auction.bids.isEmpty() != true}">
		
		<div class="panel panel-default">
			<div class="panel-heading ">
				<h4 class="noPaddingHeader">Bid history</h4>
			</div>
		<table class="table table-striped">
			<tr>
				<th>bidCoins</th>
				<th>Display name</th>
				<th>Date</th>
			</tr>
			<s:iterator value="bids.values()">
				<s:include value="/includes/listBidAuction.jsp" />
			</s:iterator>
		</table>
		</div>
		</s:if>
		<s:else>
		<h4>Bid history: </h4>  
		<div class="well">
			No bids have been placed on this auction yet!
		</div>
		</s:else>
	</div>
</div>

<div class="modal fade" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="imgModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="imgModalLabel">
					<s:property value='auction.product.name' />
				</h4>
			</div>
			<img src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg" alt="<s:property value='auction.product.name'/>" class="img-responsive imgModal">
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<s:push value="#{'progressTimersOneAuction':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>
