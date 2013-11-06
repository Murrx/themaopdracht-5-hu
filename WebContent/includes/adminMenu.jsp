<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-xs-12 col-sm-4 col-md-2 admin-menu">

		<div class="list-group">
			<a href="<s:url action='ViewAdminPanel' namespace='/admin'/>" class="list-group-item active"> Options: </a> 
			<a href="<s:url action='ViewMembersAction' namespace='/admin'/>" class="list-group-item">Manage Members</a> 
			<a href="<s:url action='ManageAuctionsAction' namespace='/admin'/>" class="list-group-item">Manage Auctions</a> 
			<a href="#"	class="list-group-item disabled">Financial Overview</a> 
			<a href="<s:url action='ViewStatsAction' namespace='/admin'/>" class="list-group-item">Statistics</a>
		</div>
	</div>