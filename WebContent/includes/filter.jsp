<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" media="all" href="bootstrap/js/dateRangePicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css" media="all" href="bootstrap/js/nouislider/jquery.nouislider.min.css" />
<h1>Filter</h1>
<div class="row">
	<s:form action="searchAuctions" namespace="/" method="post">
		<s:textfield type="hidden" name="search" value="%{search}" />
		<div class="col-sm-12">
			<div class="form-group price-range">
				<label>Highest Bid</label>
				<div class="slider" id="priceRange"></div>
				<div class="row">
					<div class="col-xs-6">
						<s:textfield type="text" name="priceRangeLow" cssClass="form-control" value="%{priceRangeLow}" />
					</div>
					<div class="col-xs-6">
						<s:textfield type="text" name="priceRangeHigh" cssClass="form-control" value="%{priceRangeHigh}"/>
					</div>
					<script>
						var sliderStart = <s:property value="%{priceRangeLow}" />;
						var sliderEnd = <s:property value="%{priceRangeHigh}" />;
					</script>
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
					<script>
						var startDateLow = "<s:property value="%{startDateLowDate}" />";
						var startDateHigh = "<s:property value="%{startDateHighDate}" />";
					</script>
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
					<script>
						var endDateLow = "<s:property value="%{endDateLowDate}" />";
						var endDateHigh = "<s:property value="%{endDateHighDate}" />";
					</script>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>Category</label>
				<s:iterator value="categories">
					<div class="checkbox">
						<label>
							<s:if test="[0].name in selectedCategories">
								<input type="checkbox" checked name="selectedCategories" value="<s:property />">
							</s:if>
							<s:else>
								<input type="checkbox" name="selectedCategories" value="<s:property />">
							</s:else>
					    		<s:property />
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