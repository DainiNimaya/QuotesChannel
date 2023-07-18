/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.bol.services.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author USER
 */
public class ChannelTest {
    
//    public ChannelTest() {
//    }
    
    Channel channel = null;
    
    @Before
    public void init() {
        channel = new Channel();
    }

    /**
     * Test of subscribeChannel method, of class Channel.
     */
    @Test
    public void testSubscribeChannel() {
    }

    /**
     * Test of unSubscribeChannel method, of class Channel.
     */
    @Test
    public void testUnSubscribeChannel() {
    }

    /**
     * Test of notifySubcribers method, of class Channel.
     */
    @Test
    public void testNotifySubcribers() {
    }

    /**
     * Test of addChannel method, of class Channel.
     */
    @Test
    public void testAddChannel() {
       channel.addChannel("test");
       assertEquals(1,Channel.channelList.size());
    }
    
}
