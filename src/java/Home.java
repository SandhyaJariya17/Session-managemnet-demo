/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1711j
 */
public class Home extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter out =resp.getWriter();
       HttpSession session=req.getSession(false);
       if(session!=null){
           
       try{
           String email=(String)session.getAttribute("email_session");
           SqlUtil.connectDB();
           String query="select * from signup where email='"+email+"'";
           ResultSet rs=SqlUtil.fetch(query);
           if(rs.next()){
               String fname=rs.getString("fname");
               String lname=rs.getString("lname");
               String phone=rs.getString("phone");
               
               out.println("<h1>welcome"+"  "+fname+"   "+lname+"</h1>");
               out.println("<p>"+phone+"</p>");
               
               out.println("<form action='LogoutServlet'>");
                out.println("<input type='submit' value='logout'>");
                out.println("</form>");
               
               
           }    SqlUtil.close();
       }
           catch(Exception ex){
            System.out.println(ex);
        }
        }
       else{
           out.println("<script>alert('please login first');location.href='login.html';</script>");
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


