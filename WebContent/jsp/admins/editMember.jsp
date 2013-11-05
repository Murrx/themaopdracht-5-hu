<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Edit member','adminPanel': true ,'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<div class="row">
	<s:include value="/includes/adminMenu.jsp" />
	<div class="col-xs-12 col-sm-8 col-md-5">
		<h3>Manage Member:</h3>

		<s:if test="%{user.rights.rightsValue >= 256}">
			<button type="button" class="btn btn-danger disabled">Admin can't be blocked</button>
		</s:if>
		<s:elseif test="%{user.rights.rightsValue < 5}">
			<button type="button" class="btn btn-success">Unblock user</button>
		</s:elseif>
		<s:else>
			<s:url action="BlockMemberAction.action" var="blockUser">
				<s:param name="userId">
					<s:property value="userId" />
				</s:param>
			</s:url>
			<s:a href="%{blockUser}"><button type="button" class="btn btn-danger">Block user</button>
			</s:a>
		</s:else>

		<h3>Member information:</h3>
		<table class="table table-striped table-bordered">
			<tr class="adminView">
				<!-- BASIC USER INFORMATION -->
				<th>Basic user information</th>
				<td></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><s:property value='user.email' /></td>
			</tr>
			<tr>
				<td>Display name:</td>
				<td><s:property value='user.displayName' /></td>
			</tr>
			<tr>
				<td>Right:</td>
				<td><s:if test="%{user.rights.rightsValue >= 256}">
						<span class="label label-danger"><s:property value='user.rights' /></span>
					</s:if> <s:else>
						<span class="label label-success"><s:property value='user.rights' /></span>
					</s:else></td>
			</tr>
			<tr>
				<td>BidCoins:</td>
				<td><s:property value='user.bidCoins' /></td>
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
				<td>Last name:</td>
				<td><s:property value='user.person.lastName' /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><s:property value='user.person.gender' /></td>
			</tr>
			<tr>
				<td>Birth date:</td>
				<td><s:property value='user.person.birthdate' /></td>
			</tr>
			<tr>
				<!-- ADDRESS INFORMATION -->
				<th>Address Information</th>
				<td></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><s:property value='user.address.street' /></td>
			</tr>
			<tr>
				<td>House number:</td>
				<td><s:property value='user.address.houseNumber' /></td>
			</tr>
			<tr>
				<td>Postal code:</td>
				<td><s:property value='user.address.postalCode' /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><s:property value='user.address.city' /></td>
			</tr>

		</table>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5">
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
	<div class="col-xs-12 col-sm-5 col-md-5">
		<h3>Member bids:</h3>

		<s:if test="%{user.myBids.isEmpty() != true}">
			<table class="table table-striped table-bordered ">
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
<s:include value="/includes/footer.jsp" />