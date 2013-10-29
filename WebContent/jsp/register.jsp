<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Register', 'location': 'home'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<!-- DatePicker -->
		<link rel="stylesheet" href="bootstrap/js/datepicker/css/datepicker.css" type="text/css" />
   		<!-- End DatePicker -->
<div class="row">
	<div class="col-md-offset-3 col-sm-offset-2 col-md-6 col-sm-8">
		<h2>Registration Application</h2>
		<hr />
		<s:form action="register" cssClass="form-horizontal" method="post">
			<div class="form-group">
				<label for="register_email" class="col-sm-3 control-label">E-mail</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_email" />
					<s:textfield type="email" name="register_email" id="register_email" key="label.email" size="20" placeholder="E-mail" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_password" />
					<s:password name="register_password" id="register_password" key="label.password" size="20" placeholder="Password" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_password2" class="col-sm-3 control-label">Password (confirm)</label>
				<div class="col-sm-9">										
					<s:fielderror fieldName="register_password2" />
					<s:password name="register_password2" id="register_password2" key="label.password" size="20" placeholder="Password (confirm)" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_displayName" class="col-sm-3 control-label">Display name</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_displayName" />
					<s:textfield name="register_displayName" id="register_displayName" key="label.displayname" placeholder="Display name" size="20" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_firstName" class="col-sm-3 control-label">First name</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_firstName" />
					<s:textfield name="register_firstName" id="register_firstName" key="label.firstName" placeholder="First name" size="20" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_lastName" class="col-sm-3 control-label">Last name</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_lastName" />
					<s:textfield name="register_lastName" id="register_lastName" key="label.lastName" placeholder="Last name" size="20" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_gender" class="col-sm-3 control-label">Gender</label>
				<div class="col-sm-9">
							<s:fielderror fieldName="register_gender" />
					<div class="btn-group" data-toggle="buttons">
						<label class="btn btn-primary">
							<input type="radio" name="register_gender" id="genderF" checked="checked" value="0" />Female
						</label>
						<label class="btn btn-primary">
							<input type="radio" name="register_gender" id="genderM" value="1" />Male
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="register_birthdate" class="col-sm-3 control-label">Birthdate</label>
				<div class="col-sm-9">
							<s:fielderror fieldName="register_birthdate" />
							<s:textfield name="register_birthdate" id="register_birthdate" key="label.birthDate" cssClass="inputDate form-control" value="01-01-1980" size="30" />								
				</div>
			</div>
			<div class="form-group">
				<label for="register_street" class="col-sm-3 control-label">Street</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_street" />
					<s:textfield name="register_street" id="register_street" key="label.street" placeholder="Street" size="20" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_houseNumber" class="col-sm-3 control-label">Housenumber</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_houseNumber" />
					<s:textfield name="register_houseNumber" id="register_houseNumber" key="label.houseNumber" placeholder="Housenumber" size="20" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_postalCode" class="col-sm-3 control-label">Postal code</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_postalCode" />
					<s:textfield pattern="[0-9]{4}[ ]?[a-zA-Z]{2}" name="register_postalCode" id="register_postalCode" key="label.postalCode" placeholder="Postal code" size="20" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="register_city" class="col-sm-3 control-label">City</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="register_city" />
					<s:textfield name="register_city" id="register_city" key="label.city" placeholder="City" size="20" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<s:submit method="execute" key="Register" align="center" cssClass="btn btn-default" value="Submit!"/>
				</div>
			</div>

		</s:form>
	</div>
</div>
<s:actionerror />
<s:push value="#{'dateTimePicker':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>