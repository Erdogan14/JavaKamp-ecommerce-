package ecommerce.business.abstracts;

import ecommerce.entities.concretes.User;

public interface UserService {
	
	void register(User user);
	
	void login(String email, String password);
}
