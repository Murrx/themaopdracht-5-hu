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
		
		<s:if test="progressTimers">
			<!-- Countdown + percentage scripts -->
			<script src="bootstrap/js/countdown2.js" type="text/javascript"></script>
			
			<script type="text/javascript">
				$(function(){
					<s:iterator value="allAuctions" >
						// Dates for auction <s:property value='auctionId'/> - <s:property value='product.name'/>
						startDateAuction<s:property value='auctionId'/> = new Date(<s:property value='startTimeYear'/>,<s:property value='startTimeMonth'/>,<s:property value='startTimeDate'/>,<s:property value='startTimeHours'/>,<s:property value='startTimeMinutes'/>);
						endDateAuction<s:property value='auctionId'/> = new Date(<s:property value='endTimeYear'/>,<s:property value='endTimeMonth'/>,<s:property value='endTimeDate'/>,<s:property value='endTimeHours'/>,<s:property value='endTimeMinutes'/>);			
					</s:iterator>
					
				});
				
				function update() {
					requestAnimationFrame(update);
					<s:iterator value="allAuctions" >
						updateGUI(<s:property value='auctionId'/>);
					</s:iterator>
				}
				requestAnimationFrame(update);

			</script>
		</s:if>
		
		<s:if test="progressTimersPopularAuctions">
			<!-- Countdown + percentage scripts -->
			<script src="bootstrap/js/countdown.js" type="text/javascript"></script>	
			<script type="text/javascript">
				$(function(){
					<s:iterator value="popularAuctions" >
						// Scripts for ID <s:property value='auctionId'/> - <s:property value='product.name'/>
						startDateAuction<s:property value='auctionId'/> = new Date(<s:property value='startTimeYear'/>,<s:property value='startTimeMonth'/>,<s:property value='startTimeDate'/>,<s:property value='startTimeHours'/>,<s:property value='startTimeMinutes'/>);
						endDateAuction<s:property value='auctionId'/> = new Date(<s:property value='endTimeYear'/>,<s:property value='endTimeMonth'/>,<s:property value='endTimeDate'/>,<s:property value='endTimeHours'/>,<s:property value='endTimeMinutes'/>);			
						GetCount(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "timer<s:property value='auctionId'/>");
						GetPercentage(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "percent<s:property value='auctionId'/>", "pbar<s:property value='auctionId'/>");
					</s:iterator>
				});
			</script>
		</s:if>
		
		<s:if test="progressTimersLatestAuctions">
			<!-- Countdown + percentage scripts -->
			<script src="bootstrap/js/countdown.js" type="text/javascript"></script>	
			<script type="text/javascript">
				$(function(){
					<s:iterator value="latestAuctions" >
						// Scripts for ID <s:property value='auctionId'/> - <s:property value='product.name'/>
						startDateAuction<s:property value='auctionId'/> = new Date(<s:property value='startTimeYear'/>,<s:property value='startTimeMonth'/>,<s:property value='startTimeDate'/>,<s:property value='startTimeHours'/>,<s:property value='startTimeMinutes'/>);
						endDateAuction<s:property value='auctionId'/> = new Date(<s:property value='endTimeYear'/>,<s:property value='endTimeMonth'/>,<s:property value='endTimeDate'/>,<s:property value='endTimeHours'/>,<s:property value='endTimeMinutes'/>);			
						GetCount(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "timerLatest<s:property value='auctionId'/>");
						GetPercentage(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "percentLatest<s:property value='auctionId'/>", "pbarLatest<s:property value='auctionId'/>");
					</s:iterator>
				});
			</script>
		</s:if>
		
		<s:if test="progressTimersOneAuction">
			<!-- Countdown + percentage scripts -->
			<script src="bootstrap/js/countdown2.js" type="text/javascript"></script>	
			<script type="text/javascript">
				$(function(){
					// Dates for auction <s:property value='auctionId'/> - <s:property value='product.name'/>
					startDateAuction<s:property value='auction.auctionId'/> = new Date(<s:property value='auction.startTimeYear'/>,<s:property value='auction.startTimeMonth'/>,<s:property value='auction.startTimeDate'/>,<s:property value='auction.startTimeHours'/>,<s:property value='auction.startTimeMinutes'/>);
					endDateAuction<s:property value='auction.auctionId'/> = new Date(<s:property value='auction.endTimeYear'/>,<s:property value='auction.endTimeMonth'/>,<s:property value='auction.endTimeDate'/>,<s:property value='auction.endTimeHours'/>,<s:property value='auction.endTimeMinutes'/>);			
				});
				
				function update() {
					requestAnimationFrame(update);
					updateGUI(<s:property value='auction.auctionId'/>);
				}
				requestAnimationFrame(update);
			</script>
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
