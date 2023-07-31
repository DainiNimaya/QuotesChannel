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
       channel.addChannel("Quotes Channel");
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
    public void testAddChannelNameAlreadyExist() {
       channel.addChannel("Quotes Channel");
       thrown.expect(RuntimeException.class);
       thrown.expectMessage("Channel name already exist");
       channel.addChannel("Quotes Channel");
    }

    
    @Test
    public void testSubscribeChannel() {
        channel.addChannel("Quotes Channel");
        int existingSubscriberCount = Channel.channelList.get("Quotes Channel").size();
        channel.subscribeChannel("Quotes Channel", new UserView("Nimal"));
        assertEquals(existingSubscriberCount+1,Channel.channelList.get("Quotes Channel").size());
    }
    
    
    @Test
    public void testSubscribeChannelWhenChannelNotExist() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Channel not found");
        channel.subscribeChannel("Quotes Channel", new UserView("Nimal"));
        channel.subscribeChannel(null, new UserView("Nimal"));
        channel.subscribeChannel("", new UserView("Nimal"));
    }

    
    @Test
    public void testSubscribeChannelWithAlreadySubscribedUser() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User have already subscribed");
        channel.addChannel("Quotes Channel");
        UserView user = new UserView("Nimal");
        channel.subscribeChannel("Quotes Channel", user);
        channel.subscribeChannel("Quotes Channel", user);
    }
    
    
    @Test
    public void testSubscribeChannelWithNullUsers() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User detail not found");
        channel.addChannel("Quotes Channel");
        channel.subscribeChannel("Quotes Channel", null);
    }
    
    
    @Test
    public void testUnSubscribeChannel() {
        channel.addChannel("Quotes Channel");
        UserView user = new UserView("Nimal");
        channel.subscribeChannel("Quotes Channel", user);
        int existingSubscriberCount = Channel.channelList.get("Quotes Channel").size();
        channel.unSubscribeChannel("Quotes Channel", user);
        assertEquals(existingSubscriberCount-1,Channel.channelList.get("Quotes Channel").size());
    }
    
    
    @Test
    public void testUnSubscribeChannelForInvalidChannel() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User not found in this channel");
        channel.addChannel("correctChannel");
        channel.addChannel("inCorrectChannel");
        UserView user = new UserView("Nimal");
        channel.subscribeChannel("correctChannel", user);
        channel.unSubscribeChannel("inCorrectChannel", user);
        channel.unSubscribeChannel(null, user);
    }
    
    
    @Test
    public void testUnSubscribeChannelForAlreadyUnsbscribedChannel() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User not found in this channel");
        channel.addChannel("Quotes Channel");
        UserView user = new UserView("Nimal");
        channel.subscribeChannel("Quotes Channel", user);
        channel.unSubscribeChannel("Quotes Channel", user);
        channel.unSubscribeChannel("Quotes Channel", user);
    }
    
    
    @Test
    public void testUnSubscribeChannelForInvalidUser() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User not found in this channel");
        channel.addChannel("Quotes Channel");
        UserView user = new UserView("correctUser");
        UserView userINC = new UserView("inCorrectUser");
        channel.subscribeChannel("Quotes Channel", user);
        channel.unSubscribeChannel("Quotes Channel", userINC);
        channel.unSubscribeChannel("Quotes Channel", null);
    }

    
    @Test
    public void testNotifySubcribers() {
        channel.addChannel("Quotes Channel");
        UserView user = new UserView("Nimal");
        channel.subscribeChannel("Quotes Channel", user);
        channel.notifySubcribers("one");
        assertEquals("one",user.message);
    }
    
    
    @Test
    public void testNotifySubcribersWhenUserGetUnsubscribe() {
        channel.addChannel("Quotes Channel");
        UserView user = new UserView("Nimal");
        channel.subscribeChannel("Quotes Channel", user);
        channel.notifySubcribers("one");
        channel.unSubscribeChannel("Quotes Channel", user);
        channel.notifySubcribers("two");
        assertEquals("one",user.message);
    }
    
}
