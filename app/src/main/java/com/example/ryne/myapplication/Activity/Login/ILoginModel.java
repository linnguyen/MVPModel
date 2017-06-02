package com.example.ryne.myapplication.Activity.Login;

import android.content.Context;

/**
 * Created by ryne on 01/06/2017.
 */

public interface ILoginModel {
    interface OnLoginFinishListener {
        void onEmailError(int code);
        void onPasswordError(int code);
        void onSuccess();
        void onApiFailure(int code);
    }

    void login(String email, String password, Context context, boolean isSocialLogin, OnLoginFinishListener onLoginFinishListener);
}
