package com.kohls.merch.poedihub.v2.exception.config;

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

import com.kohls.merch.poedihub.v2.bean.Response;
import com.kohls.merch.poedihub.v2.exception.EnableExceptionHandler;
import com.kohls.merch.poedihub.v2.handler.ComplexHandler;
import com.kohls.merch.poedihub.v2.handler.Handler;
import com.kohls.merch.poedihub.v2.handler.SimpleHandler;

@Configuration
@Aspect
public class ExceptionAspect {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ExceptionAspect.class);
	
	@Autowired
	private ApplicationContext context;
	
	@Around(value = "execution(public * *(..)) && target(bean) && @annotation(com.kohls.merch.poedihub.v2.exception.EnableExceptionHandler)")
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
	
	/*@Around(value = "execution(public * *(..)) && target(bean) && @annotation(com.kohls.merch.poedihub.v2.exception.EnableExceptionHandler)")
	//"execution(* com.kohls.merch.poedihub..*.*(..))"
	public Object wrapAround2(ProceedingJoinPoint joinPoint, Object bean) throws Throwable  {
		Response response = null;
		try {
			return joinPoint.proceed();
	    } catch (Throwable t) {
	    	LOGGER.info("Received an exception of type {}", t.getClass());
	    	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
			EnableExceptionHandler enableExceptionHandler = signature.getMethod().getAnnotation(EnableExceptionHandler.class);
			Class<? extends Handler<?>> handler = enableExceptionHandler.handler();
			if (signature.getMethod().getReturnType().isAssignableFrom(handler.getClass())) {
				Handler<?> actualhandler = (Handler<?>) context.getBean(StringUtils.uncapitalize(handler.getSimpleName()));
				if (t instanceof Exception) {
					response = new Response(actualhandler.handle((Exception) t), true);
				} else {
					throw t;
				}
			} else {
				throw new ClassCastException(signature.getMethod().getReturnType()+" is incompatible with "+handler.getClass());
			}
			
	    }
		return response;
	}*/
	
	/*@AfterThrowing(value = "execution(public * *(..)) && target(bean) && @annotation(com.kohls.merch.poedihub.v2.exception.EnableExceptionHandler)", throwing = "exp")
	public void afterThrowing(JoinPoint joinPoint, Object bean, Exception exp) throws Throwable  {
		LOGGER.info("Received an exception of type {}", exp.getClass());
    	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		EnableExceptionHandler enableExceptionHandler = signature.getMethod().getAnnotation(EnableExceptionHandler.class);
		Class<? extends Handler<?>> handler = enableExceptionHandler.handler();
		Handler<?> actualhandler = (Handler<?>) context.getBean(StringUtils.uncapitalize(handler.getSimpleName()));
		actualhandler.handle(exp);
	}*/
	
}