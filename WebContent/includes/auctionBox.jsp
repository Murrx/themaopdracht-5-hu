<%@ taglib prefix="s" uri="/struts-tags"%>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading text-center">
	    			<h3 class="panel-title">Panel <s:property value="#stat.count" /></h3>
	  			</div>
	  			<div class="panel-body">
	  				<div class="row">
	  					<div class="col-xs-4">
			    			<img src="http://style-matters.com/blog/wp-content/uploads/2011/10/auction.jpg"
			    				 alt="Auction name"
			    				 class="img-rounded img-responsive">
			    		</div>
			    		<div class="col-xs-8">	
			    			Panel <s:property value="#stat.count" /> content<br />	
			    		</div>
		    		</div>
	  			</div>
	  			<div class="panel-footer text-center">
		  			<p class="text-left">Left aligned text.</p>
		  			<div class="progress progress-striped active">
	  					<div class="progress-bar"  role="progressbar" aria-valuenow="<s:property value="%{#stat.count * 4}" />" aria-valuemin="0" aria-valuemax="100" style="width: <s:property value="%{#stat.count * 4}" />%">
	    					<span class="sr-only"><s:property value="%{#stat.count * 4}" />% Complete</span>
	  					</div>	
	  					<span class="progress-bar-label"><s:property value="%{#stat.count * 4}" />% complete</span>
					</div>
	  			</div>
			</div>
		</div>