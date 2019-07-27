package ir.metrix.ane;

import android.app.Activity;
import android.os.Bundle;

import ir.metrix.sdk.Metrix;

/**
 * MetrixANEActivity
 */
public class MetrixANEActivity extends Activity {
	@Override
	public void onCreate(Bundle saveInstanceState)
	{
		super.onCreate(saveInstanceState);
		Metrix.initialize(this, "");
	}
}