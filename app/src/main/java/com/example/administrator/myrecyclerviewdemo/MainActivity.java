package com.example.administrator.myrecyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
    }

    private void initView() {
        mBtn1 = (Button)findViewById(R.id.btn1);
        mBtn2 = (Button)findViewById(R.id.btn2);
        mBtn3 = (Button)findViewById(R.id.btn3);
        mBtn4 = (Button)findViewById(R.id.btn4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(this,SimpleActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this,AnimationActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this,AddDeleteViewActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this,DragSwipActivity.class));
                break;
        }
    }
}
