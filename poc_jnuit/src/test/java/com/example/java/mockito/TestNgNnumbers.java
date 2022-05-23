package com.example.java.mockito;

import static org.testng.Assert.assertEquals;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgNnumbers {
	
	private CreateNumber createnumber;
	
	@BeforeClass
	public void init() {
		createnumber = Mockito.mock(CreateNumber.class);
	}
	
	@Test
	public void TestNg() {
		int expected =100;
		Mockito.when(createnumber.getThreeDigitNumber()).thenReturn(expected);
		
		int actual = createnumber.getThreeDigitNumber();
		
		Assert.assertEquals(actual,expected);
		
	}

}
