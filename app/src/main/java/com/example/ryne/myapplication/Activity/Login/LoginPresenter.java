package com.example.ryne.myapplication.Activity.Login;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ryne on 01/06/2017.
 */

public class LoginPresenter implements ILoginPresenter, ILoginModel.OnLoginFinishListener{
    private ILoginView loginView;
    private ILoginModel loginInteractor;

    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
        loginInteractor = new LoginModel();
    }
    @Override
    public void validateUser(String username, String password, Context context, boolean isSocialLogin) {
       if (loginView != null){
           loginView.showProgressbar();
       }
       loginInteractor.login(username, password, context, isSocialLogin, this);
    }

    @Override
    public void onEmailError(int code) {

    }

    @Override
    public void onPasswordError(int code) {

    }

    @Override
    public void onSuccess() {
       loginView.showMessageSuccess();
    }

    @Override
    public void onApiFailure(int code) {

    }
}
