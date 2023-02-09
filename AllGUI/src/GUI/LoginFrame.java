package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SystemClass.UniLibrarySys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int getBorrowerId() {
		return Integer.parseInt(idTextField.getText().toString());
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("Login Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginTitle = new JLabel("LOGIN");
		loginTitle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		loginTitle.setBounds(202, 10, 100, 46);
		contentPane.add(loginTitle);
		
		JComboBox empCombo = new JComboBox(UniLibrarySys.employeeId().toArray());
		empCombo.setEnabled(false);
		empCombo.setBounds(21, 263, 103, 22);
		contentPane.add(empCombo);
		
		JButton empLoginBtn = new JButton("Login as Employee");
		empLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			    EmployeeFrame emp= new EmployeeFrame();
			    emp.setVisible(true);
				
			}
		});
		empLoginBtn.setEnabled(false);
		empLoginBtn.setBounds(10, 296, 140, 23);
		contentPane.add(empLoginBtn);
		
		JLabel idlabel = new JLabel("");
		idlabel.setBounds(207, 197, 291, 36);
		contentPane.add(idlabel);
		
		JCheckBox studentCB = new JCheckBox("Student");
		JButton StudentLoginBtn = new JButton("Login as Borrower");
		StudentLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTextField.getText().isEmpty()) {
					idlabel.setText("Please enter your ID!");
				} else if(UniLibrarySys.checkPersonId(Integer.parseInt(idTextField.getText())) == false) {
					idlabel.setText("An employee must add you to the system first!!");
				}else {
					dispose();
					BorrowerFrame  borrow= new BorrowerFrame ();
					borrow.setVisible(true);
				}
				
			}
		});
		StudentLoginBtn.setEnabled(false);
		StudentLoginBtn.setBounds(226, 296, 140, 23);
		contentPane.add(StudentLoginBtn);
		
		JCheckBox EmployeeCB = new JCheckBox("Employee");
		EmployeeCB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(EmployeeCB.isSelected()) {
					empLoginBtn.setEnabled(true);
					empCombo.setEnabled(true);
					studentCB.setEnabled(false);
				}else {
					empLoginBtn.setEnabled(false);
					empCombo.setEnabled(false);
					studentCB.setEnabled(true);
				}
			}
		});
		EmployeeCB.setEnabled(false);
		
		EmployeeCB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EmployeeCB.setBounds(91, 156, 97, 36);
		contentPane.add(EmployeeCB);
		
		
		studentCB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(studentCB.isSelected())
				{
					idTextField.setEnabled(true);
					EmployeeCB.setEnabled(false);
					StudentLoginBtn.setEnabled(true);
				}else {
					idTextField.setEnabled(false);
					StudentLoginBtn.setEnabled(false);
					EmployeeCB.setEnabled(true);
				}
				
			}
		});
		studentCB.setEnabled(false);
		studentCB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		studentCB.setBounds(91, 195, 97, 23);
		contentPane.add(studentCB);

		
		JLabel lblNewLabel = new JLabel("Choose ID:");
		lblNewLabel.setBounds(23, 238, 61, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setBounds(245, 238, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		idTextField = new JTextField();
		idTextField.setEnabled(false);
		idTextField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		
		idTextField.setBounds(245, 264, 100, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		idTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if(!idTextField.getText().isEmpty())
				{
					StudentLoginBtn.setEnabled(true);
					
				}else {
					StudentLoginBtn.setEnabled(false);
				}
			}
		});
		JRadioButton unimemRB = new JRadioButton("University Member");
		unimemRB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		unimemRB.setBounds(41, 122, 147, 23);
		contentPane.add(unimemRB);
		JRadioButton guestRB = new JRadioButton("Guest");
		guestRB.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(guestRB.isSelected())
				{
					idTextField.setEnabled(false);
					EmployeeCB.setEnabled(false);
					StudentLoginBtn.setEnabled(false);
				}else {
					idTextField.setEnabled(true);
					StudentLoginBtn.setEnabled(true);
					EmployeeCB.setEnabled(false);
				}
				
			    
				if(guestRB.isSelected()) {
					unimemRB.setEnabled(true);
				}else {
					unimemRB.setEnabled(false);
				}
			}
		});
		
		guestRB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		guestRB.setBounds(41, 82, 109, 23);
		contentPane.add(guestRB);
		
		unimemRB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(unimemRB.isSelected())
				{
					guestRB.setEnabled(false);
					
					EmployeeCB.setEnabled(true);
					studentCB.setEnabled(true);
					
					
				}else {
					guestRB.setEnabled(true);
					EmployeeCB.setEnabled(false);
					studentCB.setEnabled(false);
				}
				
				
				
			}
		});
		
	}
}
