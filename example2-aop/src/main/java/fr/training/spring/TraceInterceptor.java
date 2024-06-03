package fr.training.spring;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author par bnasslahsen
 */
public class TraceInterceptor implements MethodInterceptor, Serializable {

	/**
	 * @see MethodInterceptor#invoke(MethodInvocation)
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		System.out.println("ENTERING " + methodName + "()");
		long start = System.currentTimeMillis();
		Object rval = invocation.proceed();
		System.out.println("Duration of the method = " + (System.currentTimeMillis() - start) + " ms");
		System.out.println("EXITING " + methodName + "()");
		return rval;
	}
}