package fr.training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("execution(* fr.training.spring..*(..))")
	private void developerIsDoingSomething() { }

	@Before("developerIsDoingSomething()")
	public void log(JoinPoint jp) {
		StringBuilder toLog = new StringBuilder("logging ").append(jp.getSignature().toLongString())
				.append(" with args: [");
		Object[] args = jp.getArgs();
		for (Object arg : args) {
			toLog.append(arg).append(", ");
		}
		toLog.append("]");
		LOGGER.info(toLog.toString());
	}

	@Around("developerIsDoingSomething()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		LOGGER.info("Method "+ pjp.getSignature().getName() + " execution time: " + elapsedTime + " milliseconds.");
		return output;
	}
}
