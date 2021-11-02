import java.sql.SQLException;

import com.example.dao.UserDao;
import com.example.dao.UserDaoHibernate;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class Driver {
	
	private static UserDao uDao = new UserDaoHibernate();
	
	public static void main(String[] args) throws SQLException {
		
		User u1 = new User("Rick", "Sanchez", "rick@mail.com", "ricks", "password");
		User u2 = new User("Morty", "Smith", "msmith@mail.com", "morty", "password");
		
		uDao.createUser(u1);

		uDao.createUser(u2);
		
		System.out.println(uDao.getUserByUsername("ricks"));
		
		u1.setUsername("ricksanchez");
		
		uDao.updateUser(u1);
		
		System.out.println(uDao.getUserByUsername("ricksanchez"));
		
		uDao.deleteUser(u1);
		
		System.out.println(uDao.getAllUsers());
		
		HibernateUtil.closeSession();
		
	}
	
}
