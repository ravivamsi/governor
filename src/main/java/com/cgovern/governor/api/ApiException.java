package com.cgovern.governor.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

public class ApiException extends Exception {
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
