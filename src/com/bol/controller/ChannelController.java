/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bol.controller;

import com.bol.services.CommonChannel;
import com.bol.services.Observer;
import com.bol.services.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author USER
 */
public class ChannelController implements Subject {
    
    private static HashMap<CommonChannel, List<Observer>> channelList = new HashMap<>();

    @Override
    public void subscribeChannel(CommonChannel channel, Observer observer) {
        // add channel if it is a new channel
        addChannel(channel);
        
        // get subscribers of the channel
        List<Observer> subscribers = getChannelSubscribers(channel);
        
        if (subscribers != null){
            if(observer != null) {
                if(!subscribers.contains(observer)){
                    subscribers.add(observer);
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
    public void unSubscribeChannel(CommonChannel channel,Observer observer) {
        
        // get subscribers of the channel
        List<Observer> subscribers = getChannelSubscribers(channel);
        
        if (subscribers != null) {
            if (subscribers.contains(observer)){
                subscribers.remove(observer);
            }else{
                throw new RuntimeException("User not found in this channel");
            }
        }else{
            throw new RuntimeException("Channel not found");
        }
        
    }

    @Override
    public void notifySubcribers(CommonChannel channel, String message) {
        
        // get subscribers of the channel
        List<Observer> subscribers = getChannelSubscribers(channel);
        
        if (subscribers != null) {
            for(Observer observer:subscribers){
                observer.update(message);
            }
        } else {
            throw new RuntimeException("User not found in this channel");
        }
    }
    
    
    private void addChannel(CommonChannel channel){
        if(channel == null){
            throw new IllegalArgumentException("Channel can't be null");
        }
        if(!channelList.containsKey(channel)){
                channelList.put(channel, new ArrayList<>());
        }
    }
    
    private List<Observer> getChannelSubscribers(CommonChannel commonChannel){
        if(commonChannel != null){
            List<Observer> subscribers = channelList.get(commonChannel);
            return subscribers;
        }else{
            throw new IllegalArgumentException("Channel can't be null");
        }
        
    }
    
    public HashMap<CommonChannel, List<Observer>> getChannelDetail(){
        return channelList;
    }
}