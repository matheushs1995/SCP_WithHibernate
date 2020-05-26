package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.Campus;
import model.Departamento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 
 */
public class ManterDepartamentoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
               
                RequestDispatcher view = request.getRequestDispatcher("/RelatorioDepartamentoParametro.jsp");
                view.forward(request, response);
                
            }
            
            
            
            if (!operacao.equals("Incluir")) {
                int numeroRegistroDepartamento = Integer.parseInt(request.getParameter("numeroRegistroDepartamento"));
                
                
                
                Departamento departamento = Departamento.obterDepartamento(numeroRegistroDepartamento);
                request.setAttribute("departamento", departamento);
                
                Campus campus=Campus.obterCampus(departamento.getCampus().getNumeroRegistroCampus());
                request.setAttribute("camp", campus);
            }

            RequestDispatcher view = request.getRequestDispatcher("/ManterDepartamento.jsp");
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

        int numeroRegistroDepartamento = Integer.parseInt(request.getParameter("txtNumeroRegistroDepartamento"));
        String nomeDepartamento = request.getParameter("txtNomeDepartamento");

        try {
            Campus campus = null;
            if (numeroRegistroCampus != 0) {
            
                campus = Campus.obterCampus(numeroRegistroCampus);
                
            }

            Departamento departamento = new Departamento(numeroRegistroDepartamento, nomeDepartamento, campus);
           
            
            if (operacao.equals("Incluir")) {
                departamento.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    departamento.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        departamento.excluir();
                    }
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisarDepartamentoController");
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
            Logger.getLogger(ManterDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
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
