package demos.swing.tables.advanced;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

public class AddEmployeePanel extends JPanel {
	public AddEmployeePanel(TableModel model) {
		super();
		setBorder(new TitledBorder("Add a New Employee..."));
		this.model = model;
		createWidgets();
		layoutWidgets();
		setEventHandling();
	}
	private void setEventHandling() {
		addEmployeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String dept = deptTextField.getText();
				int age = Integer.parseInt(ageTextField.getText());
				double salary = Double.parseDouble(salaryTextField.getText());
				boolean onLeave = new Boolean(onLeaveTextField.getText());
				
				EmployeeTableModel empModel = (EmployeeTableModel)model;
				empModel.addEmployee(new Employee(name,dept,age,salary,onLeave));
			}
		});
	}
	private void layoutWidgets() {
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		setHorizontalLayout(layout);
		
		SequentialGroup g1 = layout.createSequentialGroup();
		
		ParallelGroup g2 = layout.createParallelGroup();
		g2.addComponent(nameLabel);
		g2.addComponent(nameTextField);
		g1.addGroup(g2);
		ParallelGroup g3 = layout.createParallelGroup();
		g3.addComponent(deptLabel);
		g3.addComponent(deptTextField);
		g1.addGroup(g3);
		ParallelGroup g4 = layout.createParallelGroup();
		g4.addComponent(ageLabel);
		g4.addComponent(ageTextField);
		g1.addGroup(g4);
		ParallelGroup g5 = layout.createParallelGroup();
		g5.addComponent(salaryLabel);
		g5.addComponent(salaryTextField);
		g1.addGroup(g5);
		ParallelGroup g6 = layout.createParallelGroup();
		g6.addComponent(onLeaveLabel);
		g6.addComponent(onLeaveTextField);
		g1.addGroup(g6);
		g1.addComponent(addEmployeeButton);
		
		layout.setVerticalGroup(g1);
	}
	private void setHorizontalLayout(GroupLayout layout) {
		SequentialGroup g1 = layout.createSequentialGroup();
		
		ParallelGroup g2 = layout.createParallelGroup();
		g2.addComponent(nameLabel);
		g2.addComponent(deptLabel); 
		g2.addComponent(ageLabel); 
		g2.addComponent(salaryLabel); 
		g2.addComponent(onLeaveLabel); 
		g2.addComponent(addEmployeeButton);
		
		ParallelGroup g3 = layout.createParallelGroup();
		g3.addComponent(nameTextField);
		g3.addComponent(deptTextField);
		g3.addComponent(ageTextField);
		g3.addComponent(salaryTextField);
		g3.addComponent(onLeaveTextField);
		
		g1.addGroup(g2);
		g1.addGroup(g3);
		layout.setHorizontalGroup(g1);
	}
	private void createWidgets() {
		nameLabel = new JLabel("Name: ");
		nameTextField = new JTextField(10);
		deptLabel = new JLabel("Dept: ");
		deptTextField = new JTextField(10);
		ageLabel = new JLabel("Age: ");
		ageTextField = new JTextField(10);
		salaryLabel = new JLabel("Salary: ");
		salaryTextField = new JTextField(10);
		onLeaveLabel = new JLabel("On Leave: ");
		onLeaveTextField = new JTextField(10);
		addEmployeeButton = new JButton("Add Employee");
	}
	private JButton addEmployeeButton;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel deptLabel;
	private JTextField deptTextField;
	private JLabel ageLabel;
	private JTextField ageTextField;
	private JLabel salaryLabel;
	private JTextField salaryTextField;
	private JLabel onLeaveLabel;
	private JTextField onLeaveTextField;
	private TableModel model;
}
