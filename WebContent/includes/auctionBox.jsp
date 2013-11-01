<%@ taglib prefix="s" uri="/struts-tags"%>

		<div class="col-xs-12 col-sm-6 col-md-4">
			<button type="button" class="btn btn-danger pull-right"><span class="glyphicon glyphicon-trash"></span></button>
			<div class="auction panel panel-default" data-id="<s:property value='auctionId'/>">
	  			<div class="panel-body fullimage">
	  				<div class="auction-title-box text-center">
	  					<h3><s:property value='product.name'/></h3>
	  					
	  					<p><span id="percent<s:property value='auctionId'/>">0</span>% complete</p>
	  				</div>  			
			    	<img src="http://smartlapus.com/garbage/<s:property value='auctionId'/>.jpg"
			    		alt="<s:property value='product.name'/>"
			    		class="img-responsive">
			    				 
		  			<div class="progress <s:if test='%{percentage != 100}'>progress-striped active </s:if>text-center">
	  					<div id="pbar<s:property value='auctionId'/>" class="progress-bar"  role="progressbar" aria-valuenow="<s:property value='percentage'/>" aria-valuemin="0" aria-valuemax="100"></div>
	  					<span class="progress-bar-label" id="timer<s:property value='auctionId'/>"></span>
					</div>
	  			</div>
			</div>
		</div>