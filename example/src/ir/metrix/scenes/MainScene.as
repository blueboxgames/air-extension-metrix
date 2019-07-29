package ir.metrix.scenes
{
	import feathers.controls.Button;
	import feathers.controls.Screen;
	import feathers.layout.AnchorLayout;
	import feathers.layout.AnchorLayoutData;

	import ir.metrix.sdk.Metrix;
	import ir.metrix.sdk.MetrixCurrency;
	import ir.metrix.sdk.MetrixEvent;

	import starling.events.Event;
	import starling.events.ResizeEvent;

	public class MainScene extends Screen
	{
		static public const NAME:String = "main";
		static public const APPID:String = "wwjrsawgehzhzti";
		public function MainScene()
		{
			super();
			this.addEventListener(Event.ADDED_TO_STAGE, addedToStageHandler);
		}

		private function addedToStageHandler(e:Event):void
		{
			this.removeEventListener(Event.ADDED_TO_STAGE, addedToStageHandler);
			this.stage.addEventListener(ResizeEvent.RESIZE, stage_resizeHandler);
		}

		override protected function initialize():void
    {
			super.initialize();
			this.name = "MainView";

			this.layout = new AnchorLayout();
			if(Metrix.instance.isSupported)
			{
				trace("Device is supported");
				Metrix.instance.appID = APPID;
				Metrix.instance.initialize();
			}
			
			var newEvent:Button = new Button();
			newEvent.label = "newEvent";
			newEvent.layoutData = new AnchorLayoutData(NaN,NaN, NaN ,NaN, 0, -15);
			if(Metrix.instance.isSupported)
				newEvent.addEventListener(Event.TRIGGERED, newEvent_triggeredHandler);
			this.addChild(newEvent);

			var newRevenue:Button = new Button();
			newRevenue.label = "newRevenue";
			newRevenue.layoutData = new AnchorLayoutData(NaN,NaN, NaN ,NaN, 0, 15);
			if(Metrix.instance.isSupported)
				newRevenue.addEventListener(Event.TRIGGERED, newRevenue_triggeredHanlder);
			this.addChild(newRevenue);
		}

		protected function newEvent_triggeredHandler(event:Event):void
		{
			// Event Slug must be recieved from dashboard.
			var metrixEvent:MetrixEvent = Metrix.instance.newEvent("event_slug");
			Metrix.instance.sendEvent(metrixEvent);
		}

		protected function newRevenue_triggeredHanlder(event:Event):void
		{
			Metrix.instance.newRevenue("event_slug", 12000, MetrixCurrency.IRR, "0");
		}
	}
}