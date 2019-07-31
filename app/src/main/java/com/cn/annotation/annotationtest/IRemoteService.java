package com.cn.annotation.annotationtest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;

import android.util.Log;
import com.cn.annotation.annotationtest.Person;

import java.util.List;


public class IRemoteService extends Service {
    private List<Person> Person;

    @Override
    public IBinder onBind(Intent intent) {
        Person = new ArrayList<Person>();
        return iBinder;
    }

    private final IMyAidlInterface.Stub iBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int numb1, int numb2) throws RemoteException {
            Log.e("number====", numb1 + "**" + numb2);
            return numb1 + numb2;
        }

        @Override
        public List<com.cn.annotation.annotationtest.Person> addList(com.cn.annotation.annotationtest.Person person) throws RemoteException {
            List<Person> Person = new ArrayList<>();
            Person.add(new Person("姓名", 123));
            Log.e("list====", Person.size() + "");
            return Person;
        }
    };
}
