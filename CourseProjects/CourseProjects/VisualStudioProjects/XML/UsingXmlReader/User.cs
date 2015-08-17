using System;

namespace XMLReaderDemo {
	public class User {
		public User(string role, string id, string password) {
			this.role = role;
			this.id = id;
			this.password = password;
		}
		public override string ToString() {
			return "User in role " + role + " with id " + id + " and password " + password; 
		}
		private string role;
		private string id;
		private string password;
	}
}
