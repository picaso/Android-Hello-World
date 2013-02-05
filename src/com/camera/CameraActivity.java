package com.camera;


import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.helloworld.R;
import com.parse.Parse;
import com.parse.ParseObject;

public class CameraActivity extends Activity implements  Camera.PictureCallback{
	private Button shutterButton;
	private CameraPreview cameraPreview;

	@Override
	public  void onCreate(Bundle b){
		super.onCreate(b);
        Parse.initialize(this, "38faGNV3UuHWiepxRkL3u0ofx80BXVFGSF2S2E2v", "ETLJ7Lcujc9m2Eq0CE9cb8ldDqEwgu2vTaKdHnCs");
        setContentView(R.layout.camera);
		cameraPreview = new CameraPreview(this);
		RelativeLayout preview = (RelativeLayout) findViewById(R.id.camera);
		preview.addView(cameraPreview);
		shutterButton = (Button) findViewById(R.id.shutter_button);

	}

	public void takePicture(View v) {
		shutterButton.setEnabled(false);
		cameraPreview.takePicture(this);
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		camera.startPreview();
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("pic", data);
        testObject.saveInBackground();
		shutterButton.setEnabled(true);
	}

}
