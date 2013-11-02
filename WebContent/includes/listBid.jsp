<%@ taglib prefix="s" uri="/struts-tags"%>

<tr>
<td><span class="label label-warning"><i class='fa fa-btc'></i> <s:property value='bidAmount' /></span> </td>
<td><s:property value='user.displayName' /></td>
<td><s:property value="day" />/<s:property value="month" />/<s:property value="year" /></td>
<td><a href="viewAction.action?id=<s:property value='auction.auctionId'/>"><s:property value='auction.product.name' /></a></td>
</tr>

