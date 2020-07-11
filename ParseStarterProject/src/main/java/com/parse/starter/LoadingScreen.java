package com.parse.starter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class LoadingScreen {
    Activity activity;
    AlertDialog dialog;
    LoadingScreen(Activity mctivity){
        this.activity = mctivity;
    }
    void startloadingScreen(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        builder.setView(layoutInflater.inflate(R.layout.loading_animations,null));
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }
    void stoploadingScreen(){
        dialog.dismiss();
    }

}
