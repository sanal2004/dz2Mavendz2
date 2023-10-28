package com.mashtykov;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Optional<Employee> employeeOptional = employeeDAO.getEmployeeByLogin(login);

        if (employeeOptional.isPresent() && employeeOptional.get().getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("employee", employeeOptional.get());
            response.sendRedirect("menu.html");
        } else {
            response.sendRedirect("index.html");         }
    }
}
