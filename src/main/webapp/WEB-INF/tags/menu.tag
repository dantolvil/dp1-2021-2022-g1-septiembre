<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="parchis_oca" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ attribute name="name" required="true" rtexprvalue="true"
	description="Name of the active menu: home, owners, vets or error"%>

<nav class="navbar navbar-default" role="navigation"> 
	<div class="container">
		<div class="navbar-collapse collapse" id="main-navbar">
			<ul class="nav navbar-nav">

				<parchis_oca:menuItem active="${name eq 'home'}" url="/"
					title="home page">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					<span>Home</span>
				</parchis_oca:menuItem>

				<parchis_oca:menuItem active="${name eq 'players'}" url="/players/find"
					title="find players">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Find Player</span>
				</parchis_oca:menuItem>
				
				<parchis_oca:menuItem active="${name eq 'game'}" url="/game/create" 
					title="Create Game">
                    <span class="glyphicon glyphicon" aria-hidden="true"></span>
					<span>Create Game</span>
                </parchis_oca:menuItem>
                
				<parchis_oca:menuItem active="${name eq 'games'}" url="/game/createGameForm"
					title="games">
					<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
					<span>Games</span>
				</parchis_oca:menuItem>

			</ul>


			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="!isAuthenticated()">
					<li><a href="<c:url value="/login" />">Login</a></li>
					<li><a href="<c:url value="/users/new" />">Register</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span> 
							<strong><sec:authentication property="name" /></strong> <span
							class="glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul class="dropdown-menu">
							<li>
								<div class="navbar-login">
									<div class="row">
										<div class="col-lg-4">
											<p class="text-center">
												<span class="glyphicon glyphicon-user icon-size"></span>
											</p>
										</div>
										<div class="col-lg-8">
											<p class="text-left">
												<strong><sec:authentication property="name" /></strong>
											</p>
											<p class="text-left">
												<a href="<c:url value="/logout" />"
													class="btn btn-primary btn-block btn-sm">Logout</a>
											</p>
										</div>
									</div>
								</div>
							</li>
							<li class="divider"></li>

						</ul></li>
				</sec:authorize>
			</ul>
		</div>

	</div>
</nav>
