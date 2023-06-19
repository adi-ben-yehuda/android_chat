package com.example.ex4.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ex4.MessageAdapter;
import com.example.ex4.MyApplication;
import com.example.ex4.R;
import com.example.ex4.api.ChatAPI;
import com.example.ex4.api.ICallback;
import com.example.ex4.schemas.Contact;
import com.example.ex4.schemas.Message;
import com.example.ex4.schemas.Msg;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChatPage extends AppCompatActivity {
    private int id;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        displayContactInfo();
        handleAddMessage();
        NavigateToContacts();
        getMessagesChat();

    }

    private void getMessagesChat() {

        ChatAPI chatAPI = new ChatAPI();

        chatAPI.getMessages(MyApplication.getToken(), getId(), new ICallback() {
            @Override
            public void status(boolean status) {
                if (status) {
                    List<Message> messages = chatAPI.getMessages();
                    ListView listView = findViewById(R.id.lstMessages);
                    final MessageAdapter adapter = new MessageAdapter(messages);
                    listView.setAdapter(adapter);
                }
            }
        });
    }


    private void NavigateToContacts() {
        FloatingActionButton bthRegister = findViewById(R.id.btnExitChat);
        bthRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this, Contacts.class);
            startActivity(intent);
        });
    }

    private void displayContactInfo() {
        String contactJson = getIntent().getStringExtra("contact");

        // Convert the JSON string back to a Contact object using Gson
        Gson gson = new Gson();
        Contact contact = gson.fromJson(contactJson, Contact.class);

        // Set the image and display name
        ImageView contactImage = findViewById(R.id.contact_profile_img);
        TextView contactName = findViewById(R.id.contact_name);

        Picasso.get().load(contact.getUser().getProfilePic()).into(contactImage);
        contactName.setText(contact.getUser().getDisplayName());

        setId(contact.getId());
    }

    private void handleAddMessage() {
        Button bthAdd = findViewById(R.id.sendButton);
        bthAdd.setOnClickListener(view -> {

            EditText message = findViewById(R.id.msgInput);
            String messageText = message.getText().toString();

            if (!messageText.isEmpty()) {
                setMessage(messageText);

                Msg msg = new Msg(getMessage());

                ChatAPI chatAPI = new ChatAPI();

                chatAPI.addMessage(MyApplication.getToken(), getId(), msg, new ICallback() {
                    @Override
                    public void status(boolean status) {
                        if (status) {
                            getMessagesChat();
                            message.setText("");
                        }
                    }
                });
            }
        });
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    ///////////////////////////////////////////////////////////////check
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // Call getMessagesChat() method again when the activity resumes
//        getMessagesChat();
//    }
}
