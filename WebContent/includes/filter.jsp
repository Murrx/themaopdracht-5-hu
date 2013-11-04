<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" media="all" href="bootstrap/js/dateRangePicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css" media="all" href="bootstrap/js/nouislider/jquery.nouislider.min.css" />
<h1>Filter</h1>
<div class="row">
	<s:form action="allAuctions" namespace="/" method="get">
		<div class="col-sm-12">
			<div class="form-group price-range">
				<label>Highest Bid</label>
				<div class="slider" id="priceRange"></div>
				<div class="row">
					<div class="col-xs-6">
						<input type="text" disabled name="priceRangeLow" class="form-control" />
					</div>
					<div class="col-xs-6">
						<input type="text" disabled name="priceRangeHigh" class="form-control"/>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>Creation Date</label>
				<div id="startDateRange" class="date-range">
					<button class="btn btn-default btn-block"></button>
					<input type="hidden" name="startDateLow" />
					<input type="hidden" name="startDateHigh" />
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>End Date</label>
				<div id="endDateRange" class="date-range">
					<button class="btn btn-default btn-block"></button>
					<input type="hidden" name="endDateLow" />
					<input type="hidden" name="endDateHigh" />
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>Category</label>
				<s:iterator value="categories" status="s">
					<div class="checkbox">
						<label>
							<input type="checkbox" name="<s:property value="categories[#s.index]"/>" value="<s:property value="categories[#s.index]" />">
					    		<s:property value="categories[#s.index]" />
						</label>
					</div>
				</s:iterator>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<button type="submit" class="btn btn-default btn-block">Apply</button>
			</div>
		</div>
	</s:form>
</div>