<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auctions', 'location': 'auctions', 'filter': true}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1>Manage auctions</h1>

<div class="row" id="allAuctions">
	<s:iterator value="allAuctions">
		<s:include value="/includes/auctionBoxAdminView.jsp" />
	</s:iterator>
</div>

<s:push value="#{'progressTimers':true, 'dateRangePicker':true, 'rangePicker': true}">
	<s:include value="/includes/footer.jsp" />
</s:push>