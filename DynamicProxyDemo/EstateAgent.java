package com.learn.gupao.designmode.DynamicProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EstateAgent implements InvocationHandler {
    /**
     *  保存被代理的对象
     */
    private Object agentedObj;

    public Object getAgentInstance(Object agentedObj){
         this.agentedObj = agentedObj;
         Class clazz = agentedObj.getClass();
         return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeDetail();
         Object obj = method.invoke(agentedObj,args);
         afterDetail();
         return obj;
    }

    private void beforeDetail(){
        System.out.println("请问有什么可以帮助你的呢？");
    }

    private  void  afterDetail(){
        System.out.println("请填一份表，然后将代理费付了");
    }
}
