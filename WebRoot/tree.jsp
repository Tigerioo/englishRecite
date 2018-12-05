<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'tree.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css"
			href="../../resources/css/ext-all.css" />
		<script type="text/javascript" src="../../adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../../ext-all.js"></script>

		<script type="text/javascript"> 
		/************** 
		onload事件 
		***************/ 
		window.onload=function(){ 
		createTree(3); 
		} 
		</script>


	</head>
	<body>
		<script type="text/javascript" src="../shared/examples.js"></script>
		<h1>
			现在要生成一颗动态树
		</h1>
		<div id="container">
		</div>
	</body>
</html>
