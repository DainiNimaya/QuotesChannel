/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bol.services.impl;

import com.bol.services.CommonChannel;
/**
 *
 * @author USER
 */
public class QuoteChannel implements CommonChannel{
    
    
    private static QuoteChannel channel;
    public String name = "";
   
    private QuoteChannel(){
        
    }
    
    public static QuoteChannel getInstance(){
        if (channel == null) {
            channel = new QuoteChannel();
        }
        return channel;
    }
    
    @Override
    public String getChannelName(){
        try{
            if (name.isEmpty()) {
                throw new RuntimeException("Channel not started yet");
            } else {
                return name;
            }
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
            throw e;        
        } finally{
            System.out.println("Finally block is executed in getChannelName");
        }
        
    }

    @Override
    public void startChannel(String name) {
        try{
            if (name == null) {
                throw new NullPointerException("Channel name can't be null");
            }
            if(name.isEmpty()){
                throw new IllegalArgumentException("Channel name can't be empty");
            } else {
                this.name = name;
            }
        
        } catch(IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            throw e; 
        } finally{
            System.out.println("Finally block is executed in startChannel");
        } 
    }
    
}



