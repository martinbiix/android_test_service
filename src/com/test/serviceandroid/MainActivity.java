package com.test.serviceandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	Intent in;
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

	public void onClickIniciarServicio(View v){
         in = new Intent(MainActivity.this,MyService.class);
        if(!MyService.isRunning())
            MainActivity.this.startService(in);
	}
	
	public void onClickPararServicio(View v){
        in = new Intent(MainActivity.this,MyService.class);
        if(MyService.isRunning())
            MainActivity.this.stopService(in);
        else
        	Toast.makeText(getApplicationContext(), "El servicio no se encuentra iniciado", Toast.LENGTH_LONG).show();
	}
}
