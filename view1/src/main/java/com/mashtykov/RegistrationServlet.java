package com.mashtykov;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Employee newEmployee = new Employee(name, email,age, login, password);

        if (employeeDAO.addEmployee(newEmployee)) {
            response.sendRedirect("index.html"); // Редирект на страницу аутентификации после успешной регистрации
        } else {
            response.sendRedirect("registration.html"); // Редирект в случае ошибки (пользователь с таким логином уже существует)
        }
    }
}
