package de.cologneintelligence.sandbox.customtxm;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kmussawisade on 06.11.15.
 */
@Aspect
public class TransactionAspect {
    private static final Logger LOG = LoggerFactory.getLogger(TransactionAspect.class);

	@Autowired
	private TransactionManager transactionManager;

	public void beginTransaction(JoinPoint joinPoint) {
		LOG.info("######### begin Transaction ##### " + joinPoint.getTarget().toString());
		transactionManager.beginTransaction();
	}

	public void endTransaction(JoinPoint joinPoint) {
		LOG.info("######### end Transaction ####### " + joinPoint.getTarget().toString());
		transactionManager.endTransaction();
	}

	@Around("@annotation(SimpleTransaction)")
	public void aroundTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
		beginTransaction(joinPoint);
		joinPoint.proceed();
		endTransaction(joinPoint);
	}


}
