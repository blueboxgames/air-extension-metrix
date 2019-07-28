package ir.metrix.scenes
{
	import feathers.controls.Screen;
	import feathers.layout.AnchorLayout;

	import starling.events.Event;
	import starling.events.ResizeEvent;
	
	import feathers.controls.Button;
	import feathers.layout.AnchorLayoutData;

	import ir.metrix.sdk.Metrix;
	import ir.metrix.sdk.MetrixEvent;

	public class MainScene extends Screen
	{
		static public const NAME:String = "main";
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
			Metrix.instance.appID = APPID;
			Metrix.instance.initialize();
			
			var metrixEventButton:Button = new Button();
			metrixEventButton.label = "Send Metrix Event";
			metrixEventButton.layoutData = new AnchorLayoutData(NaN, NaN, NaN, NaN, 0, 0);
			metrixEventButton.addEventListener(Event.TRIGGERED, metrixEventButton_triggeredHandler);
			this.addChild(metrixEventButton);
		}

		protected function metrixEventButton_triggeredHandler(event:Event):void
		{
			// Event Slug must be recieved from dashboard.
			var metrixEvent:MetrixEvent = Metrix.instance.newEvent("event_slug");
			Metrix.instance.sendEvent(metrixEvent);
		}
	}
}