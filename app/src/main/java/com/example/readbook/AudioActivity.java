package com.example.readbook;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.api.bean.HwAudioPlayItem;
import com.huawei.hms.audiokit.player.callback.HwAudioConfigCallBack;
import com.huawei.hms.audiokit.player.manager.HwAudioManager;
import com.huawei.hms.audiokit.player.manager.HwAudioManagerFactory;
import com.huawei.hms.audiokit.player.manager.HwAudioPlayerConfig;
import com.huawei.hms.audiokit.player.manager.HwAudioPlayerManager;

import java.util.ArrayList;
import java.util.List;

public class AudioActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private HwAudioManager mHwAudioManager;
    private HwAudioPlayerManager mHwAudioPlayerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(AudioActivity.this);
    }

    public List<HwAudioPlayItem> getOnlinePlaylist() {
        List<HwAudioPlayItem> playItemList = new ArrayList<>();
        // Create an audio object audioPlayItem1 and write information about the song "chengshilvren" into the object.
        HwAudioPlayItem audioPlayItem1 = new HwAudioPlayItem();
        audioPlayItem1.setAudioId("1000");
        audioPlayItem1.setSinger("Taoge");
        audioPlayItem1.setOnlinePath("https://developer.huawei.com/config/file/HMSCore/AudioKit/Taoge-chengshilvren.mp3");
        audioPlayItem1.setOnline(1);
        audioPlayItem1.setAudioTitle("chengshilvren");
        playItemList.add(audioPlayItem1);
        // Create an audio object audioPlayItem2 and write information about the song "dayu" into the object.
        HwAudioPlayItem audioPlayItem2 = new HwAudioPlayItem();
        audioPlayItem2.setAudioId("1001");
        audioPlayItem2.setSinger("Taoge");
        audioPlayItem2.setOnlinePath("https://developer.huawei.com/config/file/HMSCore/AudioKit/Taoge-dayu.mp3");
        audioPlayItem2.setOnline(1);
        audioPlayItem2.setAudioTitle("dayu");
        playItemList.add(audioPlayItem2);
        // Create an audio object audioPlayItem3 and write information about the song "wangge" into the object.
        HwAudioPlayItem audioPlayItem3 = new HwAudioPlayItem();
        audioPlayItem3.setAudioId("1002");
        audioPlayItem3.setSinger("Taoge");
        audioPlayItem3.setOnlinePath("https://developer.huawei.com/config/file/HMSCore/AudioKit/Taoge-wangge.mp3");
        audioPlayItem3.setOnline(1);
        audioPlayItem3.setAudioTitle("wangge");
        playItemList.add(audioPlayItem3);
        return playItemList;
    }


    // Initialize the SDK.
    public void init(final Context context) {
        Log.i(TAG, "init start");
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                // Create a configuration instance, which contains playback configurations.
                HwAudioPlayerConfig hwAudioPlayerConfig = new HwAudioPlayerConfig(context);
                // Create a control instance.
                HwAudioManagerFactory.createHwAudioManager(hwAudioPlayerConfig, new HwAudioConfigCallBack() {
                    // Return the control instance through callback.
                    @Override
                    public void onSuccess(HwAudioManager hwAudioManager) {
                        try {
                            Log.i(TAG, "createHwAudioManager onSuccess");
                            mHwAudioManager = hwAudioManager;
                            // Obtain the playback control instance.
                            mHwAudioPlayerManager = hwAudioManager.getPlayerManager();
                            mHwAudioPlayerManager.playList(getOnlinePlaylist(), 0, 0);
                        } catch (Exception e) {
                            Log.e(TAG, "player init fail", e);
                        }
                    }

                    @Override
                    public void onError(int errorCode) {
                        Log.e(TAG, "init err:" + errorCode);
                    }
                });
                return null;
            }
        }.execute();
    }
}