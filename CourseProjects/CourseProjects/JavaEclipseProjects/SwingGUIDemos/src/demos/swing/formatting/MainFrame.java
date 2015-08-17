package demos.swing.formatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Data Formatting Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font tmp = new Font(Font.SANS_SERIF,Font.BOLD,16);
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###???");
		} catch (ParseException e) {
			System.out.println("Cant create mask formatter!");
		}
		
		textField1 = new JFormattedTextField(new Integer(0));
		textField2 = new JFormattedTextField(new Double(0));
		textField3 = new JFormattedTextField(formatter);
		textField4 = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK));
		
		MyPropertyChangeListener listener = new MyPropertyChangeListener();
		textField1.addPropertyChangeListener(listener);
		textField2.addPropertyChangeListener(listener);
		textField3.addPropertyChangeListener(listener);
		textField4.addPropertyChangeListener(listener);
		
		label1 = new JLabel("----");
		label2 = new JLabel("----");
		label3 = new JLabel("----");
		label4 = new JLabel("----");
		
		Box box = Box.createVerticalBox();
		box.add(layoutTextFields());
		box.add(layoutLabels());
		
		add(box,BorderLayout.CENTER);
	}
	private JPanel layoutLabels() {
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(4,1));
		labels.setBorder(new TitledBorder("Data Stored"));
		labels.add(label1);
		labels.add(label2);
		labels.add(label3);
		labels.add(label4);
		return labels;
	}
	private JPanel layoutTextFields() {
		JPanel textFields = new JPanel(new GridLayout(4,2));
		textFields.setBorder(new TitledBorder("Data Input"));
		textFields.add(new JLabel("A valid integer:"));
		textFields.add(textField1);
		textFields.add(new JLabel("A valid double"));
		textFields.add(textField2);
		textFields.add(new JLabel("Pattern '123abc'"));
		textFields.add(textField3);
		textFields.add(new JLabel("Date of type '01/01/2010'"));
		textFields.add(textField4);
		return textFields;
	}
	private class MyPropertyChangeListener implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			//String message = "Property %s changed from %s to %s";
			//System.out.println(String.format(message, event.getPropertyName(), event.getOldValue(), event.getNewValue()));
			
			changeColorOnEdit(event);
			
			if(!event.getPropertyName().equals("value")) {
				return;
			}
			Object newValue = event.getNewValue();
			if(event.getSource() == textField1) {
				label1.setText("Value in first text box is:  " + newValue);
			} else if(event.getSource() == textField2) {
				label2.setText("Value in second text box is:   " + newValue);
			} else if(event.getSource() == textField3) {
				label3.setText("Value in third text box is:   " + newValue);
			} else {
				label4.setText("Value in fourth text box is:   " + newValue);
			}
		}

		private void changeColorOnEdit(PropertyChangeEvent event) {
			if(event.getPropertyName().equals("editValid")) {
				Boolean oldValue = (Boolean)(event.getOldValue());
				Boolean newValue = (Boolean)(event.getNewValue());
				JComponent source = (JComponent)event.getSource();
				
				if(oldValue == true) {
					if(newValue == false) {
						source.setBackground(Color.RED);
					}
				} else if(newValue == true) {
					source.setBackground(Color.WHITE);
				}
			}
		}
	}
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JFormattedTextField textField1;
	private JFormattedTextField textField2;
	private JFormattedTextField textField3;
	private JFormattedTextField textField4;
}
