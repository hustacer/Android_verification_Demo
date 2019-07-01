package com.example.com.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.com.aidl_demo.ICaculate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final static String TAG = "AIDL Demo";
    private Button btn;
    private EditText editTextX;
    private EditText editTextY;
    private EditText editTextResult;

    private ICaculate mService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");
            mService = ICaculate.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected");
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        editTextX = findViewById(R.id.et1);
        editTextY = findViewById(R.id.et2);
        editTextResult = findViewById(R.id.etResult);
        editTextResult.setFocusable(false);
        btn.setOnClickListener(this);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.com.aidl_demo", "com.example.com.aidl_demo.CalculateService"));
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                int x = Integer.parseInt(editTextX.getText().toString());
                int y = Integer.parseInt(editTextY.getText().toString());
                try {
                    Log.d(TAG, "X = " + x);
                    Log.d(TAG, "Y = " + y);
                    int result = mService.add(x, y);
                    editTextResult.setText("" + result);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

    }
}
