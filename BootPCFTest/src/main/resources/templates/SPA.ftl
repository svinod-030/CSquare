<html>
	<head>
		<title>CSquare</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	
		<#include "global/header.ftl"/>
		
		<div class="container">
		  	<#if viewName?has_content>
				<#include viewName/>
			<#else>
				<#include "global/customError.ftl"/>
			</#if>
		</div>
	
		<#include "global/footer.ftl"/>
	</body>
</html>