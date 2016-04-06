package com.tokbox.android.accpack.accpack2;

import android.util.Log;

import com.opentok.android.Connection;
import com.opentok.android.Session;
import com.tokbox.android.ap.APSession;

/**
 * Created by mserrano on 06/04/16.
 */
public class AccPack2 implements APSession.AnnotationListener{

    private final String LOG_TAG = this.getClass().getName();
    APSession mSession;

    public AccPack2(APSession session) {

        this.mSession = session;

        this.mSession.setAnnotationListener(this);

    }

    public void sendAnnotation(String annotation){

        mSession.sendSignal("annotation", annotation);

    }

    @Override
    public void onNewAnnotation(String annotation) {
        Log.i(LOG_TAG, "ACCPACK2 NEW SIGNAL RECEIVED: "+ annotation);
    }


}
