<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push
	value="#{'title':'View stats','adminPanel': true ,'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<div class="row">

	<s:include value="/includes/adminMenu.jsp" />

	<div class="col-xs-12 col-sm-12 col-md-10">

		<h3>Bid history</h3>
		<div class="chart-well well">
			<div id="bid-chart"></div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-2">
		<h3>Highest bid</h3>
		<div class="chart-well well">
			<div id="high-bid-chart"></div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-2">
		<h3>Auction history</h3>
		<div class="chart-well well">
			<div id="auction-chart"></div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-2">
		<h3>Most popular Auction</h3>
		<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="auction panel panel-default" data-id="<s:property value='popularAuction.auctionId'/>">
	  			<div class="panel-body fullimage">
	  				<div class="auction-title-box text-center">
	  					<h3><s:property value='popularAuction.product.name'/></h3>
	  					
	  					
	  				</div>  			
			    	<img src="http://smartlapus.com/garbage/<s:property value='popularAuction.auctionId'/>.jpg"
			    		alt="<s:property value='popularAuction.product.name'/>"
			    		class="img-responsive">
	  			</div>
			</div>
		</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function drawChart() {
		var options = {
			legend: {position: 'in'},
			chartArea: {height: 200, width: 1900, left: 100, top: 25},
			width: 2000,
			height: 300
		};
		var auctionData = google.visualization.arrayToDataTable([
				[ 'November', 'Auctions created', 'Auctions ended' ],
				<s:iterator value="data">['<s:property value="key" /> nov',
				<s:property value="value[1]" />,
				<s:property value="value[2]" />], </s:iterator> ]);
		var bidData = google.visualization.arrayToDataTable([
				[ 'November', 'Bids' ],
				<s:iterator value="data">['<s:property value="key" /> nov',
				<s:property value="value[0]" />], </s:iterator> ]);
		var highBidData = google.visualization.arrayToDataTable([[ 'November', 'Highest bid' ],
				<s:iterator value="data">['<s:property value="key" /> nov',
				<s:property value="value[3]" />], </s:iterator> ]);

		
		var auctionChart = new google.visualization.ColumnChart(document
				.getElementById('auction-chart'));
		var bidChart = new google.visualization.ColumnChart(document
				.getElementById('bid-chart'));
		var highBidChart = new google.visualization.ColumnChart(document
				.getElementById('high-bid-chart'));
		
		auctionChart.draw(auctionData, options);
		bidChart.draw(bidData, options);
		highBidChart.draw(highBidData, options);
	}
</script>
<s:push value="#{'bidGraph': true}">
	<s:include value="/includes/footer.jsp" />
</s:push>