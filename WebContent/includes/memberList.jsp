

<%@ taglib prefix="s" uri="/struts-tags"%>

<tr>
<td><s:if test="%{rights.rightsValue >= 256}"><span class="label label-danger">Admin</span> </s:if>
	<s:else><span class="label label-success">Member</span> </s:else>
</td>
<td> <s:property value='displayName'/> </td>
<td> <s:property value='email'/> </td>
<td> <s:property value='bidCoins'/> </td>

</tr>

