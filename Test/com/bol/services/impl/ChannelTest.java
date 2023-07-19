/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.bol.services.impl;

import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author USER
 */
public class ChannelTest {
    
    Channel channel = null;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public ChannelTest() {
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

   
    @Test
    public void testAddChannel() {
       channel.addChannel("test");
       assertEquals(1,Channel.channelList.size());
    }
    
    @Test
    public void testAddChannelWithNullOrEmptyStringValues() {
       thrown.expect(IllegalArgumentException.class);
       thrown.expectMessage("Channel name can't be empty or null");
       channel.addChannel("");
       channel.addChannel(null);
    }
    
    @Test
    public void testChannelNameAlreadyExist() {
       thrown.expect(RuntimeException.class);
       thrown.expectMessage("Channel name already exist");
       channel.addChannel("Quotes");
    }
    
}
