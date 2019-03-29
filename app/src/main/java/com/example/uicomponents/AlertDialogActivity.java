package com.example.uicomponents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertDialogActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
         dialog=new AlertDialog.Builder(this).setTitle("Dialog")
                .setIcon(R.mipmap.ic_launcher).setView(R.layout.activity_alert_dialog)
                 .setPositiveButton("Cancle",null)
                 .setNegativeButton("Sign in",null);
        dialog.show();
    }
}
