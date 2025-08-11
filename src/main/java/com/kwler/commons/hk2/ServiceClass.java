package com.kwler.commons.hk2;

import java.lang.annotation.Annotation;

import javax.inject.Singleton;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ServiceClass {
	
	private final Class<?> interfaceClass;
	private final Class<?> implClass;
	private final Class<? extends Annotation> scope;
	
	public ServiceClass(Class<?> implClass) {
		this.interfaceClass = implClass;
		this.implClass = implClass;
		this.scope = Singleton.class;
	}
	
	public<T> ServiceClass(Class<T> interfaceClass, Class<? extends T> implClass) {
		this.interfaceClass = interfaceClass;
		this.implClass = implClass;
		this.scope = Singleton.class;
	}
	
	public static<T> ServiceClass build(Class<?> implClass){
		return new ServiceClass(implClass);
	}

	public Class<?> getInterfaceClass() {
		return interfaceClass;
	}

	public Class<?> getImplClass() {
		return implClass;
	}

	public Class<? extends Annotation> getScope() {
		return scope;
	}

}
