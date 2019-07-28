package ir.metrix.sdk
{
	public class MetrixUser
	{
		private var _atributes:Object;
		private var _metrics:Object;

		public function MetrixUser()
		{
			super();
		}

		public function get attributes():Object
		{
			return _atributes;
		}

		public function get metrics():Object
		{
			return _metrics;
		}

		public function addAttribute(key:String, value:String):void
		{
			this._atributes[key] = value;
		}

		public function addMetric(key:String, value:Number):void
		{
			this._metrics[key] = value;
		}

		public function addUserAttributes():void
		{
			Metrix.instance.addUserAttributes(this._atributes);
		}

		public function addUserMetrics():void
		{
			Metrix.instance.setUserMetrics(this._metrics);
		}
	}
}