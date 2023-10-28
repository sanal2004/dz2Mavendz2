package com.mashtykov;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        if (employee != null) {
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Личный кабинет</title></head><body>");
            out.println("<h1>Личный кабинет</h1>");
            out.println("Имя: " + employee.getName() + "<br>");
            out.println("Возраст: " + employee.getAge() + "<br>");
            out.println("Email: " + employee.getEmail() + "<br>");
            out.println("Логин: " + employee.getLogin() + "<br>");
            out.println("Пароль: " + employee.getPassword() + "<br>");
            out.println("<form action=\"UpdateEmployeeServlet\" method=\"post\">");
            out.println("Изменить пароль: <input type=\"password\" name=\"newPassword\"><br>");
            out.println("<input type=\"submit\" value=\"Сохранить\">");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            response.sendRedirect("index.html"); // Редирект, если пользователь не аутентифицирован
        }
    }
}
