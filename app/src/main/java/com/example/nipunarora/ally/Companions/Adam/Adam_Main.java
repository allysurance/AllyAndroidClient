package com.example.nipunarora.ally.Companions.Adam;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.nipunarora.ally.Companions.Adam.ChatUtilities.ChatAuthor;
import com.example.nipunarora.ally.Companions.Adam.ChatUtilities.ChatMessage;
import com.example.nipunarora.ally.R;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.models.IUser;
import com.stfalcon.chatkit.commons.models.MessageContentType;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

public class Adam_Main extends AppCompatActivity implements MessageContentType {
    protected final String senderId = "0";
    protected ImageLoader imageLoader;
    MessagesList ml;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adam__main);
        ml=(MessagesList)findViewById(R.id.messagesList) ;
        imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Picasso.with(Adam_Main.this).load(url).into(imageView);
            }
        };
        final MessagesListAdapter<ChatMessage> adapter = new MessagesListAdapter<>(senderId, imageLoader);
        ml.setAdapter(adapter);
        ChatAuthor adam=new ChatAuthor("1","Adam","https://i.imgur.com/1RWH2Ic.png");
        final ChatAuthor me=new ChatAuthor("0","User",null);
        adapter.addToStart(new ChatMessage("0","Hey there!\nI am Adam \nLet me help you with all your policy needs",adam),true);
        MessageInput input=(MessageInput)findViewById(R.id.input);
        input.setInputListener(new MessageInput.InputListener() {
            @Override
            public boolean onSubmit(CharSequence input) {
                //validate and send message
                adapter.addToStart(new ChatMessage("1",input.toString(),me), true);
                return true;
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
