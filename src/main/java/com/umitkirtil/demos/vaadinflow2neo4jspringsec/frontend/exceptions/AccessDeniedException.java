package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.exceptions;

public class AccessDeniedException extends RuntimeException {
	public AccessDeniedException() {
	}

	public AccessDeniedException(String message) {
		super(message);
	}
}
