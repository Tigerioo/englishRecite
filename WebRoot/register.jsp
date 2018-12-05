<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>Registration Form</title>

	<script type="text/javascript" src="script/ext/ext-all.js"></script>
</head>
<body>

	<form action="user.do?method=add" method="post">  
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
                    <td>  
                        confirm-password:  
                    </td>  
                    <td>  
                        <input type="password" name="password2" id="password2"  
                            class="password2">  
                        <span id="msgPass" style="color: red"></span>  
                    </td>  
                </tr>  
                <tr>  
                    <td colspan="2">  
                        <input type="submit" name="button" id="submit" value="注册">  
                    </td>  
                </tr>  
            </table>  
        </form> 
</body>
</html>
