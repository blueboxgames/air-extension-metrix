package ir.metrix.ane;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

import java.util.HashMap;
import java.util.Map;

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