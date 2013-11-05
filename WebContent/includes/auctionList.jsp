<%@ taglib prefix="s" uri="/struts-tags"%>

<tr>
	<td><s:if test="%{status.rightsValue >= 7}">
			<span class="label label-warning">Special</span>
		</s:if>
		<s:elseif test="%{status.rightsValue >= 5}">
			<s:url action="block_auction.action" namespace="moderator" var="urlTagBlock" >
  				<s:param name="auctionId"><s:property value='auctionId'/></s:param>
			</s:url>
			<a href="<s:property value='#urlTagBlock'/>"><span class="label label-success">Active</span></a>
		</s:elseif>
		<s:elseif test="%{status.rightsValue >= 2}">
			<span class="label label-danger">Expired</span>
		</s:elseif>
		<s:elseif test="%{status.rightsValue >= 1}">
			<span class="label label-info">Users Notified</span>
		</s:elseif>
		<s:else>
			<s:url action="unblock_auction.action" namespace="moderator" var="urlTagUnblock" >
  				<s:param name="auctionId"><s:property value='auctionId'/></s:param>
			</s:url>
			<a href="<s:property value='#urlTagUnblock'/>"><span class="label label-default">Blocked</span></a>
		</s:else>
	</td>

	<td>
		<s:url action="viewAction.action" var="viewAuction" namespace="/">
			<s:param name="id"><s:property value="auctionId" /></s:param>
		</s:url>
		<s:a href="%{viewAuction}"><s:property value="product.name" /></s:a>
	</td>
	<td><s:property value='startTime.time' /></td>
	<td><s:property value='endTime.time' /></td>
	<td><s:property value='percentage' />%</td>
	<td><i class='fa fa-btc'><s:property value='startBid' /></td>
	
	<td><s:url action="ViewMemberAction.action" var="viewMember">
			<s:param name="userId"><s:property value="owner.userId" /></s:param>
		</s:url>
		<s:a href="%{viewMember}"><s:property value="owner.displayName" /></s:a>
	</td>
</tr>

