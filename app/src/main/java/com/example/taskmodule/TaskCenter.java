package com.example.taskmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TaskCenter extends AppCompatActivity implements View.OnClickListener {
    private Button btn_center_all;
    private Button btn_center_publish;
    private Button btn_center_pending;
    private Button btn_center_comment;
    private Button btn_task_center_confirm;

    /**
     * 底部导航栏
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            /*            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }*/
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_center);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_task_center);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /**
         * Button的使用
         */
        btn_center_all = findViewById(R.id.btn_center_all);
        btn_center_all.setOnClickListener(this);
        btn_center_publish = findViewById(R.id.btn_center_publish);
        btn_center_publish.setOnClickListener(this);
        btn_center_pending = findViewById(R.id.btn_center_pending);
        btn_center_pending.setOnClickListener(this);
        btn_center_comment = findViewById(R.id.btn_center_comment);
        btn_center_comment.setOnClickListener(this);
        btn_task_center_confirm = findViewById(R.id.btn_task_center_confirm);
        btn_task_center_confirm.setOnClickListener(this);

        /**
         * Toolbar及ActionBar功能
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_task_center);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    /**
     * 重写过的onClick
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_center_all:

                break;
            case R.id.btn_center_publish:

                break;
            case R.id.btn_center_pending:

                break;
            case R.id.btn_center_comment:

                break;
            case R.id.btn_task_center_confirm:
                Intent intent1 = new Intent(TaskCenter.this, TaskComment.class);
                startActivity(intent1);
                break;
        }
    }


}
