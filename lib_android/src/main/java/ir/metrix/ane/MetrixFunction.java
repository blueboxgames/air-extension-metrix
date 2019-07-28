package ir.metrix.ane;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class MetrixFunction implements FREFunction
{
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		if(context==null)
		{
			Log.i("ir.metrix.Metrix", "No context recieved");
			return null;
		}

		MetrixANE.getInstance().nativeContext = (MetrixExtensionContext) context;
		
		try {
			String command = args[0].getAsString();
			Log.i(MetrixANE.TAG, "called function: " + command);

			if ( command.equalsIgnoreCase("initialize") )
			{
				String appID = args[1].getAsString();
				MetrixANE.getInstance().initialize(appID);
				return null;
			}

			if ( command.equalsIgnoreCase("enableLocationListening") )
			{
				MetrixANE.getInstance().enableLocationListening();
				return null;
			}

			if ( command.equalsIgnoreCase("disableLocationListening") )
			{
				MetrixANE.getInstance().disableLocationListening();
				return null;
			}

			if ( command.equalsIgnoreCase("setEventUploadThreshold") )
			{
				int count = args[1].getAsInt();
				MetrixANE.getInstance().setEventUploadThreshold(count);
				return null;
			}

			if ( command.equalsIgnoreCase("setEventUploadMaxBatchSize") )
			{
				int count = args[1].getAsInt();
				MetrixANE.getInstance().setEventUploadMaxBatchSize(count);
				return null;
			}

			if ( command.equalsIgnoreCase("setEventMaxCount") )
			{
				int count = args[1].getAsInt();
				MetrixANE.getInstance().setEventMaxCount(count);
				return null;
			}

			if ( command.equalsIgnoreCase("setEventUploadPeriodMillis") )
			{
				int millis = args[1].getAsInt();
				MetrixANE.getInstance().setEventUploadPeriodMillis(millis);
				return null;
			}

			if ( command.equalsIgnoreCase("setSessionTimeoutMillis") )
			{
				long timeout = (long) args[1].getAsDouble();
				MetrixANE.getInstance().setSessionTimeoutMillis(timeout);
				return null;
			}

			if ( command.equalsIgnoreCase("enableLogging") )
			{
				boolean value = args[1].getAsBool();
				MetrixANE.getInstance().enableLogging(value);
				return null;
			}

			if ( command.equalsIgnoreCase("setLogLevel") )
			{
				int level = args[1].getAsInt();
				MetrixANE.getInstance().setLogLevel(level);
				return null;
			}

			if ( command.equalsIgnoreCase("setFlushEventsOnClose") )
			{
				boolean value = args[1].getAsBool();
				MetrixANE.getInstance().setFlushEventsOnClose(value);
				return null;
			}

			if ( command.equalsIgnoreCase("getSessionNum") )
			{
				return FREObject.newObject( MetrixANE.getInstance().getSessionNum() );
			}

			if ( command.equalsIgnoreCase("eventAttribute") )
			{
				String name = args[1].getAsString();
				String key = args[2].getAsString();
				String value = args[3].getAsString();
				MetrixEventHelper.getInstance().insertAttribute(name, key, value);
				return null;
			}

			if ( command.equalsIgnoreCase("eventMetric") )
			{
				String name = args[1].getAsString();
				String key = args[2].getAsString();
				Double value = args[3].getAsDouble();
				MetrixEventHelper.getInstance().insertMetrics(name, key, value);
				return null;
			}

			if ( command.equalsIgnoreCase("newEvent") )
			{
				String name = args[1].getAsString();
				MetrixEventHelper.getInstance().sendEvent(name);
				return null;
			}

			if ( command.equalsIgnoreCase("newRevenue") )
			{
				String name = args[1].getAsString();
				double amount = args[2].getAsDouble();
				int currencyValue = args[3].getAsInt();
				String optional = args[4].getAsString();

				MetrixANE.getInstance().newRevenue(name, amount, currencyValue, optional);
				return null;
			}

			if ( command.equalsIgnoreCase("addUserAttribute") )
			{
				String attribute = args[1].getAsString();
				String value = args[2].getAsString();
				MetrixUserHelper.getInstance().insertAttribute(attribute, value);
				return null;
			}

			if ( command.equalsIgnoreCase("addUserAttributes") )
			{
				MetrixUserHelper.getInstance().addUserAttributes();
			}

			if ( command.equalsIgnoreCase("addUserMetrics") )
			{
				String metric = args[1].getAsString();
				Double value = args[2].getAsDouble();
				MetrixUserHelper.getInstance().insertMetrics(metric, value);
			}

			if ( command.equalsIgnoreCase("setUserMetrics") )
			{
				MetrixUserHelper.getInstance().setUserMetrics();
			}

			if ( command.equalsIgnoreCase("setScreenFlowsAutoFill") )
			{
				boolean value = args[1].getAsBool();
				MetrixANE.getInstance().setScreenFlowsAutoFill(value);
				return null;
			}

			if ( command.equalsIgnoreCase("isScreenFlowsAutoFill") )
			{
				return FREObject.newObject( MetrixANE.getInstance().isScreenFlowsAutoFill() );
			}

			if ( command.equalsIgnoreCase("setDefaultTracker") )
			{
				String token = args[1].getAsString();
				MetrixANE.getInstance().setDefaultTracker(token);
				return null;
			}

			if ( command.equalsIgnoreCase("setAppSecret") )
			{
				long secretID = (long) args[1].getAsDouble();
				long info1 = (long) args[2].getAsDouble();
				long info2 = (long) args[3].getAsDouble();
				long info3 = (long) args[4].getAsDouble();
				long info4 = (long) args[5].getAsDouble();
				MetrixANE.getInstance().setAppSecret(secretID, info1, info2, info3, info4);
				return null;
			}

		} catch (Exception error) {
			error.printStackTrace();
		}
		return null;
	}
}