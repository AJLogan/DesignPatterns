using System;
using System.Collections;

namespace CustomEvents {
	class EventHolder {
		//A holder for delegates
		private IList holder = new ArrayList();
		//The event declaration
		public event Callback CustomEvent {
			add {
				holder.Add(value);
			}
			remove {
				holder.Remove(value);
			}
		}
		//Helper method to raise the event
		public void raiseEvent(int p1, double p2) {
			if(holder.Count > 0) { 
				foreach(Callback callback in holder) {
					callback(p1,p2);
				}
			}
		}
	}
}
