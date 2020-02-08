package com.xiaoming.acrossendwebview.webviewandjs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.xiaoming.acrossendwebview.R;

public class WebviewAndJSActivity extends Activity {
    private static final String TAG = "WebviewAndJSActivity";
    private WebView mWebView;
    private Button btnShow;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_and_js);

        initView();
        initData();
        initEvent();
    }

    private void initView() {
        btnShow = findViewById(R.id.btn_show);
        mWebView = findViewById(R.id.webView);
    }

    private void initData() {
        mWebView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = mWebView.getSettings();
        //是否支持 Js 使用
        webSettings.setJavaScriptEnabled(true);
        //设置本地调用对象及其接口(js调用android)
        mWebView.addJavascriptInterface(new JsInteraction(),"control");
        //加载本地h5页面
        mWebView.loadUrl("file:///android_asset/h5.html");
    }

    private void initEvent() {
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //本地调h5中的方法
                mWebView.loadUrl("javascript:sayHello()");
            }
        });
    }

    //Android本地方法
    public class JsInteraction {
        @JavascriptInterface
        public void toastMessage(String message) {
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
    }
}
