package com.bestarch.framework.exception.bean;

/**
 * Container object that should contain the actual error object
 * 
 * @author bestarch
 *
 */
public class ErrorResponse {
	
	Error error;
	
	String responseCode;
	
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public static class Error {
		
		String errorCode;
		
		String message;
		
		public String getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Error(String errorCode, String message) {
			super();
			this.errorCode = errorCode;
			this.message = message;
		}
		public Error() {
			super();
		}
		@Override
		public String toString() {
			return "Error [errorCode=" + errorCode + ", message=" + message + "]";
		}
	}

	@Override
	public String toString() {
		return "ErrorResponse [error=" + error + ", responseCode=" + responseCode + "]";
	}
	
}

