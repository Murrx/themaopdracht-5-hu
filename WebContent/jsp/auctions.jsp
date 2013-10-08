<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Auctions', 'location': 'auctions'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1>Alle Auctions</h1>

<script type="text/javascript">
	window.onload=function(){
		<s:iterator status="stat" value="(25).{ #this }" >
			dateFuture<s:property value="#stat.count" /> = new Date(2014,<s:property value="#stat.count" />,<s:property value="#stat.count" />);
			GetCount(dateFuture<s:property value="#stat.count" />, "timer<s:property value="#stat.count" />");
		</s:iterator>
	};
</script>
<div class="row">
	<s:iterator status="stat" value="(25).{ #this }" >
		<s:include value="/includes/auctionBox.jsp" />
	</s:iterator>
</div>

<s:include value="/includes/footer.jsp" />