package com.example.com.transactiontoolargeexception_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                int[] data = new int[1024*1024*8];
                // intent -- can not translate big data
//                Bundle bundle = new Bundle();
//                bundle.putIntArray("data", data);
//                intent.putExtras(bundle);
                // DataHolder -- memory leak may happen
//                DataHolder.getInstance().setData(data);

                DataHolderWeakReference.getInstance().save("bigdata", data);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
