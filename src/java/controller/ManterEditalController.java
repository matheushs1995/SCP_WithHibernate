/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Campus;
import model.Edital;


public class ManterEditalController extends HttpServlet {
    private String implementacao;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);

            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("campi", Campus.obterCampi());
            
            if (operacao.equals("relat")){
                
                RequestDispatcher view = request.getRequestDispatcher("/RelatorioEditalParametro.jsp");
                view.forward(request, response);
                
            } 
            
            if (!operacao.equals("Incluir")) {
                int numeroRegistroEdital = Integer.parseInt(request.getParameter("numeroRegistroEdital"));
                Edital edital = Edital.obterEdital(numeroRegistroEdital);
                request.setAttribute("edital", edital);
                
                Campus campus=Campus.obterCampus(edital.getCampus().getNumeroRegistroCampus());
                request.setAttribute("camp", campus);
            }
            
            
             
            RequestDispatcher view = request.getRequestDispatcher("/ManterEdital.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {

            throw new ServletException(e);
        }

    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ServletException, IOException, SQLException, ClassNotFoundException {

        String operacao = request.getParameter("operacao");
        int numeroRegistroCampus = Integer.parseInt(request.getParameter("optCampus"));
        int numeroRegistroEdital = Integer.parseInt(request.getParameter("txtNumeroRegistroEdital"));
        String dataInicio = request.getParameter("txtDataInicio");
        String dataTermino = request.getParameter("txtDataTermino");
        String vagas = request.getParameter("txtVagas");
        String nomeEdital = request.getParameter("txtNomeEdital");
        
        
        
        if(request.getParameter("optimplementacao").equals("sim")){
            implementacao="1";
        }else{
            implementacao="0";
        }
        
        
        try {

            Campus campus = null;
            if (numeroRegistroCampus != 0) {
                campus = Campus.obterCampus(numeroRegistroCampus);
            }

            Edital edital = new Edital(numeroRegistroEdital, dataInicio, dataTermino, vagas, nomeEdital, implementacao, campus);
            
            if (operacao.equals("Incluir")) {
                edital.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    edital.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        edital.excluir();
                    }
                }
            }

            RequestDispatcher view
                    = request.getRequestDispatcher("PesquisarEditalController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw new ServletException(e);
        }
    }
       // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEditalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEditalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEditalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEditalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
