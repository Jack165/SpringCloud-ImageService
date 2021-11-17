package com.feng.house.plug;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;



public  class LogFactoryBean<T> implements FactoryBean<T>{

	Class<T> logInterface;
	
	 public LogFactoryBean(Class<T> logInterface) {
		this.logInterface=logInterface;
	}
	
	@Override
	public T getObject() throws Exception {

		return logInterface.getDeclaredConstructor().newInstance();
	}

	@Override
	public Class<T> getObjectType() {
		return logInterface;
	}



}
