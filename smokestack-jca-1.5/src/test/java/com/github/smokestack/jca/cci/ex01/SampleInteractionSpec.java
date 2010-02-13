package com.github.smokestack.jca.cci.ex01;

import javax.resource.cci.InteractionSpec;

public class SampleInteractionSpec implements InteractionSpec {
	/**
	 * Generated
	 */
	private static final long serialVersionUID = 3454251375464927938L;

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public int getInteractionVerb() {
		return interactionVerb;
	}

	public void setInteractionVerb(int interactionVerb) {
		this.interactionVerb = interactionVerb;
	}

	public long getExecutionTimeout() {
		return executionTimeout;
	}

	public void setExecutionTimeout(long executionTimeout) {
		this.executionTimeout = executionTimeout;
	}

	protected String functionName;
	protected int interactionVerb;
	protected long executionTimeout;
}