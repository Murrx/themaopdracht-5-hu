<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>					
					</div>
				</div>
			</div>
		</div>
		</main>		
		<footer class="row">
			<div class="col-sm-12">
				<p>
					Auctified by Robin, Mark, Dimiter, Joris and Martin.
				</p>
			</div>
		</footer>
		<!--  Linking to latest JQuery and Bootstrap CDN  -->
		<script src="//code.jquery.com/jquery-latest.js" type="text/javascript"></script>		
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="bootstrap/js/countdown2.js" type="text/javascript"></script>
		<s:if test="bidGraph">
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<script type="text/javascript">
				google.load("visualization", "1", {packages:["corechart"]});
				google.setOnLoadCallback(drawChart);
			</script>
		</s:if>
		
		<s:if test="dateRangePicker">
			<script type="text/javascript" src="bootstrap/js/dateRangePicker/moment.min.js"></script>
			<script type="text/javascript" src="bootstrap/js/dateRangePicker/daterangepicker.js"></script>
		</s:if>
		<s:if test="rangePicker">
			<script type="text/javascript" src="bootstrap/js/nouislider/jquery.nouislider.min.js"></script>
		</s:if>
		<s:if test="dateTimePicker">
			<!-- Date + DateTime picker scripts -->
			<script src="bootstrap/js/datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
	   		<script src="bootstrap/js/datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
   		</s:if>

   		<s:if test="spinner">
	   		<!-- Number Spinner -->
	   		<!-- Source: http://www.virtuosoft.eu/code/bootstrap-touchspin/  -->
			<script src="bootstrap/js/touchspin.js" type="text/javascript" ></script>
	   		<script>
			    $("#amountSpin").TouchSpin({
			        min: 1,
			        max: 10000,
			        prefix: "<i class='fa fa-btc'></i>"
			    });
			    $("#amountSpin").change(function() {
			    	$("#price").html("€ "+($("#amountSpin").val()/10).toFixed(2).toString().replace(".", ","));
			    });
			</script>
   		</s:if>
   		
		<script src="bootstrap/js/base.js" type="text/javascript"></script>
		
	</body>
</html>
