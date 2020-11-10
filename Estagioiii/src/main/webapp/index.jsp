

<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>  
        <link rel="stylesheet" href="css/style1.css">
        <script type="text/javascript" src="js/index.js" ></script>
    </head>
    <body>
        <div class="wrapper">
            <div class="container">                
                <form name="form1" action="Autenticacao" method="post" onsubmit="return validarLogin();">
                    <h1>Login</h1>
                    <p>&nbsp;</p>
                    <input type="text" name="Username" id="Username" placeholder="Nome Usuário ou email">
                    <input type="password" name="Password" id="Password" placeholder="Senha"> 
                    <button type="submit" id="cadastro" >Login</button>
                </form>
            </div>
        </div> 
    </body>
</html>
