package com.example.nipunarora.ally.Companions.Adam.ChatUtilities;

import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.models.MessageContentType;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

/**
 * Created by nipunarora on 25/03/18.
 */

public class ChatAdapter extends MessagesListAdapter implements MessageContentType {
    public ChatAdapter(String senderId, ImageLoader imageLoader) {
        super(senderId, imageLoader);
    }
}
