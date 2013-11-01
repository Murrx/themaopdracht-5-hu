<%@ taglib prefix="s" uri="/struts-tags"%>



<a href="viewAction.action?id=<s:property value='auction.auctionId'/>" class="list-group-item">


	<span class="listBid">
		<span class="label label-warning"><i class='fa fa-btc'></i><s:property value='bidAmount' /></span> 
	</span>
 
	<span class="listUser">
		<s:property value='user.displayName' />
	</span>
	
	<span class="listDate">		
		<s:property value="day" />/<s:property value="month" />/<s:property value="year" />
	</span>
	
	<span class="listName">
		<s:property value='auction.product.name' />
	</span>
	
</a>