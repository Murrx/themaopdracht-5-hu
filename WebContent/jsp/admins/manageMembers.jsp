<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Manage members','adminPanel': true ,'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>



<div class="row">
	<s:include value="/includes/adminMenu.jsp" />

	<div class="col-xs-12 col-sm-12 col-md-8">

		<h3>Manage Members</h3>

		
		
			<div class="table-responsive table-condensed">
				<table class="table table-hover">
					<s:iterator value="users">
						<s:include value="/includes/memberList.jsp" />
					</s:iterator>
				</table>
			</div>
		




	</div>
</div>




<s:include value="/includes/footer.jsp" />