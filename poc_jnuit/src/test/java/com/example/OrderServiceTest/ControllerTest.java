package com.example.OrderServiceTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.OrderController;
import com.example.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class ControllerTest {
	
	@Autowired MockMvc mvc;
	@MockBean OrderService service;
	
	
}
