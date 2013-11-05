<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'View stats','adminPanel': true ,'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<div class="row">

	<s:include value="/includes/adminMenu.jsp" />
	
	<div class="col-xs-12 col-sm-12 col-md-10">

	<h3>View stats:</h3>
		<script type="text/javascript">
			function drawChart() {
				var data = google.visualization.arrayToDataTable([
					['November', 'Bids', 'Auctions created', 'Auctions ended'] ,
					<s:iterator value="data">		 	
						['<s:property value="key" /> nov', <s:property value="value[0]" />, <s:property value="value[1]" />, <s:property value="value[2]" />],
					</s:iterator>
				]);
				
				var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
				chart.draw(data);
			}
		</script>
		<div class="chart-well well">
			<div id="chart_div"></div>
		</div>

	</div>


</div>

<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-12">

		<h3>Stats:</h3>
		<div class="well">Here we'll display a graph or something.</div>
	
	</div>

</div>
<s:push value="#{'bidGraph': true}">
	<s:include value="/includes/footer.jsp" />
</s:push>