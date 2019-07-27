package ir.metrix.ane;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class MetrixExtension implements FREExtension
{
	@Override
	public FREContext createContext(String arguments)
	{
		return new MetrixExtensionContext();
	}

	@Override
	public void dispose() {

	}

	@Override
	public void initialize() {

	}
}