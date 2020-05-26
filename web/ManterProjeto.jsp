<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Projeto</title>
        <style>
            body{
                background-color: #dddddd;
            }
        </style>
        <script language="Javascript">
            function validarFormulario(form) {
            if (form.txtNumeroRegistroProjeto.value == "" || form.txtNomeProjeto.value == "" || form.txtResultadoEsperado.value == "" || form.txtImplementacao.value == "" || form.txtDataInicio.value == "" || form.txtDataTermino.value == "" || form.txtRenovacao.value == "" || form.txtCargaHorariaSemanal.value == "" || form.txtJustificativaProblema.value == "" || form.txtReferencialTeorico.value == "" || form.txtObjetivo.value == "" || form.txtMetodologia.value == "" || form.txtCronograma.value == "" || form.txtOrcamento.value == "" || form.txtReferenciaBibliografica.value == "") {
            alert("Formulário Incompleto, preencha todos os Campos...");
                    return false;
            } else {

            return true;
            }

            }


        </script>

    </head>
    <body>
        <h1>Manter Projeto - ${operacao}</h1>
        <form action="ManterProjetoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterProjeto" onSubmit=" return validarFormulario(this)">

            <table>
                <tr>
                    <td>Professor: </td>
                    <td> <select name="optProfessor">
                            <c:forEach items="${professores}" var="professor" >
                                <option value="${professor.numeroRegistroProfessor}" <c:if test="${professor.numeroRegistroProfessor ==pro.numeroRegistroProfessor}"> selected</c:if>>${professor.numeroRegistroProfessor}</option>  
                            </c:forEach> </select></td> </tr>


                <tr>    
                    <td>Edital: </td>
                    <td> <select name="optEdital">
                            <c:forEach items="${editais}" var="edital"> 
                                <option value="${edital.numeroRegistroEdital}" <c:if test="${edital.numeroRegistroEdital ==edit.numeroRegistroEdital}"> selected</c:if>>${edital.numeroRegistroEdital}</option>  
                            </c:forEach> </select></td> </tr>

                <tr>        
                    <td>Area Conhecimento: </td>
                    <td> <select name="optAreaConhecimento">
                            <c:forEach items="${areasConhecimento}" var="area"> 
                                <option value="${area.numeroRegistroAreaConhecimento}" <c:if test="${area.numeroRegistroAreaConhecimento ==ar.numeroRegistroAreaConhecimento}"> selected</c:if>>${area.nome}</option>  
                            </c:forEach> </select></td> </tr>        



                <tr>
                    <td>Numero do Registro do Projeto: </td>
                    <td><input type="number" name="txtNumeroRegistroProjeto" value="${projeto.numeroRegistroProjeto}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td></tr>

                    <tr><td>Nome do Projeto: </td>
                        <td><input type="text" name="txtNomeProjeto" value="${projeto.nomeProjeto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Implementacao: </td>
                        <td><input type="number" name="txtImplementacao" value="${projeto.implementacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Data Inicio: </td>
                        <td><input type="date" name="txtDataInicio" value="${projeto.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Data Termino: </td>
                        <td><input type="date" name="txtDataTermino" value="${projeto.dataTermino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>renovacao: </td>
                        <td><input type="text" name="txtRenovacao" value="${projeto.renovacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Carga Horaria: </td>
                        <td><input type="text" name="txtCargaHorariaSemanal" value="${projeto.cargaHorariaSemanal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Justificativa do problema: </td>
                        <td><input type="text" name="txtJustificativaProblema" value="${projeto.justificativaProblema}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Referencial Teorico </td>
                        <td><input type="text" name="txtReferencialTeorico" value="${projeto.referencialTeorico}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Objetivo: </td>
                        <td><input type="text" name="txtObjetivo" value="${projeto.objetivo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Metodologia: </td>
                        <td><input type="text" name="txtMetodologia" value="${projeto.metodologia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Resultado Esperado: </td>
                        <td><input type="text" name="txtResultadoEsperado" value="${projeto.resultadoEsperado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Cronograma: </td>
                        <td><input type="text" name="txtCronograma" value="${projeto.cronograma}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Orcamento: </td>
                        <td><input type="text" name="txtOrcamento" value="${projeto.orcamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    <tr><td>Referencial Bibliografico: </td>
                        <td><input type="text" name="txtReferenciaBibliografica" value="${projeto.referenciaBibliografica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

            </table>

            <table>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
            </table>
        </form>
    </body>
</html>