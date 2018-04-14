<div class="container">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
		  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="/">C Square</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
		    <ul class="nav navbar-nav">
		      <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
		        	Page 1	<span class="caret"></span>
		        </a>
		        <ul class="dropdown-menu">
		          <li><a href="/page1">Page 1-1</a></li>
		          <li><a href="/page2">Page 1-2</a></li>
		          <li><a href="/page3">Page 1-3</a></li>
		        </ul>
		      </li>
		      <li><a href="/page1">Page 1</a></li>
		      <li><a href="/page2">Page 2</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		    	<#if sessionId??>
		    		<#if user??>
		    			<li><a href="#"><span class="glyphicon glyphicon-user"></span> ${user.firstname!} ${user.lastname!}</a></li>
		    		</#if>
		    		<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
		    	<#else>
		    		<li><a href="/signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		    		<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		    	</#if>
		    </ul>
		 </div>
	  </div>
	</nav>
</div>