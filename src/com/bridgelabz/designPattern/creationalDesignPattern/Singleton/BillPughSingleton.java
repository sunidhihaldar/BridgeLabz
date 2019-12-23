package com.bridgelabz.designPattern.creationalDesignPattern.Singleton;

/**
 * Singleton design patern using private static inner class
 * @author Sunidhi Haldar
 * @created 2019-12-16
 * @version 13.0.1
 */

public class BillPughSingleton {

	//private constructor to restrict the creation of more than one instance
    private BillPughSingleton(){}
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
