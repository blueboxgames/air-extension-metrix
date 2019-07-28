package ir.metrix.scenes
{
	import feathers.controls.Screen;
	import feathers.layout.AnchorLayout;

	import starling.events.Event;
	import starling.events.ResizeEvent;
	import ir.metrix.sdk.Metrix;

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
			Metrix.instance.appID = "wwjrsawgehzhzti";
			Metrix.instance.initialize();
			Metrix.instance.newEvent("testEvent");
		}
	}
}