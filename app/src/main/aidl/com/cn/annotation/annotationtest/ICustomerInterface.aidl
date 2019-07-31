// ICustomerInterface.aidl
package com.cn.annotation.annotationtest;

// Declare any non-default types here with import statements
//import com.cn.annotation.annotationtest.AIDL.Person;
interface ICustomerInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(byte aByte,int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
//List<Person>add(Person person);
}
