package com.bestarch.framework.exception.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bestarch.framework.exception.handler.SimpleHandler;

/**
 * This will be called if no error handler is provided with <code>@EnableExceptionHandler</code>.
 * The implementation does not provide any concrete error handling except returning the plain <code>ErrorResponse</code> object
 * <br>
 * Default implementation: <br><br>
 * <code>
 * 		LOGGER.info("No exceptionHandler defined. Calling DefaultExceptionHandler");<br>
		ErrorResponse errorResponse = new ErrorResponse();<br>
		ErrorResponse.Error error = new ErrorResponse.Error("ERROR", exception.getMessage());<br>
		errorResponse.setError(error);<br>
		errorResponse.setResponseCode("ERROR");<br>
		return errorResponse;
 * </code>
 * @author abhishek.srivastava4
 *
 */
@Component
public class DefaultExceptionHandler implements SimpleHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);
	
	public void handle(Exception exception) {
		LOGGER.info("No exceptionHandler defined. Calling DefaultExceptionHandler");
		LOGGER.info("Exception :: {}", exception.getCause());
		LOGGER.info("Exception message :: {}", exception.getMessage());
	}

}
