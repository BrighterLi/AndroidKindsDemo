package com.xiaoming.a008project;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import com.xiaoming.a008project.consumption.ConsumptionActivity;
import com.xiaoming.a008project.im.ImTestActivity;
import com.xiaoming.a008project.webviewlinked.demo.ScrollViewActivity;
import com.xiaoming.a008project.webviewlinked.demo2.ScrollViewActivity2;
import com.xiaoming.a008project.webviewlinked.demo3.ScrollViewActivity3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mLvMain;
    private List<String> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDemoData();
        initView();
    }

    private void initDemoData() {
        mDataList = new ArrayList<>();
        mDataList.add("消费号");
        mDataList.add("即时聊天");
        mDataList.add("WebView联动");
        mDataList.add("WebView联动2");
        mDataList.add("WebView联动3");
    }

    private void initView() {
        mLvMain = findViewById(R.id.lv_main);
        //context, layout,data
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mDataList);
        mLvMain.setAdapter(arrayAdapter);
        mLvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, ConsumptionActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ImTestActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, ScrollViewActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, ScrollViewActivity2.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, ScrollViewActivity3.class));
                        break;
                }
            }
        });

    }
}