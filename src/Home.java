import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Home extends JFrame implements ActionListener, MenuListener{
	JLabel label, labelName, labelAdd, labelGender, labelAge, labelUserName, labelUserAdd, labelUserGender, labelUserAge, labelYourProfile;
	JPanel panel1, panelbody, panel2, panel3, panelBody1;
	JTable table;

	Vector<User> userVec = new Vector<>();
	User user = new User(getName(), getTitle(), getWarningString(), null, getName());
	JScrollPane sp;
	
	JMenuBar homeBar;
	JMenu profileMenu;
	JMenuItem logoutMenu;
	
	DBConnection db;


	public Home (Vector<User> userVec, User user, DBConnection db) {
		// TODO Auto-generated constructor stub
		this.userVec = userVec; //constructor
		this.user = user;
		this.db = db;
		
		ganarateLabel();
		generateTable();
		generatePanel();
		generateMenuBar();
		
		
//		setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().setBackground(Color.ORANGE);
		setJMenuBar(homeBar);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(900,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Home Page");
	}
	
	public void ganarateLabel() {
		label=new JLabel("Home");
		labelName = new JLabel("Name:");
		labelAdd = new JLabel("Address:");
		labelGender = new JLabel("Gender:");
		labelAge = new JLabel("Age:");
		labelYourProfile = new JLabel("Your Profile");
		
		labelUserName=new JLabel(user.getName());
		labelUserAdd = new JLabel(user.getAddress());
		labelUserGender = new JLabel(user.getGender());
		labelUserAge = new JLabel(user.getAge().toString());

	}
	
	public void generatePanel() {
		panel1 = new JPanel(new BorderLayout());
		panel1.setBackground(Color.orange);
		panelbody = new JPanel(new GridLayout(0,2));
		panelbody.setBackground(Color.orange);
		panelBody1 = new JPanel(new BorderLayout());
		panel2 = new JPanel(new BorderLayout() );
		panel2.setBackground(Color.orange);
//		panel3 = new JPanel(new FlowLayout());
		
		panelbody.add(labelName);
		panelbody.add(labelUserName);
		
		panelbody.add(labelAdd);
		panelbody.add(labelUserAdd);
		
		panelbody.add(labelGender);
		panelbody.add(labelUserGender);
		
		panelbody.add(labelAge);
		panelbody.add(labelUserAge);
		
		panelbody.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		
		panelbody.setBorder(new EmptyBorder(10, 200, 0, 200));
		panelBody1.add(panelbody, BorderLayout.CENTER);
		panelBody1.add(labelYourProfile, BorderLayout.NORTH);
		panelBody1.setPreferredSize(new Dimension(100, 100));
		
//		panel3.add(label);
		
		panel2.add(panelBody1, BorderLayout.NORTH);
		panel2.add(sp, BorderLayout.CENTER);
		
//		panel1.add(panel3, BorderLayout.NORTH);
//		panel1.add(panel2, BorderLayout.SOUTH);
		panel1.add(panel2);
//		panel1.add(panelbody);
		
		add(panel1);
	}
	
	public Vector<Vector<Object>> getUserData() {
		Vector<Vector<Object>> data = new Vector<>();

		for(int i=0; i<userVec.size(); i++) {
			Vector<Object> rows = new Vector<>();//pake object aj jgn string, klo obj bisa bnyk tipe data
			rows.add(userVec.get(i).getName());
			rows.add(userVec.get(i).getAddress());
			rows.add(userVec.get(i).getGender());
			rows.add(userVec.get(i).getAge());
			data.add(rows);
		}

		return data;
	}
	
	public void generateTable(){
		Vector<String> col = new Vector<>();
		col.add("Name");
		col.add("Address");
		col.add("Gender");
		col.add("Age");

		table = new JTable(getUserData(), col);
		
		sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(600, 250));
		
//		add(sp);
		
	}
	
	public void generateMenuBar() {
		homeBar = new JMenuBar();
		profileMenu = new JMenu("Menu");
		logoutMenu = new JMenuItem("Logout");
		logoutMenu.addActionListener(this);
		
		profileMenu.add(logoutMenu);
//		profileMenu.addMenuListener(this);
		
		homeBar.add(profileMenu);
	}
	
	public boolean passwordValidator(String name, String password) {
		for(int i=0; i<userVec.size(); i++) {
			if(userVec.get(i).getName().equals(name)) {
				if(userVec.get(i).getPassword().equals(password)) {
					return true;
				}else {
					JOptionPane.showMessageDialog(this, "Wrong username/password!", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(this, "Wrong username/password!", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == logoutMenu) {
			this.dispose();
			new Login(userVec, db);
		}

		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Menu selected");
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Menu deselected");
		
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

}