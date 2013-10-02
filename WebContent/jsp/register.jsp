<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Register', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
							<!-- Body -->
							<h2>Register Application</h2>
							<s:actionerror />
							<s:form action="register.action" method="post">
								<s:textfield name="register_email" key="label.email" size="20" placeholder="Email" cssClass="form-control" />
								<s:password name="register_password" key="label.password" size="20" placeholder="Password" cssClass="form-control" />
								<s:password name="register_password2" key="label.password" size="20" placeholder="Password" cssClass="form-control" />
								<s:textfield name="register_displayName" key="label.displayname" placeholder="Displayname" size="20" cssClass="form-control" />
								
								<s:textfield name="register_firstName" key="label.firstName" placeholder="FirstName" size="20" cssClass="form-control" />
								<s:textfield name="register_lastName" key="label.lastName" placeholder="LastName" size="20" cssClass="form-control" />
  								<s:radio label="Gender" name="register_gender" cssClass="btn-group, btn btn-primary" list="#{'0':'Female','1':'Male'}" theme="simple"/>
  								<s:textfield name="register_birthdate" key="label.birthDate" cssClass="inputDate form-control" id="inputDate" value="01/01/1980" size="30" />
								
								<s:textfield name="register_postalCode" key="label.postalCode" placeholder="PostalCode" size="20" cssClass="form-control" />
								<s:textfield name="register_houseNumber" key="label.houseNumber" placeholder="HouseNumber" size="20" cssClass="form-control" />
								<s:textfield name="register_street" key="label.street" placeholder="Street" size="20" cssClass="form-control" />
								<s:textfield name="register_city" key="label.city" placeholder="City" size="20" cssClass="form-control" />
								
								<s:submit method="execute" key="Register" align="center" cssClass="btn btn-default" value="Submit!"/>
							</s:form>
<s:include value="/includes/footer.jsp" />