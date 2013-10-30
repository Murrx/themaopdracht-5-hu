<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auction info', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
<div class="row">
	<div class="col-md-offset-3 col-sm-offset-2 col-md-6 col-sm-8">

		<h2>Auction info!</h2>


		<div class="row" id="oneAuction">
			<div class="col-xs-12 col-sm-6 col-md-4">
				<div class="panel panel-default"
					data-id="<s:property value='auction.auctionId'/>">
					<div class="panel-body fullimage">
						<div class="auction-title-box text-center">
							<h3>
								<s:property value='auction.product.name' />
							</h3>

							<p>
								<span id="percent<s:property value='auction.auctionId'/>">x</span>%
								complete
							</p>
						</div>
						<img
							src="http://smartlapus.com/garbage/<s:property value='auction.auctionId'/>.jpg"
							alt="<s:property value='auction.product.name'/>"
							class="img-responsive">
						<div
							class="progress <s:if test='%{percentage != 100}'>progress-striped active </s:if>text-center">
							<div id="pbar<s:property value='auction.auctionId'/>"
								class="progress-bar" role="progressbar"
								aria-valuenow="<s:property value='auction.percentage'/>"
								aria-valuemin="0" aria-valuemax="100"></div>
							<span class="progress-bar-label"
								id="timer<s:property value='auction.auctionId'/>"></span>
						</div>
					</div>
				</div>
			</div>
		</div>


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
			<s:property value="auction.userId" />
		</p>
		
		<p>
			display name:
			<s:property value="auction.owner.displayName" />
		</p>

	</div>
</div>

<s:push value="#{'progressTimersOneAuction':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>
