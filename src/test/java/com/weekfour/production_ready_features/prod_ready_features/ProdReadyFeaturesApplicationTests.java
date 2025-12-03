package com.weekfour.production_ready_features.prod_ready_features;

import com.weekfour.production_ready_features.prod_ready_features.clients.EmployeeClient;
import com.weekfour.production_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	//we hav eto built controller...but for learning purpose we are using tests
	@Test
	void getAllEmployeesTest() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}


}
