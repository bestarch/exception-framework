
package com.bestarch.framework.exception;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bestarch.framework.exception.handler.Handler;
import com.bestarch.framework.exception.handler.impl.DefaultExceptionHandler;

/**
 * This annotation will create the necessary environment needed to delegate the exception handling to the framework.
 * Always, annotate the configuration class with <code>@EnableAspectJAutoProxy</code> in order to configure the exception framework
 * correctly
 * 
 * @author bestarch
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface EnableExceptionHandler {
	
	static final Class<DefaultExceptionHandler> DEFAULT_HANDLER = DefaultExceptionHandler.class;
	public Class<? extends Handler> handler() default DefaultExceptionHandler.class;

}
