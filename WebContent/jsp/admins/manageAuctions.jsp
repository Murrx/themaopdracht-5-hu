<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Manage Auctions', 'adminPanel': true ,'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<div class="row">
	<s:include value="/includes/adminMenu.jsp" />

	<div class="col-xs-12 col-sm-12 col-md-8">

		<h3>Manage Auctions</h3>

		<div class="table-responsive table-condensed">
			<table class="table table-hover">
				<tr>
					<th>Status</th>
					<th>Name</th>
					<th>Start date</th>
					<th>End date</th>
					<th>Completion</th>
					<th>Start bid</th>
					<th>Owner</th>
				</tr>
				<s:iterator value="allAuctions">
					<s:include value="/includes/auctionList.jsp" />
				</s:iterator>
			</table>
		</div>
			
	</div>
</div>


<s:include value="/includes/footer.jsp" />
