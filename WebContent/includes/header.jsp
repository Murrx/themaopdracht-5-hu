<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Auctify - ${param.title}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Bootstrap -->
		<link href="/themaopdracht5/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	</head>
	<body>
		
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/themaopdracht5">
					<img src="http://smartlapus.com/th5/logo.png">
				</a>
			</div>
		
			<!--  Search bar -->
			<s:form cssClass="navbar-form navbar-left" role="form">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search for a product">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</s:form>
		
		
			<!--  Login form -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<s:actionerror />
				<s:form action="login.action" method="post" theme="simple" cssClass="navbar-form navbar-right" role="form">
					<div class="form-group">
						<label class="sr-only" for="exampleInputEmail2">email</label>
						<s:textfield name="email" key="label.email" size="8" cssClass="form-control" id="inputEmail1" placeholder="Email" />
					</div>
					<div class="form-group">
						<label class="sr-only" for="exampleInputPassword2">Password</label>
						<s:password name="password" key="label.password" size="8" cssClass="form-control" id="inputPassword1" placeholder="Password" />
					</div>
		
					<button type="submit" class="btn btn-default">Sign in</button>
				</s:form>
				<p class="navbar-text pull-right"><small><a href="/themaopdracht5/jsp/register.jsp">Nog geen gebruiker? Registreer hier!</a></small></p>
				
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
		