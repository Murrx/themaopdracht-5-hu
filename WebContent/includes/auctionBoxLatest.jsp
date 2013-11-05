<%@ taglib prefix="s" uri="/struts-tags"%>
		<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
			<div class="auction panel panel-default auctionLatest" 
			data-id="<s:property value='auctionId'/>" 
			data-start-year="<s:property value='startTimeYear'/>" 
			data-start-month="<s:property value='startTimeMonth'/>" 
			data-start-day="<s:property value='startTimeDate'/>" 
			data-start-hour="<s:property value='startTimeHours'/>" 
			data-start-min="<s:property value='startTimeMinutes'/>" 
			data-end-year="<s:property value='endTimeYear'/>" 
			data-end-month="<s:property value='endTimeMonth'/>" 
			data-end-day="<s:property value='endTimeDate'/>" 
			data-end-hour="<s:property value='endTimeHours'/>" 
			data-end-min="<s:property value='endTimeMinutes'/>">
	  			<div class="panel-body fullimage">
	  				<div class="auction-title-box text-center">
	  					<h3><s:property value='product.name'/></h3>
	  				</div>  			
			    	<img src="http://smartlapus.com/garbage/<s:property value='auctionId'/>.jpg"
			    		alt="<s:property value='product.name'/>"
			    		class="img-responsive">
			    				 
		  			<div class="progress <s:if test='%{percentage != 100}'>progress-striped active </s:if>text-center">
	  					<div  class="progress-bar"  role="progressbar" aria-valuenow="<s:property value='percentage'/>" aria-valuemin="0" aria-valuemax="100"></div>
	  					<span class="progress-bar-label" id="timerLatest<s:property value='auctionId'/>"></span>
					</div>
	  			</div>
			</div>
		</div>