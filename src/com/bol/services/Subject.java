/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bol.services;

/**
 *
 * @author USER
 */
public interface Subject {
    public void subscribeChannel(String name, Observer observer);
    public void unSubscribeChannel(String name, Observer observer);
    public void notifySubcribers(String t);
    
}
