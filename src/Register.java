import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Register extends JFrame implements ActionListener{
	JLabel label, labelNama, labelAdd, labelGen, labelAge, labelPass, labelRepeatPass;
	JPanel panel1, panelbody, panel2, panel3, panelRadio, nameTxtFieldPanel;
	JComboBox<Integer> AgeBox;
	JTextField texNama, texAddress;
	JPasswordField texPass, texRepeatPass;
	JRadioButton maleBtn, femaleBtn;
	JButton buttonRegister,buttonLogin;;
	ButtonGroup buttonGroup;
	Vector<User> userVec = new Vector<>();
	String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
	Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	DBConnection db;


	public Register (Vector<User> userVec, DBConnection db) {
		// TODO Auto-generated constructor stub
		this.userVec = userVec; //constructor
		this.db = db;
		
		buttText();
		ganarateLabel();
		generatePanel();
		
		getContentPane().setBackground(Color.ORANGE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Register Page");
	}
	
	public void ganarateLabel() {
		label=new JLabel("REGISTER");
		labelNama=new JLabel("Name");
		labelAdd=new JLabel("Address");
		labelGen=new JLabel("Gender");
		labelAge=new JLabel("Age");
		labelPass=new JLabel("Password");
		labelRepeatPass=new JLabel("Repeat Password");
		
	}
	
	public void generatePanel() {
		panel1 = new JPanel(new BorderLayout(0, 30));
		panelbody = new JPanel(new GridLayout(0,2, 20, 20));
//		panel1 = new JPanel(new BorderLayout());
//		panelbody = new JPanel(new GridLayout(0, 2));
		panel2 = new JPanel(new FlowLayout());
		panel3 = new JPanel(new FlowLayout());
		panelRadio = new JPanel(new FlowLayout());
//		nameTxtFieldPanel = new JPanel();
		
//		nameTxtFieldPanel.add(texNama);
		panelRadio.setBackground(Color.orange);
		panelRadio.add(maleBtn);
		panelRadio.add(femaleBtn);;
		
		panelbody.setBackground(Color.orange);
		panelbody.add(labelNama);
		panelbody.add(texNama);
		
		panelbody.add(labelAdd);
		panelbody.add(texAddress);
		
		panelbody.add(labelGen);
		panelbody.add(panelRadio);
		
		panelbody.add(labelAge);
		panelbody.add(AgeBox);
		
		panelbody.add(labelPass);
		panelbody.add(texPass);
		
		panelbody.add(labelRepeatPass);
		panelbody.add(texRepeatPass);
		
		panel2.setBackground(Color.orange);
		panel2.add(buttonRegister);
		panel2.add(buttonLogin);
		panel3.add(label);
		
		panel1.setBackground(Color.orange);
		panel1.add(panel3, BorderLayout.NORTH);
		panel1.add(panel2, BorderLayout.SOUTH);
		panel1.add(panelbody);
		
		add(panel1);
	}
	
	public void buttText(){
		Integer[] umur = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		AgeBox = new JComboBox<Integer>(umur);
		
		texNama = new JTextField();
//		texNama.setPreferredSize(new Dimension(150, 40));
		
		texAddress = new JTextField();
		
		texPass = new JPasswordField();
		texRepeatPass = new JPasswordField();
		
		maleBtn = new JRadioButton("Male");
		femaleBtn = new JRadioButton("Female");
		maleBtn.setBackground(Color.yellow);
		femaleBtn.setBackground(Color.yellow);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(maleBtn);
		buttonGroup.add(femaleBtn);

		buttonRegister = new JButton("Register");
		buttonRegister.addActionListener(this);
		
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(this);
		
	}
	
	public boolean validator(String name, String address, String Gender, Integer age, String password, String repeatPass) {
		
		if(!name.isEmpty()) {
			
			if(!address.isEmpty()) {
				
				if(!Gender.isEmpty()) {
					
					if(age!=0) {
						
						if(!password.isEmpty()) {
							
							if(!repeatPass.isEmpty()) {
								
								if(password.equals(repeatPass)) {
									
									if(pattern.matcher(password).matches() == true) {
										return true;
										
									}
									else {
										JOptionPane.showMessageDialog(this, "Password must has at least 1 aplhanumberic and 8 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(this, "Those passwords didn’t match. Try again", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(this, "Repeat password mustt be filled!", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(this, "Password must be filler!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(this, "Age must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "Gender must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Address must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Name must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}
	
	public boolean userNameValidator(String name) {
		for(int i=0; i<userVec.size(); i++) {
			if(userVec.get(i).getName().equals(name)) {
				JOptionPane.showMessageDialog(this, "Username already used", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
		
	}
	
	public void insertUserToDB(String name, String address, String Gender, Integer age, String password) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonRegister) {
			String name = texNama.getText();
			String address = texAddress.getText();
			String gender = (maleBtn.isSelected()) ? "Male" : ((femaleBtn.isSelected())?"Female" : "");
			Integer age = (Integer)AgeBox.getSelectedItem();
			String password = String.valueOf(texPass.getPassword());
			String repeatPass = String.valueOf(texRepeatPass.getPassword());
			
			if(validator(name, address, gender, age, password, repeatPass)) {
				if(userNameValidator(name) == true) {
					User newUser = new User(name, address, gender, age, password);
					userVec.add(newUser);
					db.insertUser(name, address, age, gender, password);
					JOptionPane.showMessageDialog(this, name + " berhasil terdaftar");
					this.dispose();
					new Login(userVec, db);
				}
			}
			
		}else if(e.getSource() == buttonLogin) {
			this.dispose();
			new Login(userVec, db);
//			new Home(userVec, new User("Richard", "Pade", "Male", 2, "YoNdakTah6"));
			
		}
		
	}

}