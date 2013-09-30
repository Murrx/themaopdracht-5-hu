<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Register', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
							<!-- Body -->
							<h2>Register Application</h2>
							<s:actionerror />
							<s:form action="register.action" method="post">
								<s:textfield name="register_email" key="label.email" size="20" placeholder="label.email" cssClass="form-control" />
								<s:password name="register_password" key="label.password" size="20" placeholder="label.password" cssClass="form-control" />
								<s:password name="register_password2" key="label.password" size="20" placeholder="label.password" cssClass="form-control" />
								<s:textfield name="register_displayName" key="label.displayname" placeholder="label.displayname" size="20" cssClass="form-control" />
								
								<s:textfield name="register_firstName" key="label.firstName" placeholder="label.firstName" size="20" cssClass="form-control" />
								<s:textfield name="register_lastName" key="label.lastName" placeholder="label.lastName" size="20" cssClass="form-control" />
  								<s:radio label="Gender" name="register_gender" list="#{'0':'label.female','1':'label.male'}" />
  								<s:textfield name="register_birthdate" key="label.birthDate" placeholder="label.birthDate" size="20" cssClass="form-control" />
								
								<s:textfield name="register_postalCode" key="label.postalCode" placeholder="label.postalCode" size="20" cssClass="form-control" />
								<s:textfield name="register_houseNumber" key="label.houseNumber" placeholder="label.houseNumber" size="20" cssClass="form-control" />
								<s:textfield name="register_street" key="label.street" placeholder="label.street" size="20" cssClass="form-control" />
								<s:textfield name="register_city" key="label.city" placeholder="label.city" size="20" cssClass="form-control" />
								
								<s:submit method="execute" key="label.register" align="center" cssClass="btn btn-default" />
							</s:form>
<s:include value="/includes/footer.jsp" />