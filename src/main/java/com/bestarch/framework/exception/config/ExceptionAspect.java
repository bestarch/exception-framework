package com.bestarch.framework.exception.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.bestarch.framework.exception.EnableExceptionHandler;
import com.bestarch.framework.exception.bean.Response;
import com.bestarch.framework.exception.handler.ComplexHandler;
import com.bestarch.framework.exception.handler.Handler;
import com.bestarch.framework.exception.handler.SimpleHandler;

/**
 * 
 * @author bestarch
 *
 */
@Configuration
@Aspect
public class ExceptionAspect {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ExceptionAspect.class);
	
	@Autowired
	private ApplicationContext context;
	
	@Around(value = "execution(public * *(..)) && target(bean) && @annotation(com.bestarch.framework.exception.EnableExceptionHandler)")
	public Object wrapAround(ProceedingJoinPoint joinPoint, Object bean) throws Throwable  {
		Response response = null;
		try {
			return joinPoint.proceed();
	    } catch (Throwable t) {
	    	LOGGER.info("Received an exception of type {}", t.getClass());
			if (t instanceof Exception) {
				MethodSignature signature = (MethodSignature) joinPoint.getSignature();
				EnableExceptionHandler enableExceptionHandler = signature.getMethod().getAnnotation(EnableExceptionHandler.class);
				Class<? extends Handler> handler = enableExceptionHandler.handler();
				Handler actualhandler = (Handler) context.getBean(StringUtils.uncapitalize(handler.getSimpleName()));
				if (SimpleHandler.class.isAssignableFrom(actualhandler.getClass())) {
					((SimpleHandler) actualhandler).handle((Exception) t);
				} else if (ComplexHandler.class.isAssignableFrom(actualhandler.getClass())) {
					response = new Response(((ComplexHandler<?>) actualhandler).handle((Exception) t), true);
				} 
			} else {
				throw t;
			}
	    }
		return response;
	}
	
}
