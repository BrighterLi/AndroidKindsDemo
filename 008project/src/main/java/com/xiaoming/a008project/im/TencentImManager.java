package com.xiaoming.a008project.im;


/*import android.content.Context;
import android.util.Log;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;*/

public class TencentImManager {

    /*public static void initSDK(Context context) {
        V2TIMSDKConfig config = new V2TIMSDKConfig();
        config.setLogLevel(V2TIMSDKConfig.V2TIM_LOG_INFO);

        V2TIMManager.getInstance().initSDK(context, TencentImConfig.APP_KEY, config, new V2TIMSDKListener() {
            @Override
            public void onConnecting() {
                // 正在连接到腾讯云服务器
                Log.i("TencentImManager", "bright8#initSDK#onConnecting");
            }

            @Override
            public void onConnectSuccess() {
                // 已经成功连接到腾讯云服务器
                Log.i("TencentImManager", "bright8#initSDK#onConnectSuccess");
                TencentImManager.login();
            }

            @Override
            public void onConnectFailed(int code, String error) {
                // 连接腾讯云服务器失败
                Log.i("TencentImManager", "bright8#initSDK#onConnectFailed");
            }
        });
    }

    public static void login() {
        V2TIMManager.getInstance().login("11111", TencentImConfig.USER_SIG, new V2TIMCallback() {

            @Override
            public void onError(int code, String desc) {
               Log.i("TencentImManager", "bright8#login#onError#code:" + code + " #desc:" + desc);
            }

            @Override
            public void onSuccess() {
                Log.i("TencentImManager", "bright8#login#onSuccess");
            }
        });
    }*/


}
