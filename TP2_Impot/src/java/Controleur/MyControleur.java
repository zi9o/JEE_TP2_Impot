/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Metier.EmptyText;
import Metier.Impots;
import Metier.NumberError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zakaria
 */
public class MyControleur extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyControleur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyControleur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        String Nom = request.getParameter("Nom");
        String Prenom = request.getParameter("Prenom");
        String NbEnfant = request.getParameter("NbEnfant");
        String Salaire = request.getParameter("Salaire");
        String statut = request.getParameter("marie");
        String variable = null;
        Impots MyManager=new Impots();
        double impot=0;
        try
        {
            if(Nom.equalsIgnoreCase(""))throw new EmptyText(Nom);
            if(Prenom.equalsIgnoreCase(""))throw new EmptyText(Prenom);
            if(statut.equalsIgnoreCase(""))throw new EmptyText(statut);
            variable="Nombre d'enfants";
            int nbEnfant=Integer.parseInt(NbEnfant);
            variable="Salaire";
            double salaire=Double.parseDouble(Salaire);
            impot=MyManager.CalculeImpot(
                    MyManager.GetChamps(MyManager.CalculeQF(MyManager.CalculeNBPARTS(statut, nbEnfant), salaire)),
                    MyManager.CalculeNBPARTS(statut, nbEnfant),
                    salaire);
            request.setAttribute("Impot", impot);
            request.getRequestDispatcher("Resultat.jsp").forward(request, response);
        }
        catch(NumberFormatException ex)
        {
            NumberError numberError = new NumberError(variable);
            request.setAttribute("erreur", numberError.getMessage());
            request.getRequestDispatcher("ErrorNumber.jsp").forward(request, response);
        }
        catch(EmptyText ex)
        {
            request.setAttribute("erreur", ex.getMessage());
            request.getRequestDispatcher("ErrorSaisie.jsp").forward(request, response);
        }
//        Impots ob = new Impots();
//        List<double[]> list = ob.GetDBImpots();
//        System.out.println(" " + (list == null));
//        //construit la requête puis l'envoie à la vue
//        request.setAttribute("liste", list);
//        request.getRequestDispatcher("resultatAll.jsp").forward(request, response);
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
        processRequest(request, response);
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
