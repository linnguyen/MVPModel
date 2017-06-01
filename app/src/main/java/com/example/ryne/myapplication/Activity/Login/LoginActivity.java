package com.example.ryne.myapplication.Activity.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.ryne.myapplication.R;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edtLoginUserName)
    EditText edtLoginUserName;
    @BindView(R.id.edtLoginPassWord)
    EditText edtLoginPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
