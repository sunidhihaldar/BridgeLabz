package com.bridgelabz.designPattern.creationalDesignPattern.Singleton.EagerInitializedSingleton;

public class EagerInitialized {
    
    private static final EagerInitialized instance = new EagerInitialized();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitialized(){}

    public static EagerInitialized getInstance(){
        return instance;
    }
}
