package ecommerce;

import ecommerce.business.concretes.UserManager;
import ecommerce.core.GoogleCheckinAdapter;
import ecommerce.dataAccess.concretes.HibernateUserDao;
import ecommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
			UserManager userManager = new UserManager(new HibernateUserDao(), new GoogleCheckinAdapter());
			
			User user1 = new User(1,"Erdoğan","Çiftci","eciftci1406@gmail.com","a1");
		
			userManager.register(user1);
			
			userManager.login("eciftci1406@gmail.com", "a1");
			
	

	}

}



