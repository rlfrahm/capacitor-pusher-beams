package com.cesarbarone.pusherbeams;

import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.pusher.pushnotifications.BeamsCallback;
import com.pusher.pushnotifications.PushNotifications;
import com.pusher.pushnotifications.PusherCallbackError;
import com.pusher.pushnotifications.auth.AuthData;
import com.pusher.pushnotifications.auth.AuthDataGetter;
import com.pusher.pushnotifications.auth.BeamsTokenProvider;

import java.util.HashMap;
import java.util.Set;

@NativePlugin()
public class PusherBeams extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }

    @PluginMethod()
    public  void start(PluginCall call) {
        throw new NullPointerException("PushNotifications start metheod not implemented yet");
    }

    @PluginMethod()
    public void addDeviceInterest(PluginCall call) {
        String interest = call.getString("interest");
        PushNotifications.addDeviceInterest(interest);
        JSObject ret = new JSObject();
        ret.put("success", true);
        call.success();
    }

    @PluginMethod()
    public void removeDeviceInterest(PluginCall call) {
        String interest = call.getString("interest");
        PushNotifications.removeDeviceInterest(interest);
        JSObject ret = new JSObject();
        ret.put("success", true);
        call.success();
    }

    @PluginMethod()
    public void getDeviceInterests(PluginCall call) {
        Set<String> interests = PushNotifications.getDeviceInterests();
        JSObject ret = new JSObject();
        ret.put("interests", interests);
        call.success(ret);
    }

    @PluginMethod()
    public void setDeviceInterests(PluginCall call) {
        throw new NullPointerException("PushNotifications setDeviceInterests metheod not implemented yet");
    }

    @PluginMethod()
    public  void clearDeviceInterests(PluginCall call) {
        PushNotifications.clearDeviceInterests();
        call.success();
    }

    @PluginMethod()
    public void setOnDeviceInterestsChangedListener(PluginCall call) {
        throw new NullPointerException("PushNotifications setOnDeviceInterestsChangedListener metheod not implemented yet");
    }

    @PluginMethod()
    public  void setOnMessageReceivedListenerForVisibleActivity(PluginCall call) {
        throw new NullPointerException("PushNotifications setOnMessageReceivedListenerForVisibleActivity metheod not implemented yet");
    }

    @PluginMethod()
    public void setUserID(final PluginCall call) {
        String beamsAuthURl = call.getString("beamsAuthURL");
        String userID = call.getString("userID");
        JSObject headers = call.getObject("headers");
        JSObject queryParams = call.getObject("queryParams");

        BeamsTokenProvider tokenProvider = new BeamsTokenProvider(
            beamsAuthURl,
            new AuthDataGetter() {
                @Override
                public AuthData getAuthData() {
                // Headers and URL query params your auth endpoint needs to
                // request a Beams Token for a given user
                HashMap<String, String> headers = new HashMap<>();
                // for example:
                // headers.put("Authorization", sessionToken);
                HashMap<String, String> queryParams = new HashMap<>();
                return new AuthData(
                        headers,
                        queryParams
                );
                }
            }
        );
        PushNotifications.setUserId(userID, tokenProvider, new BeamsCallback<Void, PusherCallbackError>(){
            @Override
            public void onSuccess(Void... values) {
                Log.i("PusherBeams", "Successfully authenticated with Pusher Beams");
                JSObject ret = new JSObject();
                ret.put("success", true);
                ret.put("message", "Successfully authenticated with Pusher Beams");
                call.success(ret);
            }

            @Override
            public void onFailure(PusherCallbackError error) {
                Log.e("PusherBeams", "Pusher Beams authentication failed: " + error.getMessage());
                JSObject ret = new JSObject();
                ret.put("success", false);
                ret.put("message", error.getMessage());
                call.error(error.getMessage());
            }
        });
    }

    @PluginMethod()
    public  void clearAllState(PluginCall call) {
        PushNotifications.clearAllState();
        JSObject ret = new JSObject();
        ret.put("success", false);
        call.success(ret);
    }

    @PluginMethod()
    public  void stop(PluginCall call) {
        PushNotifications.stop();
        JSObject ret = new JSObject();
        ret.put("success", false);
        call.success(ret);
    }
}
