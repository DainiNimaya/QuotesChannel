/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.bol.services.impl;

import com.bol.controller.ChannelController;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author USER
 */
public class QuoteChannelTest {
    
    private final QuoteChannel quoteChannel;
    private final ChannelController channelController;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public QuoteChannelTest() {
        quoteChannel = QuoteChannel.getInstance();
        channelController = new ChannelController();
    }

   
    @Test
    public void testGetInstance() {
        assertEquals(quoteChannel,QuoteChannel.getInstance());
    }

    
    @Test
    public void testGetChannelName() {
        quoteChannel.startChannel("Quotes Channel");
        assertEquals("Quotes Channel",quoteChannel.getChannelName());
    }
    
    @Test
    public void testGetChannelNameWhenChannelNotStarted() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Channel not started yet");
        quoteChannel.getChannelName();
    }

    
    @Test
    public void testStartChannel() {
       quoteChannel.startChannel("Quotes Channel");
       assertEquals("Quotes Channel",quoteChannel.getChannelName());
    }
    
    
    @Test
    public void testStartChannelWithNullOrEmptyStringValues() {
       thrown.expect(IllegalArgumentException.class);
       thrown.expectMessage("Channel name can't be empty or null");
       quoteChannel.startChannel("");
       quoteChannel.startChannel(null);
    }
    
}
