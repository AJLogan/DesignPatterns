package demos.swing.flying.saucer.tabbed;

import java.io.ByteArrayInputStream;
import java.net.URL;

import javax.swing.SwingUtilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xhtmlrenderer.simple.XHTMLPanel;

public class PageLoadingTask implements Runnable {
	public PageLoadingTask(String location, XHTMLPanel flyingSaucer) {
		super();
		this.location = location;
		this.flyingSaucer = flyingSaucer;
	}
	@Override
	public void run() {
		try {
			loadDocumentAndPassToEDT();
		} catch (Exception ex) {
			buildErrorAndPassToEDT(ex);
		}
	}
	private void buildErrorAndPassToEDT(Exception ex) {
		StringBuilder msg = new StringBuilder();
		msg.append("<html><body><h2>Error:");
		msg.append(ex.getClass().getName());
		msg.append("</h2></body></html>");
		final String errorMsg = msg.toString();
		
		Runnable r = new Runnable() {
			public void run() {
				try {
					flyingSaucer.setDocument(new ByteArrayInputStream(errorMsg.getBytes()),location);
				} catch (Exception e) {
					System.out.println("Cant display error message: " + e.getMessage());
				}
			}
		};
		SwingUtilities.invokeLater(r);
	}
	private void loadDocumentAndPassToEDT() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setEntityResolver(FSEntityResolver.instance());
		URL url = new URL(location);
		final Document doc = builder.parse(url.openStream());
		
		Runnable r = new Runnable() {
			public void run() {
				flyingSaucer.setDocument(doc,location);
			}
		};
		SwingUtilities.invokeLater(r);
	}
	private final String location;
	private final XHTMLPanel flyingSaucer;
}
