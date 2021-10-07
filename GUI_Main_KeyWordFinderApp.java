import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GUI_Main_KeyWordFinderApp {

	private JFrame frame;
	private JTextField user_text_location_input;
	private JTextField user_word;
	private JButton btnNewButton;
	private JTextPane output_location;
	private String user_text_file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Main_KeyWordFinderApp window = new GUI_Main_KeyWordFinderApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Main_KeyWordFinderApp() {
		initialize();
		// create variables
		
		BinaryTree myTree = new BinaryTree();
		
			// submit everything once button has been pressed
			btnNewButton.addActionListener((ActionListener) new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {
					//take the user's txt file location 
					user_text_file = user_text_location_input.getText();
					
					try {
						Scanner src = new Scanner(new File(user_text_file));
						while (src.hasNext()) {
							String s = src.next();
							myTree.addwordNode(s);
						}
					}
							catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			
						myTree.inOrderTraversal();

					//take in the word the user is looking for 
					String takeUserInput = user_word.getText();

					// pull the check method from the bst class
					if (myTree.checkForWord(myTree.root, takeUserInput)) {
						output_location.setText("'" +takeUserInput + "'" + " was found in the article.");
					} else {
						output_location.setText( takeUserInput + " was not found in the article. Please look for another word.");
					}

				}

			});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel KeyWord_Finder_title = new JLabel("KeyWord Assitant ");
		KeyWord_Finder_title.setFont(
				new Font("Century Gothic", KeyWord_Finder_title.getFont().getStyle() & ~Font.BOLD | Font.ITALIC, 20));
		KeyWord_Finder_title.setHorizontalAlignment(SwingConstants.CENTER);
		KeyWord_Finder_title.setBounds(175, 10, 193, 39);
		frame.getContentPane().add(KeyWord_Finder_title);

		JTextPane txtpnHelloWelcomeTo = new JTextPane();
		txtpnHelloWelcomeTo.setForeground(Color.WHITE);
		txtpnHelloWelcomeTo.setBackground(Color.LIGHT_GRAY);
		txtpnHelloWelcomeTo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		txtpnHelloWelcomeTo.setText(
				"Hello! Welcome to the KeyWord Finder App. To get Started, please enter a text file location to be read through. **NOTE** : This app will only work if the file is a '.txt' format. If you need help converting the file into one, click the 'How to Convert' button. ");
		txtpnHelloWelcomeTo.setBounds(57, 59, 444, 74);
		frame.getContentPane().add(txtpnHelloWelcomeTo);

		user_text_location_input = new JTextField();
		user_text_location_input.setBounds(137, 143, 364, 37);
		frame.getContentPane().add(user_text_location_input);
		user_text_location_input.setColumns(10);

		JLabel lblNewLabel = new JLabel("txt location: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(26, 143, 81, 37);
		frame.getContentPane().add(lblNewLabel);

		user_word = new JTextField();
		user_word.setBounds(137, 191, 178, 37);
		frame.getContentPane().add(user_word);
		user_word.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("word to look for: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(26, 190, 88, 38);
		frame.getContentPane().add(lblNewLabel_1);

		btnNewButton = new JButton("FIND");
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Bernard MT Condensed", btnNewButton.getFont().getStyle(),
				btnNewButton.getFont().getSize() + 8));
		btnNewButton.setBounds(335, 190, 166, 38);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Output: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(26, 256, 81, 25);
		frame.getContentPane().add(lblNewLabel_2);

		output_location = new JTextPane();
		output_location.setBounds(117, 256, 384, 35);
		frame.getContentPane().add(output_location);
	}
}
