

<%@ taglib prefix="s" uri="/struts-tags"%>

<tr>
	<td><s:if test="%{rightsValue >= 256}">
			<span class="label label-danger">Admin</span>
		</s:if>
		<s:elseif test="%{rights.rightsValue < 5}">
			<span class="label label-default">Blocked</span>
		</s:elseif>
		 <s:else>
			<span class="label label-success">Member</span>
		</s:else></td>

	<td>
		<s:url action="ViewMemberAction.action" var="viewMember" >
		<s:param name="userId"><s:property value="userId" /></s:param>
		</s:url>
		<s:a href="%{viewMember}"><s:property value="email" /></s:a>
	</td>
	<td><s:property value='displayName' /></td>
	<td><s:property value='bidCoins' /></td>

</tr>

