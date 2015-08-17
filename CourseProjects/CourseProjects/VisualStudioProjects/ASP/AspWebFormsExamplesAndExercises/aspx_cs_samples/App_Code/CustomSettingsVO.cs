using System;

namespace AspxDemos {
	public class CustomSettingsVO {
		public CustomSettingsVO(int maxThreads, string databaseIP) {
			this.maxThreads = maxThreads;
			this.databaseIP = databaseIP;
		}

		public string DatabaseIP {
			get { return databaseIP; }
		}

		public int MaxThreads {
			get { return maxThreads; }
		}

		private readonly string databaseIP;
		private readonly int maxThreads;
	}
}