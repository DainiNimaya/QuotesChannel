/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bol.main;

import com.bol.services.impl.QuoteChannel;
import com.bol.view.HomeView;

/**
 *
 * @author USER
 */
public class Main {
    
    public static void main(String[] args) {
        QuoteChannel channel = QuoteChannel.getInstance();
        new HomeView(channel).setVisible(true);
    }
    
}
