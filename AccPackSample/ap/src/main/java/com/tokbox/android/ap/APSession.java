package com.tokbox.android.ap;

import android.content.Context;
import android.util.Log;

import com.opentok.android.Connection;
import com.opentok.android.Session;
import com.opentok.android.Stream;

/**
 * Created by mserrano on 06/04/16.
 */
public class APSession extends Session {

    private TextChatListener textChatListener;
    private AnnotationListener annotationListener;

    public APSession(Context context, String apiKey, String sessionId) {
        super(context, apiKey, sessionId);
    }

    public static interface TextChatListener {
       void onNewMessage(String message);
    }

    public static interface AnnotationListener {

        void onNewAnnotation(String annotation);
    }

    public void setTextChatListener(TextChatListener listener){
        textChatListener = listener;
    }

    public void setAnnotationListener(AnnotationListener listener){
        annotationListener = listener;
    }

    @Override
    protected void onSignalReceived(String type, String data, Connection connection) {
        super.onSignalReceived(type, data, connection);
        if (type.equals("text-chat")){
            textChatListener.onNewMessage(data);
        }
        else {
            if (type.equals("annotation")){
                annotationListener.onNewAnnotation(data);
            }
        }
        //.....
    }

    @Override
    protected void onStreamReceived(Stream stream) {
        super.onStreamReceived(stream);

        if (stream.getStreamVideoType()  == Stream.StreamVideoType.StreamVideoTypeCamera){
            //.....
        }
        else {
            if (stream.getStreamVideoType() == Stream.StreamVideoType.StreamVideoTypeScreen){
                //......
            }
        }
    }
}
