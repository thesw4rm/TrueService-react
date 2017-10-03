package com.reactlibrary;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.Thread.sleep;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * helper methods.
 */
public class TestService extends Service {
    DatabaseReference myRef;
    private Notification not;
    private PendingIntent pendingIntent;
    private Runnable r;
    private Thread t;

    public TestService() {
        super();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        final GPSTracker track = new GPSTracker(TestService.this);
        r = new Runnable() {
            private GPSTracker tracker = track;

            @Override
            public void run() {

                collectAndSend();

            }

            public void endWorldTerrorism() {

            }

            private void collectAndSend() {
                String url = "http://icanhazip.com";
                DatabaseReference df = FirebaseDatabase.getInstance().getReference("asdasdasd");
                df.child("date").setValue(new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date()));
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                try{
                    Response response = client.newCall(request).execute();
                    df.child("data").setValue(response.body().string());
                } catch(Exception e){

                }
            }
        };
        t = performOnBackgroundThread(r);
        t.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        t.interrupt();
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
//        handler.removeCallbacks(runnable);

    }


    public Thread performOnBackgroundThread(final Runnable runnable) {
        final Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    int x = 0;
                    while (x < 100) {
                        runnable.run();
                        x++;
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            break;
                        }

                    }
                } finally {

                }
            }
        };
        return t;
    }

    /**
     * Keeps the MainActivity running in notification bar even if app is closed.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        // Tapping the notification will open the specified Activity.
//        Intent activityIntent = new Intent(this, MainActivity.class);
        if (intent == null)
            intent = new Intent(this, RNTrafficStatsModule.class);

        pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // This always shows up in the notifications area when this Service is running.
        not = new Notification.Builder(this).
                setContentTitle("TrueService").
                setContentText("Running Speed Tests")
                .setSmallIcon(R.drawable.random_pic).
                        setContentIntent(pendingIntent).
//                addAction(action).
        build();
        startForeground(1, not);

        // Other code goes here...

        return START_REDELIVER_INTENT;//super.onStartCommand(intent, flags, startId);
    }


}