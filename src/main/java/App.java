import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kimschool.manage.entity.User_Info;

public class App {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
		EntityManager em = emf.createEntityManager();
		
		User_Info result1 = em.find(User_Info.class, 1);
		
//		List<User_Info> results = em.createQuery("select u from User_Info u", User_Info.class).
		
		System.out.println(result1);
	}

}
