<%@ taglib prefix="s" uri="/struts-tags"%>



<tr>
	<td><span class="label label-warning"><i class='fa fa-btc'></i> <s:property value='bidAmount' /></span></td>
	<td><s:url action="ViewMemberAction.action" namespace="/member" var="viewMember">
			<s:param name="userId">
				<s:property value="user.userId" />
			</s:param>
		</s:url> <s:a href="%{viewMember}">
			<s:property value='user.displayName' />
		</s:a></td>
	<td><s:property value="day" />/<s:property value="month" />/<s:property value="year" /></td>

</tr>






