package GUI;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonInheritance.Borrower;
import SystemClass.UniLibrarySys;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AddOrRemoveFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField gentextId;
	private JTextField textField_4;
	private JTextField enteridTxt;
	private JTextField nameTxt;
	private JTextField phoneTxt;
	private JTextField emailTxt;
	private JTextField removeidTxt;
	public int generatedId = -1;
	public String memberType = "UniMember";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrRemoveFrame frame = new AddOrRemoveFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public AddOrRemoveFrame() {
		
		setTitle("Add / Remove Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JRadioButton addGuestBtn = new JRadioButton("Guest");
		
		contentPane.setLayout(null);
		JButton generateBtn = new JButton("Generate ID");
		generateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generatedId = UniLibrarySys.generateGuestId();
				gentextId.setText(generatedId + "");
			}
		});
		generateBtn.setEnabled(false);
		generateBtn.setBounds(36, 99, 130, 23);
		contentPane.add(generateBtn);
		
		gentextId = new JTextField();
		gentextId.setEditable(false);
		gentextId.setEnabled(false);
		gentextId.setBounds(92, 133, 103, 20);
		contentPane.add(gentextId);
		gentextId.setColumns(10);
		
		JRadioButton addUniversityMemberBtn = new JRadioButton("University Member");
		addUniversityMemberBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(addUniversityMemberBtn.isSelected()) {
					addGuestBtn.setEnabled(true);
				}else {
					addGuestBtn.setEnabled(false);
				}
			}
		});
		addUniversityMemberBtn.setEnabled(false);
		addUniversityMemberBtn.setBounds(272, 106, 147, 23);
		contentPane.add(addUniversityMemberBtn);
		
		
		addGuestBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(addGuestBtn.isSelected())
				{
					generateBtn.setEnabled(false);
					gentextId.setEnabled(false);
					enteridTxt.setEnabled(true);
					addUniversityMemberBtn.setEnabled(true);
					memberType = "UniMember";
					
				}else {
					generateBtn.setEnabled(true);
					gentextId.setEnabled(true);
					enteridTxt.setEnabled(false);
					addUniversityMemberBtn.setEnabled(false);
					memberType = "Guest";
				}
			}
		});
		addGuestBtn.setEnabled(false);
		addGuestBtn.setBounds(69, 69, 82, 23);
		contentPane.add(addGuestBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(707, 81, 237, 309);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		
		JButton calcfeeBtn = new JButton("Calculate Fee");
		calcfeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(removeidTxt.getText());
				textArea.setText(UniLibrarySys.displayFee(id));
				
			}
		});
		calcfeeBtn.setEnabled(false);
		calcfeeBtn.setBounds(507, 221, 149, 35);
		contentPane.add(calcfeeBtn);
		
		
		JButton displayBtn = new JButton("Display Borrowers");
		displayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Borrower.getOwnedBook() == null) {
					textArea.setText(UniLibrarySys.displayPerson());
				}else {
					textArea.setText(UniLibrarySys.displayPersonWithBook());
				}
				
				
				
			}
		});
		displayBtn.setEnabled(false);
		displayBtn.setBounds(507, 266, 149, 35);
		contentPane.add(displayBtn);
		
		
		

		removeidTxt = new JTextField();
		removeidTxt.setEnabled(false);
		removeidTxt.setEditable(false);
		removeidTxt.setBounds(547, 168, 109, 20);
		contentPane.add(removeidTxt);
		removeidTxt.setColumns(10);
		
		
		
		JButton removeBorrowerBtn = new JButton("Remove Borrower");
		removeBorrowerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Borrower.getOwnedBook() == null) {
					textArea.setText("You should first borrow a book");
				} else {
					int borrowerId = Integer.parseInt(removeidTxt.getText());
					boolean check = UniLibrarySys.removePerson(borrowerId);
					if(check) {
						textArea.setText("Borrower is removed");
					}else {
						textArea.setText("Borrower with that id does not exist!");
					}
				}
				
			}
		});
		removeBorrowerBtn.setEnabled(false);
		removeBorrowerBtn.setBounds(508, 315, 148, 37);
		contentPane.add(removeBorrowerBtn);
		
		JRadioButton removeMemBtn = new JRadioButton("Remove");
		removeMemBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(removeMemBtn.isSelected()) {
					displayBtn.setEnabled(false);
					calcfeeBtn.setEnabled(false);
					removeBorrowerBtn.setEnabled(false);
					removeidTxt.setEnabled(false);
					removeidTxt.setEditable(false);
				}else {
					displayBtn.setEnabled(true);
					calcfeeBtn.setEnabled(true);
					removeBorrowerBtn.setEnabled(true);
					removeidTxt.setEnabled(true);
					removeidTxt.setEditable(true);
				}
			}
			
		});
		removeMemBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		removeMemBtn.setBounds(680, 17, 109, 23);
		contentPane.add(removeMemBtn);
		
		JRadioButton addMemBtn = new JRadioButton("Add");
		addMemBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		addMemBtn.setBounds(185, 17, 65, 23);
		contentPane.add(addMemBtn);
		addMemBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(addMemBtn.isSelected()) {
				removeMemBtn.setEnabled(true);
				enteridTxt.setEnabled(false);
				nameTxt.setEnabled(false);
				phoneTxt.setEnabled(false);
				emailTxt.setEnabled(false);
				addGuestBtn.setEnabled(false);
				addUniversityMemberBtn.setEnabled(false);
				}else {
					removeMemBtn.setEnabled(false);
					enteridTxt.setEnabled(true);
					nameTxt.setEnabled(true);
					phoneTxt.setEnabled(true);
					emailTxt.setEnabled(true);
					addGuestBtn.setEnabled(true);
					addUniversityMemberBtn.setEnabled(true);
				}
			}
		});
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBounds(458, 0, 8, 419);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(0, 42, 972, 9);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setBounds(222, 47, 8, 141);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Generated ID:");
		lblNewLabel.setBounds(10, 136, 82, 14);
		contentPane.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setBounds(0, 179, 466, 9);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		enteridTxt = new JTextField();
		enteridTxt.setEnabled(false);
		enteridTxt.setBounds(200, 222, 124, 20);
		contentPane.add(enteridTxt);
		enteridTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setEnabled(false);
		nameTxt.setColumns(10);
		nameTxt.setBounds(200, 253, 124, 20);
		contentPane.add(nameTxt);
		
		phoneTxt = new JTextField();
		phoneTxt.setEnabled(false);
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(200, 284, 124, 20);
		contentPane.add(phoneTxt);
		
		emailTxt = new JTextField();
		emailTxt.setEnabled(false);
		emailTxt.setColumns(10);
		emailTxt.setBounds(200, 315, 124, 20);
		contentPane.add(emailTxt);
		
		JLabel labelTxt = new JLabel("");
		labelTxt.setBounds(69, 345, 293, 17);
		contentPane.add(labelTxt);
		
	
		
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String name = nameTxt.getText();
				String phone = phoneTxt.getText();
				String email = emailTxt.getText();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();  
				String borrowDate = formatter.format(date);
				if(name.equalsIgnoreCase("") || phone.equalsIgnoreCase("") || email.equalsIgnoreCase("")) {
					labelTxt.setText("Please fill all empty fields!");
				} else {
					if(memberType.equalsIgnoreCase("Guest")) {
						if(generatedId == -1) {
							labelTxt.setText("Please generate an Id");
						} else {
							id = generatedId;
							labelTxt.setText("New guest is added to the system!");
							UniLibrarySys.addPerson(name, id, borrowDate , phone, email, memberType);
							nameTxt.setText("");
							phoneTxt.setText("");
							emailTxt.setText("");
							enteridTxt.setText("");
							gentextId.setText("");
						}
					
					} else if (memberType.equals(null)) {
						labelTxt.setText("type is null");
					} else {
						id = Integer.parseInt(enteridTxt.getText());
						if(UniLibrarySys.checkPersonId(id)) {
							labelTxt.setText("A user with this id already exists in the system!");
						}else {
							labelTxt.setText("New university member is added to the system!");
							UniLibrarySys.addPerson(name, id, borrowDate, phone, email, memberType);
							nameTxt.setText("");
							phoneTxt.setText("");
							emailTxt.setText("");
							enteridTxt.setText("");
						}
					}
				
				}
				
				
			}
		});
		addBtn.setBounds(153, 367, 89, 23);
		contentPane.add(addBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(84, 225, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(84, 256, 82, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phone Number:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(84, 287, 111, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("E-mail:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(84, 318, 82, 14);
		contentPane.add(lblNewLabel_1_1_2);
		

		
		JLabel lblNewLabel_2 = new JLabel("Enter ID: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(486, 171, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			    EmployeeFrame emp = new EmployeeFrame();
			    emp.setVisible(true);
			}
		});
		backBtn.setBounds(10, 385, 89, 23);
		contentPane.add(backBtn);
		
		
	}
}
