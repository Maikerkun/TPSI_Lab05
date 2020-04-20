/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maikeru
 */
@WebServlet(name = "StudentListServlet", urlPatterns = {"/studentList"})
public class StudentListServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        List<Student> studenci = new ArrayList<>();
        
        Student s1 = new Student("Jan", "Kowalski", "jan.kowalski@poczta.pl");
        Student s2 = new Student("Piotr", "Nowak", "piotr.nowak@poczta.pl");
        Student s3 = new Student("Michał", "Drelich", "michal.drelich@poczta.pl");
        Student s4 = new Student("Kacper", "Kowalik", "kacper.kowalik@poczta.pl");
        
        studenci.add(s1);
        studenci.add(s2);
        studenci.add(s3);
        studenci.add(s4);
      
        session.setAttribute("lista_studentow", studenci);
        //session.setAttribute("nowy", nowy_student);
        
        request.getRequestDispatcher("studentList.jsp").forward(request, response);
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
        
        HttpSession session = request.getSession();
        
        String imie = request.getParameter("s_imie");
        String nazwisko = request.getParameter("s_nazwisko");
        String email = request.getParameter("s_email");
        
        Student nowy_student = new Student(imie, nazwisko, email);
        
        List<Student> studenci= (List<Student>)session.getAttribute("lista_studentow");
        
        studenci.add(nowy_student);
        session.setAttribute("lista_studentow", studenci);
        request.setAttribute("nowe_imie", imie);
        request.getRequestDispatcher("studentList.jsp").forward(request, response);
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
