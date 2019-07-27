package ir.metrix.sdk
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	import flash.events.Event;
	import com.android.metrix.Log;

	public class Metrix extends EventDispatcher
	{
		static private var _instance:Metrix;
		private var _context:ExtensionContext;
		private var _appID:String;
		
		public function Metrix()
		{
			super();
			this._context = ExtensionContext.createExtensionContext("ir.metrix.extension", "");

			if (this._context == null)
				throw new Error("<ir.metrix.extension> not found or is not supported on this platfrom.");
			
			this._context.addEventListener( StatusEvent.STATUS, context_statusHandler);
		}

		static public function get instance():Metrix
		{
			if(_instance == null)
				_instance = new Metrix();
			return _instance;
		}

		// ---------------------
		// Methods
		// ---------------------
		/**
		 * Delete the extension context.
		 */
		public function dispose():void
		{
			this._context.dispose();
		}

		public function get appID():String
		{
			return this._appID;
		}

		public function set appID(id:String):void
		{
			this._appID = id;
		}

		public function initialize():void
		{
			if(this._appID == null)
			{
				trace("<ir.metrix.extension> you must setup you app id before initializing.");
				return;
			}
			this._context.call("metrix", "initialize", this._appID);
		}

		/**
		 * Enable users location related information sending with other
		 * informations.
		 */
		public function enableLocationListening():void
		{
			this._context.call("metrix", "enableLocationListening");
		}

		public function disableLocationListening():void
		{
			this._context.call("metrix", "disableLocationListening");
		}

		/**
		 * Determine when to send events to server after how many event
		 * counts occurs.
		 * 
		 * @default 30
		 * @param count: event count threshold.
		 * @return void
		 */
		public function set eventUploadThreshold(count:int):void
		{
			this._context.call("metrix", "setEventUploadThreshold", count);
		}

		/**
		 * Set maximum amount of event sending in each request.
		 * 
		 * @default 100
		 * @param count: batch event count
		 * @return void
		 */
		public function set eventUploadMaxBatchSize(count:int):void
		{
			this._context.call("metrix", "setEventUploadMaxBatchSize", count);
		}

		/**
		 * 
		 */
		public function set eventMaxCount(count:int):void
		{
			this._context.call("metrix", "setEventMaxCount", count);
		}

		/**
		 * 
		 */
		public function set eventUploadPeriodMillis(milisec:int):void
		{
			this._context.call("metrix", "setEventUploadPeriodMillis", milisec);
		}

		/**
		 * 
		 */
		public function set sessionTimeoutMillis(timeout:Number):void
		{
			this._context.call("metrix", "setSessionTimeoutMillis", timeout);
		}

		/**
		 * 
		 */
		public function set enableLogging(value:Boolean):void
		{
			this._context.call("metrix", "enableLogging", value);
		}

		/**
		 * @default Log.INFO
		 * @see com.android.metrix.Log
		 */
		public function set logLevel(value:int):void
		{
			if(
				value != Log.VERBOSE || 
				value != Log.DEBUG ||
				value != Log.INFO ||
				value != Log.WARN ||
				value != Log.ERROR ||
				value != Log.ASSERT
			)
			{
				throw new Error("<Metrix> log level:" + value + " is not a valid log level.");
			}
			this._context.call("metrix", "setLogLevel", value);
		}

		public function set flushEventsOnClose(value:Boolean):void
		{
			this._context.call("metrix", "setFlushEventsOnClose", value);
		}

		public function get sessionNum():int
		{
			return this._context.call("metrix", "getSessionNum") as int;
		}

		public function newEvent(eventName:String):MetrixEvent
		{
			var metrixEvent:MetrixEvent = new MetrixEvent();
			metrixEvent.name = eventName;
			return metrixEvent;
		}

		public function sendEvent(metrixEvent:MetrixEvent):void
		{
			var key:String;
			for each(key in metrixEvent.attributes)
			{
				this._context.call("metrix", "eventAttribute", metrixEvent.name, key, metrixEvent.attributes[key]);
			}
			for each(key in metrixEvent.metrics)
			{
				this._context.call("metrix", "eventMetric", metrixEvent.name, key, metrixEvent.metrics[key]);
			}
			this._context.call("metrix", "newEvent", metrixEvent.name);
		}

		public function newRevenue(name:String, amount:Number, currency:int=0, optional:String=null):void
		{
			this._context.call("metrix", "newRevenue", name, amount, currency, optional);
		}

		public function addUserAttributes(attributes:Object):void
		{
			this._context.call("metrix", "addUserAttributes", attributes);
		}

		public function setUserMetrics(attributes:Object):void
		{
			this._context.call("metrix", "setUserMetrics", attributes);
		}

		public function set screenFlowsAutoFill(value:Boolean):void
		{
			this._context.call("metrix", "setScreenFlowsAutoFill", value);
		}

		public function get screenFlowsAutoFill():Boolean
		{
			return this._context.call("metrix", "isScreenFlowsAutoFill") as Boolean;
		}

		public function set defaultTracker(token:String):void
		{
			this._context.call("metrix", "setDefaultTracker", token);
		}

		public function setAppSecret(secretID:Number, info1:Number, info2:Number, info3:Number, info4:Number):void
		{
			this._context.call("metrix", "setAppSecret", secretID, info1, info2, info3, info4);
		}
		// ---------------------
		// Event handlers
		// ---------------------
		/**
		 * @private Listens for extensions events.
		 */
		private function context_statusHandler(event:StatusEvent):void
		{
			// this.dispatchEvent( new Event("") );
		}
	}
}