package com.example.ryne.myapplication.Activity.Login;

import android.content.Context;

/**
 * Created by ryne on 01/06/2017.
 */

public interface ILoginPresenter {
    void validateUser(String email, String password, Context context, boolean isSocialLogin);
}
