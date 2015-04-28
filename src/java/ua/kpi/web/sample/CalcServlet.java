/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.web.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Александр
 */
@WebServlet(name = "CalcServlet", urlPatterns = {"/CalcServlet"})
public class CalcServlet extends HttpServlet {

    List<String> sss = new ArrayList<>();
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
            out.println("<title>Servlet CalcServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{               
                int a = Integer.parseInt(request.getParameter("a"));
                int b = Integer.parseInt(request.getParameter("b"));
                int result = 0;
//                String[] t = request.getParameterValues("option1");
//                if(t[0].equals("a")) {
//                    sss.clear();
//                }
                String[] s = request.getParameterValues("option");
                for(String ss: s){
                    switch (ss) {
                        case "a1":  
                            out.println("<hr>");
                            result = a + b;
                            out.println("<li> result:" + result + "</li>");
                            sss.add(request.getParameter("a") + " + " + request.getParameter("b") + " = " + result + ";");
                            break;
                        case "a2":
                             out.println("<hr>");
                            result = a - b;
                            out.println("<li> result:" + result+ "</li>");
                            sss.add(request.getParameter("a") + " + " + request.getParameter("b") + " = " + result + ";");
                            break;
                        case "a3":
                             out.println("<hr>");
                            result = a / b;
                            out.println("<li> result:" + result+ "</li>");
                            sss.add(request.getParameter("a") + " + " + request.getParameter("b") + " = " + result + ";");
                            break;
                        case "a4":
                            out.println("<hr>");
                            result = a * b;
                            out.println("<li> result:" + result + "</li>");
                            sss.add(request.getParameter("a") + " + " + request.getParameter("b") + " = " + result + ";");
                            break;
                    }
                }
         
              
            }
            catch(Exception e){e.getStackTrace();}

            out.println("History");

            for(String e: sss) {
                out.println("<br>");
                out.println(e);
            }
            
            
             
            
            
            out.println("<h1>Servlet CalcServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("<a href=\"./input.html\"> LINK</a>");
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
        processRequest(request, response);
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
