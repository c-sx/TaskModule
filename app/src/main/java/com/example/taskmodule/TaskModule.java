package com.example.taskmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TaskModule extends AppCompatActivity {
    private Button button_publish;
    private Button button_receive;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_module);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_task_module);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        button_publish = (Button) findViewById(R.id.btn_task_publish);
        button_receive = (Button) findViewById(R.id.btn_task_receive);
        button_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskModule.this, TaskCategory.class);
                startActivity(intent);
            }
        });
        button_receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskModule.this, TaskReceive.class);
                startActivity(intent);
            }
        });
    }

}
