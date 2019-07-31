//package com.cn.annotation.moudle
//
//import android.content.ComponentName
//import android.content.Context
//import android.content.Intent
//import android.content.ServiceConnection
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.os.IBinder
//import android.view.View
//import com.cn.annotation.annotationtest.IMyAidlInterface
//import com.cn.annotation.annotationtest.Person
//import kotlinx.android.synthetic.main.activity_main.*
//import java.lang.StringBuilder
//
//class IMainActivity : AppCompatActivity(), View.OnClickListener {
//    //    var imMyAidl: IMyAidlInterface? = null
//    var imMyAidl: IMyAidlInterface? = null
//    private var conn = object : ServiceConnection {
//        override fun onServiceConnected(name: ComponentName, service: IBinder) {
//            //拿到返回代理 proxy 代理调用 transact()通过底层通讯把数据发给services
//            imMyAidl = IMyAidlInterface.Stub.asInterface(service)
//        }
//
//        override fun onServiceDisconnected(name: ComponentName) {
//            imMyAidl = null
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        initView();
//        val intent = Intent()
//        //隐式启动
////        intent.action = "com.cn.annotation.annotationtest.service.bindbind"
////        intent.setPackage("com.cn.annotation.annotationtest")
//        intent.component =
//            ComponentName("com.cn.annotation.annotationtest", "com.cn.annotation.annotationtest.IRemoteService")
//        bindService(intent, conn, Context.BIND_AUTO_CREATE)
//    }
//
//    private fun initView() {
//        btn.setOnClickListener(this)
//    }
//
//    override fun onClick(v: View?) {
//        when (v!!.id) {
//            R.id.btn -> {
//                clickAction()
//            }
//        }
//    }
//
//    private fun initService() {
//        var intent = Intent();
////        intent.action = "com.cn.annotation.annotationtest.service.bindbind"
////        intent.`package` = "com.cn.annotation.annotationtest"//App A的包名
//        intent.component =
//            ComponentName("com.cn.annotation.annotationtest", "com.cn.annotation.annotationtest.IRemoteService")
//        bindService(intent, conn, Context.BIND_AUTO_CREATE)
//    }
//
//    private fun clickAction() {
//        var numb1 = edt_1.text.toString()
//        var numb2 = edt_2.text.toString()
//        var count = imMyAidl!!.add(numb1.toInt(), numb2.toInt())
////        var personList=imMyAidl!!.addList(Person("dfdf",11))
//        val personList = imMyAidl!!.addList(Person("年龄", count.toInt()))
//        var str: StringBuilder? = StringBuilder()
//        str!!.append(personList.toString())
//        tv.setText(str)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        unbindService(conn)
//    }
//}