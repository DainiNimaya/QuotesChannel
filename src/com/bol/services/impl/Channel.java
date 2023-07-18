/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bol.services.impl;

import com.bol.services.ChannelUsers;
import com.bol.services.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author USER
 */
public class Channel implements Subject{
    
    public static HashMap<String, List<ChannelUsers>> channelList = new HashMap<>();

    @Override
    public void subscribeChannel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void unSubscribeChannel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifySubcribers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void addChannel(String name){
    }
}
