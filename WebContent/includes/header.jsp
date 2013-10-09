<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Auctify - <s:property value="title" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<base href="<%=request.getContextPath()%>/" />
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="bootstrap/css/style.css">
		
		<!-- JQuery en countdown moeten in header (niet footer), anders werkt de timer van auctions niet meer! -->
		<script src="//code.jquery.com/jquery-latest.js" type="text/javascript"></script>
		<script src="includes/countdown.js" type="text/javascript"></script>		
		
		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="bootstrap/js/html5shiv.js"></script>
		<![endif]-->
	</head>
	
	<body>
		<div class="container">
			<header class="row">
				<div class="col-sm-3">
					<!-- Logo -->
					<span class="logo-part-one">Auctify</span><span class="logo-part-two">.com</span>
					<button class="navbar-toggle pull-right" type="button">
						<span class="navbar-toggle-bar"></span>
						<span class="navbar-toggle-bar"></span>
						<span class="navbar-toggle-bar"></span>
						<span class="navbar-toggle-bar"></span>
					</button>
				</div>
				<div class="col-sm-6">
					<!-- Search -->
					<form role="search">
						<div class="form-group" id="search-bar">
							<div id="floater"></div>
							<div id="search-bar-content">
								<input type="search" class="form-control input-lg" placeholder="Search">
							</div>
						</div>
					</form>
				</div>
				<div class="col-sm-3" id="login-form">
					<!-- Login -->
					<s:actionerror />
					<s:if test="%{#session.user == null}">
					<s:form action="/login" method="post">
						<div class="row">
							<div class="col-sm-7 col-sm-offset-1">
								<div class="form-group">
									<s:textfield name="login_email" key="label.email" cssClass="form-control input-sm" id="inputEmail1" placeholder="E-mail" />
									<s:fielderror fieldName="login_email"/>
								</div>
								<div class="form-group">
									<s:password name="login_password" key="label.password" cssClass="form-control input-sm" id="inputPassword1" placeholder="Password" />
									<s:fielderror fieldName="login_password"/>
								</div>
								<a href="registerPage">Register a new account</a>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<button type="submit" class="btn btn-default btn-block">
									<span class="glyphicon glyphicon-user"></span>Sign in
									</button>
								</div>
							</div>
						</div>
					</s:form>
					</s:if>
					<s:else>
						<p><span class="glyphicon glyphicon-user"></span><s:property value="#session.user.email" /></p>
						<p><small><a href="<s:url action='logout'/>">Log out!</a></small></p>
					</s:else>
					
				</div>
			</header>
			<div class="row">
				<s:if test='filter'>
				<div class="col-sm-2">
					<!-- Filter -->
					Filter
				</div>					
				</s:if>
				<s:if test='filter && optional'>
				<div class="col-sm-8">
				</s:if>
				<s:elseif test='filter || optional'>
				<div class="col-sm-10">
				</s:elseif>
				<s:else>
				<div class="col-sm-12">
				</s:else>
					<s:include value="menu.jsp" />
					<div class="row">
						<div class="col-sm-12">
							<!-- Breadcrumbs -->
							Home > <s:property value="title" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
