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
		
		<!-- Countdown + percentage scripts -->
		<script src="includes/countdown.js" type="text/javascript"></script>	
		<script type="text/javascript">
			$(function(){
				<s:iterator value="allAuctions" >
					// Scripts for ID <s:property value='auctionId'/> - <s:property value='product.name'/>
					startDateAuction<s:property value='auctionId'/> = new Date(<s:property value='startTimeYear'/>,<s:property value='startTimeMonth'/>,<s:property value='startTimeDate'/>,<s:property value='startTimeHours'/>,<s:property value='startTimeMinutes'/>);
					endDateAuction<s:property value='auctionId'/> = new Date(<s:property value='endTimeYear'/>,<s:property value='endTimeMonth'/>,<s:property value='endTimeDate'/>,<s:property value='endTimeHours'/>,<s:property value='endTimeMinutes'/>);			
					GetCount(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "timer<s:property value='auctionId'/>");
					GetPercentage(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "percent<s:property value='auctionId'/>", "pbar<s:property value='auctionId'/>");
				</s:iterator>
			});
		</script>
		
		<!-- Date + DateTime picker scripts -->
		<script src="datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
   		<script src="datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
   		
   		<!-- Number Spinner -->
   		<!-- Source: http://www.virtuosoft.eu/code/bootstrap-touchspin/  -->
		<script src="includes/touchspin.js" type="text/javascript" ></script>
   		<script>
		    $("#amountSpin").TouchSpin({
		        min: 0,
		        max: 10000,
		        prefix: "<i class='fa fa-btc'></i>"
		    });
		</script>
   		
   		
		<script src="bootstrap/js/base.js" type="text/javascript"></script>
		
	</body>
</html>
