package com.cb.pusherbeams;

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
    public void setUserID(final PluginCall call) {
        String beamsAuthURl = call.getString("beamsAuthURL");
        String userID = call.getString("userID");
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
                call.success();
            }

            @Override
            public void onFailure(PusherCallbackError error) {
                Log.e("PusherBeams", "Pusher Beams authentication failed: " + error.getMessage());
                call.error(error.getMessage());
            }
        });
    }

    @PluginMethod()
    public  void clearAllState(PluginCall call) {
        PushNotifications.clearAllState();
        call.success();
    }
}
