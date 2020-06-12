package com.xiaoming.androidknowledgepoints.broadcast;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//https://www.cnblogs.com/lihaolihao/p/4702541.html
import com.xiaoming.androidknowledgepoints.R;

public class LocalBroadcastActivity extends AppCompatActivity {
    private Button mBtnSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);

        initView();
    }

    private void initView() {
        mBtnSendBroadcast = findViewById(R.id.bt_send_broadcast);
        mBtnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(LocalBroadcastActivity.this);
                Intent intent = new Intent();
                intent.setAction(LocalBroadcastReceiverActivity.FILETER);
                intent.putExtra("name", "我是LocalBroadcast发送");
                localBroadcastManager.sendBroadcast(intent);
                //startActivity(new Intent(LocalBroadcastActivity.this, LocalBroadcastReceiverActivity.class));
            }
        });
    }
}