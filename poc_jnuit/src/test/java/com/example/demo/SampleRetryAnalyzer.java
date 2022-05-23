package com.example.demo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class SampleRetryAnalyzer implements IRetryAnalyzer {
	private int retryCount = 0;
	private int maxCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}