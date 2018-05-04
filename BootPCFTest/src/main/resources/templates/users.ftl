<div class="panel panel-primary">
  <div class="panel-heading">
  	All Users
  </div>
  <div class="panel-body table-responsive">
  <#if (users?size > 0) >
	<table class="table table-striped">
		<tr>
			<th><input type="checkbox"/></th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<#list users as user>
			<tr>
				<td><input type="checkbox"/></td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.email}</td>
				<td>
					<div class="btn-group">
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ProfileModal" onClick="AJAXCall('GET',${user.id});">
							<span class="glyphicon glyphicon-eye-open"></span>
						</button>
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ProfileModal" onClick="AJAXCall('EDIT',${user.id});">
							<span class="glyphicon glyphicon-edit"></span>
						</button>
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ProfileModal" onClick="AJAXCall('DEL',${user.id});">
							<span class="glyphicon glyphicon-trash"></span>
						</button>
					</div>
				</td>
			</tr>
		</#list>
	</table>
	<#else>
		<strong>No users found.</strong>
  	</#if>
  </div>
</div>

<!-- Modal -->
<div id="ProfileModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" id="modal-title">Please Have Some Patience</h4>
      </div>
      <div class="modal-body">
        <p id="modal-body">We are processing your request. Please maintain some patience. Your patience will be appreciated.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>


<script>
function AJAXCall(action, id){

	jQuery('#modal-title').html("Please Have Some Patience");
	jQuery('#modal-body').html("We are processing your request. Please maintain some patience. Your patience will be appreciated.");
				
	if(action == "GET"){
		endpoint = "/getUser?id="+id;
	}else if(action == "DEL"){
		endpoint = "/deleteUser?id="+id;
	}else if(action == "EDIT"){
		endpoint = "/editUser?id="+id;
	}
	
	jQuery.ajax({
		type: "GET",
		url: endpoint,
		cache: false,
		success: function(res){
			if(action == "DEL" && res == true){
				jQuery('#modal-title').html("Request Status");
				jQuery('#modal-body').html("Deleted Successfully");
			}else if(action == "GET"){
				jQuery('#modal-title').html((res.firstname) +" " + (res.lastname));
				jQuery('#modal-body').html("This is " + (res.firstname) +" joined with the mail id " + (res.email));
			}else{
				jQuery('#modal-title').html("Sorry for the inconvenience");
				jQuery('#modal-body').html("Currently, we are not able to fetch the user profile. Please try after sometime. Thanks for your patience.");
			}
		},
		error: function(xhr, textStatus, error){
			jQuery('#modal-title').html("Sorry for the inconvenience");
			jQuery('#modal-body').html("Currently, we are not able to fetch the user profile. Please try after sometime. Thanks for your patience.");
		}
	});
}
</script>