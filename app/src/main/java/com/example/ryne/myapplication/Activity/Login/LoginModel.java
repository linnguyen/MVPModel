package com.example.ryne.myapplication.Activity.Login;

import android.content.Context;

import com.example.ryne.myapplication.Utilities.Constant;
import com.example.ryne.myapplication.Utilities.Utils;

/**
 * Created by ryne on 01/06/2017.
 */

public class LoginModel implements ILoginModel {

    @Override
    public void login(String email, String password, Context context, boolean isSocialLogin, OnLoginFinishListener onLoginFinishListener) {
        if (!Utils.isValidEmail(email)){
            onLoginFinishListener.onEmailError(Constant.LOGIN_EMAIL_INVALID);
        } else {
            if (email.isEmpty()){
                onLoginFinishListener.onEmailError(Constant.LOGIN_EMAIL_EMPTY);
            } else {
                if (password.isEmpty()){
                    onLoginFinishListener.onPasswordError(1);
                } else {
                    if (isSocialLogin) {

                    } else {
                        callLogin(email, password, context, onLoginFinishListener);
                    }
                }
            }
        }
    }
    private void callLogin(final String email, String pwd, final  Context context, final OnLoginFinishListener onLoginFinishListener){
        if (email.equals("nguyenlin@gmail.com") && pwd.equals("hochiminh")){
            onLoginFinishListener.onSuccess();
        }
    }
}
