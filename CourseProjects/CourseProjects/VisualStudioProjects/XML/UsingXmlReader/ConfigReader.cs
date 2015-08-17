using System;
using System.Xml;
using System.Collections;

namespace XMLReaderDemo {
	class ConfigReader {
		//ConfigReader parses a config file on construction
		public ConfigReader(string configFile) {
			reader = new XmlTextReader(configFile);
			usersList = new ArrayList();
			//Read through the nodes in the file
			while(reader.Read()) {
				switch(reader.NodeType) {
					//If the node is an Element we are interested in parse it
					case XmlNodeType.Element:
						switch(reader.LocalName) {
							case "user":
								//If we have a 'user' element pull out the role attribute
								reader.MoveToAttribute("role");
								tmpRole = reader.Value;
							break;
							case "id":
								//If we have an 'id' element pull its content as a string
								tmpId = reader.ReadString();
							break;
							case "password":
								//When we meet a 'password' element we have enough info to create a User
								string password = reader.ReadString();
								usersList.Add(new User(tmpRole,tmpId,password));
							break;
						}
					break;
					//If the node is a comment print it
					case XmlNodeType.Comment:
						Console.WriteLine("Found the comment {0}", reader.Value);
					break;
				}
			}
		}
		//Utility method to output users collection
		public void printUsers() {
			Console.WriteLine("\nUser accounts are:");
			foreach(User user in usersList) {
				Console.WriteLine("\t{0}",user.ToString());
			}
		}
		private XmlTextReader reader;	//The XML Reader
		private ArrayList usersList;	//To hold user objects
		private string tmpRole;			//Temporary vars to hold user
		private string tmpId;			// details as we find them
	}
}
