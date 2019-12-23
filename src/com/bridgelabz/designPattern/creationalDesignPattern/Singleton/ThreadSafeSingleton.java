package com.bridgelabz.designPattern.creationalDesignPattern.Singleton;

/**
 * Singelton design pattern to create thread safe object
 * @author Sunidhi Haldar
 * @created 2019-12-16
 * @version 13.0.1
 */

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    //private constructor to restrict the creation of more than one instance
    private ThreadSafeSingleton(){}
    
    /**
     * synchronized keyword is used to make this method thread safe
     * @return new instance of Class type
     */
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

}
