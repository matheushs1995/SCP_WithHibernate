<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Campus</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
         <script language="Javascript">
            function validarFormulario(form) {
                if (form.txtNumeroRegistroCampus.value == "" || form.txtNomeCampus.value == "") {
                    alert("Formulário Incompleto, preencha todos os Campos...");
                    
                    return false; 
                } else {
                    return true; 
                }
                
            }
        </script>
    </head>
    <body>
        <h1>Manter Campus - ${operacao}</h1>
        <form action="ManterCampusController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterCampus" onSubmit="return validarFormulario(this)">

            <table>
                <td>Numero do Registro do Campus </td>
                <td><input type="number" name="txtNumeroRegistroCampus" value="${campus.numeroRegistroCampus}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td></tr>

                    <td>Nome do Campus </td>
                    <td><input type="text" name="txtNomeCampus" value="${campus.nomeCampus}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

            </table>
            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>
