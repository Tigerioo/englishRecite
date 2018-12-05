<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Login</title>
    <script type="text/javascript" src="js/jquery-1.6.1.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("#username").focus();
    	});
    	function checkForm(){
    		var name = $("#username").val();
    		if(name.length<=0){
    			$("#msgName").html("username is null");
    			return false;
    		}else{
    			$("#msgName").html("");
    		}
    		var pass = $(".password").val();
    		if(pass.length<=0){
    			$("#msgPass").html("password is null");
    			return false;
    		}else{
    			$("#msgPass").html("");
    		}
    	$.ajax({
    		type:"POST",
    		cache:"false",
    		url:"user.do?method=login",
    		data:"username="+name+"&password="+pass,
    		dataType:"text",
    		error:function(){
    			$("#msg").html("Failed!");
    		},
    		success:function(message){
    			$("#table").hide();
    			$("#msg").html(message);
    		}
    	});
    	return false;
    	}
    </script>
</head>
<body>
	  <form action="" method="post" onSubmit="return checkForm()">  
	  	<span id="msg" style="color: red"></span>  
            <table width="388" border="0" cellpadding="0" cellspacing="0" id="table">  
                <tr>  
                    <td width="92">  
                        username:  
                    </td>  
                    <td width="280">  
                        <input type="text" name="username" id="username">  
                        <span id="msgName" style="color: red"></span>  
                    </td>  
                </tr>  
                <tr>  
                    <td>  
                        password:  
                    </td>  
                    <td>  
                        <input type="password" name="password" id="password"  
                            class="password">  
                        <span id="msgPass" style="color: red"></span>  
                    </td>  
                </tr>  
                <tr>  
                    <td colspan="2">  
                        <input type="submit" name="button" id="submit" value="submit">  
                    </td>  
                </tr>  
            </table>  
        </form> 
</body>
</html>

