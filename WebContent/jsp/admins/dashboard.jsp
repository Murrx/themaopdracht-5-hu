<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Admin Panel', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>



<div class="row">

	<s:include value="/includes/adminMenu.jsp" />
	
	<div class="col-xs-12 col-sm-12 col-md-8">

	<h3>Admin Panel:</h3>
		<div class="well">
			Welcome to your awesome admin panel.<br /> 
			Here you manage your website.
		</div>

	</div>


</div>

<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-6">

		<h3>Stats:</h3>
		<div class="well">Here we'll display a graph or something.</div>

	</div>

</div>


<s:include value="/includes/footer.jsp" />