package com.callr.samples.callrsampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;

import com.callr.exceptions.CallrException;
import com.callr.Api;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // we need this to execute blocking calls on main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
    }

    // This is where we send our SMS
    public void sendSMS(View view){
        String phoneNumber = ((EditText)findViewById(R.id.editPhonenumber)).getText().toString();
        String message = ((EditText)findViewById(R.id.editMessage)).getText().toString();
        Api api = new Api("login", "password");
        try {
            api.call("sms.send","SMS", phoneNumber, message, null);
        } catch (CallrException e) {
            e.printStackTrace();
        }
    }
}
