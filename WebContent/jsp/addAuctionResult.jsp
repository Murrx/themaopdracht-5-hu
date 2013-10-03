<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'New Auction successful', 'location': 'create-new-auction'}">
	<s:include value="/includes/header.jsp" />
</s:push>

<h1>Struts 2 &lt;s:file&gt; file upload example</h1>

<h4>Auction Name : <s:property value="auction_name"/></h4> 
<h4>Auction Description : <s:property value="auction_description"/></h4> 
<h4>Auction Category value: <s:property value="auction_category" /></h4>
<hr />

<h4>File Upload Name : <s:property value="fileUploadFileName"/></h4> 
<h4>File Upload Type : <s:property value="fileUploadContentType"/></h4> 
<h4>File Upload Location: <s:property value="fileUpload"/></h4>
<hr />


<h4>Auction Price: <s:property value="auction_price"/></h4> 
<h4>Auction End date: <s:property value="auction_end_date" /></h4>

<s:include value="/includes/footer.jsp" />