package com.weekfour.production_ready_features.prod_ready_features;

import com.weekfour.production_ready_features.prod_ready_features.clients.EmployeeClient;
import com.weekfour.production_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

	@Test
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO=employeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}

	@Test
	void createNewEmployeeTest() {
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "supreet", "sup@gmail.com", 2,
				"USER", 5000.0, LocalDate.of(2020, 12, 1), true);
		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}

}
