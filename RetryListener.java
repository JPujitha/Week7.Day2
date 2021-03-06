package week7.Day2.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import utils.RetryTest;

public class RetryListener implements IAnnotationTransformer {
	  public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		   annotation.setRetryAnalyzer(utils.RetryTest.class);
		  }


}
