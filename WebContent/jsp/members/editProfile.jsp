<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Edit profile', 'location': 'edit-profile'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<!-- DatePicker -->
		<link rel="stylesheet" href="/themaopdracht5/datepicker/css/datepicker.css" type="text/css" />
   		<!-- End DatePicker -->
<div class="row">
	<div class="col-md-offset-3 col-sm-offset-2 col-md-6 col-sm-8">
		<h2>Edit profile</h2>
		<hr />
		<s:form action="editProfile" cssClass="form-horizontal" method="post">
			<input type="hidden" name="edit_email" id="edit_email" key="label.email" size="20" placeholder="E-mail" cssClass="form-control" value="<s:property value='#session.user.email' />" />
			<div class="form-group">
				<label for="edit_password" class="col-sm-3 control-label">Current password</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_password" />
					<s:textfield name="edit_password" id="edit_password" size="20" placeholder="Password" value="%{#session.user.password}" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_new_password" class="col-sm-3 control-label">New password</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_new_password" />
					<s:password name="edit_new_password" id="edit_new_password" size="20" placeholder="New password" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_password2" class="col-sm-3 control-label">New password (confirm)</label>
				<div class="col-sm-9">										
					<s:fielderror fieldName="edit_password2" />
					<s:password name="edit_password2" id="edit_password2" size="20" placeholder="Password (confirm)" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_displayName" class="col-sm-3 control-label">Display name</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_displayName" />
					<s:textfield name="edit_displayName" id="edit_displayName" placeholder="Display name" size="20" cssClass="form-control" value="%{#session.user.displayName}" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_firstName" class="col-sm-3 control-label">First name</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_firstName" />
					<s:textfield name="edit_firstName" id="edit_firstName" placeholder="First name" size="20" cssClass="form-control" value="%{#session.user.person.firstName}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="edit_lastName" class="col-sm-3 control-label">Last name</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_lastName" />
					<s:textfield name="edit_lastName" id="edit_lastName" placeholder="Last name" size="20" cssClass="form-control" value="%{#session.user.person.lastName}" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_gender" class="col-sm-3 control-label">Gender</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_gender" />
					<div class="btn-group" data-toggle="buttons">
						<s:if test='%{#session.user.person.gender == 0}'>
							<label class="btn btn-primary active">
						</s:if>
						<s:else>
							<label class="btn btn-primary">
						</s:else>
							<input type="radio" name="edit_gender" id="genderF" value="0" />Female
						</label>
						<s:if test='%{#session.user.person.gender == 1}'>
							<label class="btn btn-primary active">
						</s:if>
						<s:else>
							<label class="btn btn-primary">
						</s:else>
							<input type="radio" name="edit_gender" id="genderM" value="1" />Male
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="edit_birthdate" class="col-sm-3 control-label">Birthdate</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_birthdate" />
					<s:textfield name="edit_birthdate" id="edit_birthdate" cssClass="inputDate form-control" value="%{#session.user.person.birthdate}" size="30" />								
				</div>
			</div>
			<div class="form-group">
				<label for="edit_street" class="col-sm-3 control-label">Street</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_street" />
					<s:textfield name="edit_street" id="edit_street" placeholder="Street" size="20" value="%{#session.user.address.street}" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_houseNumber" class="col-sm-3 control-label">Housenumber</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_houseNumber" />
					<s:textfield name="edit_houseNumber" id="edit_houseNumber" placeholder="Housenumber" size="20" value="%{#session.user.address.houseNumber}" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_postalCode" class="col-sm-3 control-label">Postal code</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_postalCode" />
					<s:textfield pattern="[0-9]{4}[ ]?[a-zA-Z]{2}" name="edit_postalCode" id="edit_postalCode" placeholder="Postal code" size="20" value="%{#session.user.address.postalCode}" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="edit_city" class="col-sm-3 control-label">City</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="edit_city" />
					<s:textfield name="edit_city" id="edit_city" placeholder="City" size="20" value="%{#session.user.address.city}" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<s:submit align="center" cssClass="btn btn-default" value="Submit!"/>
				</div>
			</div>

		</s:form>
	</div>
</div>
<s:actionerror />
<s:push value="#{'dateTimePicker':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>