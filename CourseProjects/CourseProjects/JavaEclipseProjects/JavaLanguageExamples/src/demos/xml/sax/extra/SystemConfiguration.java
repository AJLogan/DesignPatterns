package demos.xml.sax.extra;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SystemConfiguration implements Configuration {
	/*
		Builder method - this class is a Singleton
	*/
	public static synchronized Configuration getInstance(String fileName) throws ParserConfigurationException, SAXException {
		if(instance == null) {
			instance = new SystemConfiguration(fileName);
		}
		return instance;
	}

	/*
		Constructor
	*/
	private SystemConfiguration() throws ParserConfigurationException, SAXException {
		super();

		reader = new ConfigReader();
		server_ip = new String("000.000.000.000");
		accounts = new LinkedList<User>();
	}
	private SystemConfiguration(String file) throws ParserConfigurationException, SAXException {
		this();

		try {
			File f = new File(file);
			if(f.exists()) {
				FileReader fr = new FileReader(f);
				reader.parse(fr);
			}else {
				System.out.println("No file named " + file);
				System.exit(1);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/*
		Interface
		Used by client code to discover current config
	*/
	public int queryThreads() {
		return threads;
	}
	public int queryCacheSize() {
		return cache_size;
	}
	public String queryServerIP() {
		return server_ip;
	}
	public boolean isDebugOn() {
		return debug_log.getStatus();
	}
	public boolean isErrorLogOn() {
		return error_log.getStatus();
	}
	public boolean userExists(String id) {
		Iterator<User> i = accounts.iterator();
		while(i.hasNext()) {
			User u = i.next();
			if(id.equals(u.user_id)){
				return true;
			}
		}
		return false;
	}
	public boolean validateUser(String id, String password) {
		Iterator<User> i = accounts.iterator();
		while(i.hasNext()) {
			User u = i.next();
			if(id.equals(u.user_id) && password.equals(u.password)){
				return true;
			}
		}
		return false;
	}

	/*
		Class members
		Used to store system configuration
	*/
	private int threads;
	private int cache_size;
	private String server_ip;
	private LinkedList<User> accounts;
	private Report error_log;
	private Report debug_log;
	private ConfigReader reader;

	/*
		Inner classes
		Used to track User Accounts and Error/Debug logging
	*/
	class User {
		public User(String id, String pass, String role) {
			password = pass;
			user_id = id;
			this.role = role;
		}
		public String password;
		public String user_id;
		public String role;
	}
	class Report {
		public Report(boolean status, String level) {
			this.status = status;
			this.level = level;
		}
		boolean getStatus() { return status; }
		String getLevel() {return level; }

		private boolean status;
		private String level;
	}
	class ErrorLogging extends Report {
		public ErrorLogging(boolean status, String level) {
			super(status,level);
		}
	}
	class DebugLogging extends Report {
		public DebugLogging(boolean status, String level) {
			super(status,level);
		}
	}
	class ConfigReader extends DefaultHandler {

		public ConfigReader() throws ParserConfigurationException, SAXException {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
		}
		public void parse(Reader r) {
			try {
				parser.parse(new InputSource(r),this);
			}catch(SAXException e) {
				System.out.println(e);
				e.printStackTrace();
			}catch(IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		public void startElement(String namespaceURI, String localName, String rawName, Attributes atts) throws SAXException {
			//out.println("Handler::startElement[" + localName + " , " + rawName + "]");

			if(rawName.equals("threads")) {
				get_threads = true;
			}
			else if(rawName.equals("server-ip")) {
				get_ip = true;
			}
			else if(rawName.equals("cache")) {
				cache_size = Integer.parseInt(atts.getValue("size"));
			}
			if(rawName.equals("user")) {
				tmpRole = atts.getValue("role");
			}
			else if(rawName.equals("id")) {
				get_id = true;
			}
			else if(rawName.equals("password")) {
				get_password = true;
			}
			else if(rawName.equals("debug")) {
				Boolean status = Boolean.valueOf(atts.getValue("do-debug"));
				String level = atts.getValue("level");
				debug_log = new Report(status.booleanValue(),level);
			}
			else if(rawName.equals("error-log")) {
				Boolean status = Boolean.valueOf(atts.getValue("do-logging"));
				String level = atts.getValue("level");
				error_log = new Report(status.booleanValue(),level);
			}
		}
		public void endElement(String namespaceURI, String localName, String rawName) throws SAXException {
			//out.println("Handler::endElement[" + localName + "]");

			if(rawName.equals("user")) {
				accounts.add(new User(tmpID,tmpPassword,tmpRole));
			}
		}
		public void characters(char ch[], int start, int length) throws SAXException {
			String chars = new String(ch,start,length);
			//out.println("Handler::characters[" + chars + "]");

			if(get_threads) {
				threads = Integer.parseInt(chars);
				get_threads = false;
			}
			else if(get_ip) {
				server_ip = chars;
				get_ip = false;
			}
			else if(get_id) {
				tmpID = chars;
				get_id = false;
			}
			else if(get_password) {
				tmpPassword = chars;
				get_password = false;
			}
		}
		public void warning(SAXParseException exception) throws SAXException {
			out.println(exception);
		}
		public void error(SAXParseException exception) throws SAXException {
			out.println(exception);
		}
		public void fatalError(SAXParseException exception) throws SAXException {
			out.println(exception);
		}

		private SAXParser parser;
		private PrintStream out = System.out;

		//flags
		private boolean get_threads;
		private boolean get_ip;
		private boolean get_id;
		private boolean get_password;

		//temporary vars
		private String tmpID;
		private String tmpRole;
		private String tmpPassword;

	}
	private static SystemConfiguration instance;
}
