<%@ taglib prefix="s" uri="/struts-tags"%>
					<div class="row">
						<nav class="col-sm-12">
							<!-- Navigation -->
							<ul class="nav nav-tabs">
								<li <s:if test='location == "home"'>class="active"</s:if>><a href="welcome.jsp">Home</a></li>
								<li <s:if test='location == "auction"'>class="active"</s:if>><a href="#">Auctions</a></li>
								<li <s:if test='location == "mass-auctions"'>class="active"</s:if>><a href="#">Mass Auctions</a></li>
								<li <s:if test='location == "create-new-auction"'>class="active"</s:if>><a href="addAuction.jsp">Create New Auction</a></li>
							</ul>
						</nav>
					</div>