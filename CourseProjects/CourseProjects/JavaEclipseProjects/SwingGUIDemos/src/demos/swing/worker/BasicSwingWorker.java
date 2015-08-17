package demos.swing.worker;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class BasicSwingWorker extends SwingWorker<String,Object> {
	public BasicSwingWorker(JTextField textField) {
		super();
		this.textField = textField;
	}
	@Override
	protected String doInBackground() throws Exception {
		try {
			Thread.sleep(5000);
		} catch(Exception ex) {
			System.out.println("Sleep failed!");
		}
		return "Test Text";
	}
	@Override
	protected void done() {
		try {
			textField.setText(get());
		} catch (Exception e) {
			System.out.println("Done method failed!");
		}
	}
	private JTextField textField;
}
