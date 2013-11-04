<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Admin Panel', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>


<h3>Admin Panel:</h3>
<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-2">

		<div class="list-group">
			<a href="#" class="list-group-item active"> Options: </a> <a href="#" class="list-group-item">Manage Members</a> <a href="#" class="list-group-item">Manage Auctions</a> <a href="#"
				class="list-group-item">Financial Overview</a> <a href="#" class="list-group-item">Statistics</a>
		</div>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-8">

	
		<div class="well">
			Welcome to your awesome admin panel.<br /> 
			Here you manage your website.
		</div>

	</div>


</div>

<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-6">

		<h3>Amount bids:</h3>
		<div class="well">Here we'll display a graph or something.</div>

	</div>

</div>


<s:include value="/includes/footer.jsp" />