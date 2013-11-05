<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title><s:property value="title" /> - Auctify</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<base href="<%=request.getContextPath()%>/" />
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.css">
		<link rel="stylesheet" href="bootstrap/css/style.css">

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="bootstrap/js/html5shiv.js"></script>
		<![endif]-->
	</head>
	
	<body class="container">
		<header class="row">
			<div class="col-sm-3">
				<!-- Logo -->
				<a href=".action"><span class="logo-part-one">Auctify</span><span class="logo-part-two">.com</span></a>
				<button class="navbar-toggle pull-right" type="button">
<!-- 				<span class="navbar-toggle-bar"></span>
					<span class="navbar-toggle-bar"></span>
					<span class="navbar-toggle-bar"></span>
					<span class="navbar-toggle-bar"></span> -->
					<i class="fa fa-user"></i>
				</button>
			</div>
			<div class="col-sm-5">
				<!-- Search -->
				<s:form action="searchAuctions" namespace="/" method="post" role="search">
					<div class="form-group" id="search-bar">
						<div id="floater"></div>
						<div id="search-bar-content">
							<s:textfield type="search" name="search" cssClass="form-control input-lg" placeholder="Search" value="%{search}" />
							<button type="submit" id="searchBtn" class="btn btn-default input-lg"><i class="fa fa-search"></i></button>
						</div>
					</div>
				</s:form>
			</div>
			<div class="col-sm-4" id="login-form">
				<!-- Login -->
				<s:if test="%{#session.user == null}">
				<s:form action="login" namespace="/" method="post">
					<div class="row">
						<div class="col-sm-7 col-sm-offset-1">
							<div class="form-group">
								<s:textfield name="login_email" type="email" cssClass="form-control input-sm" id="inputEmail1" placeholder="E-mail" />
								<s:fielderror fieldName="login_email"/>
							</div>
							<div class="form-group">
								<s:password name="login_password" cssClass="form-control input-sm" id="inputPassword1" placeholder="Password" />
								<s:fielderror fieldName="login_password"/>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<button id="loginBtn" type="submit" class="btn btn-default btn-block input-sm">
									Sign in
								</button>
							</div>
							<div class="form-group">
								<a href="<s:url action='registerForm' namespace='/' />">
									Register
								</a>
							</div>
						</div>
					</div>
				</s:form>
				</s:if>
				<s:else>
					<div>
						<div class="user-box">
							<div class="user-box-edit" title="Edit Profile">
								<a href="<s:url action='editProfileForm' namespace='/member'/>"><i class="fa fa-cog"></i></a>
							</div>
							<div class="user-box-mine" title="View Own Auctions">
								<a href="<s:url action='ViewAllUserAuctionForm' namespace='/member'/>">
									<span class="icon-stack">
										<i class="fa fa-gavel"></i>
										<i class="fa fa-user"></i>
									</span>
								</a>
							</div>
							
							<s:if test="%{#session.user.rights.rightsValue >= 256}">
							<div class="user-box-admin" title="Admin Panel">
							<a href="<s:url action='ViewAdminPanel' namespace='/admin'/>">
									<i class="fa fa-wrench"></i>
							</a>
							</div>
							</s:if>
							
							
							<div class="user-box-info">
								<div class="user-box-field">
									<div class="user-box-text">
										<s:property value="#session.user.displayName" />
									</div>
									<div class="user-box-icon">
										<i class="fa fa-user"></i>
									</div>
								</div>
								<div class="user-box-field">
									<div class="user-box-text">
										<s:property value="#session.user.bidCoins" />
										<a class="buyBidCoinsButton" href="<s:url action='buyBidCoinsForm' namespace='/member'/>"><i class="fa fa-plus-square"></i></a>
									</div>
									<div class="user-box-icon">
										<i class="fa fa-btc"></i>
									</div>
								</div>
								<div class="user-box-field">
									<div class="user-box-text">
										<a href="<s:url action='logout' namespace='/member' />">Log out!</a>
									</div>
									<div class="user-box-icon">
										<i class="fa fa-sign-out"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
				</s:else>
				
			</div>
		</header>
		<main>
		<div class="row">
			<div class="col-sm-12">
				<s:include value="menu.jsp" />
				<div class="row">
					<div class="col-sm-12">
						<!-- Breadcrumbs -->
						<a href=".action">Home</a> 
						<s:if test="%{parent != null}">
							> <a href="<s:url action='%{parent}' namespace='/'/> "><s:property value="parentName" /></a>
						</s:if>
						<s:if test="adminPanel">
							> <a href="<s:url action='ViewAdminPanel' namespace='/admin'/> ">Admin Panel</a>
						</s:if>
						> <s:property value="title" />
					</div>
				</div>
				<div class="row">
					<s:if test="filter">
						<div class="col-sm-3 col-md-2">
							<s:include value="filter.jsp" />
						</div>
						<div class="col-sm-9 col-md-10">
					</s:if>
					<s:else>
						<div class="col-sm-12">
					</s:else>
