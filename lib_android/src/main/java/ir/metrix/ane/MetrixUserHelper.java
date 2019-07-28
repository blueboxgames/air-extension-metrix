package ir.metrix.ane;

import java.util.Map;

import java.util.HashMap;
import java.util.Map;

import ir.metrix.sdk.Metrix;

public class MetrixUserHelper {
	protected static MetrixUserHelper _instance = null;

	private Map<String, String> userAttributes = new HashMap<String, String>();
	private Map<String, Double> userMetrics = new HashMap<String, Double>();

	public static MetrixUserHelper getInstance() {
		if(_instance == null)
			_instance = new MetrixUserHelper();
		return _instance;
	}

	public void insertAttribute(String attribute, String value){
		userAttributes.put(attribute, value);
	}

	public void insertMetrics(String attribute, Double value){
		userMetrics.put(attribute, value);
	}

	public void addUserAttributes()
	{
		Metrix.getInstance().addUserAttributes(userAttributes);
	}

	public void setUserMetrics()
	{
		Metrix.getInstance().setUserMetrics(userMetrics);
	}
}