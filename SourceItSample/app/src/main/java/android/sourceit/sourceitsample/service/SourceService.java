package android.sourceit.sourceitsample.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Ruslan Ivakhnenko on 13.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class SourceService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("----", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("----", "onStartCommand " + intent.getAction());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("----", "onDestroy ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
