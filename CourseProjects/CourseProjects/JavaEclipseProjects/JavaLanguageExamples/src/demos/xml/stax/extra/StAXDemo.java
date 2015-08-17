package demos.xml.stax.extra;

import java.io.*;
import java.util.*;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import javax.xml.namespace.*;

public class StAXDemo {
	public StAXDemo(String fileName) throws Exception {
		listOfUsers = new ArrayList<User>();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		FileReader fr = new FileReader(fileName);
		reader = factory.createXMLEventReader(fr);
	}
	public void process() throws Exception {
		while(reader.hasNext()) {
			XMLEvent event = (XMLEvent)reader.next();
			if(event.isStartElement()) {
				StartElement current = event.asStartElement();
				//System.out.println(current.getName());
				if(current.getName().equals(qUser)) {
					//If we have a 'user' element pull out the role attribute
					Attribute att = current.getAttributeByName(qRole);
					tmpRole = att.getValue();
				} else if(current.getName().equals(qID)) {
					//If we have an 'id' element pull its content as a string
					tmpID = ((XMLEvent)reader.next()).asCharacters().getData();
				} else if(current.getName().equals(qPassword)) {
					//When we meet a 'password' element we have enough info to create a User
					String password = ((XMLEvent)reader.next()).asCharacters().getData();
					addUserToList(password);
				}
			}
		}
	}
	private void addUserToList(String password) {
		User user = new User(tmpRole,tmpID,password);
		listOfUsers.add(user);
	}
	public void displayUsers() {
		Iterator<User> iter = listOfUsers.iterator();
		while(iter.hasNext()) {
			User user = iter.next();
			System.out.println(user);
		}
	}
	//Inner class to hold user details
	private class User {
		public User(String role, String id, String password) {
			this.role = role;
			this.id = id;
			this.password = password;
		}
		public String toString() {
			return "User in role " + role + " with id " + id + " and password " + password;
		}
		private String role;
		private String id;
		private String password;
	}
	//Constant values for QNames
	private static QName qUser = new QName("user");
	private static QName qID = new QName("id");
	private static QName qPassword = new QName("password");
	private static QName qRole = new QName("role");

	private XMLEventReader reader;	//The pull parser
	private ArrayList<User> listOfUsers;	//To hold user objects
	private String tmpRole;			//Temporary vars to hold user
	private String tmpID;			// details as we find them
}
