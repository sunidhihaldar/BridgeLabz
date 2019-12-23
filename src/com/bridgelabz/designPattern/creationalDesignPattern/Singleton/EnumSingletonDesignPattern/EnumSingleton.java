package com.bridgelabz.designPattern.creationalDesignPattern.Singleton.EnumSingletonDesignPattern;

public enum EnumSingleton {

    INSTANCE;
    int i;
    
    public void print(){
        System.out.println(i);
    }
}
