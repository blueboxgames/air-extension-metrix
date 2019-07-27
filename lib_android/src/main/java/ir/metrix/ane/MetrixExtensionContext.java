package ir.metrix.ane;

import java.util.Map;
import java.util.HashMap;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class MetrixExtensionContext extends FREContext
{
	@Override
	public void dispose(){}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functionMap = new HashMap<String, FREFunction>();
		functionMap.put("metrix", new MetrixFunction());
		return functionMap;
	}
}