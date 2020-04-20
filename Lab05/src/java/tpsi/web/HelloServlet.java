package tpsi.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    private int counter = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        counter++;
        session.setAttribute("licznik", counter);

        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String email = request.getParameter("email");
        
        Person osoba = new Person(imie, nazwisko, email);
        
        request.setAttribute("osoba", osoba);
        
        
        
        List<String> dni = new ArrayList<>();
        dni.add("Poniedziałek");
        dni.add("Wtorek");
        dni.add("Środa");
        dni.add("Czwartek");
        dni.add("Piątek");
        
        request.setAttribute("dniTygodnia", dni);
        
        request.getRequestDispatcher("hello.jsp").forward(request, response);
        
    }
}