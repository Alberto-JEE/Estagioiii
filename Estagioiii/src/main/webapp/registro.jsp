

<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>        
        <link rel="stylesheet" href="css/style1.css">  
        <script type="text/javascript" src="js/index.js"> </script>
    </head>
    <body>
        <div class="wrapper">
            <div class="container">                
                <form name="form" method="post" action="Registrar" onsubmit="return validar();">
                    <h1>Cadastro</h1>
                    <p>&nbsp;</p>
                    <input type="text" name="Username" id="Username" placeholder="Nome">
                    <input type="text" name="Loginname" id="Loginname" placeholder="Nome de Login">
                    <input type="text" name="Email" id="Email" placeholder="Email : exemplo@gmail.com">
                    <input type="password" name="Password" id="Password" placeholder="senha">
                    <input type="password" name="Password2" id="Password2" placeholder="senha">
                    <button type="submit"  id="login-button" >Enviar</button>
                </form>
            </div>
        </div>
    </body>
</html>
