<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'View member', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<s:if test="%{#session.user.rights.rightsValue >= 256}">
	
	<br />
	<s:url action="ViewMemberAction.action" namespace="/admin" var="viewMember">
		<s:param name="userId">
			<s:property value="userId" />
		</s:param>
	</s:url>
	<s:a href="%{viewMember}">
		<button type="button" class="btn btn-danger">Admin: view member</button>
	</s:a>


</s:if>

<h3>
	View Member: "
	<s:property value='user.displayName' />
	"

</h3>

<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-4">


		<table class="table table-striped table-bordered">
			<tr class="adminView">
				<h4>Member information:</h4>
				<!-- BASIC USER INFORMATION -->
				<th>Basic user information</th>
				<td></td>
			</tr>
			<tr>
				<td>Display name:</td>
				<td><s:property value='user.displayName' /></td>
			</tr>
			<tr>
				<td>Right:</td>
				<td><s:if test="%{user.rights.rightsValue >= 256}">
						<span class="label label-danger"><s:property value='user.rights' /></span>
					</s:if> <s:elseif test="%{user.rights.rightsValue < 5}">
						<span class="label label-default"><s:property value='user.rights' /></span>
					</s:elseif> <s:else>
						<span class="label label-success"><s:property value='user.rights' /></span>
					</s:else></td>
			</tr>
			<tr>
				<!-- PERSONAL INFORMATION -->
				<th>Personal information</th>
				<td></td>
			</tr>
			<tr>
				<td>First name:</td>
				<td><s:property value='user.person.firstName' /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><s:if test="%{user.person.gender == 1}">
						<i class="fa fa-male"></i>
					</s:if> <s:else>
						<i class="fa fa-female"></i>
					</s:else></td>
			</tr>
			<tr>
				<!-- ADDRESS INFORMATION -->
				<th>Address Information</th>
				<td></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><s:property value='user.address.city' /></td>
			</tr>

		</table>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-6">

		<h4>Bidding history:</h4>
		<s:if test="%{user.myBids.isEmpty() != true}">
			<table class="table table-striped table-bordered ">
				<tr>
					<th>BidCoins:</th>
					<th>Product:</th>
					<th>Date:</th>
				</tr>
				<s:iterator value="user.myBids.values()">
					<s:include value="/includes/myListBidAuction.jsp" />
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div class="well">The user didn't place any bids yet.</div>
		</s:else>
	</div>
</div>
<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-10">
		<h3>Member auctions:</h3>
		<div class="well">
			<s:if test="%{user.myAuctions.isEmpty() != true}">
				<div class="panel-body">
					<s:iterator value="user.myAuctions.values()">
						<s:include value="/includes/auctionBoxAdminView.jsp" />
					</s:iterator>
				</div>
			</s:if>
			<s:else>
					The user didn't place any auctions yet.
				</s:else>
		</div>
	</div>

</div>


<s:include value="/includes/footer.jsp" />
