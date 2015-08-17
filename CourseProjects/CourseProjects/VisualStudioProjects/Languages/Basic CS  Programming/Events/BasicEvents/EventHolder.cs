using System;
using System.Collections;

namespace BasicEvents {
	class EventHolder {
		//The event declaration
		public event Callback MyEvent;
        //Helper method to raise the event
        public void raiseEvent(int p1, double p2) {
            if (MyEvent != null) { MyEvent(p1, p2); }
        }
	}
}
