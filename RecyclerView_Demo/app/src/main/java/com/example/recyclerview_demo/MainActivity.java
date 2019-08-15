package com.example.recyclerview_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initViews();

        mAdapter = new SimpleAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,  "click" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "long click" + position, Toast.LENGTH_SHORT).show();
            }
        });
        // 设置RecyclerView的分割线
        //mRecyclerView.addItemDecoration(
        //        new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerview);
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();

        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char)i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_delete:
                mAdapter.deleteData(1);
                break;
            case R.id.action_listview:
                //listview布局
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                break;
            case R.id.action_gridView:
                //Gridview布局
                mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                break;
            case R.id.action_hor_gridView:
                //水平grid
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                //瀑布流布局
                Intent intent = new Intent(this, StaggeredActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
