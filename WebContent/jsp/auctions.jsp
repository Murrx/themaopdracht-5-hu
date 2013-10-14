<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auctions', 'location': 'auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1>All Auctions</h1>

<script type="text/javascript">
	$(function(){
		<s:iterator value="allAuctions" >
			startDateAuction<s:property value='auctionId'/> = new Date(<s:property value='startTimeYear'/>,<s:property value='startTimeMonth'/>,<s:property value='startTimeDate'/>);
			endDateAuction<s:property value='auctionId'/> = new Date(<s:property value='endTimeYear'/>,<s:property value='endTimeMonth'/>,<s:property value='endTimeDate'/>);			
			GetCount(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "timer<s:property value='auctionId'/>");
			GetPercentage(startDateAuction<s:property value='auctionId'/>, endDateAuction<s:property value='auctionId'/>, "percent<s:property value='auctionId'/>", "pbar<s:property value='auctionId'/>");
		</s:iterator>

	});
</script>
<div class="row" id="allAuctions">
	<s:iterator value="allAuctions"  >
		<s:include value="/includes/auctionBox.jsp" />
	</s:iterator>
</div>

<s:include value="/includes/footer.jsp" />
