package com.arunya.aarunya;

/**
 * Created by Raj_Sinha on 3/24/2018.
 */


import android.net.sip.SipSession;


import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class MessageDataSource {
    /*This class is created to store all firebase related data*/

    private static final Firebase sRef = new Firebase("Your Firebase URL");
    /*UEL should be the official firebase url you are using , here i am using ArunyaOfficial Firebase URL*/
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddmmss");
    private static final String TAG = "MessageDataSource";
    private static final String COLUMN_TEXT = "text";
    private static final String COLUMN_SENDER = "sender";

    public static void saveMessage(com.arunya.aarunya.Message message, String convoId) {
        Date date = message.getmDate();
        String Key = sDateFormat.format(date);
        /*key is simply a date format*/

        HashMap<String, String> msg = new HashMap<>();
        /* hashmap is used to receive and store multiple data */

        msg.put(COLUMN_TEXT, message.getmText());
        msg.put(COLUMN_SENDER, "Raj");
        sRef.child(convoId).child(Key).setValue(msg);

    }

    public static MessagesListener addMessagesListener(String convoId, final MessagesCallbacks callbacks) {
        MessagesListener Listener = new MessagesListener(callbacks);
        sRef.child(convoId).addChildEventListener(Listener);
        return Listener;
    }

    public static void stop(MessagesListener listener) {
        sRef.removeEventListener(listener);
    }


    public static class MessagesListener implements ChildEventListener {

        private MessagesCallbacks callbacks;

        public MessagesListener(MessagesCallbacks callbacks) {
            /*created constructor*/
            this.callbacks = callbacks;

        }

        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            HashMap<String, String> msg = (HashMap<String, String>) dataSnapshot.getValue();
            com.arunya.aarunya.Message message = new com.arunya.aarunya.Message();
            message.setmSender(msg.get(COLUMN_SENDER));
            message.setmText(msg.get(COLUMN_TEXT));
            try {
                message.setmDate(sDateFormat.parse(dataSnapshot.getKey()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (callbacks != null) {
                callbacks.onMessageAdded(message);
            }

        }


        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    }

    public interface MessagesCallbacks {
        public void onMessageAdded(Message message);


    }


}
