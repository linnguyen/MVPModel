package com.example.ryne.myapplication.Utilities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.ryne.myapplication.R;

/**
 * Created by ryne on 02/06/2017.
 */

public class Utils {
    private static ProgressDialog progressDialog;

    public static  void hideSoftKeyBoard(Context  context, View view){
        if(view!=null){
            InputMethodManager ipm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            ipm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public  static  boolean isValidEmail(CharSequence target){
        if(TextUtils.isEmpty(target)){
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public final  static  boolean isInternetOn(Context context){
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public static void networkErrorDialog(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder
                .setMessage("No network connection. Please check your network.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();

    }

    public static void showProgressBar(Context context){
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        progressDialog = ProgressDialog.show(context, null, null);
        progressDialog.setContentView(R.layout.progressbar);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.show();
    }

}
