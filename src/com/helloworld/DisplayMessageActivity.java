package com.helloworld;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.message);

		// Get the message from the intent
		TextView textView = (TextView) findViewById(R.id.textView);
		Intent intent = getIntent();
		String message = intent.getStringExtra(Hello.EXTRA_MESSAGE);

		// Create the text view
		textView.setTextSize(40);
		textView.setText(message);

	}

}
