package com.example.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	@SuppressWarnings("removal")
	@DataProvider(name = "test1")
	public Object[][] createdata1() {
		return new Object[][] { { "hello", 12 }, { "hi", 23 } };
	}

	@Test(dataProvider = "test1")
	public void verifyData1(String n1, Integer n2) {
		System.out.println(n1 + " " + n2);
	}
}