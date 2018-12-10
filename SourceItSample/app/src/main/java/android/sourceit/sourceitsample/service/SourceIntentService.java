package android.sourceit.sourceitsample.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Ruslan Ivakhnenko on 13.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class SourceIntentService extends IntentService {

    public SourceIntentService() {
        super(null);
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SourceIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("----", "onCreate");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i("----", "onStart " + intent.getAction());
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i("----", "onStartCommand " + intent.getAction());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("----", "onHandleIntent " + intent.getAction());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("----", "onDestroy ");
    }
}
