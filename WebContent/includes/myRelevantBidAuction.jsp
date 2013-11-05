

<%@ taglib prefix="s" uri="/struts-tags"%>

<tr>
	<td><a
		href="viewAction.action?id=<s:property value='auction.auctionId'/>"><s:property
				value='auction.product.name' /></a></td>
	<td><s:property value="day" />/<s:property value="month" />/<s:property
			value="year" /></td>

	<td><span class="label label-warning"><i class='fa fa-btc'></i>
			<s:property value='bidAmount' /></span></td>
	<td><s:if test="%{bidStatus.StatusValue == 2}">
			<span class="label label-danger">Lost</span>
		</s:if> <s:elseif test="%{bidStatus.StatusValue == 1}">
			<span class="label label-warning">Losing</span>
		</s:elseif> <s:elseif test="%{bidStatus.StatusValue == 0}">
			<span class="label label-info">Winning</span>
		</s:elseif> <s:elseif test="%{bidStatus.StatusValue == 3}">
			<span class="label label-info">Won</span>
		</s:elseif> <s:else>
			<span class="label label-success">Unknown</span>
		</s:else></td>
</tr>

