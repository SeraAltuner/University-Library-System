package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PersonInheritance.Borrower;
import SystemClass.UniLibrarySys;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		setTitle("Employee Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton readBookBtn = new JButton("Read Book");
		readBookBtn.setBounds(22, 21, 148, 28);
		contentPane.add(readBookBtn);
		
		JButton displayBorrowBtn = new JButton("Display Borrowers");
		displayBorrowBtn.setBounds(22, 87, 148, 28);
		contentPane.add(displayBorrowBtn);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(121, 200, 89, 36);
		contentPane.add(searchBtn);
		
		JButton displayBookListBtn = new JButton("Display Booklist");
		displayBookListBtn.setBounds(22, 301, 189, 47);
		contentPane.add(displayBookListBtn);
		
		JButton addremoveBtn = new JButton("Add / Remove Borrower");
		addremoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			    AddOrRemoveFrame aor = new AddOrRemoveFrame();
			    aor.setVisible(true);
			}
		});
		addremoveBtn.setBounds(60, 372, 302, 36);
		contentPane.add(addremoveBtn);
		
		JLabel lblNewLabel = new JLabel("Search Borrower:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(11, 168, 159, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 21, 213, 338);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(11, 200, 100, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(Enter ID)");
		lblNewLabel_1.setBounds(60, 242, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			    LoginFrame log = new LoginFrame();
			    log.setVisible(true);
			}
		});
		backBtn.setBounds(162, 419, 89, 23);
		contentPane.add(backBtn);
		
		readBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isread = UniLibrarySys.readBookFromFile();
				if(isread) {
					textArea.setText("Books are in the system.");
				}else
					textArea.setText("File not found.");
			}
		});
		
		displayBorrowBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Borrower.getOwnedBook() == null) {
					textArea.setText(UniLibrarySys.displayPerson());
				}else {
					textArea.setText(UniLibrarySys.displayPersonWithBook());
				}
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					textArea.setText("Please enter borrower ID.");
				}else {
					int borrowerId = Integer.parseInt(textField.getText().toString());
					textArea.setText(UniLibrarySys.displaySelectedBorrower(borrowerId));
				}
				
			}
		});
		
		displayBookListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(UniLibrarySys.displayBook());
			}
		});
	}
}
