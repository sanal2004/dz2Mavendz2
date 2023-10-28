package com.mashtykov;

import java.util.Optional;

public class EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAO();
    public Optional<EmployeeDTO> getEmployee(String login){
        return employeeDAO.getEmployeeByLogin(login).map(it-> new EmployeeDTO(it.getName(), it.getEmail(), it.getAge(), it.getLogin(),it.getPassword()));

    }

}
