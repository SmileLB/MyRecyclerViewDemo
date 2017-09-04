package com.example.administrator.myrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.myrecyclerviewdemo.adapter.SimpleAdapter;
import com.example.administrator.myrecyclerviewdemo.bean.SimpleBean;

import java.util.ArrayList;

public class SimpleActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ArrayList<SimpleBean> mList;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initData();
        initRecyclerView();
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            SimpleBean bean = new SimpleBean();
            bean.setTitle("条目" + i);
            bean.setContent("内容" + i);
            bean.setUrl("http://img5.imgtn.bdimg.com/it/u=1139776033,805074286&fm=27&gp=0.jpg");
            mList.add(bean);
        }
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        mAdapter = new SimpleAdapter(R.layout.item_simple, mList);
        mAdapter.openLoadAnimation();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(SimpleActivity.this, position + "被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(SimpleActivity.this, mList.get(position).getTitle() + "被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(SimpleActivity.this, position + "被长按了", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }
}
