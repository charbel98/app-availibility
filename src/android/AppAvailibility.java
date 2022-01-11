package com.example.app_availibility;

import android.app.ActivityManager;
import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class AppAvailibility extends CordovaPlugin {
    @Override
    public boolean execute(
            String action,
            JSONArray args,
            CallbackContext callbackContext
    ) throws JSONException {
        if(action.equals("isAppRunning")){
            try {
                isAppRunning(this.cordova.getActivity().getApplicationContext(), args.getString(0));
            }
            catch (Exception e){
                callbackContext.error("Something went wrong " + e.getMessage());
            }
        }
        return false;
    }
    public boolean isAppRunning(final Context ctx,final String myPackage) throws  Exception{
        if(myPackage == null){ throw new Exception();}
        final  ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        final  List<ActivityManager.RunningAppProcessInfo> processesInfos = activityManager.getRunningAppProcesses();
        if (processesInfos != null)
        {
            for (final ActivityManager.RunningAppProcessInfo processInfo : processesInfos) {
                if (processInfo.processName.equals(myPackage)) {
                    return true;
                }
            }
        }
        return false;
    }
}
