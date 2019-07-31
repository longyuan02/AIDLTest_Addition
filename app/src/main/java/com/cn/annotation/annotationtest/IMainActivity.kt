package com.cn.annotation.annotationtest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class IMainActivity : AppCompatActivity(), View.OnClickListener {
    //    var imMyAidl: IMyAidlInterface? = null
    var imMyAidl: IMyAidlInterface? = null
    private var conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            imMyAidl = IMyAidlInterface.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            imMyAidl = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initService();
        initView();
    }

    private fun initView() {
        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn -> {
                clickAction()
            }
        }
    }

    private fun initService() {
        var intent = Intent();
        intent.action = "com.cn.annotation.annotationtest.service.bindbind"
        intent.`package` = "com.cn.annotation.annotationtest"//App A的包名
//        intent.package="com.cn.annotation.annotationtest"
//        intent.component =
//            ComponentName("com.cn.annotation.annotationtest", "IRemoteService")
        bindService(intent, conn, Context.BIND_AUTO_CREATE)
    }

    private fun clickAction() {
        var numb1 = edt_1.text.toString()
        var numb2 = edt_2.text.toString()
        var count = imMyAidl!!.add(numb1.toInt(), numb2.toInt())
        tv!!.setText(count.toString());
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(conn)
    }

}
