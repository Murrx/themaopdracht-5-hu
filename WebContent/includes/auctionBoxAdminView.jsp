<%@ taglib prefix="s" uri="/struts-tags"%>

		<div class="col-xs-12 col-sm-12 col-md-6">
			<div class="auction panel panel-default" data-id="<s:property value='auctionId'/>">
	  			<div class="panel-body fullimage">
	  				<div class="auction-title-box text-center">
	  					<h3><s:property value='product.name'/></h3>
	  					
	  				</div>  			
			    	<img src="http://smartlapus.com/garbage/<s:property value='auctionId'/>.jpg"
			    		alt="<s:property value='product.name'/>"
			    		class="img-responsive">
	  			</div>	  			
			</div>
		</div>