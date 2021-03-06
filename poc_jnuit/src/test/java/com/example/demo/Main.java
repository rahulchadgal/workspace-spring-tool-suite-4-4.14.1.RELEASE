package com.example.demo;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Main extends ParentClass {

	public Main() {
		System.out.println("testclass - inside constructor()");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("testclass - inside beforeClass()");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("testclass - inside afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("testclass - inside beforeMethod()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("testclass - inside afterMethod()");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("testclass - inside beforeTest()");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("testclass - inside afterTest()");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("testclass - inside beforeSuite()");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("testclass - inside afterSuite()");
	}
	
	@Parameters("key")
	@Test(retryAnalyzer = SampleRetryAnalyzer.class)
	public void test(String key) {
		Assert.fail(key);
		System.out.println("testclass - inside test()" +  key);
	}
}

class ParentClass {

	public ParentClass() {
		System.out.println("parentclass - inside constructor()");
	}

	@BeforeClass
	public void parentBeforeClass() {
		System.out.println("parentclass - inside beforeClass()");
	}

	@AfterClass
	public void parentAfterClass() {
		System.out.println("parentclass - inside afterClass()");
	}

	@BeforeMethod
	public void parentBeforeMethod() {
		System.out.println("parentclass - inside beforeMethod()");
	}

	@AfterMethod
	public void parentAfterMethod() {
		System.out.println("parentclass - inside afterMethod()");
	}

	@BeforeTest
	public void parentBeforeTest() {
		System.out.println("parentclass - inside beforeTest()");
	}

	@AfterTest
	public void parentAfterTest() {
		System.out.println("parentclass - inside afterTest()");
	}

	@BeforeSuite
	public void parentBeforeSuite() {
		System.out.println("parentclass - inside beforeSuite()");
	}

	@AfterSuite
	public void parentAfterSuite() {
		System.out.println("parentclass - inside afterSuite()");
	}

}
