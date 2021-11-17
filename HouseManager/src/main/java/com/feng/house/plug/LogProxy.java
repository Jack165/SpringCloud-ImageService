package com.feng.house.plug;



import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.feng.house.util.JsonUtil;

public class LogProxy<T> implements MethodInterceptor{
	 
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		//o表示目标类，method目标类的方法，objects目标类方法需要的形参，methodProxy表示代理类+目标方法。
				System.out.println("执行("+method.getName()+")方法");
				//执行目标类的方法。
				return methodProxy.invokeSuper(o,objects);

	}


}
