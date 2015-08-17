package demos.swing.worker;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class IncrementalSwingWorker extends SwingWorker<String,String> {
	public IncrementalSwingWorker(JComboBox comboBox, JLabel label) {
		super();
		this.comboBox = comboBox;
		this.label = label;
	}
	@Override
	protected String doInBackground() throws Exception {
		doSleep();
		publish("abc","def","ghi");
		doSleep();
		publish("jkl","mno","pqr");
		doSleep();
		publish("stu","vwx","yza");
		doSleep();
		publish("bcd","efg","hij");
	
		return "All Done!";
	}
	private void doSleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Sleep interrupted!");
		}
	}
	@Override
	protected void process(List<String> chunks) {
		for(String str : chunks) {
			comboBox.addItem(str);
		}
	}
	@Override
	protected void done() {
		try {
			label.setText(get());
		} catch (Exception ex) {
			System.out.println("Done failed!");
		} 
	}
	private JComboBox comboBox;
	private JLabel label;
}
