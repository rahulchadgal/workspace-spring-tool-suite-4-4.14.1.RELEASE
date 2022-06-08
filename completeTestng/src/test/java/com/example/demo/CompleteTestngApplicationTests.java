package com.example.demo;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testng.annotations.Test;
//import org.springframework.http.MediaType;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class CompleteTestngApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ObjectMapper objectMapper;
/*
	 @Test
	    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{

	        // given - precondition or setup
	        Employee employee = Employee.builder()
	                .firstName("Ramesh")
	                .lastName("Fadatare")
	                .email("ramesh@gmail.com")
	                .build();
	        given(employeeService.saveEmployee(any(Employee.class)))
	                .willAnswer((invocation)-> invocation.getArgument(0));

	        // when - action or behaviour that we are going test
	        ResultActions response = mockMvc.perform(post("/api/employees")
	            .content(objectMapper.writeValueAsString(employee)));
	        
	        response.andDo(print()).
	                andExpect(status().isCreated())
	                .andExpect(jsonPath("$.firstName",
	                        is(employee.getFirstName())))
	                .andExpect(jsonPath("$.lastName",
	                        is(employee.getLastName())))
	                .andExpect(jsonPath("$.email",
	                        is(employee.getEmail())));

	    }*/

	    // JUnit test for Get All employees REST API
	    @Test
	    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception{
	        // given - precondition or setup
	        List<Employee> listOfEmployees = new ArrayList<>();
	        listOfEmployees.add(Employee.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build());
	        listOfEmployees.add(Employee.builder().firstName("Tony").lastName("Stark").email("tony@gmail.com").build());
	        given(employeeService.getAllEmployees()).willReturn(listOfEmployees);

	        // when -  action or the behaviour that we are going test
	        ResultActions response = mockMvc.perform(get("/api/employees"));

	        // then - verify the output
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.size()",
	                        is(listOfEmployees.size())));

	    }
	@Test
	public void GetApiCheck() throws Exception{
		List<Employee> employeeList =new ArrayList<>();
		employeeList.add(Employee.builder().firstName("hello").lastName("check").email("zyx@gmail.com").build());
		employeeList.add(Employee.builder().firstName("hello1").lastName("check1").email("zyx1@gmail.com").build());
		
		given(employeeService.getAllEmployees()).willReturn(employeeList);
		
		ResultActions response = mockMvc.perform(get("/api/employees"));
		
		  response.andExpect(status().isOk())
          .andDo(print())
          .andExpect(jsonPath("$.size()",
                  is(employeeList.size())));
	}
	

}
