<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" media="all" href="bootstrap/js/dateRangePicker/daterangepicker-bs3.css" />
<h1>Filter</h1>
<div class="row">
	<s:form action="allAuctions" namespace="/" method="post">
		<div class="col-sm-12">
			<div class="form-group">
				<label for="priceRange">Highest Bid</label>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label for="startDateRange">Creation Date</label>
				<div id="startDateRange">
                  <i class="glyphicon glyphicon-calendar icon-calendar icon-large"></i>
                  <span></span> <b class="caret"></b>
               </div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label for="endDateRange">End Date</label>
				<div id="endDateRange">
                  <i class="glyphicon glyphicon-calendar icon-calendar icon-large"></i>
                  <span></span> <b class="caret"></b>
                 </div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>Category</label>
				<s:iterator value="categories">
					<div class="checkbox">
						<label>
							<input type="checkbox" name="<s:property value="category.name"/>" value="<s:property value="category.name" />">
					    		<s:property value="category.name" />
						</label>
					</div>
				</s:iterator>
			</div>
		</div>
	</s:form>
</div>