package week12;

import java.sql.SQLException;

import week12.DAO.UserDAO;
import week12.Model.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		
		try {
			//CREATE
			//dao.create(new User(3, "짱구", 5));
			
			// READ
			User u = dao.read(3);
			System.out.println(u.getName() + " (" + u.getAge() + "살)");
			
			// Update
			u.setAge(31);
			dao.update(u);
			
			// DELETE
			dao.delete(3);
		} catch (SQLException  e) {
			e.printStackTrace();
		}

	}

}
