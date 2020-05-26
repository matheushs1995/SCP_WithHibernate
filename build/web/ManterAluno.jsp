<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Aluno</title>
        <style>
            body{
                background-color: #dddddd;
            }
         </style>
         <script language="Javascript">
            function validarFormulario(form) {
                if (form.txtCpf.value == "" || form.txtNomeCompleto.value == "" || form.txtNumeroRegistroAluno.value == "" || form.txtNomeBanco.value == "" || form.txtAgencia.value == "" || form.txtNumeroConta.value == ""
                       || form.txtEndereco.value == ""  || form.txtLogin.value == "" || form.txtSenha.value == "" 
                       || form.txtNaturalidade.value == "" || form.txtNacionalidade.value == "" || form.txtRg.value == ""
                       || form.txtOrgaoExpedidor.value == "" || form.txtUfrg.value == "" || form.txtDataNascimento.value == "" ) {
                    alert("Formulário Incompleto, preencha todos os Campos Obrigatórios...");
                    
                    return false; 
                } else {
                    return true; 
                }
                
            }
        </script>
    </head>
    <body>
        <h1>Manter Aluno - ${operacao}</h1>
        <form action="ManterAlunoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterAluno" onSubmit=" return validarFormulario(this)">

            <table>
                <tr><td colspan="2">Dados Pessoais:</td></tr>                                  <p>*Campos Obrigatórios</p>

                <tr>
                    <td>*CPF Usuario:</td>
                    <td><input type="number" name="txtCpf" value="${usuario.cpf}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td colspan="1">*Nome: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNomeCompleto" value="${usuario.nomeCompleto}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr>
                        <td>*Curso: </td>
                        <td> <select name="optCurso">
                            <c:forEach items="${cursos}" var="cur"> 
                                <option value="${cur.numeroRegistroCurso}" <c:if test="${ curso.numeroRegistroCurso ==cur.numeroRegistroCurso }"> selected</c:if>>${cur.nomeCurso}</option>  
                            </c:forEach> </select></td> </tr>



               <tr>     
                <td>*Número de registro do aluno: </td>
                <td><input type="number" name="txtNumeroRegistroAluno" value="${aluno.numeroRegistroAluno}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>

                <tr>
                    <td>*Nome do banco: </td>
                    <td><input type="text" name="txtNomeBanco" value="${aluno.nomeBanco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr>
                    <td>*Agência bancária </td>
                    <td><input type="text" name="txtAgencia" value="${aluno.agencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Número da conta: </td>
                    <td><input type="text" name="txtNumeroConta" value="${aluno.numeroConta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr>
                    <td> Dados do responsável: </td>
                    <td><input type="text" name="txtDadosResponsavel" value="${aluno.dadosResponsavel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Estado: </td>
                    <td><input type="text" name="txtEstado" value="${usuario.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Cidade: </td>
                    <td><input type="text" name="txtCidade" value="${usuario.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*bairro: </td>
                    <td><input type="text" name="txtBairro" value="${usuario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>*rua: </td>
                    <td><input type="text" name="txtRua" value="${usuario.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>*numero: </td>
                    <td><input type="text" name="txtNumero" value="${usuario.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>*complemento: </td>
                    <td><input type="text" name="txtComplemento" value="${usuario.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                
                <tr>
                    <td>*Login: </td>
                    <td><input type="text" name="txtLogin" value="${usuario.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Senha: </td>
                    <td><input type="password" name="txtSenha" value="${usuario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Naturalidade: </td>
                    <td><input type="text" name="txtNaturalidade" value="${usuario.naturalidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Nacionalidade: </td>
                    <td><input type="text" name="txtNacionalidade" value="${usuario.nacionalidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*RG: </td>
                    <td><input type="text" name="txtRg" value="${usuario.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Orgao Expedidor: </td>
                    <td><input type="text" name="txtOrgaoExpedidor" value="${usuario.orgaoExpedidor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*UFRG: </td>
                    <td><input type="text" name="txtUfrg" value="${usuario.ufrg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td>*Data Nascimento: </td>
                    <td><input type="date" name="txtDataNascimento" value="${usuario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                    <td> Email: </td>
                    <td><input type="email" name="txtEmail" value="${usuario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                
                

            </table>



            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
            <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
        </form>
    </body>
</html>
