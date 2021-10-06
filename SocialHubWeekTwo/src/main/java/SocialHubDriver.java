import java.sql.SQLException;
import java.util.List;

import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.User;

public class SocialHubDriver {

	public static void main(String[] args) {
		
		UserDao uDao = new UserDaoDB();
		
		List<User> uList = uDao.getAllUsers();
		
		System.out.println(uList);
		
		User morty = uDao.getUserByUsername("mortysmith");
		
		System.out.println(morty);
		
		/*
		User gearhead = new User("Bird", "Person", "birdperson@mail.com", "birdperson", "password");
		
		try {
			uDao.createUser(gearhead);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		uList = uDao.getAllUsers();
		System.out.println(uList);
	*/
		
		morty.setEmail("newMail@mail.com");
		morty.setUsername("mortdawg1738");
		
		uDao.updateUser(morty);
		
		uDao.getUserByUsername("mortdawg1738");
		System.out.println(morty);
		
		User birdPerson = uDao.getUserByUsername("birdperson");
		uDao.deleteUser(birdPerson);
		uList = uDao.getAllUsers();
		System.out.println(uList);
	}

}
