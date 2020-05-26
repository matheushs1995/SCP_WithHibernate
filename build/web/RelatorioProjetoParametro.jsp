<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>

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
            <h2></h2>
            <div id="text"></div>
            <div id="menu">
                <div class="formulario-conteudo">

                    <form action="RelatorioProjetoParametroController" method="post">
                        <table>
                            <tr><h4>Relatorio Projeto</h4></tr>
                            <tr>Selecione a Área de Conhecimento:</tr>
                        </table>  
                        <select class="formulario-campo" name="txtarea">
                            <c:forEach items="${areasConhecimento}" var="area"> 
                                <option value="${area.numeroRegistroAreaConhecimento}">${area.nome}</option>  
                            </c:forEach> 
                        </select>

                        <input type="submit" class="botao botao-fixo" value="Confirmar"><br />
                        <input type="button" class="botao botao-fixo flutuar-d" value="home" onclick="javascript: location.href = 'index.jsp';">

                    </form>

                </div>


            </div>


        </div>
    </body>
</html>
