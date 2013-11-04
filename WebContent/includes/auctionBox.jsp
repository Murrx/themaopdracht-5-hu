<%@ taglib prefix="s" uri="/struts-tags"%>

		<div class="col-xs-12 col-sm-12 col-md-4">
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
	  			<s:if test="%{#session.user.rights.rightsValue >= 128}">
					<div class="panel-footer modpanel">
					
						<div class="btn-group">
						  <button type="button" class="btn btn-danger">Action</button>
						  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
						    <span class="caret"></span>
						    <span class="sr-only">Toggle Dropdown</span>
						  </button>
						  <ul class="dropdown-menu" role="menu">
						    <li><a href="#">Action</a></li>
						    <li><a href="#">Another action</a></li>
						    <li><a href="#">Something else here</a></li>
						    <li class="divider"></li>
						    <li><a href="#">Separated link</a></li>
						  </ul>
						</div>
					
						<s:url action="delete_auction.action" namespace="moderator" var="urlTag" >
	    					<s:param name="auctionId"><s:property value='auctionId'/></s:param>
						</s:url>
						<a href="<s:property value="#urlTag" />" type="button" class="btn btn-danger pull-right"><span class="glyphicon glyphicon-trash"></span></a>
					</div>
				</s:if>	
	  			
			</div>
		</div>