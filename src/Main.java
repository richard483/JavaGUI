import java.util.Vector;

public class Main {
	
	public Vector<User> userVec = new Vector<>();
	public DBConnection db = new DBConnection();;
	
	public Main() {
		// TODO Auto-generated constructor stub
		moveData();
		
		new Register(userVec, db);
	}
	
	public void moveData() {
		
		try {
			db.resSet = db.getUserData();
			while(db.resSet.next()) {
				String name = String.valueOf(db.resSet.getObject("name"));
				String address = String.valueOf(db.resSet.getObject("address"));
				String gender = String.valueOf(db.resSet.getObject("gender"));
				Integer age = (Integer) db.resSet.getObject("age");
				String password = String.valueOf(db.resSet.getObject("password"));
				
				userVec.add(new User(name, address, gender, age, password));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

	}
	
}
