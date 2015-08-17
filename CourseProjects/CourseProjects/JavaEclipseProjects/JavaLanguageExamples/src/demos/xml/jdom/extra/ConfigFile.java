package demos.xml.jdom.extra;

import java.io.*;
import org.jdom.*;
import org.jdom.output.*;

public class ConfigFile {
	public ConfigFile() {
		document = new Document(new Element("config-file"));
		Element root = document.getRootElement();
		root.addContent(new Element("accounts"));
		Element reporting = new Element("reporting");
		root.addContent(reporting);
		reporting.addContent(new Element("error-log"));
		reporting.addContent(new Element("debug-log"));
	}
	public void addResources(String noThreads, String serverIP, String cacheSize) {
		Element e = document.getRootElement();
		e.addContent(new Resources(noThreads,serverIP,cacheSize));
	}
	public void addAccount(String type, String userName, String passwd) {
		Element root = document.getRootElement();
		Element accounts = root.getChild("accounts");
		accounts.addContent(new User(type,userName,passwd));
	}
	public void addErrorLog(String logging, String level, String dest_type, String dest) {
		Element root = document.getRootElement();
		Element accounts = root.getChild("reporting");
		Element errorLog = accounts.getChild("error-log");
		errorLog.setAttribute(new Attribute("do-logging",logging));
		errorLog.setAttribute(new Attribute("level",level));
		Element output = new Element("output");
		output.setAttribute(new Attribute("destination",dest_type));
		if(null != output) {
			output.addContent(dest);
		}
		errorLog.addContent(output);
	}
	public void addDebugLog(String logging, String level, String dest_type, String dest) {
		Element root = document.getRootElement();
		Element accounts = root.getChild("reporting");
		Element debugLog = accounts.getChild("debug-log");
		debugLog.setAttribute(new Attribute("do-debug",logging));
		debugLog.setAttribute(new Attribute("level",level));
		Element output = new Element("output");
		output.setAttribute(new Attribute("destination",dest_type));
		if(null != output) {
			output.addContent(dest);
		}
		debugLog.addContent(output);
	}
	public void saveDoc(String filename) throws IOException {
		File f = new File(filename);
		if(f.exists()) {
			f.delete();
		}
		XMLOutputter out = new XMLOutputter();
		out.output(document,new FileOutputStream(filename));
    }
	@SuppressWarnings("serial")
	private class User extends Element {
		User(String role, String id, String password) {
			super("user");
			setAttribute(new Attribute("role",role));
			addContent(new Element("id").addContent(id));
			addContent(new Element("password").addContent(password));
		}
	}
	@SuppressWarnings("serial")
	private class Resources extends Element {
		Resources(String threads, String ip, String cache) {
			super("resources");
			addContent(new Element("threads").addContent(threads));
			addContent(new Element("server-ip").addContent(ip));
			addContent(new Element("cache").setAttribute(new Attribute("size",cache)));
		}
	}
	private Document document;
}
