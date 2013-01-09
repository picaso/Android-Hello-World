package com.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.camera.CameraActivity;
import com.customview.SampleView;

public class Hello extends Activity {
	public static final String EXTRA_MESSAGE ="com.helloworld.HELLO" ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	public void startCamera(View view) {
		Intent intent = new Intent(this, CameraActivity.class);
		startActivity(intent);
	}

    public void startCustomView(View v){
        Intent intent= new Intent(this, SampleView.class);
        startActivity(intent);

    }
}
