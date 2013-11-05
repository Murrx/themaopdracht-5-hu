<%@ taglib prefix="s" uri="/struts-tags"%>
		<div class="col-xs-12 col-sm-12 col-md-4">
			<div class="auction panel panel-default" 
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
	  					<div class="progress-bar" role="progressbar" aria-valuenow="<s:property value='percentage'/>" aria-valuemin="0" aria-valuemax="100"></div>
	  					<span class="progress-bar-label"></span>
					</div>
	  			</div>
	  			<s:if test="%{#session.user.rights.rightsValue >= 128}">
					<div class="panel-footer modpanel">
						<s:url action="delete_auction.action" namespace="moderator" var="urlTagDel" >
	    					<s:param name="auctionId"><s:property value='auctionId'/></s:param>
						</s:url>
						<s:url action="block_auction.action" namespace="moderator" var="urlTagBlock" >
	    					<s:param name="auctionId"><s:property value='auctionId'/></s:param>
						</s:url>
						<s:url action="unblock_auction.action" namespace="moderator" var="urlTagUnblock" >
	    					<s:param name="auctionId"><s:property value='auctionId'/></s:param>
						</s:url>
						
						<div class="btn-group">
						  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
						  	Admin tools <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu" role="menu">
						  	<s:if test="%{status.rightsValue != 0}">
						    	<li><a href="<s:property value='#urlTagBlock'/>"><i class="fa fa-lock"></i> Block Auction</a></li>
						    </s:if>
						    <s:else>
						    	<li><a href="<s:property value='#urlTagUnblock'/>"><i class="fa fa-unlock"></i> Unblock Auction</a></li>
						    </s:else>
						    <li><a href="<s:property value='#urlTagDel' />"><i class="fa fa-trash-o"></i> Delete Auction</a></li>
						  </ul>
						</div>
						
					</div>
				</s:if>
			</div>
		</div>