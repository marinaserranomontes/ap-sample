package com.tokbox.accpack.accpack1;

import android.util.Log;

import com.opentok.android.Connection;
import com.opentok.android.Session;
import com.tokbox.android.ap.APSession;

/**
 * Created by mserrano on 06/04/16.
 */
public class ACCPack1 implements APSession.TextChatListener{
    private final String LOG_TAG = this.getClass().getName();
    APSession mSession;

    public ACCPack1(APSession session) {

        this.mSession = session;
        this.mSession.setTextChatListener(this);
    }

    public void sendMessage(String msg){
        mSession.sendSignal("text-chat", msg);
    }

    @Override
    public void onNewMessage(String message) {
        Log.i(LOG_TAG, "NEW MESSAGE HAS BEEN RECEIVED "+ message);
    }
}
