package demos.swing.text.crypto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	public MainFrame() throws Exception {
		super("Demo of Text Areas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createWidgets();
		layoutWidgets();
		
		createKeyAndCipher();
		
		encrypt.addActionListener(new MyActionListener());
		
		loadSampleData();
	}
	private void loadSampleData() {
		String fileName = "input" + File.separator + "muskateers.txt";
		File f = new File(fileName);
		if(f.exists()) {
			FileReader input;
			try {
				input = new FileReader(f);
				plainText.read(input, null);
			} catch (IOException e) {
				plainText.setText("File exists but cant be read");
			}
		} else {
			plainText.setText("Cant find sample input");
		}
	}
	private void createKeyAndCipher() throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException {
		KeyGenerator generator = KeyGenerator.getInstance("DES");
        key = generator.generateKey();
        
        cipher = Cipher.getInstance("DES/CFB8/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
	}
	private void layoutWidgets() {
		JPanel p = new JPanel();
		p.add(splitPane);
		p.add(encrypt);
		add(p,BorderLayout.CENTER);
	}
	private void createWidgets() {
		plainText = new JTextArea(20,50);
		cypherText = new JTextArea(20,50);
		sp1 = new JScrollPane(plainText);
		sp2 = new JScrollPane(cypherText);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,sp2);
		encrypt = new JButton("encrypt");
	}
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
			CipherOutputStream cipherOutput = new CipherOutputStream(outputBuffer,cipher);
	        OutputStreamWriter writer  = new OutputStreamWriter(cipherOutput);
			try {
				plainText.write(writer);
				ByteArrayInputStream inputBuffer = new ByteArrayInputStream(outputBuffer.toByteArray());
				cypherText.read(new InputStreamReader(inputBuffer), null);
			} catch (IOException ex) {
				cypherText.setText("Exception in encryption code...");
			}
		}
	}
	private JSplitPane splitPane;
	private JScrollPane sp1;
	private JScrollPane sp2;
	private JTextArea plainText;
	private JTextArea cypherText;
	private JButton encrypt;
	//encryption related fields
	private SecretKey key;
	private Cipher cipher;
	
}
