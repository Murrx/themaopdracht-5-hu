<%@ taglib prefix="s" uri="/struts-tags"%>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<div class="auction panel panel-default">
	  			<div class="panel-body fullimage">
	  				<div class="auction-title-box text-center">
	  					<h3><s:property value='product.name'/></h3>
	  					<p><s:property value='product.description'/></p>
	  				</div>  			
			    	<img src="http://hhhhold.com/l/w/"
			    		alt="<s:property value='product.name'/>"
			    		class="img-responsive">
			    				 
		  			<div class="progress progress-striped active text-center">
	  					<div class="progress-bar"  role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%"></div>
	  					<span class="progress-bar-label" id="timer<s:property value='auctionId'/>"></span>
					</div>
	  			</div>
			</div>
		</div>