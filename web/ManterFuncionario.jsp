<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Funcionario</title>

        <style>
            body{
                background-color: #dddddd;
            }
        </style>
        <script language="Javascript">
            function validarFormulario(form) {

                if (form.txtNumeroRegistroFuncionario.value == "" || form.txtCargo.value == "" || form.txtCpf.value == "" || form.txtNomeCompleto.value == "" || form.txtEndereco.value == "" || form.txtLogin.value == "" || form.txtSenha.value == ""
                        || form.txtNaturalidade.value == "" || form.txtNacionalidade.value == "" || form.txtRg.value == ""
                        || form.txtOrgaoExpedidor.value == "" || form.txtUfrg.value == "" || form.txtDataNascimento.value == "") {
                    alert("Formulário Incompleto, preencha todos os Campos Obrigatórios...");

                    return false;
                }
                else {
                    return true;
                }

            }
        </script>
    </head>
    <body>
        <h1>Manter Funcionario- ${operacao}</h1>                                              <p>*Campos Obrigatórios</p>
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterFuncionario" onSubmit="return validarFormulario(this)">

            <table>
                <tr>
                    <td >*Cpf:</td>
                    <td><input type="number" name="txtCpf" value="${usuario.cpf}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>

                    </tr>    
                    <tr>
                        <td>*Número de registro do funcionário </td>
                        <td><input type="number" name="txtNumeroRegistroFuncionario" value="${funcionario.numeroRegistroFuncionario}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr><td colspan="1">*Nome: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNomeCompleto" value="${usuario.nomeCompleto}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>
                    <tr><td colspan="1">*RG: </td>
                        <td colspan="3"><input type="text" size="59" name="txtRg" value="${usuario.rg}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>
                    <tr><td colspan="1">*UFRG: </td>
                        <td colspan="3"><input type="text" size="59" name="txtUfrg" value="${usuario.ufrg}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>
                    <tr><td colspan="1">*Orgao Expedidor: </td>
                        <td colspan="3"><input type="text" size="59" name="txtOrgaoExpedidor" value="${usuario.orgaoExpedidor}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">*Data Nascimento: </td>
                        <td colspan="3"><input type="date" size="59" name="txtDataNascimento" value="${usuario.dataNascimento}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
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

                    <tr><td colspan="1">*Naturalidade: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNaturalidade" value="${usuario.naturalidade}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">*Nacionalidade: </td>
                        <td colspan="3"><input type="text" size="59" name="txtNacionalidade" value="${usuario.nacionalidade}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>



                    <tr>
                        <td>*Cargo </td>
                        <td><input type="text" name="txtCargo" value="${funcionario.cargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr><td colspan="1">*Login: </td>
                        <td colspan="3"><input type="text" size="59" name="txtLogin" value="${usuario.login}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">*Senha: </td>
                        <td colspan="3"><input type="password" size="59" name="txtSenha" value="${usuario.senha}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                    </tr>

                    <tr><td colspan="1">Email: </td>
                        <td colspan="3"><input type="email" size="59" name="txtEmail" value="${usuario.email}" <c:if test="${operacao =='Excluir'}"> readonly=""</c:if>></td>
                </tr>
            </table>



            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
            <tr><td><input type="button"  onClick="parent.location.href = 'index.jsp'"value="   Home    "></td> </tr>
        </form>
    </body>
</html>
