package com.example.thecallr;

import java.util.Hashtable;

import com.google.gson.JsonElement;
import com.thecallr.Api;
import com.thecallr.exceptions.ThecallrException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public void sendSms(View view) {
    	new Thread(new Runnable() {
            public void run() {
            	Api tc = new Api("login", "password");
                
                Hashtable<String, Object> param = new Hashtable<String, Object>();
                param.put("flash_message", false);
                
                try {
        			JsonElement result = tc.call("sms.send", "THECALLR", "+33123456789", "Hello, world", param);
        			System.out.println(result);
        		} catch (ThecallrException e) {
        			System.out.println(e.getMessage());
        			System.out.println(e.data);
        		}
            }
        }).start();
    }
}
