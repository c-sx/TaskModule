package com.example.taskmodule;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class TaskReceiveDetails extends AppCompatActivity {
    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_time;
    private TextView tv_type;
    private TextView tv_integral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_receive_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_task_receive_details);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_title = findViewById(R.id.tv_task_receive_details_title);
        tv_time = findViewById(R.id.tv_task_receive_details_time);
        tv_type = findViewById(R.id.tv_task_receive_details_type);
        tv_content = findViewById(R.id.tv_task_receive_details_content);
        tv_integral = findViewById(R.id.tv_task_receive_details_integral);
    }

}
