package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class DemoListeners implements ITestListener, ISuiteListener {

	public void onFinish(ITestContext res) {
		Reporter.log(res.getName() + " is Finished", true);
	}

	public void onStart(ITestContext res) {
		Reporter.log(res.getName() + " is Started", true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult res) {
		Reporter.log(res.getName() + " is Failed", true);
	}

	public void onTestSkipped(ITestResult res) {
		Reporter.log(res.getName() + " is Skipped", true);
	}

	public void onTestStart(ITestResult res) {
		Reporter.log(res.getName() + " is Started", true);
	}

	public void onTestSuccess(ITestResult res) {
		Reporter.log(res.getName() + " is Success", true);
	}

	public void onStart(ISuite res) {
		Reporter.log(res.getName() + " is Started", true);
	}

	public void onFinish(ISuite res) {
		Reporter.log(res.getName() + " is Finished", true);
		
	}
}
