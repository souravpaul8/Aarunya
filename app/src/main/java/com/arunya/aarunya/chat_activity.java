package com.arunya.aarunya;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.os.Build;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class chat_activity extends AppCompatActivity implements View.OnClickListener,MessageDataSource.MessagesCallbacks {
    public static final String USER_EXTRA="USER";
    public static final String Tag = "ChatActivity";
    private ArrayList<Message> mMessages;
    private MessagesAdapter mAdapter;
    private String mRecipient;
    private ListView mListView;
    private Date mLastMessageDate= new Date();
    private String mConvoId;
    private MessageDataSource.MessagesListener mListener;
    List<Message>Message_List;
    private MessageDataSource dataSource;
    public static SharedPreferences noteprefs;
    HashMap<String,String> MapListMessages =new HashMap<String, String>();
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chat_activity);
    mRecipient = "Hitesh";
    mListView = (ListView) findViewById(R.id.messages_List);
    mMessages = new ArrayList<>();
    mAdapter = new MessagesAdapter(mMessages);
    mListView.setAdapter(mAdapter);
    setTitle(mRecipient);
    if (getSupportActionBar() != null) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    Button sendMessage = (Button) findViewById(R.id.send_message);
    sendMessage.setOnClickListener(this);
    String[] ids = {"hashif", "Raj"};
    // Arrays.sort(ids);
    mConvoId = ids[0] + ids[1];
    mListener = MessageDataSource.addMessagesListener(mConvoId, this);
}
       /* private ArrayList<Message> mAdapter;
        private MessagesAdapter mAdapter;
        private String mRecipient;
        private ListView mListView;
        private Date mLastMessageDate = new Date();
        private String mConvoId;
        private MessageDataSource.MessagesListener mListener;
        List<Message> Message List;
        private MessageDataSource dataSource;
        public static SharedPreferences noteprefs;
        HashMap<String,String> MapListMessages= new HashMap<String, String>();

        Firebase.setAndroidContext(this); */

    @Override
    public void onClick(View v){
        EditText newMessageView=(EditText) findViewById(R.id.new_message);
        String newMessageView1 = newMessageView.getText().toString();
        newMessageView.setText("");
        com.arunya.aarunya.Message msg = new com.arunya.aarunya.Message();
        msg.setmDate(new Date());
        msg.setmText("newMessage");
        msg.setmSender("Raj");

        MessageDataSource.saveMessage(msg,mConvoId); /*fetches message from edit text add to the message object */



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MessageDataSource.stop(mListener);

    }

    @Override
    public void onMessageAdded(com.arunya.aarunya.Message message) {
        mMessages.add(message);
        mAdapter.notifyDataSetChanged();
    }

    private class MessagesAdapter extends ArrayAdapter<Message>{
        MessagesAdapter(ArrayList<Message>messages){
            super(chat_activity.this, R.layout.message_item,R.id.message,messages);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            convertView=super.getView(position,convertView,parent);
            com.arunya.aarunya.Message message= getItem(position);
            TextView nameView =(TextView)convertView.findViewById(R.id.message);
            nameView.setText(message.getmText());
            LinearLayout.LayoutParams layoutParams =(LinearLayout.LayoutParams)nameView.getLayoutParams();

            int sdk = Build.VERSION.SDK_INT;
            if(message.getmSender().equals("Raj"))
            {
                if (sdk >= Build.VERSION_CODES.JELLY_BEAN) {
                   // nameView.setBackground(getDrawable(R.drawable.bubble_right_green));
                }
                else {
                   // nameView.setBackgroundDrawable(getDrawable(R.drawable.bubble_right_green));
                }
                layoutParams.gravity= Gravity.RIGHT;
                } else{
                if( sdk >= Build.VERSION_CODES.JELLY_BEAN) {
                   // nameView.setBackground(getDrawable(R.drawable.bubble_left_gray));
                }
                layoutParams.gravity=Gravity.LEFT;

                } nameView.setLayoutParams(layoutParams);
                  return convertView;
            }
        }
    }

