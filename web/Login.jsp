<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPC - MENU</title>

        <style>
            body{
                background-color: #dddddd;
            }



            h2{
                text-align: center;
            }

            legend{


                font-family: fantasy;
                font-size: 30px;

            }

            #menu{
                position: absolute;
                left:450px;
                top: 150px;


                border-radius: 10px;
                font-family: sans-serif;
            }
            #text{
                position: absolute;
                background-color: #eeeeee;
                left: 400px;
                top:120px;
                height: 400px;
                width: 400px;
                border-radius: 30px;
            }
            a{
                font-size: 20px;
            }
            #menu2{
                position: absolute;
                left:450px;
                top: 550px;


                border-radius: 10px;
                font-family: sans-serif;
            }

        </style>
    </head>
    <body>
        <div>
            <h2>Login</h2>
            <div id="text"></div>
            <div id="menu">
                <br/><br/><br/><br/><br/>
                
             <form action="ManterLoginController?acao=confirmarOperacao&operacao=login" 
              method="post"  onSubmit=" return validarFormulario(this)">
                
                <table>
                    
                        <tr>
                            <td>Login:</td>
                            <td><input type="text" name="txtLogin"></td>
                        </tr>
                        <tr>
                            <td>Senha:</td>
                            <td><input type="password" name="txtPass"></td>
                        </tr>
                    
                </table>
                 
                             <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
            <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </form>
            </div>
            


        </div>
    </body>
</html>
