/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.FilmeBean;
import model.dao.FilmesDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "SakilaController", urlPatterns = {"/SakilaController","/sakila","/NovoFilme","/editar"})
public class SakilaController extends HttpServlet {

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
            throws ServletException, IOException {
 
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
        String paginaAtual = request.getServletPath();
        System.out.println(paginaAtual);
          FilmesDAO dao = new FilmesDAO();
         
        if(paginaAtual.equals("/sakila")){
             FilmeBean bean = new FilmeBean();
            
            List<FilmeBean> filmes = dao.ler();
            
            
             request.setAttribute("lista", filmes);
            
            request.getRequestDispatcher("/WEB-INF/jsp/sakila.jsp").forward(request, response);
        
        } else if(paginaAtual.equals("/NovoFilme")){
            
            request.getRequestDispatcher("/WEB-INF/jsp/NovoFilme.jsp").forward(request, response);
        
        } else if(paginaAtual.equals("/editar")){
            
            int id = Integer.parseInt(request.getParameter("filme"));
                FilmeBean filmeAtual = dao.selecionarFilme(id);
                request.setAttribute("titulo",filmeAtual.getTitle());
                request.setAttribute("descricao",filmeAtual.getDescription());
                request.setAttribute("ano",filmeAtual.getRelease_year());
                
            request.getRequestDispatcher("/WEB-INF/jsp/editar.jsp").forward(request, response);
            
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
        FilmeBean bean = new FilmeBean();
        FilmesDAO dao = new FilmesDAO();
            String paginaAtual = request.getServletPath();
        
          if(paginaAtual.equals("/NovoFilme")) {

            bean.setTitle(request.getParameter("titulo")); /*PEGA OS VALORES DOS INPUTS E PASSA PARA A VARIAVEL PRESENTE NO BEAN*/
            bean.setDescription(request.getParameter("descricao"));
            bean.setRelease_year(Integer.parseInt(request.getParameter("ano")));
            
                dao.InserirFilme(bean);
            
           response.sendRedirect("./sakila");
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
