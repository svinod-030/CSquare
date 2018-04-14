<div class="panel panel-primary">
  <div class="panel-heading">
  	Truss Dimensions
  </div>
  <div class="panel-body">
	<div class="input-group">
	    <span class="input-group-addon">Bay Width</span>
	    <input id="bayWidth" type="text" class="form-control" placeholder="Bay Width">
	
	    <span class="input-group-addon">Truss Height</span>
	    <input id="height" type="text" class="form-control" placeholder="Truss Height">

	    <span class="input-group-addon">No of Bays</span>
	    <input id="noOfBays" type="text" class="form-control" placeholder="No of Bays">

		<span class="input-group-addon">Ready To</span>
	    <input type="button" value="GO" class="form-control btn btn-info" onClick="prepareGrid();">
	</div>
  </div>
  <div class="panel-body">
  	<div class="col-sm-3">
  		Tool Picker
  	</div>
  	<div id="grid" class="col-sm-9">
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  		<div id="inner-cell" class="col-sm-2"></div>
  	</div>
  </div>
</div>

<script>
	function prepareGrid(){
		alert("Please have some patience....... We are preparing grid for you.....");
	}
</script>
<style>
	#grid{
		border:2px solid #000;
		padding:30px 30px 30px 30px;
	}
	#inner-cell{
		position: absolute;
		width: 20%;
		padding-top: 20%;
		box-sizing: border-box;
		position: relative;
		border:1px dotted #000;
	}
</style>