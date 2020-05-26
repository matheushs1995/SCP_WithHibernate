<%-- 
    Document   : home
    Created on : 04/12/2014, 22:33:43
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop Halffree </title>
        
        <style>
            body{
                background-color: #ffffff;
                width: 1200px;
            }
            #barraTopo{
                background-color: #ffffff;
                position: absolute;
                width: 1200px;
                height: 100px;
                left:0px;
                top: 0px;
                
                
            }
            #menu{
                background-color: #DfDfDf;
                position: absolute;
                width: 1130px;
                height: 50px;
                left:10px;
                top: 100px;
                border-radius: 10px
            }
            #login{
                position: absolute;
                left: 1000px;
                top: 20px;
                height:30px;
            }
            #cadastrar{
                position: absolute;
                left: 1005px;
                top: 50px;
                
            }
            #home{
                position: absolute;
                left: 100px;
                top: 5px;
                height: 40px;
                    
            }
            #carrinho{
                position: absolute;
                left: 280px;
                top: 5px;
                height: 40px;
            }
            #reclama{
                position: absolute;
                left: 490px;
                top: 5px;
                height: 40px;
            }
            
            #baLateral{
                background-color: #DfDfDf;
                position: absolute;
                width: 140px;
                height: 900px;
                left:995px;
                top: 170px;
                border-radius: 10px
            }
            #marcas{
                position: absolute;
                left:10px;
                top:10px;
                height: 40px;
            }
            #central{
                position: absolute;
                left:70px;
                top:270px;
                height: 40px; 
            }
            #h1-1{
                position: absolute;
                left:40px;
                top:200px;
                height: 40px;
            }
            
            #btb{
                position: absolute;
                left:400px;
                top:1000px;
                 
            }
            #bta{
                position: absolute;
                left:180px;
                top:700px;
                 
            }
            #cad{
               position: absolute;
                left:300px;
                top:250px; 
               
            }
            
            
        </style>
        
    </head>
    <body>
        <div id="barraTopo">
            <img src="simbol.jpg" height="100px">
            <a href="login.jsp"><img id="login" src="login.jpg" ></a>
            <a id="cadastrar" href="cadastrarCliente.jsp">cadastre-se já</a>
        </div>
        <div id="menu">
            <a href="Produto.jsp"><img src="home.jpg" name="menuLink" id="home"></a>
            <a href=""><img src="carrinho.jpg" name="menuLink" id="carrinho"></a>
            <a href=""><img src="reclama.jpg" name="menuLink" id="reclama"></a>
        </div>
        <div id="baLateral">
            <a href=""><img src="marcas.jpg" name="menuLink" id="marcas"></a>
            
        </div>
        
        <div>
            <h1>Cadastrado feito com Sucesso</h1>
        </div>
             
    </body>
</html>
