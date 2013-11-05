

<%@ taglib prefix="s" uri="/struts-tags"%>

<tr>
	<td><s:if test="%{bidStatus.StatusValue == 2}">
			<span class="label label-danger">Lost</span>
		</s:if>
		<s:elseif test="%{bidStatus.StatusValue == 1}">
			<span class="label label-warning">Losing</span>
		</s:elseif>
		<s:elseif test="%{bidStatus.StatusValue == 0}">
			<span class="label label-info">Winning</span>
		</s:elseif>
		<s:elseif test="%{bidStatus.StatusValue == 3}">
			<span class="label label-info">Won</span>
		</s:elseif>
		 <s:else>
			<span class="label label-success">Unknown</span>
		</s:else></td>

	<td>
		<s:url action="viewAction.action" var="viewAuction" >
		<s:param name="auction.id"><s:property value="id" /></s:param>
		</s:url>
		<s:a href="%{viewAuction}"><s:property value="id" /></s:a>
	</td>
	<td><s:property value='auction.product.name' /></td>
	<td><s:property value='bidCoins' /></td>

</tr>

