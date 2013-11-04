<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Admin Panel', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>


<h3>Admin Panel:</h3>
<div class="row">

	<s:include value="/includes/adminMenu.jsp" />
	
	<div class="col-xs-12 col-sm-12 col-md-8">

	
		<div class="well">
				SHOW ALL MEMBERS		
		</div>

	</div>


</div>




<s:include value="/includes/footer.jsp" />