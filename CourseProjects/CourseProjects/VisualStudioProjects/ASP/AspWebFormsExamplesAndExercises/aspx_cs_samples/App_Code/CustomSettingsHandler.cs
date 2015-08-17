using System;
using System.Configuration;
using System.Xml;

namespace AspxDemos {
	public class CustomSettingsHandler : IConfigurationSectionHandler {
		public object Create(object parent, object configContext, XmlNode section) {
			string tmpMaxThreads = "";
			string tmpDatabaseIP = "";
			foreach(XmlNode child in section.ChildNodes) {
				if(child is XmlElement) {
					XmlElement current = (XmlElement)child;
					if(current.Name.Equals("MaxThreads")) {
						tmpMaxThreads = current.InnerText;
					} else if(current.Name.Equals("DatabaseIP")) {
						tmpDatabaseIP = current.InnerText;
					}
				}
			}
			return new CustomSettingsVO(Convert.ToInt32(tmpMaxThreads.Trim()),tmpDatabaseIP);
		}
	}
}
