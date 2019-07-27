package ir.metrix.ane;

import com.adobe.air.AndroidActivityWrapper;
import ir.metrix.sdk.Metrix;

public class MetrixANE
{
	public static final String TAG = "MetrixANE";
	protected static String APP_ID = null;
	protected static MetrixANE _instance = null;

	public static MetrixANE getInstance(){
		if (_instance == null)
			_instance = new MetrixANE();
		return _instance;
	}


	public void initialize(String appid)
	{
		if (APP_ID == null)
			APP_ID = appid;
	}

	public void enableLocationListening()
	{
		Metrix.getInstance().enableLocationListening();
	}

	public void disableLocationListening()
	{
		Metrix.getInstance().disableLocationListening();
	}

	public void setEventUploadThreshold(int count)
	{
		Metrix.getInstance().setEventUploadThreshold(count);
	}

	public void setEventUploadMaxBatchSize(int count)
	{

	}

	public void setEventMaxCount(int count)
	{

	}

	public void setEventUploadPeriodMillis(int milisec)
	{
		
	}

	public void setSessionTimeoutMillis(long milies)
	{

	}

	public void enableLogging(boolean value)
	{

	}

	public void setLogLevel(int level)
	{

	}

	public void setFlushEventsOnClose(boolean value)
	{

	}

	public double getSessionNum()
	{
		return (double) Metrix.getInstance().getSessionNum();
	}

	public void newEvent()
	{

	}

	public void newRevenue(String name, double amount, int currency, String optional)
	{

	}

	public void addUserAttributes()
	{
		
	}

	public void setUserMetrics()
	{

	}

	public void setScreenFlowsAutoFill(boolean value)
	{

	}

	public boolean isScreenFlowsAutoFill()
	{
		return Metrix.getInstance().isScreenFlowsAutoFill();
	}

	public void setDefaultTracker(String token)
	{

	}

	public void setAppSecret(long secretID, long info1, long info2, long info3, long info4)
	{
		
	}

}