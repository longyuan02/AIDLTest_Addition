// IMyAidlInterface.aidl
package com.cn.annotation.annotationtest;

// Declare any non-default types here with import statements
import com.cn.annotation.annotationtest.Person;
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int add(int numb1,int numb2);
    List<Person>addList(in Person person);
}
