
package com.bestarch.framework.exception;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.bestarch.framework.exception.config.ExceptionConfig;
import com.bestarch.framework.exception.handler.Handler;
import com.bestarch.framework.exception.handler.impl.DefaultExceptionHandler;

/**
 * This annotation will create the necessary environment needed to delegate the exception handling to the framework.
 * Always, annotate the configuration class with <code>@EnableExceptionHandler</code> in order to configure the exception framework
 * 
 * @author bestarch
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@EnableAspectJAutoProxy
@Import(ExceptionConfig.class)
public @interface EnableExceptionHandler {
	
	static final Class<DefaultExceptionHandler> DEFAULT_HANDLER = DefaultExceptionHandler.class;
	public Class<? extends Handler> handler() default DefaultExceptionHandler.class;

}
