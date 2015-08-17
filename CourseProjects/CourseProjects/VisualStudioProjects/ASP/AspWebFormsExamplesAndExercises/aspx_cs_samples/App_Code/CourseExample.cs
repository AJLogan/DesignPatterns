using System;

namespace aspxsamples {
	public class CourseExample {
		private readonly string url;
		private readonly string description;
		private readonly string title;

		public CourseExample(string title, string description, string url) {
			this.title = title;
			this.description = description;
			this.url = url;
		}
		public string Url {
			get { return url; }
		}
		public string Description {
			get { return description; }
		}
		public string Title {
			get { return title; }
		}
	}
}