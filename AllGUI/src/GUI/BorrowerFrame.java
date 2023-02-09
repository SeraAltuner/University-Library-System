package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookInheritance.Book;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import SystemClass.*;
import javax.swing.JScrollPane;

public class BorrowerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblEmpty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerFrame frame = new BorrowerFrame();
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
	public BorrowerFrame() {
		setTitle("Borrower Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		//Displays all the books in the text file in textArea
		JButton btnNewButton = new JButton("Display Books");
		btnNewButton.setBounds(35, 141, 170, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UniLibrarySys.readBookFromFile();
				
				if(textArea.getText().isEmpty()) {
					String out = "University Library Books";
					out += UniLibrarySys.displayBook();
					textArea.setText(out);
				}
				
				else {
					lblEmpty.setText("Please press 'Clear' button to clear the screen!");
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		//Displays the book with the entered id
		JButton btnNewButton_1 = new JButton("Display Selected Book");
		btnNewButton_1.setBounds(35, 233, 170, 42);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textArea.getText().isEmpty()) {
					
					if(textField.getText().isEmpty()) {
						textArea.setText("Please enter the book id you are searching for!");
				}
					else{
						int bookId = Integer.parseInt(textField.getText());
						Book b = UniLibrarySys.searchBook(bookId);
						if(b == null) {
							textArea.setText("Book Id does not exist in the system!");
						}else {
							textArea.setText(b.toString());
						}
						
					}
				}
		
				else {
					lblEmpty.setText("Please press 'Clear' button to clear the screen!");
				}
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		//Adds ownedBook
		JButton btnNewButton_2 = new JButton("Add Book");
		btnNewButton_2.setBounds(35, 321, 170, 42);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textArea.getText().isEmpty()) {
					
					if(textField.getText().isEmpty()) {
						textArea.setText("Please enter the book id you want to borrow!");
					}
					else {
						int bookId = Integer.parseInt(textField.getText());
				
						UniLibrarySys.addOwnedBook(bookId);
						if(UniLibrarySys.getHardcopy(bookId)==null) {
							textArea.setText("You cannot borrow electronic books!");
						}else {
							textArea.setText(UniLibrarySys.getHardcopy(bookId).toString());
							
							textArea.setText("Borrow operation is complete!");
						}
						
					}
				}
				else {
					lblEmpty.setText("Please press 'Clear' button to clear the screen!");
				}
			}
		});
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(146, 30, 377, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter the Book ID:");
		lblNewLabel.setBounds(35, 34, 149, 14);
		contentPane.add(lblNewLabel);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(10, 402, 89, 23);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			    LoginFrame login = new LoginFrame();
			    login.setVisible(true);
			}
		});
		contentPane.add(backBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 141, 272, 297);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JButton btnNewButton_3 = new JButton("Clear ");
		btnNewButton_3.setBounds(116, 402, 89, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				lblEmpty.setText("");
			}
		});
		contentPane.add(btnNewButton_3);
		
		lblEmpty = new JLabel("");
		lblEmpty.setBounds(116, 88, 310, 23);
		contentPane.add(lblEmpty);
	}
}
