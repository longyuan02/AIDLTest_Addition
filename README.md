# AIDLTest_Addition
annotation 工程说明
# moudle
    |-AIDLmoudle 测试AIDL
    |-

# 使用注意事项
    |-AIDLmoudle   IPC   多应用    多线程
    |-Binder       IPC   多应用    无多线程
    |-Message      IPC   单应用    无多线程

# AIDL支持除了short以外的其他基本数据类型
    byte short(不支持) int long float double boolean
    list\ map \CharSequence\String
    不支持short原因--Parcelable 序列化不支持writeShote()

# 使用流程
    |-定义接口
    |-服务端实现
    |-客户端调用
  |-基本语法
    |-AIDL只支持方法不支持静态成员变量
    |-AIDL有任何形式的参数和返回值
    |-除默认基本类型 均需要导包 (在类名.AIDL中声明 parcelable 类--aidl文件中import导入)





