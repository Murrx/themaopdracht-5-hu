<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="/includes/header.jsp">
   <s:param name="title">Login</s:param>
</s:include>

	<h2>Login Application</h2>
	<s:actionerror />
	<s:form action="login.action" method="post" theme="simple" cssClass="form-horizontal" role="form">
		
        <div class="form-group">
            <label for="username" class="col-lg-2 control-label">Username</label>
            <div class="col-lg-10">
                <s:textfield name="username" key="label.username" size="20" cssClass="form-control" id="inputEmail1" placeholder="Username"/>
             </div>
		</div>
      	<div class="form-group">
        	<label for="password" class="col-lg-2 control-label">Password</label>
      		<div class="col-lg-10">
           		<s:password name="password" key="label.password" size="20" cssClass="form-control" id="inputPassword1" placeholder="Password"/>
           	</div>
       </div>
       <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
            <s:submit method="execute" key="label.login" align="center" cssClass="btn btn-default" />
		</div>
       </div>
	</s:form>
	<a href="<s:url value="/jsp/register.jsp"  />">Register here</a>
	
<s:include value="/includes/footer.jsp" />