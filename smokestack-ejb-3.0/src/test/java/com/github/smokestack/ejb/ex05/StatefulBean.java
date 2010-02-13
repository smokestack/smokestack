package com.github.smokestack.ejb.ex05;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

@Stateful
public class StatefulBean {
	
	protected boolean initializeCalled=false;
	protected boolean cleanupCalled=false;
	
	@PostConstruct
	public void initialize(){
		initializeCalled=true;
	}

	@PreDestroy
	public void cleanup(){
		cleanupCalled=true;		
	}
}
