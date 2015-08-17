using System;
using System.Collections;
using System.Web.UI;

namespace aspxsamples {
	public class ItemListTwo : Control {
		protected override void LoadViewState(object savedState) {
			if(savedState != null) {
				object[] saved = (object[]) savedState;
				isNumbered = (bool)saved[0];
				dataCache = (ArrayList)saved[1];
			}
		}

		protected override object SaveViewState() {
			object[] toSave = new object[2];
			toSave[0] = isNumbered;
			toSave[1] = dataCache;
			return toSave;
		}

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