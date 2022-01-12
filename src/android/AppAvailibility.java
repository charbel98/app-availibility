package SABIS.Plugins.AppAvailibility;

import android.widget.Toast;
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
          isAppRunning(this.cordova.getActivity().getApplicationContext(), args.getString(0), callbackContext);
            return true;
        }
         if(action.equals("nativeToast")){ 
           nativeToast();
             return true;
         }
        return false;
    }
    public void isAppRunning(final Context ctx,final String myPackage, final CallbackContext callback){
           Toast.makeText(
                      webView.getContext(), 
                      myPackage,
                      Toast.LENGTH_SHORT)
                      .show(); 
        final  ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        final  List<ActivityManager.RunningAppProcessInfo> processesInfos = activityManager.getRunningAppProcesses();
        
        if (processesInfos != null)
        {
            for (final ActivityManager.RunningAppProcessInfo processInfo : processesInfos) {
          
                if (processInfo.processName.equals(myPackage)) {
                    callback.success(""+ true);
                }
            }
        }
        callback.success(""+ false);
    }
    public void nativeToast(){ 
      Toast.makeText(
                      webView.getContext(), 
                      "Hello World Cordova Plugin",
                      Toast.LENGTH_SHORT)
                      .show(); 
   }
}
