package com.cn.annotation.moudle;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("绑定", "");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("解绑", "");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        //隐式启动
        intent.setAction("com.cn.annotation.annotationtest.service.bindbind");
        intent.setPackage("com.cn.annotation.annotationtest");
//        intent.setComponent(new ComponentName("com.cn.annotation.annotationtest", "com.cn.annotation.annotationtest.IRemoteService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

}
