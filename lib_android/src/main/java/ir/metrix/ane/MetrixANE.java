package ir.metrix.ane;

import android.content.Intent;
import android.os.Bundle;

import ir.metrix.sdk.Metrix;
import ir.metrix.sdk.MetrixCurrency;

public class MetrixANE
{
	public static final String TAG = "MetrixANE";
	public MetrixExtensionContext nativeContext;
	protected static MetrixANE _instance = null;

	public static MetrixANE getInstance(){
		if (_instance == null)
			_instance = new MetrixANE();
		return _instance;
	}


	public void initialize(String appid)
	{
		Metrix.initialize(this.nativeContext.getActivity().getApplication(), appid);
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
		Metrix.getInstance().setEventUploadMaxBatchSize(count);
	}

	public void setEventMaxCount(int count)
	{
		Metrix.getInstance().setEventMaxCount(count);
	}

	public void setEventUploadPeriodMillis(int milisec)
	{
		Metrix.getInstance().setEventUploadPeriodMillis(milisec);
	}

	public void setSessionTimeoutMillis(long milies)
	{
		Metrix.getInstance().setSessionTimeoutMillis(milies);
	}

	public void enableLogging(boolean value)
	{
		Metrix.getInstance().enableLogging(value);
	}

	public void setLogLevel(int level)
	{
		Metrix.getInstance().setLogLevel(level);
	}

	public void setFlushEventsOnClose(boolean value)
	{
		Metrix.getInstance().setFlushEventsOnClose(value);
	}

	public double getSessionNum()
	{
		return (double) Metrix.getInstance().getSessionNum();
	}

	public void newRevenue(String name, double amount, int currencyValue, String optional)
	{
		MetrixCurrency currency = MetrixCurrency.IRR;
		switch (currencyValue)
		{
			case 0: currency = MetrixCurrency.IRR; break;
			case 1: currency = MetrixCurrency.USD; break;
			case 2: currency = MetrixCurrency.EUR; break;
			default: currency = MetrixCurrency.IRR; break;
		}
		Metrix.getInstance().newRevenue(name, amount, currency, optional);
	}

//	public void addUserAttributes()
//	{
//
//	}
//
//	public void setUserMetrics()
//	{
//
//	}

	public void setScreenFlowsAutoFill(boolean value)
	{
		Metrix.getInstance().setScreenFlowsAutoFill(value);
	}

	public boolean isScreenFlowsAutoFill()
	{
		return Metrix.getInstance().isScreenFlowsAutoFill();
	}

	public void setDefaultTracker(String token)
	{
		Metrix.getInstance().setDefaultTracker(token);
	}

	public void setAppSecret(long secretID, long info1, long info2, long info3, long info4)
	{
		Metrix.getInstance().setAppSecret(secretID, info1, info2, info3, info4);
	}
}