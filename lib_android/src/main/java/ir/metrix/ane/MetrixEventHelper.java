package ir.metrix.ane;

import java.util.HashMap;
import java.util.Map;

import ir.metrix.sdk.Metrix;

public class MetrixEventHelper {
	protected static MetrixEventHelper _instance = null;

	private Map<String, Map<String, String>> nameAttribute = new HashMap<String, Map<String, String>>();
	private Map<String, Map<String, Double>> nameMetrics = new HashMap<String, Map<String, Double>>();

	public static MetrixEventHelper getInstance() {
		if(_instance == null)
			_instance = new MetrixEventHelper();
		return _instance;
	}

	public void insertAttribute(String name, String attribute, String value){
		if( nameAttribute.containsKey(name) )
		{
			Map<String,String> tmp = nameAttribute.get(name);
			tmp.put(attribute, value);
			nameAttribute.replace(name, tmp);
		}
		else {
			Map<String,String> tmp = new HashMap<String, String>();
			tmp.put(attribute, value);
			nameAttribute.put(name, tmp);
		}
	}

	public void insertMetrics(String name, String attribute, Double value){
		if( nameMetrics.containsKey(name) )
		{
			Map<String,Double> tmp = nameMetrics.get(name);
			tmp.put(attribute, value);
			nameMetrics.replace(name, tmp);
		}
		else {
			Map<String,Double> tmp = new HashMap<String, Double>();
			tmp.put(attribute, value);
			nameMetrics.put(name, tmp);
		}
	}

	public void sendEvent(String name)
	{
		if(nameAttribute.containsKey(name) && nameMetrics.containsKey(name) )
		{
			Metrix.getInstance().newEvent(name, nameAttribute.get(name), nameMetrics.get(name));
			nameAttribute.remove(name);
			nameMetrics.remove(name);
		}
		else {
			Metrix.getInstance().newEvent(name);
		}
	}
}
