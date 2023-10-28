package com.mashtykov;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
    private static List<Employee> employees = new ArrayList<>();

    public Optional<Employee> getEmployeeByLogin(String login) {
        return employees.stream()
                .filter(employee -> employee.getLogin().equals(login))
                .findFirst();
    }

    public boolean addEmployee(Employee employee) {
        if (!getEmployeeByLogin(employee.getLogin()).isPresent()) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    public boolean updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getLogin().equals(updatedEmployee.getLogin())) {
                employees.set(i, updatedEmployee);
                return true;
            }
        }
        return false;
    }

}
