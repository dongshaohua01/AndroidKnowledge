// IServiceManager.aidl
package com.cmcc.androidknowledge;

//服务对象Binder管理
interface IServiceManager {

      IBinder getService(String serviceName);

}
