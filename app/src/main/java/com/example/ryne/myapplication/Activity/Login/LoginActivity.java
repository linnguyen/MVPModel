package com.example.ryne.myapplication.Activity.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryne.myapplication.R;
import com.example.ryne.myapplication.Utilities.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnTouchListener{
    private ILoginPresenter loginPresenter;
    @BindView(R.id.edtLoginUserName)
    EditText edtLoginUserName;
    @BindView(R.id.edtLoginPassWord)
    EditText edtLoginPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btnLogin)
    public void login(View view){
        Utils.hideSoftKeyBoard(this, view);
        if (Utils.isInternetOn(this)) {
            loginPresenter.validateUser(edtLoginUserName.getText().toString().trim(), edtLoginPassWord.getText().toString(),LoginActivity.this, false);
        } else {
            Utils.networkErrorDialog(this);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void showProgressbar() {
      Utils.showProgressBar(this);
    }

    @Override
    public void showMessageSuccess() {
        Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_LONG).show();
    }
}
