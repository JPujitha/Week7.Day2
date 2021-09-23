package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {
int maxRetry=2;
int retryCount=0;
	public boolean retry(ITestResult result) {
if (!result.isSuccess()&&maxRetry>retryCount) {
	retryCount++;
	return true;
}
		return false;
	}

}
