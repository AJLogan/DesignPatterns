package demos.swing.text.xslt;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class MainFrame extends JFrame {
	private static final File xmlFile = new File(("input" + File.separator + "muchAdoAboutNothing.xml"));
	private static final File xsltFile = new File("input" + File.separator + "shakespeare.xslt");
	
	public MainFrame() throws Exception {
		super("Demo of Text Areas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createWidgets();
		layoutWidgets();
		
		transformerFactory = TransformerFactory.newInstance();	
		
		transform.addActionListener(new MyActionListener());
		
		loadSampleData();
	}
	private void loadSampleData() {
		if(xmlFile.exists()) {
			FileReader input;
			try {
				input = new FileReader(xmlFile);
				xmlText.read(input, null);
			} catch (IOException e) {
				xmlText.setText("File exists but cant be read");
			}
		} else {
			xmlText.setText("Cant find sample input");
		}
	}
	private void layoutWidgets() {
		Box b = Box.createHorizontalBox();
		b.add(transform);
		add(b,BorderLayout.NORTH);
		add(splitPane,BorderLayout.CENTER);
	}
	private void createWidgets() {
		xmlText = new JTextArea(20,50);
		
		htmlText = new JEditorPane();
		htmlText.setEditorKit(new HTMLEditorKit());
		
		sp1 = new JScrollPane(xmlText);
		sp2 = new JScrollPane(htmlText);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp1,sp2);
		transform = new JButton("transform");
	}
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				StreamSource inputSource = buildStreamSourceFromXml();
				StreamSource stylesheetSource = new StreamSource(xsltFile);
				
				ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
				StreamResult fileResult = new StreamResult(outputBuffer);
			
				Transformer t = transformerFactory.newTransformer(stylesheetSource);
				t.transform(inputSource,fileResult);
				
				ByteArrayInputStream inputBuffer = new ByteArrayInputStream(outputBuffer.toByteArray());
				htmlText.read(new InputStreamReader(inputBuffer), null);
				
			} catch (Exception ex) {
				htmlText.setText("Exception reading or transforming xml");
			}
		}
		private StreamSource buildStreamSourceFromXml() throws IOException {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			OutputStreamWriter writer  = new OutputStreamWriter(buffer);
			xmlText.write(writer);
			
			return new StreamSource(new ByteArrayInputStream(buffer.toByteArray()));
		}
	}
	private JSplitPane splitPane;
	private JScrollPane sp1;
	private JScrollPane sp2;
	private JTextArea xmlText;
	private JEditorPane htmlText;
	private JButton transform;
	private TransformerFactory transformerFactory;
	
}

