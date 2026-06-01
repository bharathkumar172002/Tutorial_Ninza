package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

		System.out.println(
		"Test Execution Started ");
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println(
		"Executing Test : "
		+ result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println(
		"Test Passed : "
		+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println(
		"Test Failed : "
		+ result.getName());

		System.out.println(
		"Failure Reason : "
		+ result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println(
		"Test Skipped : "
		+ result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println(
		"Test Execution Completed ");
	}
}