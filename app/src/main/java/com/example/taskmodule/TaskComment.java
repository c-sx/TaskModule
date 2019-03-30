package com.example.taskmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaskComment extends AppCompatActivity {
    private Button btn_task_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_comment);

        btn_task_comment = findViewById(R.id.btn_task_comment);
        btn_task_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskComment.this, CommentSuccess.class);
                startActivity(intent);
            }
        });
    }
}
