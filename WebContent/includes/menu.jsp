<%@ taglib prefix="s" uri="/struts-tags"%>
						<nav class="col-sm-12">
							<!-- Navigation -->
							<s:if test='%{(param.location) == "home"}'>class="active"</s:if>
							<ul class="nav nav-tabs">
								<li ><a href="#">Home</a></li>
								<li <s:if test='%{(param.location) == "auction"}'>class="active"</s:if>><a href="#">Auctions</a></li>
								<li <s:if test='%{(param.location) == "mass-auctions"}'>class="active"</s:if>><a href="#">Mass Auctions</a></li>
								<li <s:if test='%{(param.location) == "create-new-auction"}'>class="active"</s:if>><a href="#">Create New Auction</a></li>
							</ul>
						</nav>