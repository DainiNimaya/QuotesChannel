/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.bol.services.impl;

import com.bol.view.UserView;
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

    
    @Test
    public void testSubscribeChannel() {
        channel.addChannel("name");
        int existingSubscriberCount = Channel.channelList.get("name").size();
        channel.subscribeChannel("name", new UserView("name"));
        assertEquals(existingSubscriberCount+1,Channel.channelList.get("name").size());
    }
    
    
    @Test
    public void testSubscribeChannelWhenChannelNotExist() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Channel not found");
        channel.subscribeChannel("name", new UserView("name"));
        channel.subscribeChannel(null, new UserView("name"));
        channel.subscribeChannel("", new UserView("name"));
    }

    
    @Test
    public void testSubscribeChannelWithAlreadySubscribedUser() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User have already subscribed");
        channel.addChannel("name");
        UserView user = new UserView("name");
        channel.subscribeChannel("name", user);
        channel.subscribeChannel("name", user);
    }
    
    
    @Test
    public void testSubscribeChannelWithNullUsers() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User detail not found");
        channel.addChannel("name");
        channel.subscribeChannel("name", null);
    }
    
    
    @Test
    public void testUnSubscribeChannel() {
        channel.addChannel("name");
        UserView user = new UserView("name");
        channel.subscribeChannel("name", user);
        int existingSubscriberCount = Channel.channelList.get("name").size();
        channel.unSubscribeChannel("name", user);
        assertEquals(existingSubscriberCount-1,Channel.channelList.get("name").size());
    }

    
    @Test
    public void testNotifySubcribers() {
    }
    
}
