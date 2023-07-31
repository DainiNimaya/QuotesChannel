/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bol.services.impl;

import com.bol.services.Observer;
import com.bol.services.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author USER
 */
public class Channel implements Subject{
    
    public static HashMap<String, List<Observer>> channelList = new HashMap<>();

    @Override
    public void subscribeChannel(String name, Observer observer) {
        List<Observer> users = channelList.get(name);
        if (users != null){
            if(observer != null) {
                if(!users.contains(observer)){
                    users.add(observer);
                }else{
                    throw new RuntimeException("User have already subscribed");
                }
            }else{
                throw new RuntimeException("User detail not found");
            }
        }else{
            throw new RuntimeException("Channel not found");
        }
        
    }

    @Override
    public void unSubscribeChannel(String name,Observer observer) {
        List<Observer> users = channelList.get(name);
        if (users != null) {
            if (users.contains(observer)){
                users.remove(observer);
            }else{
                throw new RuntimeException("User not found in this channel");
            }
        }else{
            throw new RuntimeException("Channel not found");
        }
        
    }

    @Override
    public void notifySubcribers(String t) {
        channelList.forEach((key,value) -> {
            for(Observer observer:value){
                observer.update(t);
            }
        });
    }
    
    
    public void addChannel(String name){
        if(name.isEmpty() || name == null){
            throw new IllegalArgumentException("Channel name can't be empty or null");
        }
        if(!channelList.containsKey(name)){
                channelList.put(name, new ArrayList<>());
        }else{
                throw new RuntimeException("Channel name already exist");
        }
    }
}
