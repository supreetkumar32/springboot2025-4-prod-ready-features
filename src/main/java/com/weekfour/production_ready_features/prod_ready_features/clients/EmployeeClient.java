package com.weekfour.production_ready_features.prod_ready_features.clients;

import com.weekfour.production_ready_features.prod_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
