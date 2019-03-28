package com.example.taskmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterSuccess extends AppCompatActivity {
    private Button btn_reg_suic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);

        /**
         * set findId
         */
        btn_reg_suic = findViewById(R.id.btn_reg_suc);
        btn_reg_suic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterSuccess.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
