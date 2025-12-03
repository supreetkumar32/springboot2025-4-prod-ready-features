package com.weekfour.production_ready_features.prod_ready_features.clients.impl;

import com.weekfour.production_ready_features.prod_ready_features.clients.EmployeeClient;
import com.weekfour.production_ready_features.prod_ready_features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            List<EmployeeDTO> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOList;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
