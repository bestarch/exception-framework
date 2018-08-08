package com.kohls.merch.poedihub.v2.handler;

public interface ComplexHandler<T> extends Handler {
	
	/**
	 * <code>exception</code> object in argument encapsulates the exception thrown from the called service/api.
	 * This method will act as a fallback and can return any object taking advantage of <code>exception</code> object.
	 * @param exception contains the actual exception received
	 * @return any object type 
	 */
	public T handle(Exception exception);
	
}
