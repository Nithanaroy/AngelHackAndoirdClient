package com.angelhack.visionangelhack;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

public class History extends ActionBarActivity {

	private static boolean isPlaying = false;
	VideoView teacherVideoView = null, slidesVideoView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);

		Uri teacherAudioSource = Uri.parse(Environment.getExternalStorageDirectory() + "/DCIM/Camera/Test.mp4");
		Uri slidesAudioSource = Uri.parse(Environment.getExternalStorageDirectory() + "/DCIM/Camera/test2.mp4");
		teacherVideoView = (VideoView) findViewById(R.id.teacherVideoView);
		slidesVideoView = (VideoView) findViewById(R.id.slideVideoView);
		teacherVideoView.setVideoURI(teacherAudioSource);
		slidesVideoView.setVideoURI(slidesAudioSource);

		isPlaying = false;
	}

	public void controlAudio(View view) {
		if (isPlaying) {
			// Swap Button
			teacherVideoView.pause();
			if (slidesVideoView.isPlaying())
				slidesVideoView.resume();
			else
				slidesVideoView.start();
			isPlaying = false;
		} else {
			// Start Playing Button
			slidesVideoView.pause();
			if (teacherVideoView.isPlaying())
				teacherVideoView.resume();
			else
				teacherVideoView.start();
			isPlaying = true;
		}
	}

	public void stopPlayback(View view) {
		isPlaying = false;
		teacherVideoView.stopPlayback();
		slidesVideoView.stopPlayback();
	}

	private void tests() {
		Uri u = Uri.fromFile(new File("/sdcard/DCIM/Camera/Test.mp4"));
		u = Uri.parse(
				new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/Test.mp4").toString());
		VideoView v = (VideoView) findViewById(R.id.teacherVideoView);
		// v.setVideoURI(u);

		// Uri uri = Uri.parse(Environment.getExternalStorageDirectory() +
		// "/DCIM/Camera/Test.mp4");
		Uri uri = Uri.parse(Environment.getExternalStorageDirectory() + "/Download/Scotts.wav");
		// File file = new File(Environment.getExternalStorageDirectory() +
		// "/DCIM/Camera/Tes1t.mp4");
		// Log.d("Nitin", file.exists() + "");
		v.setVideoURI(uri);
		v.start();

		u = Uri.parse(new File("/sdcard/DCIM/Camera/nitin.jpg").toString());
		u = Uri.fromFile(new File("/sdcard/DCIM/Camera/nitin.jpg"));
		// ImageView i = (ImageView) findViewById(R.id.imageView1);
		// i.setImageURI(u);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.history, menu);
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
}
