<%@ taglib prefix="s" uri="/struts-tags"%>



<a href="viewAction.action?id=<s:property value='auction.auctionId'/>" class="list-group-item"> 
	
	<s:property value='user.displayName' /> - <i class='fa fa-btc'></i> 
	<s:property value='bidAmount' /> :: 
	<em><s:property value="auction.endTimeDate" />/<s:property value="auction.endTimeMonth" />/<s:property value="auction.endTimeYear" /></em> -
	<s:property value='auction.product.name' />
</a>