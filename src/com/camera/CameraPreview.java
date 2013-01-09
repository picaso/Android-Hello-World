package com.camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import static android.hardware.Camera.PictureCallback;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
	Camera camera;

	public CameraPreview(Context context) {
		super(context);
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
	}

	public void takePicture(PictureCallback callback) {
		camera.takePicture(null, null, callback);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			// Open the Camera in preview mode
			camera = Camera.open();
			camera.setPreviewDisplay(holder);
		} catch (IOException ioe) {
			ioe.printStackTrace(System.out);
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		camera.setDisplayOrientation(270);
		camera.getParameters();
		// IMPORTANT: We must call startPreview() on the camera before we take
		// any pictures
		camera.startPreview();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.stopPreview();
		camera.release();
		camera = null;
	}

}
