package com.learn.gupao.designmode.DynamicProxyDemo;

public class EstateAgentMainTest {
    public static void main(String[] args) {
        //People people = (People) new EstateAgent().getAgentInstance(new YoungCouple());
        //people.findHome();

        ClassLoader classLoader = new EstateAgent().getClass().getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        System.out.println(classLoader.getParent().getParent());
        System.out.println(classLoader.getParent().getParent().getParent());
    }
}
