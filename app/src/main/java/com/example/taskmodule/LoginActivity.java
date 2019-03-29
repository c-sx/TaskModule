package com.example.taskmodule;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private String userName, userPW;
    private Button btn_login;
    private EditText et_log_user;
    private EditText et_log_pw;
    private TextView tv_log_reg;
    private TextView tv_log_forget;

    /**
     * post请求
     */
    private static final int POST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
         * findId
         */
        btn_login = findViewById(R.id.btn_login);
        et_log_user = findViewById(R.id.et_log_user);
        et_log_pw = findViewById(R.id.et_log_pw);
        tv_log_reg = findViewById(R.id.btn_login_reg);
        tv_log_forget = findViewById(R.id.btn_login_forget);

        /**
         * setOnClickListener
         */
        //设置Login界面“登录”btn
        btn_login.setOnClickListener(this);
        //设置Login界面“立即注册”btn
        tv_log_reg.setOnClickListener(this);
        //设置Login界面“忘记密码”btn
        tv_log_forget.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                //获取文本框中的内容
                userName = et_log_user.getText().toString().trim();
                userPW = et_log_pw.getText().toString().trim();
                loginPost(userName, userPW);
                break;
        }
    }

    /**
     * 使用post请求网络数据
     */
    private void loginPost(final String userName, final String userPW) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String result = post("http://www.xinxianquan.xyz:8080/zhaqsq/user/login", "\"userName\":\"" + userName + "\",\"userPassword\":\"" + userPW + "\"");
                    Log.e("TAG", result);
                    Message msg = Message.obtain();
                    msg.what = POST;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * okhttp3的post请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    /**
     * 导入gson
     */
    Gson gson = new Gson();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case POST:
                    //解析json数据
//                    Calls calls_post = gson.fromJson((String) msg.obj, Calls.class);

                    Toast.makeText(LoginActivity.this, (String) msg.obj, Toast.LENGTH_LONG).show();

                    //展示数据

//                    tv_tips1.setText("Json内容为：");
//                    tv_json.setText((String) msg.obj);
//                    tv_tips2.setText("Gson转化为：");
//                    tv_gson.setText(calls_post.toString());
                    break;
            }
        }
    };
}
