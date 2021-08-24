import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	JLabel label, labelNama, labelPass;
	JPanel panel1, panelbody, panel2, panel3;
	JTextField texNama;
	JPasswordField texPass;
	JButton buttonRegister,buttonLogin;;
	Vector<User> userVec = new Vector<>();
	DBConnection db;


	public Login (Vector<User> userVec, DBConnection db) {
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
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Login Page");
	}
	
	public void ganarateLabel() {
		label=new JLabel("Login");
		labelNama=new JLabel("Name");
		labelPass=new JLabel("Password");
		
	}
	
	public void generatePanel() {
		panel1 = new JPanel(new BorderLayout(0, 30));
		panel1.setBackground(Color.orange);
		panelbody = new JPanel(new GridLayout(0,2, 20, 20));
		panelbody.setBackground(Color.orange);
		panel2 = new JPanel(new FlowLayout());
		panel2.setBackground(Color.orange);
		panel3 = new JPanel(new FlowLayout());
		panel3.setBackground(Color.orange);
		
		panelbody.add(labelNama);
		panelbody.add(texNama);
		
		panelbody.add(labelPass);
		panelbody.add(texPass);
		
		panel2.add(buttonLogin);
		panel2.add(buttonRegister);
		panel3.add(label);
		
		panel1.add(panel3, BorderLayout.NORTH);
		panel1.add(panel2, BorderLayout.SOUTH);
		panel1.add(panelbody);
		
		add(panel1);
	}
	
	public void buttText(){
		texNama = new JTextField();
		
		texPass = new JPasswordField();

		buttonRegister = new JButton("Register");
		buttonRegister.addActionListener(this);
		
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(this);
		
	}
	
	public Integer passwordValidator(String name, String password) {
		for(int i=0; i<userVec.size(); i++) {
			if(userVec.get(i).getName().equals(name)) {
				if(userVec.get(i).getPassword().equals(password)) {
					return i;
				}else {
					JOptionPane.showMessageDialog(this, "Nama user atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
			}
		}
		JOptionPane.showMessageDialog(this, "Nama user atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
		return -1;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonRegister) {
			this.dispose();
			new Register(userVec, db);
			
		}else if(e.getSource() == buttonLogin) {
			String name = texNama.getText();
			String password = String.valueOf(texPass.getPassword());
			
			if(passwordValidator(name, password) != -1) {
				JOptionPane.showMessageDialog(this, name+" berhasil login!");
				this.dispose();
				new Home(userVec, userVec.get(passwordValidator(name, password)), db);
			}
			
		}
		
	}

}