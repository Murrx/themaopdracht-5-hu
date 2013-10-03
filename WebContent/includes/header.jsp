<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Auctify - <s:property value="title" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<!-- Optional Bootstrap theme -->
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="/themaopdracht5/bootstrap/css/style.css">
		
		<!-- DatePicker -->
		<link rel="stylesheet" href="/themaopdracht5/datepicker/css/datepicker.css" type="text/css" />
   		<link rel="stylesheet" media="screen" type="text/css" href="/themaopdracht5/datepicker/css/layout.css" />
    
		<script type="text/javascript" src="/themaopdracht5/datepicker/js/jquery.js"></script>
		<script type="text/javascript" src="/themaopdracht5/datepicker/js/datepicker.js"></script>
	    <script type="text/javascript" src="/themaopdracht5/datepicker/js/eye.js"></script>
	    <script type="text/javascript" src="/themaopdracht5/datepicker/js/utils.js"></script>
	    <script type="text/javascript" src="/themaopdracht5/datepicker/js/layout.js?ver=1.0.2"></script>
   		<!-- End DatePicker -->
		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="/themaopdracht5/bootstrap/js/html5shiv.js"></script>
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
					<s:form action="login" method="post">
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
								<a href="/themaopdracht5/jsp/register.jsp">Register a new account</a>
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
					<div class="row">
						<nav class="col-sm-12">
							<!-- Navigation -->
							
							<ul class="nav nav-tabs">
								<li <s:if test='location == "home"'>class="active"</s:if>><a href="#">Home</a></li>
								<li <s:if test='location == "auction"'>class="active"</s:if>><a href="#">Auctions</a></li>
								<li <s:if test='location == "mass-auctions"'>class="active"</s:if>><a href="#">Mass Auctions</a></li>
								<li <s:if test='location == "create-new-auction"'>class="active"</s:if>><a href="#">Create New Auction</a></li>
							</ul>
						</nav>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<!-- Breadcrumbs -->
							Home > <s:property value="title" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">