/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1711j
 */
public class Signup extends HttpServlet {
     @Override
    public void init() throws ServletException {
        System.out.println(" chalo swagat karo hamara!");
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        String fname=(req.getParameter("fname"));
        String lname=(req.getParameter("lname"));
        String email=(req.getParameter("email"));
        String phone=(req.getParameter("phone"));
        String pswd=(req.getParameter("password"));
      String query="insert into signup values('"+fname+"','"+lname+"','"+email+"','"+phone+"','"+pswd+"')";
       SqlUtil.connectDB();
       SqlUtil.insert(query);
       
        PrintWriter out=resp.getWriter();
        out.println("signup sucessfull");
        }
         catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
    }

    @Override
    public void destroy() {
        System.out.println("Achha chalta hu duaaoo mai yaad rakhna!");
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
