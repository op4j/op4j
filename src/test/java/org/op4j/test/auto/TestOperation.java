package org.op4j.test.auto;

import org.junit.Ignore;


@Ignore
public class TestOperation {

	private final String methodName;
	private final Object[] params;
	
	public TestOperation(String methodName, Object[] params) {
		super();
		this.methodName = methodName;
		this.params = params;
	}

	public TestOperation(String methodName) {
		super();
		this.methodName = methodName;
		this.params = null;
	}
	
	public String getMethodName() {
		return this.methodName;
	}

	public Object[] getParams() {
		return this.params;
	}
	
	
}
