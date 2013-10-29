<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Add BidCoins', 'location': 'add-bidcoins'}">
	<s:include value="/includes/header.jsp" />
</s:push>
<div class="row">
	<div class="col-md-offset-3 col-sm-offset-2 col-md-6 col-sm-8">
		<h2>Add Auction</h2>
		<p>Please buy as many BidCoins as possible! Give us your money! Actual buying is not yet implemented.</p>
		<hr />
		<s:form action="" cssClass="form-horizontal" method="post" namespace="/" enctype="multipart/form-data">
 			<div class="form-group">
				<label for="amount" class="col-sm-3 control-label">Amount</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="amount" />
					<input type="number" id="amountSpin" name="amount" class="form-control" placeholder="Amount">
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-3 control-label">Price</label>
				<div class="col-sm-9">
					<s:fielderror fieldName="price" />
					<span name="price" id="price" class="form-control">€ 0,00</span>
				</div>
			</div>
			<hr />
			<div class="form-group">
				<div class="col-sm-12">
					<s:submit method="execute" key="label.submit" align="center" cssClass="btn btn-default" value="submit"   />
				</div>
			</div>
		</s:form>
	</div>
</div>
<s:actionerror />
<s:push value="#{'spinner':true}">	
	<s:include value="/includes/footer.jsp" />
</s:push>
