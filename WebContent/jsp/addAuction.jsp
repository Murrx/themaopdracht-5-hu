<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:push value="#{'title':'Create New Auction', 'location': 'create-new-auction'}">
	<s:include value="/includes/header.jsp" />
</s:push>
		<h2>Add Auction</h2>
		<s:actionerror />
		
		<s:form action="resultAction" method="post" namespace="/" enctype="multipart/form-data">
		
			<s:fielderror fieldName="auction_name" />
			<s:textfield name="auction_name" key="auction.name" size="20" placeholder="Name" cssClass="form-control" />
			
			<s:fielderror fieldName="auction_description" />
			<s:textarea name="auction_description" key="auction.description" placeholder="Description" cssClass="form-control" />
			
			<s:fielderror fieldName="auction_category" />
			<s:select name="auction_category" 
    			list="%{#{'art':'Art', 'elec':'Electronics'}}">
				<s:optgroup label="Books" 
					list="#{'thril':'Thriller','scifi':'Science Fiction','roman':'Romantic Novel'}" />
				<s:optgroup label="Cars" 
					list="#{'part':'Car Parts','old':'Oldtimers','truck':'Truck'}" />
			</s:select>
			
			<s:fielderror fieldName="fileUpload" />
    		<s:file name="fileUpload" label="File"/>
						
			<s:fielderror fieldName="auction_price" />
			<s:textfield name="auction_price" key="auction.price" size="20" placeholder="Price" cssClass="form-control" />
			
			<s:fielderror fieldName="auction_end_date" />
  			<s:textfield name="auction_end_date" key="auction.enddate" cssClass="inputDate form-control" id="inputDate" value="01/01/1980" size="30" />								
			
			<s:submit method="execute" key="label.submit" align="center" cssClass="btn btn-default" value="submit"   />
		
		</s:form>
			

		
<s:include value="/includes/footer.jsp" />