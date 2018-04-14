<div class="panel panel-primary">
  <div class="panel-heading">
  	All Users
  </div>
  <div class="panel-body table-responsive">
  <#if (users?size > 0) >
	<table class="table table-striped">
		<tr>
			<th>#</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<#list users as user>
			<tr>
				<td>${user.id}</td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.email}</td>
				<td><a href=#>View</a> <a href=#>Delete</a></td>
			</tr>
		</#list>
	</table>
	<#else>
		<strong>No users found.</strong>
  	</#if>
  </div>
</div>
