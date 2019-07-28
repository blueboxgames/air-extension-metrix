package ir.metrix.ane;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class MetrixExtension implements FREExtension
{
	@Override
	public FREContext createContext(String arguments)
	{
		Log.i("ir.metrix.Metrix", "ANE context created.");
		return new MetrixExtensionContext();
	}

	@Override
	public void dispose() {

	}

	@Override
	public void initialize() {

	}
}