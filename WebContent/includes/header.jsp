<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Auctify - ${param.title}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<link href="/themaopdracht5/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="/themaopdracht5/bootstrap/css/style.css" rel="stylesheet">		
		
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
					<s:if test="%{#session.user ==null}">
					
						<s:form action="login.action" method="post" theme="simple" cssClass="navbar-form navbar-right" role="form">
							<div class="form-group">
								<label class="sr-only" for="exampleInputEmail2">email</label>
								<s:textfield name="login_email" key="label.email" size="8" cssClass="form-control" id="inputEmail1" placeholder="Email" />
								<s:fielderror fieldName="login_email"/>
							</div>
							<div class="form-group">
								<label class="sr-only" for="exampleInputPassword2">Password</label>
								<s:password name="login_password" key="label.password" size="8" cssClass="form-control" id="inputPassword1" placeholder="Password" />
								<s:fielderror fieldName="login_password"/>
							</div>
				
							<button type="submit" class="btn btn-default">Sign in</button>
						</s:form>
						<p class="navbar-text pull-right"><small><a href="/themaopdracht5/jsp/register.jsp">Not using Auctify yet? Register here!</a></small></p>
					</s:if>
					<s:else>
						<p>Welcome, <s:property value="#session.user.email" /></p>
						<p><small><a href="<s:url action='logout'/>">Log out!</a></small></p>
						
					</s:else>
					<form>
						<div class="row">
							<div class="col-sm-7 col-sm-offset-1">
								<div class="form-group">
									<input type="text" class="form-control input-small" placeholder="E-mail" />
								</div>
								<div class="form-group">
									<input type="password" class="form-control input-small" placeholder="Password" />
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<button type="submit" class="btn btn-default btn-block">Log in</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</header>


			<!--  Login form -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<s:actionerror />
				<s:if test="%{#session.user ==null}">
				
					<s:form action="login.action" method="post" theme="simple" cssClass="navbar-form navbar-right" role="form">
						<div class="form-group">
							<label class="sr-only" for="exampleInputEmail2">email</label>
							<s:textfield name="login_email" key="label.email" size="8" cssClass="form-control" id="inputEmail1" placeholder="Email" />
							<s:fielderror fieldName="login_email"/>
						</div>
						<div class="form-group">
							<label class="sr-only" for="exampleInputPassword2">Password</label>
							<s:password name="login_password" key="label.password" size="8" cssClass="form-control" id="inputPassword1" placeholder="Password" />
							<s:fielderror fieldName="login_password"/>
						</div>
			
						<button type="submit" class="btn btn-default">Sign in</button>
					</s:form>
					<p class="navbar-text pull-right"><small><a href="/themaopdracht5/jsp/register.jsp">Not using Auctify yet? Register here!</a></small></p>
				</s:if>
				<s:else>
					<p>Welcome, <s:property value="#session.user.email" /></p>
					<p><small><a href="<s:url action='logout'/>">Log out!</a></small></p>
					
				</s:else>
				
			</div>
			
		</nav> <!-- /.navbar-collapse --> 
			
			<!-- Navbar breadcrumbs -->
			<ol class="breadcrumb">
				<li class="active">Home</li>
			</ol>
			
		<div id="leftNavigation">
		
			<ul class="nav nav-pills nav-stacked">
				<li class="active">
					<a href="#">
						<span class="badge pull-right">/</span> Home
					</a>
				</li>
				<li>
					<a href="#">
						<span class="badge pull-right">54</span> Auctions
					</a>
				</li>
				<li>
					<a href="#">
						<span class="badge pull-right">25</span> Mass Auctions
					</a>
				</li>
			</ul>
		</div>
		