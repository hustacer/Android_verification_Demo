package com.example.com.aidl_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalculateService extends Service {
    public CalculateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final ICaculate.Stub mBinder = new ICaculate.Stub() {
        @Override
        public int add(int x, int y) throws RemoteException {
            return x + y;
        }
    };
}
