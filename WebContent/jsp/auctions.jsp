<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auctions', 'location': 'auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1>Alle Auctions</h1>

<script type="text/javascript">
	window.onload=function(){
		<s:iterator value="allAuctions" >
			dateFuture<s:property value='auctionId'/> = new Date(<s:property value='endTimeYear'/>,<s:property value='endTimeMonth'/>,<s:property value='endTimeDate'/>);
			GetCount(dateFuture<s:property value='auctionId'/>, "timer<s:property value='auctionId'/>");
		</s:iterator>
	};
</script>
<div class="row">
	<s:iterator value="allAuctions"  >
		<s:include value="/includes/auctionBox.jsp" />
	</s:iterator>
</div>

<s:include value="/includes/footer.jsp" />