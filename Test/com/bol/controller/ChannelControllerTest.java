/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.bol.controller;

import com.bol.services.CommonChannel;
import com.bol.services.Observer;
import com.bol.services.impl.QuoteChannel;
import com.bol.view.UserView;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author USER
 */
public class ChannelControllerTest {
    
    private final ChannelController channelController;
    private final QuoteChannel quoteChannel;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public ChannelControllerTest() {
        channelController = new ChannelController();
        quoteChannel = QuoteChannel.getInstance();
    }
    
   
//    @Test
//    public void testAddChannelNameAlreadyExist() {
//       channelController.addChannel("Quotes Channel");
//       thrown.expect(RuntimeException.class);
//       thrown.expectMessage("Channel name already exist");
//       channelController.notifySubcribers("Quotes Channel");
//    }

    
    @Test
    public void testSubscribeChannel() {
        quoteChannel.startChannel("Quotes Channel");
        HashMap<CommonChannel, List<Observer>> channelDetail = channelController.getChannelDetail();
        int existingSubscriberCount = !channelDetail.isEmpty() ? channelDetail.get(quoteChannel).size() : 0;
        channelController.subscribeChannel(quoteChannel, new UserView(quoteChannel));
        assertEquals(existingSubscriberCount+1,channelDetail.get(quoteChannel).size());
    }
    
    
    @Test
    public void testSubscribeChannelWhenChannelIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Channel can't be null");
        quoteChannel.startChannel("Quotes Channel");
        channelController.subscribeChannel(null, new UserView(quoteChannel));
    }

    
    @Test
    public void testSubscribeChannelWithAlreadySubscribedUser() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User have already subscribed");
        quoteChannel.startChannel("Quotes Channel");
        UserView user = new UserView(quoteChannel);
        channelController.subscribeChannel(quoteChannel, user);
        channelController.subscribeChannel(quoteChannel, user);
    }
    
    
    @Test
    public void testSubscribeChannelWithNullUsers() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User detail not found");
        quoteChannel.startChannel("Quotes Channel");
        channelController.subscribeChannel(quoteChannel, null);
    }
    
    
    @Test
    public void testUnSubscribeChannel() {
        quoteChannel.startChannel("Quotes Channel");
        UserView user = new UserView(quoteChannel);
        channelController.subscribeChannel(quoteChannel, user);
        HashMap<CommonChannel, List<Observer>> channelDetail = channelController.getChannelDetail();
        int existingSubscriberCount = !channelDetail.isEmpty() ? channelDetail.get(quoteChannel).size() : 0;
        channelController.unSubscribeChannel(quoteChannel, user);
        assertEquals(existingSubscriberCount-1,channelDetail.get(quoteChannel).size());
    }
    
    
    @Test
    public void testUnSubscribeChannelWhenChannelIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Channel can't be null");
        quoteChannel.startChannel("Quotes Channel");
        UserView user = new UserView(quoteChannel);
        channelController.subscribeChannel(quoteChannel, user);
        channelController.unSubscribeChannel(null, user);
    }
    
    
    @Test
    public void testUnSubscribeChannelForAlreadyUnsbscribedChannel() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User not found in this channel");
        quoteChannel.startChannel("Quotes Channel");
        UserView user = new UserView(quoteChannel);
        channelController.subscribeChannel(quoteChannel, user);
        channelController.unSubscribeChannel(quoteChannel, user);
        channelController.unSubscribeChannel(quoteChannel, user);
    }
    
    
    @Test
    public void testUnSubscribeChannelForInvalidUser() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User not found in this channel");
        quoteChannel.startChannel("Quotes Channel");
        UserView user = new UserView(quoteChannel);
        UserView userINC = new UserView(quoteChannel);
        channelController.subscribeChannel(quoteChannel, user);
        channelController.unSubscribeChannel(quoteChannel, userINC);
        channelController.unSubscribeChannel(quoteChannel, null);
    }

    
    @Test
    public void testNotifySubcribers() {
        quoteChannel.startChannel("Quotes Channel");
        UserView user = new UserView(quoteChannel);
        channelController.subscribeChannel(quoteChannel, user);
        channelController.notifySubcribers(quoteChannel, "one");
        assertEquals("one",user.message);
    }
    
    
    @Test
    public void testNotifySubcribersWhenUserGetUnsubscribe() {
        quoteChannel.startChannel("Quotes Channel");
        UserView user = new UserView(quoteChannel);
        channelController.subscribeChannel(quoteChannel, user);
        channelController.notifySubcribers(quoteChannel, "one");
        channelController.unSubscribeChannel(quoteChannel, user);
        channelController.notifySubcribers(quoteChannel, "two");
        assertEquals("one",user.message);
    }
   
}
