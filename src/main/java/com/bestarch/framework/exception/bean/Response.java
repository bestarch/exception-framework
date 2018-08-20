package com.bestarch.framework.exception.bean;

/**
 * Parent return object which would be returned whatever may be the result of the call.
 * <br>
 * <ul>
 * <li>
 * For Successful call: 
	 * 
	 * <ul>
	 * <li>
	 * <code>error</code> = false
	 * </li>
	 * <li>
	 * <code>entity</code> will contain object of desired type
	 * </li>
	 * 
	 * </ul>
 * 
 * </li>
 *  <li>
 * For Unsuccessful call:
	 * 
	 * <ul>
	 * <li>
	 * <code>error</code> = true
	 * </li>
	 * <li>
	 * <code>entity</code> will contain object of type <code> ErrorResponse</code>
	 * </li>
	 * 
	 * </ul>
 * 
 * </li>
 * 
 * </ul>
 * <br>
 * <code>entity</code> variable contains the actual response
 * @author bestarch
 * 
 */
public class Response {
	
	Object entity;
	
	boolean error;
	
	public Response(Object entity, boolean error) {
		super();
		this.entity = entity;
		this.error = error;
	}
	
	public Response() { }

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Response [entity=" + entity + ", error=" + error + "]";
	}
	
}
