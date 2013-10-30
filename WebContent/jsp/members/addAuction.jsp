<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Create New Auction', 'location': 'create-new-auction'}">
	<s:include value="/includes/header.jsp" />
</s:push>
<!-- DatePicker -->
	<link rel="stylesheet" href="bootstrap/js/datetimepicker/bootstrap-datetimepicker.css" type="text/css" />
<!-- End DatePicker -->
<div class="row">
	<div class="col-md-offset-3 col-sm-offset-2 col-md-6 col-sm-8">
		<h2>Add Auction</h2>
		<hr />
		<s:form action="addAuction" cssClass="form-horizontal" method="post" namespace="/member" enctype="multipart/form-data">
 			<div class="form-group">
				<label for="auction_name" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="auction_name" />
					<s:textfield name="auction_name" size="20" placeholder="Name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="auction_description" class="col-sm-3 control-label">Description</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="auction_description" />
					<s:textarea name="auction_description" placeholder="Description" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="auction_category" class="col-sm-3 control-label">Category</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="auction_category" />
					<s:select name="auction_category" 
		    			list="categories" listKey="name()" cssClass="form-control">
					</s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="fileUpload" class="col-sm-3 control-label">Image</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="fileUpload" />
		    		<s:file cssClass="form-control" name="fileUpload" accept="image/jpeg" label="File"/>
				</div>
			</div>
			<div class="form-group">
				<label for="auction_price" class="col-sm-3 control-label">Price</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="auction_price" />
					<s:textfield name="auction_price" size="20" placeholder="Price" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="auction_end_time" class="col-sm-3 control-label">End Date</label>
				<div class="col-sm-9 ">
					<s:fielderror fieldName="auction_end_time" />
					<input type="text" name="auction_end_time" size="30" placeholder="dd-mm-yyyy hh:mm" id="auction_end_time" class="form-control form_datetime">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<s:submit method="execute" align="center" cssClass="btn btn-default" value="submit"   />
				</div>
			</div>
		</s:form>
	</div>
</div>
<s:actionerror />
<s:push value="#{'dateTimePicker':true}">
	<s:include value="/includes/footer.jsp" />
</s:push>
