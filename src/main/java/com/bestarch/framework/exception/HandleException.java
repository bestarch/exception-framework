
package com.bestarch.framework.exception;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bestarch.framework.exception.handler.Handler;
import com.bestarch.framework.exception.handler.impl.DefaultExceptionHandler;

/**
 * The framework will handle exception for those methods which are annotated with {@code @HandleException}
 * 
 * @author bestarch
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface HandleException {
	
	static final Class<DefaultExceptionHandler> DEFAULT_HANDLER = DefaultExceptionHandler.class;
	public Class<? extends Handler> handler() default DefaultExceptionHandler.class;

}
