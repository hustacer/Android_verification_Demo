package com.example.com.transactiontoolargeexception_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv);

//        Intent intent = this.getIntent();
//        int[] data = intent.getIntArrayExtra("data");

//        int[] data = DataHolder.getInstance().getData();

        int[] data = (int[]) DataHolderWeakReference.getInstance().get("bigdata");
        textView.setText(data.toString());
    }
}
