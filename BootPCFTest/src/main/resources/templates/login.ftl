<div class="panel panel-primary">
  <div class="panel-heading">
  	Login Page
  </div>
  <div class="panel-body">
	<div class="col-sm-6">
		<div class="panel panel-info">
		  <div class="panel-heading">
		  	SignUp Form
		  </div>
		  <div class="panel-body">
		  	<form class="form-horizontal" action="/submitSignUp" method="POST">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="firstname">First Name:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter First Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="lastname">Last Name:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter Last Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="email">Email:</label>
			    <div class="col-sm-10">
			      <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">Password:</label>
			    <div class="col-sm-10"> 
			      <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter password">
			    </div>
			  </div>
			  <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-primary">Submit</button>
			    </div>
			  </div>
			</form>
		  </div>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="panel panel-info">
		  <div class="panel-heading">
		  	Login Form
		  </div>
		  <div class="panel-body">
		  	<form class="form-horizontal" action="/submitLogin" method="POST">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="email">Email:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">Password:</label>
			    <div class="col-sm-10"> 
			      <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter password">
			    </div>
			  </div>
			  <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label><input type="checkbox"> Remember me</label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-primary">Submit</button>
			    </div>
			  </div>
			</form>
		  </div>
		</div>
	</div>
  </div>
</div>
