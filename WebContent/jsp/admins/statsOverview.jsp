<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'View stats','adminPanel': true ,'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<div class="row">

	<s:include value="/includes/adminMenu.jsp" />
	
	<div class="col-xs-12 col-sm-12 col-md-8">

	<h3>View stats:</h3>
		<div class="well">
			<div id="chart_div"></div>
		</div>

	</div>


</div>

<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-6">

		<h3>Stats:</h3>
		<div class="well">Here we'll display a graph or something.</div>
		<script type="text/javascript">
			function drawChart() {
				var data = google.visualization.arrayToDataTable([
					['Year', 'numBids'] ,
					<s:iterator value="allBids">		 	
						[<s:property value="key" />, <s:property value="value" />],
					</s:iterator>
				]);
				
				var options = {
					title: 'Company Performance',
					hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}
				};
				
				var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
				chart.draw(data, options);
			}
		</script>	
	</div>

</div>
<s:push value="#{'bidGraph': true}">
	<s:include value="/includes/footer.jsp" />
</s:push>