package com.angelhack.visionangelhack;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

	static final int REQUEST_VIDEO_CAPTURE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	private void tests() {
		Uri u = Uri.fromFile(new File("/sdcard/DCIM/Camera/Test.mp4"));
		u = Uri.parse(
				new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/Test.mp4").toString());
		VideoView v = (VideoView) findViewById(R.id.videoView1);
		// v.setVideoURI(u);

//		Uri uri = Uri.parse(Environment.getExternalStorageDirectory() + "/DCIM/Camera/Test.mp4");
		Uri uri = Uri.parse(Environment.getExternalStorageDirectory() + "/Download/Scotts.wav");
//		File file = new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera/Tes1t.mp4");
//		Log.d("Nitin", file.exists() + "");
		v.setVideoURI(uri);
		v.start();

		u = Uri.parse(new File("/sdcard/DCIM/Camera/nitin.jpg").toString());
		u = Uri.fromFile(new File("/sdcard/DCIM/Camera/nitin.jpg"));
		ImageView i = (ImageView) findViewById(R.id.imageView1);
		i.setImageURI(u);
	}

	public void dispatchTakeVideoIntent(View view) {
		Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
			Uri videoUri = data.getData();
			VideoView v = (VideoView) findViewById(R.id.videoView1);
			v.setVideoURI(videoUri);
			v.start();
		}
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
}
