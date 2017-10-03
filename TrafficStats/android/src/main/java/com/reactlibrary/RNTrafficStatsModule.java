package com.reactlibrary;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


public class RNTrafficStatsModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNTrafficStatsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNTrafficStats";
    }

    @ReactMethod
    public void startService(Callback successCallback, Callback errorCallback) {
        try {

            this.getCurrentActivity().startService(new Intent(this.getReactApplicationContext(), TestService.class));
            successCallback.invoke(isMyServiceRunning(TestService.class));
        } catch (Exception e) {
            String s = "";
            for (StackTraceElement s1 : e.getStackTrace())
                s += s1.toString() + "\n";
            errorCallback.invoke(s + "\n\n" + e.getMessage());
        }

    }

    @ReactMethod
    public void stopService(Callback successCallback, Callback errorCallback) {
        try {

            this.getCurrentActivity().stopService(new Intent(this.getReactApplicationContext(), TestService.class));
            successCallback.invoke(isMyServiceRunning(TestService.class));
        } catch (Exception e) {
            String s = "";
            for (StackTraceElement s1 : e.getStackTrace())
                s += s1.toString() + "\n";
            errorCallback.invoke(s + "\n\n" + e.getMessage());
        }

    }


    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) this.getCurrentActivity().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}