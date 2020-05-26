<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Edital</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
         <script language="Javascript">
            function validarFormulario(form) {
                if (form.txtNumeroRegistroEdital.value == "" || form.txtDataInicio.value == "" || form.txtDataTermino.value == "" || form.txtVagas.value == "" || form.txtNomeEdital.value == "") {
                    alert("Formulário Incompleto, preencha todos os Campos...");
                    
                    return false; 
                } else {
                    
                    if(parseInt(form.txtVagas.value)>3){
                        alert("Número máximo de vagas = 3");
                        return false;
                        
                    }
                    
                    return true; 
                }
                
            }
        </script>
    </head>
    <body>
        <h1>Manter Edital - ${operacao}</h1>
        <form action="ManterEditalController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterEdital" onSubmit="return validarFormulario(this)">

            <table>
                <tr>
                    <td>Campus: </td>
                    <td> <select name="optCampus">
                            <c:forEach items="${campi}" var="campus"> 
                                <option value="${campus.numeroRegistroCampus}" <c:if test="${campus.numeroRegistroCampus ==camp.numeroRegistroCampus}"> selected</c:if>>${campus.nomeCampus}</option>  
                            </c:forEach> </select></td> </tr>

            
                <tr>
                    <td>Numero do Registro do Edital </td>
                    <td><input type="number" name="txtNumeroRegistroEdital" value="${edital.numeroRegistroEdital}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td>Data Inicio </td>
                        <td><input type="date" name="txtDataInicio" value="${edital.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td>Data Termino </td>
                        <td><input type="date" name="txtDataTermino" value="${edital.dataTermino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td>Numero de Vagas </td>
                        <td><input type="number" name="txtVagas" value="${edital.vagas}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td>Nome do Edital </td>
                        <td><input type="text" name="txtNomeEdital" value="${edital.nomeEdital}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>implementação: </td>
                        <td> <select name="optimplementacao" >
                                    <option value="sim" <c:if test="${edital.implementacao ==1}"> selected</c:if>>Sim</option>
                                    <option value="nao" <c:if test="${edital.implementacao ==0}"> selected</c:if>>Não</option>
                            </select></td> </tr>


            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>