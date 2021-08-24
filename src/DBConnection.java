import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public Connection connection;
	public Statement statement;
	public ResultSet resSet;
	public ResultSetMetaData resMeta;
	public PreparedStatement preparedStat;
	
	public DBConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/latbootcamp", "root", "");
			
			statement = connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getUserData() {
		try {
			preparedStat = connection.prepareStatement("SELECT * FROM `userdata`");
			resSet = preparedStat.executeQuery();
			resMeta = resSet.getMetaData();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resSet;
		
	}
	
	public void insertUser(String name, String address, Integer age, String gender, String password) {
		try {
			preparedStat = connection.prepareStatement("INSERT INTO `userdata`(`name`, `address`, `gender`, `age`, `password`) VALUES (?, ?, ?, ?, ?)");
			preparedStat.setString(1, name);
			preparedStat.setString(2, address);
			preparedStat.setString(3, gender);
			preparedStat.setInt(4, age);
			preparedStat.setString(5, password);
			
			preparedStat.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
