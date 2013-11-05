

<%@ taglib prefix="s" uri="/struts-tags"%>

<tr>
	<td><a
		href="viewAction.action?id=<s:property value='auctionId'/>"><s:property
				value='product.name' /></a></td>
	<td><s:property value="endTimeDate" />/<s:property value="endTimeMonth" />/<s:property value="endTimeYear" /> 
	<s:property value="endTimeHours" />:<s:property value="endTimeMinutes" /> 
	</td>

	<td><span class="label label-info"><i class='fa fa-btc'></i>
			<s:property value='startBid' /></span></td>
	<td><span class="label label-warning"><i class='fa fa-btc'></i>
			<s:property value='highestBid.bidAmount' /></span></td>
	
	<td><s:if test="%{status.rightsValue == 0}">
			<span class="label label-danger">Blocked</span>
		</s:if> <s:elseif test="%{status.rightsValue == 2}">
			<span class="label label-warning">Expired</span>
		</s:elseif> <s:elseif test="%{status.rightsValue == 5}">
			<span class="label label-success">Active</span>
		</s:elseif> <s:elseif test="%{status.rightsValue == 7}">
			<span class="label label-info">Special</span>
		</s:elseif> <s:else>
			<span class="label label-success">Unknown</span>
		</s:else></td>
</tr>

