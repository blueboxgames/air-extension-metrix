package ir.metrix.sdk
{
	public class MetrixEvent
	{
		private var _atributes:Object;
		private var _metrics:Object;

		public function MetrixEvent()
		{
			super();
		}

		private var _name:String;
		
		public function get name():String
		{
			return _name;
		}
		
		public function set name(value:String):void
		{
			_name = value;
		}

		public function get attributes():Object
		{
			return _atributes;
		}

		public function get metrics():Object
		{
			return _metrics;
		}

		public function setAttribute(key:String, value:String):void
		{
			this._atributes[key] = value;
		}

		public function setMetrics(key:String, value:Number):void
		{
			this._metrics[key] = value;
		}

		public function send():void
		{
			Metrix.instance.sendEvent(this);
		}
	}
}