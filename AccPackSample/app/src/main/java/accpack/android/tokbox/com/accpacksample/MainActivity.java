package accpack.android.tokbox.com.accpacksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.opentok.android.OpentokError;
import com.opentok.android.Session;
import com.opentok.android.Stream;
import com.tokbox.accpack.accpack1.ACCPack1;
import com.tokbox.android.accpack.accpack2.AccPack2;
import com.tokbox.android.ap.APSession;


public class MainActivity extends AppCompatActivity implements APSession.SessionListener {

    private final String LOG_TAG = this.getClass().getName();

    private APSession mSession;
    private ACCPack1 mAccPack1;
    private AccPack2 mAccPack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSession = new APSession(this, OpenTokConfig.API_KEY, OpenTokConfig.SESSION_ID);

        mAccPack1 = new ACCPack1(mSession);
        mAccPack2 = new AccPack2(mSession);
        mSession.setSessionListener(this);


        mSession.connect(OpenTokConfig.TOKEN);

    }

    @Override
    public void onConnected(Session session) {

        mAccPack1.sendMessage("hi");
        mAccPack2.sendAnnotation("drawn-line");

    }

    @Override
    public void onDisconnected(Session session) {

    }

    @Override
    public void onStreamReceived(Session session, Stream stream) {

    }

    @Override
    public void onStreamDropped(Session session, Stream stream) {

    }

    @Override
    public void onError(Session session, OpentokError opentokError) {

    }
}
