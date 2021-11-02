import java.sql.SQLException;

import org.hibernate.Query;

import com.example.dao.PostDao;
import com.example.dao.PostDaoHibernate;
import com.example.dao.UserDao;
import com.example.dao.UserDaoHibernate;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostService;
import com.example.utils.HibernateUtil;

public class Driver {
	
	private static UserDao uDao = new UserDaoHibernate();
	private static PostDaoHibernate pDao = new PostDaoHibernate();
	
	private static PostService pServ = new PostService(pDao, uDao);
	
	public static void main(String[] args) throws SQLException {
		
		User u1 = new User("Rick", "Sanchez", "rick@mail.com", "ricks", "password");
		User u2 = new User("Morty", "Smith", "msmith@mail.com", "morty", "password");
		
		uDao.createUser(u1);

		uDao.createUser(u2);
		
		System.out.println(uDao.getUserByUsername("ricks"));
		
		u1.setUsername("ricksanchez");
		
		uDao.updateUser(u1);
		
		System.out.println(uDao.getUserByUsername("ricksanchez"));
		
		/*
		uDao.deleteUser(u1);
		
		System.out.println(uDao.getAllUsers());
		*/
		
		Post p1 = new Post(u1, "Hello, this is our first post using hibernate");
		
		pDao.createPost(p1);
		
		System.out.println(pDao.getAllPosts());
		
		u1.getPosts().add(p1);
		
		uDao.updateUser(u1);
		
		System.out.println(uDao.getUserByUsername("ricksanchez"));
		
		System.out.println(pDao.getPostById(1));
		
		pServ.likePost(u2, p1);
		
		System.out.println(pDao.getPostById(1));
		System.out.println(uDao.getUserByUsername("morty"));
		
		
		Query q = HibernateUtil.getSession().createNamedQuery("getUserLikedPosts");
		q.setInteger("id", u2.getId());
		System.out.println(q.getResultList());
		
		/*
		q = HibernateUtil.getSession().createNamedQuery("getUsersThatLiked");
		q.setInteger("id", 1);
		System.out.println(q.getResultList());
		*/
		
		HibernateUtil.closeSession();
		
	}
	
}
