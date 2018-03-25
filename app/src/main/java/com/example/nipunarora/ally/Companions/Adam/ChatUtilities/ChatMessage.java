package com.example.nipunarora.ally.Companions.Adam.ChatUtilities;

import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by nipunarora on 25/03/18.
 */

public class ChatMessage implements IMessage {
    String id,text;
    IUser author;
    Date today;

    public ChatMessage() {
    }

    public ChatMessage(String id, String text, IUser author) {
        this.id = id;
        this.text = text;
        this.author = author;
        Calendar rightNow = Calendar.getInstance();
        this.today=rightNow.getTime();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public IUser getUser() {
        return author;
    }

    @Override
    public Date getCreatedAt() {
        return today;
    }
}
