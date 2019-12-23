package com.bridgelabz.designPattern.creationalDesignPattern.Singleton.StaticBlockSingleton;

/**
 * Singleton design pattern to create the instance inside static block
 * @author Sunidhi Haldar
 * @created 2019.12.16
 * @version 13.0.1
 */

public class StaticBlock {

    private static StaticBlock instance;
    
    private StaticBlock(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlock();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlock getInstance(){
        return instance;
    }
}
