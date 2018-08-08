package com.kohls.merch.poedihub.v2.exception;

import java.util.ArrayList;
import java.util.List;

import com.kohls.merch.poedihub.v2.bean.ErrorResponse;

public class EdiHubException extends RuntimeException {

	private static final long serialVersionUID = 4347142003745577166L;

	private List<ErrorResponse> errorResponse = new ArrayList<>();

	private Object object;

	public List<ErrorResponse> getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(List<ErrorResponse> errorResponse) {
		this.errorResponse = errorResponse;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public EdiHubException() {
		super();
	}

	public EdiHubException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EdiHubException(String message, Throwable cause) {
		super(message, cause);
	}

	public EdiHubException(String message) {
		super(message);
	}

	public EdiHubException(Throwable cause) {
		super(cause);
	}

}
