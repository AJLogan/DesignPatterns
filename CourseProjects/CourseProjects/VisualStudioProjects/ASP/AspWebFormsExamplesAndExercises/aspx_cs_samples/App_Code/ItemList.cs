using System;
using System.Collections;
using System.Web.UI;

namespace aspxsamples {
	public class ItemList : Control {
		protected override void OnDataBinding(EventArgs e) {
			base.OnDataBinding(e);
			dataCache = new ArrayList();
			foreach(object obj in dataSource) {
				dataCache.Add(obj);
			}
		}

		protected override void Render(HtmlTextWriter writer) {
			string listTag;
			if(isNumbered) {
				listTag = "ol";
			} else {
				listTag = "ul";
			}
			if(dataCache == null) {
				writer.Write("<ul><li>No Content</li></ul>");
			} else {
				writer.WriteFullBeginTag(listTag);
				foreach(object obj in dataCache) {
					writer.WriteFullBeginTag("li");
					writer.Write(obj.ToString());
					writer.WriteEndTag("li");
				}
				writer.WriteEndTag(listTag);
			}
		}

		public bool Numbered {
			get { return isNumbered; }
			set { isNumbered = value; }
		}

		public IEnumerable DataSource {
			get { return dataSource; }
			set { dataSource = value; }
		}

		private bool isNumbered;
		private IEnumerable dataSource;
		private ArrayList dataCache;
	}
}