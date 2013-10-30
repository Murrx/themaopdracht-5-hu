<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Buy BidCoins', 'location': 'buy-bidcoins'}">
	<s:include value="/includes/header.jsp" />
</s:push>
<div class="row">
	<div class="col-md-offset-3 col-sm-offset-2 col-md-6 col-sm-8">
		<h2>Buy <i class='fa fa-btc'></i>idCoins</h2>
		<p>Please buy as many BidCoins as possible! Give us your money! Actual buying is not yet implemented.</p>
		<hr />
		<s:if test="%{exception.message !=''}">
		    <div class="alert alert-danger"><s:property value="%{exception.message}"/></div>
		</s:if>
		<s:form action="buyBidCoins" namespace="/member" cssClass="form-horizontal" method="post" enctype="multipart/form-data">
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
					<span name="price" id="price" class="form-control">€ 0,10</span>
				</div>
			</div>
			<hr />
			<div class="form-group">
				<div class="col-sm-12">
					<s:submit align="center" cssClass="btn btn-default" value="Buy BidCoins" />
				</div>
			</div>
		</s:form>
	</div>
</div>
<s:actionerror />
<s:push value="#{'spinner':true}">	
	<s:include value="/includes/footer.jsp" />
</s:push>
