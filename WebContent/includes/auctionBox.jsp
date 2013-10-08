<%@ taglib prefix="s" uri="/struts-tags"%>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<div class="auction panel panel-default">
	  			<div class="panel-body fullimage">
	  				<div class="auction-title-box text-center">
	  					<h3>Titel <s:property value='#stat.count'/></h3>
	  					<p>Hier komt een omschrijving van artikel <s:property value='#stat.count'/></p>
	  				</div>  			
			    	<img src="http://hhhhold.com/l?<s:property value='#stat.count'/>"
			    		alt="Auction name"
			    		class="img-responsive">
			    				 
		  			<div class="progress progress-striped active text-center">
	  					<div class="progress-bar"  role="progressbar" aria-valuenow="<s:property value="%{#stat.count * 4}" />" aria-valuemin="0" aria-valuemax="100" style="width: <s:property value="%{#stat.count * 4}" />%"></div>
	  					<span class="progress-bar-label" id="timer<s:property value='#stat.count'/>"></span>
					</div>
	  			</div>
			</div>
		</div>