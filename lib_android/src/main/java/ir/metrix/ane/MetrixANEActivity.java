package ir.metrix.ane;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import ir.metrix.sdk.Metrix;

/**
 * MetrixANEActivity
 */
public class MetrixANEActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		Metrix.initialize(this.getApplication(), extras.getString("app_id"));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}
}